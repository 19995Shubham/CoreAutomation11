package StefDefs;

import common.digital.pom.pages.*;
import common.shared.Test.BaseTest_Digital;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildToolFlowsStepDefinition extends BaseTest_Digital
{
    digitalLoginPage loginPage = new digitalLoginPage(driver);
    gradePage gradepage = new gradePage(driver);
    exitPage exitpage = new exitPage(driver);
    buildPage buildpage = new buildPage(driver);
    personalisePage personalisepage = new personalisePage(driver);
    MIYPage miypage = new MIYPage(driver);
    public static Logger log = LogManager.getLogger(digitalLoginPage.class);
    String financeStatement;
    String selectedEngineName;
    String driveAwayPrice;


    @Then("^Clicks \"([^\"]*)\" from homepage$")
    public void clicksFromHomepage(String buttonName)
    {
        loginPage.clickBuyingTools(buttonName);
        log.info("Clicked on button: "+buttonName);
    }

    @And("^Clicks Build your mazda$")
    public void clicksBuildYourMazda()
    {
        loginPage.validateBuildYourMazdaText(buildYourMazdaText);
        loginPage.clickBuildYourMazda();
        log.info("Clicked on Build your mazda");
    }

    @And("^Close postcode pop-up$")
    public void closePostcodePopUp()
    {
        loginPage.clickCloseBtn();
        log.info("Close postcode pop-up without entering any value");
    }

    @And("^Selects \"([^\"]*)\" model$")
    public void selectsModel(String modelName)
    {
        loginPage.clickSelectedModel(modelName);
        log.info("Model name selected for further steps is: "+modelName);
    }

    @Then("^Enter and Select postcode \"([^\"]*)\"$")
    public void enterAndSelectPostcode(String postCode)
    {
        String postCodeArea = loginPage.enterAndSelectPostCode(postCode);
        log.info("Entered postcode is: "+postCode+" and postcode area is: "+postCodeArea);
    }

    @And("^Selects buyer type \"([^\"]*)\" if not selected$")
    public void selectsBuyerTypeIfNotSelected(String buyerName)
    {
        loginPage.validateBuyerType(buyerName);
        log.info("Selected buyer name is: "+buyerName);
    }

    @And("^Click on Submit$")
    public void clickOnSubmit()
    {
        loginPage.clickOnSubmit();
        log.info("Click on Submit button");
    }

    @Then("^Verify different grades cards$")
    public void verifyDifferentGradesCards()
    {
        gradepage.validatePageLoad();
        log.info("Landed on Different grades card page");
        gradepage.validateGradeCardsHeader(modelNames);
        log.info("Expected Model Names are: "+ Arrays.toString(modelNames));
       gradepage.validateGradeCardsPrice(modelPrices);
        log.info("Expected Prices are: "+ Arrays.toString(modelPrices));
        gradepage.validateKeyFeatures(card1Feature,card2Feature,card3Feature);
    }

    @Then("^Clicks on \"([^\"]*)\" CTA$")
    public void clicksOnCTA(String textName)
    {
        gradepage.clickOnFirstEstimateRepayment(textName);
        financeStatement = gradepage.getFinanceEstimateValues();
        log.info("Clicked on the text as: "+textName);
    }

    @And("^Validate Finance calculator opened and RDP price shown with other parameters$")
    public void validateFinanceCalculatorOpenedAndRDPPriceShownWithOtherParameters()
    {
        gradepage.validateFinancePopUpTabs(popUpTabNames);
        log.info("Tab names in finance pop-up is: "+ Arrays.toString(popUpTabNames));
        gradepage.clickPriceTab();
        gradepage.validateFeatureTitles(featureTitles);
        log.info("All features in finance pop-up is :"+ Arrays.toString(featureTitles));
    }

    @Then("^Clicks on \"([^\"]*)\" finance calculator popup$")
    public void clicksOnFinanceCalculatorPopup(String btnName)
    {
        loginPage.clickCloseBtn();
        log.info("Closed finance calcultor pop-up with button Name: "+btnName);
    }

    @And("^Finance calculator options shown on popup should be shown in the grade cards$")
    public void financeCalculatorOptionsShownOnPopupShouldBeShownInTheGradeCards()
    {
        gradepage.validateFirstModelFinanceDetails(financeStatement);
    }

    @Then("^clicks on \"([^\"]*)\"$")
    public void clicksOn(String buttonName)
    {
        gradepage.clickButtonByName(buttonName);
        log.info("Clicked on the feature: "+buttonName);
    }

    @And("^User should be able to scroll through different key feature cards$")
    public void userShouldBeAbleToScrollThroughDifferentKeyFeatureCards()
    {
        gradepage.clickOnNextArrow();
        gradepage.closeKeyFeatureModal();
    }

    @And("^Compare page should be opened in a new tab, with the selected grade already selected.$")
    public void comparePageShouldBeOpenedInANewTabWithTheSelectedGradeAlreadySelected()
    {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        gradepage.validateComparePageTitle(comparePageTitle);
        driver.switchTo().window(tabs.get(0));
    }

    @Then("^clicking on mazda logo to land on home page$")
    public void clickingOnMazdaLogoToLandOnHomePage()
    {
        exitpage.clickOnMazdaLogo();
    }

    @And("^Validate build abandonment popup$")
    public void validateBuildAbandonmentPopup()
    {
        exitpage.validatePopUpMsg(popUpExistMsg1,popUpExistMsg2);
        log.info("Abandonment popup message 1 before leaving: "+popUpExistMsg1);
        log.info("Abandonment popup message 2 before leaving: "+popUpExistMsg2);
    }

    @And("^Validate User stays on the Grade step$")
    public void validateUserStaysOnTheGradeStep()
    {
        gradepage.validatePageLoad();
        log.info("User stays on the grade page");
    }

    @And("^Validate User is navigated back to mazda home page$")
    public void validateUserIsNavigatedBackToMazdaHomePage()
    {
        exitpage.validateHomePage();
        log.info("Landed on Home Page");
    }

    @And("^Validate navigated back to grade step of CX-60$")
    public void validateNavigatedBackToGradeStepOfCX() {
        gradepage.validatePageLoad();
        log.info("User again landed on the grade page");
    }

    @And("^Validate Build step page$")
    public void validateBuildStepPage()
    {
        buildpage.validatePageLoad();
    }

    @Then("^Selects Build Yours CTA$")
    public void selectsBuildYoursCTA()
    {
        exitpage.clickOnBuildYoursBtn();
        log.info("Clicked on Build Yours button");
    }

    @And("^Selects Exit Build CTA$")
    public void selectsExitBuildCTA()
    {
        exitpage.clickOnExitBuildBtn();
        log.info("Clicked on Exit Build Button");
    }

    @Then("^selects \"([^\"]*)\" CTA$")
    public void selectsCTA(String buttonName)
    {
        exitpage.clickOnBuildYourModel();
        log.info("clicked on button: "+buttonName);
    }

    @Then("^Clicks on \"([^\"]*)\" button$")
    public void clicksOnButton(String btnName)
    {
        gradepage.clickNextBtn();
        log.info("Clicked on button: "+btnName);
    }

    @Given("User lands on Build Step of build tool")
    public void userLandsOnBuildStepOfBuildTool() {
        buildpage.validateBuildPageCards();
        log.info("User landed on Build Step page");
    }

    @Then("User selects different engine options")
    public void userSelectsDifferentEngineOptions()
    {
        buildpage.validateEngineTitles(engineNameList);
        log.info("Different engine levels available: "+ Arrays.toString(engineNameList));
    }

    @And("The engine card should be selected")
    public void theEngineCardShouldBeSelected() {
        selectedEngineName = buildpage.selectedEngine(engineNameList);
        log.info("Selected Engine Name is: "+selectedEngineName);
    }

    @Then("User clicks on  Help me choose")
    public void userClicksOnHelpMeChoose() {
        buildpage.clickHelpMeChoose();
        log.info("Navigate to different engine options");
    }

    @And("User is displayed with different engine options")
    public void userIsDisplayedWithDiffernetEngineOptions() {
        gradepage.clickOnNextArrow();
        gradepage.closeKeyFeatureModal();
    }

    @Then("^User selects different exterior colour options and select \"([^\"]*)\"$")
    public void userSelectsDifferentExteriorColourOptions(String colorName)
    {
        buildpage.selectColor(colorName);
        buildpage.validateSelectedColorName(colorName);
        log.info("Selected color name is: "+colorName);
    }

    @Then("^User selects different interior options and select \"([^\"]*)\"$")
    public void userSelectsDifferentInteriorOptions(String interiorName)
    {
        buildpage.selectInterior(interiorName);
        buildpage.validateSelectedInteriorName(interiorName);
        log.info("Selected Interior name is: "+interiorName);
    }

    @Then("^User selects different wheel options and select \"([^\"]*)\"$")
    public void userSelectsDiffernetWheelOptions(String wheelName)
    {
        buildpage.selectWheels(wheelName);
        buildpage.validateSelectedWheelName(wheelName);
        log.info("Selected Wheel name is: "+wheelName);
    }

    @Then("^User selects \"([^\"]*)\" CTA$")
    public void userSelectsCTA(String btnName)
    {
        exitpage.clickOnBtnByName(btnName);
        log.info("Clicked on button: "+btnName);
    }

    @And("User is presented with a Build save form")
    public void userIsPresentedWithABuildSaveForm()
    {
        String saveFormTitle = exitpage.validateSaveForm();
        log.info("Save form title is: "+saveFormTitle);
        exitpage.closeAbandonmentPopup();
    }

    @And("User stays on the build step with the selections unchanged")
    public void userStaysOnTheBuildStepWithTheSelectionsUnchanged()
    {
        String expectedEngineName = buildpage.selectedEngine(engineNameList);
        if(selectedEngineName.equalsIgnoreCase(expectedEngineName))
        {
            log.info("Stays on the build step with previous selections");
        } else {
            log.error("Stays on the build step but previous selections are not matching");
        }
    }

    @And("User is navigated to the personalization step")
    public void userIsNavigatedToThePersonalizationStep() {
        personalisepage.validatePageLoad();
    }

    @Given("^User visits mazda home page$")
    public void user_visits_mazda_home_page() {
        loginPage.validatePageLoad();
        System.out.println("Username: "+userName);
        System.out.println("Password: "+password);
        loginPage.setLogInCredentials(userName,password);
    }

    @Then("^Validate All Broken links$")
    public void validate_all_broken_links() {
        loginPage.validateHomePageBrokenLinks();
    }

    @Then("^Clicks on Estimate Repayments CTA on Footer$")
    public void clicksOnEstimateRepaymentsCTAOnFooter()
    {
        driveAwayPrice = personalisepage.getDriveAwayPrice();
        System.out.println("Drive Away price: "+driveAwayPrice);
        buildpage.clickOnFooterEstimateRepayment();
        gradepage.validateRepaymentModel();
    }

    @And("Validate build abandonment popup for Build Step")
    public void validateBuildAbandonmentPopupForBuildStep() {
        exitpage.validateBuildPopUpMsg(buildPopUpExistMsg1, buildPopUpExistMsg2);
        log.info("First message is: "+buildPopUpExistMsg1);
        log.info("Second message is: "+buildPopUpExistMsg2);
    }

    @Given("User lands on personalise step of build tool")
    public void userLandsOnPersonaliseStepOfBuildTool() {
        personalisepage.validatePersonalisePageCards();
        log.info("Landed on Personalise Page");
    }

    @Then("User selects different option packs available")
    public void userSelectsDifferentOptionPacksAvailable()
    {
        personalisepage.validateOptionalPacks(optionalPackList);
        personalisepage.clickOnOptionalPackButton("Details");
        personalisepage.validateDetailsPageTitle(optionalPackList[0]);
        personalisepage.closeModal();
    }

    @Then("User selects different accessory options available")
    public void userSelectsDifferentAccessoryOptionsAvailable()
    {
        personalisepage.clickOnOptionalPackButton("Add pack");
        personalisepage.clickConfirmBtn();
    }

    @And("Validate build abandonment popup for Personalise Step")
    public void validateBuildAbandonmentPopupForPersonaliseStep()
    {
        exitpage.validateBuildPopUpMsg(personalisePopUpExistMsg1, personalisePopUpExistMsg2);
        log.info("First message is: "+personalisePopUpExistMsg1);
        log.info("Second message is: "+personalisePopUpExistMsg2);
    }

    @Given("User lands on the MIY step of build tool")
    public void userLandsOnTheMIYStepOfBuildTool()
    {
        String pageTitle = miypage.validateMIYPageTitle();
        log.info("Make It your page title is: "+pageTitle);
    }

    @Then("User is presented with different CTA's")
    public void userIsPresentedWithDifferentCTAS() {
        
    }

    @And("^\"([^\"]*)\" when price is selected - Navigates to Book a test drive form$")
    public void whenPriceIsSelectedNavigatesToBookATestDriveForm(String pageTitle) {
        miypage.clickAndValidateBookTestDrive(pageTitle);
        log.info("Page title is: "+pageTitle);
    }

    @And("^\"([^\"]*)\" when finance is selected - Navigates to Make an Enqiry form$")
    public void whenFinanceIsSelectedNaviagtesToMakeAnEnqiryForm(String pageTitle)
    {
        miypage.clickOnFinanceTab();
        gradepage.validateRepaymentModel();
        loginPage.clickCloseBtn();
        miypage.clickAndValidateMakeFinanceEnquiry(pageTitle);
        log.info("Page title is: "+pageTitle);
    }

    @And("^\"([^\"]*)\" is standard for both selections - Navigates to Build Save form$")
    public void isStandardForBothSelectionsNavigatesToBuildSaveForm(String pageTitle) {
        miypage.clickOnSaveAndEmail();
        exitpage.validateSaveForm();
        miypage.saveYourBuild();
        loginPage.clickCloseBtn();
    }

    @Then("Final price is shown as default for the configurations selected in build journey")
    public void finalPriceIsShownAsDefaultForTheConfigurationsSelectedInBuildJourney()
    {
        gradepage.clickPriceTab();
       String expectedDriveAwayPrice = miypage.getDriveAwayPriceOnMIYPage();
//        Assert.assertEquals(expectedDriveAwayPrice,driveAwayPrice);
    }

    @And("The accordians when expanded Drive Away Price should be accurate")
    public void theAccordiansWhenExpandedDriveAwayPriceShouldBeAccurate() {
        miypage.clickEachAccorian();
        log.info("Expanded one by one accordian");
    }

    @Then("^User selections should be shown under \"([^\"]*)\" section$")
    public void userSelectionsShouldBeShownUnderSection(String myDesign)
    {
        miypage.validateMyDesignLabelList(designLabelList);
        log.info("All my design label List: "+Arrays.asList(designLabelList));
    }

    @And("Validate User selections")
    public void validateUserSelections() {
    }

    @Then("User should be able to edit selections made using the edit under {string} section")
    public void user_should_be_able_to_edit_selections_made_using_the_edit_under_section(String string) {
        miypage.clickEditBtn();
    }
    @Then("User should be navigated back to the specific fields of configuration, in the respective steps")
    public void user_should_be_navigated_back_to_the_specific_fields_of_configuration_in_the_respective_steps() {
        gradepage.clickNextBtn();
        gradepage.clickNextBtn();
        gradepage.clickNextBtn();
    }
    @Then("My design section should be updated with the latest selections")
    public void my_design_section_should_be_updated_with_the_latest_selections() {

    }
    @Then("User should be presented with a build save form")
    public void user_should_be_presented_with_a_build_save_form()
    {
        loginPage.clickCloseBtn();
    }

    @And("User is navigated to the Make It Yours step")
    public void userIsNavigatedToTheMakeItYoursStep()
    {
        miypage.validatePageLoad();
        log.info("Landed on MIY page");
    }

    @Then("^Clicks on \"([^\"]*)\" button on Build Page$")
    public void clicksOnButtonOnBuildPage(String buttonName) {
        buildpage.clickContinueBtn();
    }
}
