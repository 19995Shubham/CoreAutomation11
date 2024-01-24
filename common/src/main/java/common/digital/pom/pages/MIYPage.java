package common.digital.pom.pages;


import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.MIYLocator;
import common.shared.Utility.UtlActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MIYPage extends MIYLocator
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    public static Logger log = LogManager.getLogger(MIYPage.class);


    public MIYPage(WebDriver driver) {
        this.driver = driver;
        MIYLocators();
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
    }

    public void validatePageLoad() {
        try {
            actions.waitForElementToBeDisplayed(MIYLabel, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
    }

    public String validateMIYPageTitle()
    {
        try {
            actions.waitForElementToBeDisplayed(MIYPageTitle, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
        return actions.getText(MIYPageTitle);
    }

    public void clickAndValidateBookTestDrive(String actualPageTitle)
    {
        try {
            actions.waitForElementToBeDisplayed(bookTestDriveBtn, Duration.ofSeconds(10));
            actions.click(bookTestDriveBtn);
            String expectedPageTitle = actions.getText(bookTestDrivePageTitle);
            Assert.assertEquals(expectedPageTitle,actualPageTitle);
            driver.navigate().back();
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
    }

    public void clickOnFinanceTab()
    {
        try {
            actions.waitForElementToBeDisplayed(financeTab, Duration.ofSeconds(10));
            actions.click(financeTab);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Finance Tab Not found");
        }
    }

    public void clickAndValidateMakeFinanceEnquiry(String actualPageTitle)
    {
        try {
            actions.waitForElementToBeDisplayed(financeEnquiryBtn, Duration.ofSeconds(10));
            actions.click(financeEnquiryBtn);
            String expectedPageTitle = actions.getText(financeEnquiryTitle);
            Assert.assertEquals(expectedPageTitle,actualPageTitle);
            driver.navigate().back();
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("MakeFinanceEnquiry Not found");
        }
    }

    public void clickOnSaveAndEmail()
    {
        try {
            actions.waitForElementToBeDisplayed(saveAndEmailBuild, Duration.ofSeconds(10));
            actions.click(saveAndEmailBuild);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("saveAndEmailBuild Not found");
        }
    }

    public void saveYourBuild()
    {
        actions.setText(fName, "Smaranika");
        actions.setText(email, "sm@abc.com");
        actions.waitForElementToBeDisplayed(acknowledgeChkBox, Duration.ofSeconds(10));
        actions.click(acknowledgeChkBox);
        actions.click(privacyPolicyChkBox);
        actions.waitForElementToBeDisplayed(saveYourBuildBtn, Duration.ofSeconds(10));
        actions.click(saveYourBuildBtn);
    }

    public String getDriveAwayPriceOnMIYPage()
    {
        try {
            actions.waitForElementToBeDisplayed(driveAwayPrice, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
        return actions.getText(driveAwayPrice);
    }

    public void clickEachAccorian()
    {
        List<WebElement> accordian = driver.findElements(accordianList);
        for(WebElement element:accordian)
        {
            if(element.isDisplayed())
            {
                element.click();
            }
        }
    }

    public void validateMyDesignLabelList(String[] expectedMyDesignLabelList)
    {
        try{
            List<WebElement> designLabelLists = driver.findElements(designLabelList);
            List<String> actualLabelList = new ArrayList<>();
            for(WebElement element:designLabelLists)
            {
                actualLabelList.add(element.getText());
            }
            log.info("Actual My Design Label are: "+actualLabelList);
            Assert.assertEquals(Arrays.asList(expectedMyDesignLabelList), String.valueOf(actualLabelList));

        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Engine Title Not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickEditBtn()
    {
        try {
            actions.waitForElementToBeDisplayed(editBtn, Duration.ofSeconds(10));
            digitalActions.scrollByIndex(editBtn);
            Thread.sleep(4000);
            digitalActions.clickElementByActionClass(editBtn);
            }catch(Exception e)
            {
                digitalActions.updateFailureStatus("Page Header Not found");
            }
        }

}
