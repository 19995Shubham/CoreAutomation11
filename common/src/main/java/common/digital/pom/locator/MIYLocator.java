package common.digital.pom.locator;

import org.openqa.selenium.By;

public class MIYLocator
{
    protected By MIYLabel;

    protected By MIYPageTitle;

    protected By bookTestDriveBtn;

    protected By bookTestDrivePageTitle;

    protected By financeTab;

    protected By financeEnquiryBtn;

    protected By financeEnquiryTitle;

    protected By saveAndEmailBuild;

    protected By fName;

    protected By email;

    protected By privacyPolicyChkBox;

    protected By acknowledgeChkBox;

    protected By saveYourBuildBtn;

    protected By driveAwayPrice;

    protected By accordianList;

    protected By designLabelList;

    protected By editBtn;

    protected By saveBtn;


    public void MIYLocators()
    {
        MIYLabel = By.xpath("//span[text()='MAKE IT YOURS']/../../button[contains(@class,'active')]");
        MIYPageTitle = By.xpath("//h1[text()='BUILD SUMMARY']");
        fName = By.xpath("//input[@name='firstName']");
        email = By.xpath("//input[@name='email']");
        bookTestDriveBtn = By.xpath("//a[text()='Book a test drive']");
        bookTestDrivePageTitle = By.xpath("//div[contains(@class,'BookTestDrive')]/h1");
        financeEnquiryBtn = By.xpath("//a[text()='Make a Finance enquiry']");
        financeEnquiryTitle = By.xpath("//div[contains(@class,'FinanceCalculatorForm')]//h1");
        financeTab = By.xpath("//a//span[text()='Finance']");
        saveAndEmailBuild = By.xpath("//button[text()='Save & Email your build']");
        privacyPolicyChkBox = By.xpath("//input[@name='privacyPolicy']/..//label[1]");
        acknowledgeChkBox = By.xpath("//input[@name='optIn']/..//label[1]");
        saveYourBuildBtn = By.xpath("//button[text()='Save Your Build']");
        driveAwayPrice = By.xpath("//h3[text()='Driveaway from']/../following-sibling::h4");
        accordianList = By.xpath("//span[contains(@class,'AccordionTitleBoxIcon')]");
        designLabelList = By.xpath("//div[contains(@class,'BuildToolMIYMyDesign')]//h6");
        editBtn = By.xpath("//h6[contains(@class, 'WithDetails') and b[text()='Model']]" +
                "/..//following-sibling::div//span");
        saveBtn = By.xpath("//button[text()='Save']");
    }
}
