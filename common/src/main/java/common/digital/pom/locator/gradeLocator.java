package common.digital.pom.locator;

import org.openqa.selenium.By;

public class gradeLocator
{
    protected By pageTitle;

    protected String totalGradeCards;

    protected By gradeCardsHeader;

    protected By gradeCardsPrice;

    protected String estimateRepayment;

    protected String keyFeatures;

    protected By mazdaLogo;

    protected By financePopupTabs;

    protected By priceTab;

    protected By driveAwayPrice;

    protected By featureTitles;

    protected By depositTxt;

    protected By termRadioBtn;

    protected By interestRate;

    protected By totalKm;

    protected By finalPayment;

    protected By frequency;

    protected String frequencyByName;

    protected By estimateRepayAmount;

    protected By financeDetails;

    protected String featureName;

    protected By nextArrow;

    protected By closeKeyFeature;

    protected By nextBtn;

    protected By compareRangeText;

    protected By repaymentModalText;

    protected By repaymentModalCloseBtn;


    public void gradeLocators()
    {
        pageTitle = By.xpath("//h4[contains(., 'Choose a grade for your Mazda CX-60')]");
        totalGradeCards = "//div[@class='slick-track']//div[@data-index]";
        gradeCardsHeader = By.xpath(totalGradeCards +
                "//div[contains(@class,'BuildToolGradeStickyHeading')]/h5");
//        gradeCardsPrice = By.xpath(totalGradeCards +
//                "//div[contains(@class,'BuildToolGradeStickyHeading')]/h5");
        gradeCardsPrice = By.xpath("//h5[contains(@class, '_SameHeadingStyle_c60d3') and contains(@class, '_H5_c60d3') and contains(@class, '_WithDetails_c60d3')]");
        estimateRepayment = "//button[text()='sampleText']";
        keyFeatures = totalGradeCards +"[indexNum]"+
                "//div[contains(@class,'BuildToolGradeIconGrid')]//div/div";
        mazdaLogo = By.xpath("//div[contains(@class,'FinanceCalculatorLogo')]");
        financePopupTabs = By.xpath("//div[contains(@class,'FinancePopup')]" +
                "//li[@data-test='tab-item']");
        priceTab = By.xpath("//li[@data-test='tab-item']//span[text()='PRICE']");
        driveAwayPrice = By.xpath("//h4[text()='Driveaway from']/../following-sibling::h4");
        featureTitles = By.xpath("//span[contains(@class,'AccordionTitleBoxText')]");
        depositTxt = By.xpath("//input[@name='deposit']");
        termRadioBtn = By.xpath("//input[@name='term' and @checked='']");
        interestRate = By.xpath("//div[contains(@class,'InputRangeValue')]");
        totalKm = By.xpath("//span[contains(text(),'End odometer')]/following-sibling::span");
        finalPayment = By.xpath("//span[contains(text(),'(GFV)')]/following-sibling::div");
        frequency = By.xpath("//input[@name=['frequency']/following-sibling::label]");
        frequencyByName = "//input[@name='frequency']/following-sibling::label[text()='freqName']";
        estimateRepayAmount = By.xpath("//*[text()='Estimated repayments']/../span/span[1]");
        financeDetails = By.xpath("//div[@data-finance-details]");
        featureName = "//button[text()='sampleButtonText']";
        nextArrow = By.xpath("//div[@style='transform: rotate(90deg);']");
        closeKeyFeature = By.xpath("//div[contains(@class,'ModalClose')]");
        nextBtn = By.xpath("//button[text()='Next']");
        compareRangeText = By.xpath("//div[contains(@class,'CompareToolSelectorNameplate')]/h6");
        repaymentModalText = By.xpath("//div/h4[text()='MAZDA ASSURED REPAYMENT CALCULATOR']");
        repaymentModalCloseBtn = By.xpath("//div/h4[text()='MAZDA ASSURED REPAYMENT CALCULATOR']" +
                "/../../div[contains(@class,'ModalClose')]");


    }
}
