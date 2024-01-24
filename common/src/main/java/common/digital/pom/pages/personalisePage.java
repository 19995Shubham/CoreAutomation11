package common.digital.pom.pages;


import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.personaliseLocator;
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

public class personalisePage extends personaliseLocator
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    public static Logger log = LogManager.getLogger(personalisePage.class);

    public personalisePage(WebDriver driver) {
        this.driver = driver;
        personaliseLocators();
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
    }

    public void validatePageLoad() {
        try {
            actions.waitForElementToBeDisplayed(personalizeLabel, Duration.ofSeconds(10));
        }catch (Exception e)
        {
            digitalActions.updateFailureStatus("Personalize page not found");
        }
    }

    public void validatePersonalisePageCards()
    {
        try {
            actions.waitForElementToBeDisplayed(optionalPackTitle, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Personalize page Title Not found");
        }
    }

    public void validateOptionalPacks(String[] expectedOptionalPacks)
    {
        try{
            List<WebElement> optionalPacks = driver.findElements(optionalPackList);
            List<String> actualOptionalPacks = new ArrayList<>();
            for(WebElement element:optionalPacks)
            {
                actualOptionalPacks.add(element.getText());
            }
            log.info("Actual Optional Packs are: "+actualOptionalPacks);
            Assert.assertEquals(Arrays.asList(expectedOptionalPacks), String.valueOf(actualOptionalPacks));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Optional Packs Not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickOnOptionalPackButton(String buttonName)
    {
        try
        {
            String modifiedXpath = optionsPackBtn.replace("sampleText",buttonName);
            List<WebElement> element = driver.findElements(By.xpath(modifiedXpath));
            element.get(0).click();
            Thread.sleep(4000);
        }catch(Exception e){
            digitalActions.updateFailureStatus(buttonName+" not found");
            log.error("Unable to click on "+buttonName);
        }
    }

    public void validateDetailsPageTitle(String expectedTitle)
    {
        try {
            String actualTitle = actions.getText(detailsTitle);
            Assert.assertEquals(expectedTitle, actualTitle);
            actions.waitForElementToBeDisplayed(nextArrow, Duration.ofSeconds(10));
            actions.click(nextArrow);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Details Page title not matching");
        }
    }

    public void closeModal()
    {
        try {
            actions.waitForElementToBeDisplayed(modalCloseBtn, Duration.ofSeconds(10));
            actions.click(modalCloseBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Close Btn Not found");
        }
    }

    public void clickConfirmBtn()
    {
        try {
            actions.waitForElementToBeDisplayed(confirmBtn, Duration.ofSeconds(10));
            actions.click(confirmBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Close Btn Not found");
        }
    }

    public String getDriveAwayPrice()
    {
        try {
            actions.waitForElementToBeDisplayed(driveAwayPrice, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
        return actions.getText(driveAwayPrice);
    }



}
