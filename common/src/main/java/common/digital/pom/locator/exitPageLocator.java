package common.digital.pom.locator;

import org.openqa.selenium.By;

public class exitPageLocator
{
    protected By mazdaLogOnHeader;

    protected String gradeAbandonmentPopup;

    protected By gradeAbandonmentPopupText1;

    protected By gradeAbandonmentPopupText2;

    protected By buildYoursBtn;

    protected By exitBuildBtn;

    protected By buildYourModel;

    protected By homePage;

    protected String buttonName;

    protected By saveForm;

    protected String buildAbandonmentPopup;

    protected By buildAbandonmentPopupText1;

    protected By buildAbandonmentPopupText2;

    protected By closePopup;


    public void exitPageLocators()
    {
        mazdaLogOnHeader = By.xpath("//div[contains(@class,'BuildToolHeader')]//a/img[@alt='Mazda']");
        gradeAbandonmentPopup = "//div[contains(@class,'AbandonmentPopupOverseasModelMessage')]";
        gradeAbandonmentPopupText1 = By.xpath(gradeAbandonmentPopup+"//h1");
        gradeAbandonmentPopupText2 = By.xpath("("+gradeAbandonmentPopup+"//p)[1]");
        buildYoursBtn = By.xpath("//button[text()='build yours']");
        exitBuildBtn = By.xpath("//span[text()='Exit Build']");
        buildYourModel = By.xpath("//a[text()='Build Your CX-60']");
        homePage = By.xpath("//main[@class='main-content']");
        buttonName = "//*[text()='ButtonName']";
        saveForm = By.xpath("//div[@data-test='save-form']//h1");
        buildAbandonmentPopup = "//div[contains(@class,'AbandonmentPopupImageBackgroundLayer')]";
        buildAbandonmentPopupText1 = By.xpath(buildAbandonmentPopup + "//h1");
        buildAbandonmentPopupText2 = By.xpath(buildAbandonmentPopup + "//p");
        closePopup = By.xpath("//div[contains(@class,'ModalClose')]");

    }
}
