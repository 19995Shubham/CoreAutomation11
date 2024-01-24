package common.digital.pom.locator;

import org.openqa.selenium.By;

public class login
{
    protected By userNameTxt;
    protected By passwordTxt;
    protected By loginBtn;
    protected By mazdaLogo;
    protected String buyingToolsBtn;
    protected String locator;
    protected By buildYourMazdaBtn;
    protected By buildYourMazdaText;
    protected By popUpCloseBtn;
    protected String mazdaC60Model;
    protected By mazdaC60ModelLink;
    protected By mazdaC60ModelType;
    protected By postCodeTxt;
    protected By postCodeValue;
    protected By buyerType;
    protected By submitBtn;

    protected By humburgerMenu;
    protected By buyingToolPlusIcon;

    protected By  buildYourMazdaBtnAndroid;

    public void loginLocators()
    {
        userNameTxt = By.xpath("//input[@id='LoginControl_UserName']");
        passwordTxt = By.xpath("//input[@id='LoginControl_Password']");
        loginBtn = By.xpath("//input[@value='Log in']");
        mazdaLogo = By.xpath("//div[@id='header']//a/img[@alt='Mazda']");
        buyingToolsBtn = "//a[text()='sampleText']";
        locator = "//a//h5[contains(normalize-space(), 'Build Your Mazda')]";
        buildYourMazdaBtn = By.xpath(locator);
        buildYourMazdaText = By.xpath(locator + "//following-sibling::span");
        popUpCloseBtn = By.xpath("//div[@role='dialog']//div[contains(@class,'ModalClose')]");
        mazdaC60Model = "//a[contains(@href, '/build/cx-60/') and contains(., 'Mazda CX-60')]";
        mazdaC60ModelLink = By.xpath(mazdaC60Model);
        mazdaC60ModelType = By.xpath(mazdaC60Model + "//following-sibling::span");
        postCodeTxt = By.xpath("//input[@name='region']");
        postCodeValue = By.xpath("//ul[@data-test='input-searchable']//li/a");
        buyerType = By.xpath("//div[@data-test='radiogroup']//input");
        submitBtn = By.xpath("//button[text()='Submit']");


    }
    public void androidLocator(){

        buildYourMazdaBtnAndroid = By.xpath("//a[text()='Build Your Mazda']");
        humburgerMenu = By.xpath("//span[@data-test='hamburger']");
        buyingToolPlusIcon = By.xpath("(//a[text()='Buying Tools']/div/span/span)[2]");
    }
}
