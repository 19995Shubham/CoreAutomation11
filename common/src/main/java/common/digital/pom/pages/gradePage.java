package common.digital.pom.pages;


import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.gradeLocator;
import common.shared.Utility.UtlActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class gradePage extends gradeLocator
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    public static Logger log = LogManager.getLogger(gradePage.class);

    public gradePage(WebDriver driver) {
        this.driver = driver;
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
        gradeLocators();
    }

    public boolean validatePageLoad() {
        boolean chkPageTitleDisplayed = false;
        try
        {
             chkPageTitleDisplayed = actions
                    .waitForElementToBeDisplayed(pageTitle, Duration.ofSeconds(20));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Grade Page title not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return chkPageTitleDisplayed;
    }

    public void validateGradeCardsHeader(String[] expectedModelNames) {
        try {
            List<WebElement> elements = driver.findElements(gradeCardsHeader);
            List<String> actualModelNames = new ArrayList<>();

            for (WebElement gradeCard : elements) {
                String modelName = gradeCard.getText().trim();
                actualModelNames.add(modelName);
            }
            log.info("Actual Model Names are: " + actualModelNames);
            Assert.assertEquals(Arrays.asList(expectedModelNames), actualModelNames,
                    "Model names do not match the expected values.");
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Model names are not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }


    public void validateGradeCardsPrice(String[] expectedPrice)
    {
        try
        {
            List<WebElement> element = driver.findElements(gradeCardsPrice);
            List<String> actualPrice = new ArrayList<>();
            for(WebElement gradePrice:element)
            {
                Thread.sleep(6000);
                String mName = gradePrice.getText();
                actualPrice.add(mName.replaceAll("[^\\d]", ""));
                System.out.println(actualPrice.add(mName));
            }
            log.info("Actual Prices are: "+actualPrice);
            Assert.assertEquals(Arrays.asList(expectedPrice), actualPrice,
                    "Model price do not match the expected values.");
        }catch(Exception e){
            digitalActions.updateFailureStatus("Model Prices are not matching");
            log.error("Unable to fetch price of grade cards: "+e.getMessage());
        }
    }

    public void clickOnFirstEstimateRepayment(String buttonName)
    {
        try
        {
            String modifiedXpath = estimateRepayment.replace("sampleText",buttonName);
            List<WebElement> element = driver.findElements(By.xpath(modifiedXpath));
            element.get(0).click();
            Thread.sleep(4000);
            validateRepaymentModel();
            actions.waitForElementToBeDisplayed(mazdaLogo, Duration.ofSeconds(20));
        }catch(Exception e){
            digitalActions.updateFailureStatus(buttonName+" not found");
            log.error("Unable to click on Estimate Repayment");
        }
    }

    public void validateKeyFeatures(String[] card1Feature,
                                    String[] card2Feature,
                                    String[] card3Feature)
    {
        try
        {
        List<String[]> listOfStringArrays = new ArrayList<>();
        for(int i =1;i<4;i++)
        {
            String feature = keyFeatures.replace("indexNum",String.valueOf(i));
            List<WebElement> element = driver.findElements(By.xpath(feature));

            List<String> cardWiseKeyFeatures = new ArrayList<>();
            for (WebElement features : element)
            {
                cardWiseKeyFeatures.add(features.getText());
            }
            String[] cardWiseKeyFeaturesArray = cardWiseKeyFeatures.toArray(new String[0]);
            listOfStringArrays.add(cardWiseKeyFeaturesArray);
        }


        for (int i = 0; i < listOfStringArrays.size(); i++) {
            System.out.println("Array " + (i + 1) + ": " + Arrays.toString(listOfStringArrays.get(i)));
        }

        // Compare listOfStringArrays with parameter values
        log.info("Expected Feature of card1: "+card1Feature);
        log.info("Actual Feature of card1: "+Arrays.toString(listOfStringArrays.get(0)));
        compareArrays(listOfStringArrays.get(0), card1Feature);
        log.info("Expected Feature of card2: "+card2Feature);
        log.info("Actual Feature of card2: "+Arrays.toString(listOfStringArrays.get(1)));
        compareArrays(listOfStringArrays.get(1), card2Feature);
        log.info("Expected Feature of card3: "+card3Feature);
        log.info("Actual Feature of card3: "+Arrays.toString(listOfStringArrays.get(2)));
        compareArrays(listOfStringArrays.get(2), card3Feature);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Different grade values not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    private void compareArrays(String[] array1, String[] array2) {
        if (Arrays.equals(array1, array2)) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Arrays are not equal.");
        }
    }

    public void validateFinancePopUpTabs(String[] expectedTabNames)
    {
       try {
        List<WebElement> tabName = driver.findElements(financePopupTabs);
        List<String> actualTabName = tabName.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        log.info("Actual Prices are: "+actualTabName);
           Assert.assertEquals(Arrays.asList(expectedTabNames), actualTabName,
                   "Finance pop-up tab names do not match the expected values.");
       }catch(Exception e)
       {
           digitalActions.updateFailureStatus("Tab names not matcing");
           log.error("Unable to locate element: "+e.getMessage());
       }
    }

    public void validateFrequencyTypes(String[] expectedFrequencyTypes)
    {
        try{
        List<WebElement> tabName = driver.findElements(frequency);
        List<String> actualFrequencyTypes = tabName.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        log.info("Actual Prices are: "+actualFrequencyTypes);
        Assert.assertEquals(Arrays.asList(expectedFrequencyTypes), actualFrequencyTypes,
                    "Finance pop-up tab names do not match the expected values.");
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Frequency types not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public String getDepositAmount()
    {
        try{
        actions.waitForElementToBeDisplayed(depositTxt, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Deposit amount not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return actions.getTextByValueAttribute(depositTxt);
    }

    public String getTenureInMonths()
    {
        int finalTenure = 0;
        try{
        actions.waitForElementToBeDisplayed(termRadioBtn, Duration.ofSeconds(10));
        String tenure =  actions.getTextByValueAttribute(termRadioBtn);
        finalTenure = (Integer.parseInt(tenure) * 12) - 1;
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Tenure in months not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return String.valueOf(finalTenure);
    }

    public String getTotaKms()
    {
        try{
        actions.waitForElementToBeDisplayed(totalKm, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Total kms not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return actions.getText(totalKm).replace("s","").trim();
    }

    public String getFinalPayment()
    {
        try{
        actions.waitForElementToBeDisplayed(finalPayment, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Final Payment not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return actions.getText(finalPayment);
    }

    public String getMonthlyPayment()
    {
        String monPay = "";
        try{
        clickWeekTab("Monthly");
        actions.waitForElementToBeDisplayed(estimateRepayAmount, Duration.ofSeconds(10));
        monPay =actions.getText(estimateRepayAmount);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Monthly payment not found");
            log.error("Unable to locate element: "+e.getMessage());
        }

        return monPay;
    }

    public void clickWeekTab(String freqName)
    {
        try{
            String frName = frequencyByName.replace("freqName", freqName);
            actions.scrollToElement(By.xpath(frName));
            actions.click(By.xpath(frName));
            Thread.sleep(3000);
        }catch(Exception e){
            digitalActions.updateFailureStatus(freqName+" not found");
            log.error("Unable to click on tab: "+freqName);
        }
    }

    public String getInterestRate()
    {
        try{
        actions.waitForElementToBeDisplayed(interestRate, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Interest Rate not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return actions.getText(interestRate);
    }

    public String getFinanceEstimateValues()
    {
        String financeText = "Based on $"+getDepositAmount()+" Deposit, "+getTenureInMonths()+" " +
                "monthly repayments of "+getMonthlyPayment()+", "+getTotaKms()+" allowance and " +
                "a final payment of "+getFinalPayment()+" to keep your Mazda.";
        return financeText;
    }

    public void clickPriceTab()
    {
        try{
        actions.waitForElementToBeDisplayed(priceTab, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Price Tab not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        actions.click(priceTab);
    }

    public void validateFeatureTitles(String[] expectedFeatures)
    {
        try{
        actions.waitForElementToBeDisplayed(driveAwayPrice, Duration.ofSeconds(10));
        List<WebElement> featureTitle = driver.findElements(featureTitles);
        List<String> actualFeatures = new ArrayList<>();
        for(WebElement element:featureTitle)
        {
            actualFeatures.add(element.getText());
        }
        log.info("Actual Feature titles are: "+actualFeatures);
       Assert.assertEquals(Arrays.asList(expectedFeatures), actualFeatures,
                    "Feature names do not match the expected values.");
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Feature titles not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void validateFirstModelFinanceDetails(String expectedFinanceDeatils)
    {
        try{
        List<WebElement> element = driver.findElements(financeDetails);
        String actualFinanceDeatils =  element.get(0).getText();
        System.out.println("Actual: "+actualFinanceDeatils);
        System.out.println("Expected: "+expectedFinanceDeatils);
        Assert.assertTrue(expectedFinanceDeatils.contains(actualFinanceDeatils),
                "Finande details texts are not matching");
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus(expectedFinanceDeatils+" not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickButtonByName(String buttonName)
    {
        try{
        String name = featureName.replace("sampleButtonText", buttonName);
        List<WebElement> elements = driver.findElements(By.xpath(name));
        elements.get(0).click();
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus(buttonName+" not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickOnNextArrow()
    {
        try{
        actions.waitForElementToBeDisplayed(nextArrow, Duration.ofSeconds(10));
        for(int i=0;i<3;i++)
        {
            actions.click(nextArrow);
        }
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Next Arrow Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void closeKeyFeatureModal()
    {
        try{
        actions.waitForElementToBeDisplayed(closeKeyFeature, Duration.ofSeconds(10));
        actions.click(closeKeyFeature);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Close Modal Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickNextBtn()
    {
        try{
        actions.waitForElementToBeDisplayed(nextBtn, Duration.ofSeconds(10));
        actions.click(nextBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Next Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void validateComparePageTitle(String expectedPageTitle)
    {
        try{
        actions.waitForElementToBeDisplayed(compareRangeText, Duration.ofSeconds(10));
        String actualPageTitle = actions.getText(compareRangeText);
        Assert.assertEquals(expectedPageTitle.toUpperCase(),actualPageTitle);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Title not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void validateRepaymentModel()
    {
        try{
        if(actions.isDisplayed(repaymentModalText,10))
            actions.click(repaymentModalCloseBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Repayment modal not displayed");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

}
