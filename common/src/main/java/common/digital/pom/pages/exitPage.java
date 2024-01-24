package common.digital.pom.pages;


import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.exitPageLocator;
import common.digital.pom.locator.login;
import common.shared.Utility.UtlActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class exitPage extends exitPageLocator
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    public static Logger log = LogManager.getLogger(exitPage.class);

    public exitPage(WebDriver driver) {
        this.driver = driver;
        exitPageLocators();
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
    }

    public boolean validatePageLoad() {
        boolean chkUserTxtDisplayed = false;
        try{
            chkUserTxtDisplayed = actions
                .waitForElementToBeDisplayed(By.xpath(gradeAbandonmentPopup), Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Abandonment pop-up not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return chkUserTxtDisplayed;
    }

    public void clickOnMazdaLogo()
    {
        try{
        actions.waitForElementToBeDisplayed(mazdaLogOnHeader, Duration.ofSeconds(10));
        actions.click(mazdaLogOnHeader);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Mazda Logo not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void validatePopUpMsg(String actualMsg1,String actualMsg2)
    {
        try{
        validatePageLoad();
        String expectedMsg1 = actions.getText(gradeAbandonmentPopupText1);
        String expectedMsg2 = actions.getText(gradeAbandonmentPopupText2);
        Assert.assertEquals(actualMsg1,expectedMsg1);
        Assert.assertEquals(actualMsg2,expectedMsg2);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("pop-up message not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickOnBuildYoursBtn()
    {
        try{
        actions.waitForElementToBeDisplayed(buildYoursBtn, Duration.ofSeconds(10));
        actions.click(buildYoursBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Build Yours Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickOnExitBuildBtn()
    {
        try{
        actions.waitForElementToBeDisplayed(exitBuildBtn, Duration.ofSeconds(10));
        actions.click(exitBuildBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Exit Build Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void validateHomePage()
    {
        try {
            actions.waitForElementToBeDisplayed(homePage, Duration.ofSeconds(10));
            actions.isDisplayed(homePage, 10);
        }catch(Exception e)
    {
        digitalActions.updateFailureStatus("Home Page not found");
        log.error("Unable to locate element: "+e.getMessage());
    }
    }

    public void clickOnBuildYourModel()
    {
        try{
        actions.waitForElementToBeDisplayed(buildYourModel, Duration.ofSeconds(10));
        actions.click(buildYourModel);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Build Your Model not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickOnBtnByName(String bName)
    {
        String btnName = buttonName.replace("ButtonName", bName);
        try{
            By element = By.xpath(btnName);
            actions.waitForElementToBeDisplayed(element, Duration.ofSeconds(10));
            actions.click(element);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus(bName+" not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public String validateSaveForm()
    {
        String actualSaveFormText = "";
        try {
            actions.waitForElementToBeDisplayed(saveForm, Duration.ofSeconds(10));
            actualSaveFormText = actions.getText(saveForm);
            Assert.assertEquals("SAVE YOUR BUILD", actualSaveFormText);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Build Save form not found");
        }
        return actualSaveFormText;
    }

    public void validateBuildPopUpMsg(String actualMsg1,String actualMsg2)
    {
        try{
            String expectedMsg1 = actions.getText(buildAbandonmentPopupText1).trim();
            String expectedMsg2 = actions.getText(buildAbandonmentPopupText2).trim();
            Assert.assertTrue(expectedMsg1.contains(actualMsg1));
            Assert.assertTrue(expectedMsg2.contains(actualMsg2));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("pop-up message not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void closeAbandonmentPopup()
    {
        try{
            actions.waitForElementToBeDisplayed(closePopup, Duration.ofSeconds(10));
            actions.click(closePopup);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("close btn not found on Abandonment pop-up");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }




}
