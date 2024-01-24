package common.digital.pom.pages;


import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.buildLocator;
import common.shared.Utility.UtlActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buildPage extends buildLocator
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    public static Logger log = LogManager.getLogger(buildPage.class);


    public buildPage(WebDriver driver) {
        this.driver = driver;
        buildLocators();
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
    }

    public void validatePageLoad() {
       actions.waitForElementToBeDisplayed(builePageModelImg, Duration.ofSeconds(10));
    }

    public void validateBuildPageCards()
    {
        try {
            actions.waitForElementToBeDisplayed(buildPageHeader, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Page Header Not found");
        }
    }


    public void validateEngineTitles(String[] expectedEngineTitles)
    {
        try{
            List<WebElement> engineTitle = driver.findElements(engineNameList);
            List<String> actualEngineTitle = new ArrayList<>();
            for(WebElement element:engineTitle)
            {
                actualEngineTitle.add(element.getText());
            }
            log.info("Actual Engine titles are: "+actualEngineTitle);
            Assert.assertEquals(Arrays.asList(expectedEngineTitles), String.valueOf(actualEngineTitle));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Engine Title Not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickHelpMeChoose()
    {
        try {
            actions.waitForElementToBeDisplayed(helpMeChooseBtn, Duration.ofSeconds(10));
            actions.click(helpMeChooseBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Help Me Choose button Not found");
        }
    }

    public void selectColor(String colorName)
    {
        try {
            String color = chooseColor.replace("sampleColor", colorName);
            System.out.println("Color xpath: " + color);
            actions.waitForElementToBeDisplayed(By.xpath(color), Duration.ofSeconds(25));
            By colorLocator = By.xpath(color);
            digitalActions.scrollByIndex(colorLocator);
            Thread.sleep(4000);
            digitalActions.clickElementByActionClass(colorLocator);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus(colorName+" Not found");
        }
    }

    public void validateSelectedColorName(String expectedColor)
    {
        try {
            String actualColor = actions.getText(selectedColor);
            Assert.assertEquals(expectedColor, actualColor);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Color Name not matching");
        }
    }

    public void selectInterior(String interiorName) {
        try{
            String interior = chooseInterior.replace("sampleInterior", interiorName);
            System.out.println("Color xpath: " + interior);
            actions.waitForElementToBeDisplayed(By.xpath(interior), Duration.ofSeconds(20));
            By interiorLocator = By.xpath(interior);
            digitalActions.scrollByIndex(interiorLocator);
            digitalActions.clickElementByActionClass(interiorLocator);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Interior not found");
        }
    }

    public void validateSelectedInteriorName(String expectedInterior)
    {
        try {
            String actualInterior = actions.getText(selectedInterior);
            Assert.assertEquals(expectedInterior, actualInterior);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Interior Name not matching");
        }
    }

    public void selectWheels(String wheelName)
    {
        try {
            String wheel = chooseWheels.replace("sampleWheel", wheelName);
            System.out.println("Wheel xpath: " + wheel);
            actions.waitForElementToBeDisplayed(By.xpath(wheel), Duration.ofSeconds(20));
            By wheelLocator = By.xpath(wheel);
            digitalActions.scrollByIndex(wheelLocator);
            digitalActions.clickElementByActionClass(wheelLocator);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Wheels not found");
        }
    }

    public void validateSelectedWheelName(String expectedWheel)
    {
        try {
            String actualWheel = actions.getText(selectedWheels);
            Assert.assertEquals(expectedWheel, actualWheel);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Wheel Name not matching");
        }
    }

    public String selectedEngine(String[] engineList)
    {
        String selectedEngineName ="";
        try {
            selectedEngineName = actions.getText(selectedEngine);
            List<String> myList = Arrays.asList(engineList);

            Assert.assertTrue(myList.contains(selectedEngineName));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus(selectedEngineName+"  not found");
        }
        return selectedEngineName;
    }

    public void clickOnFooterEstimateRepayment()
    {
        try
        {
            actions.waitForElementToBeDisplayed(estimateRepayments, Duration.ofSeconds(20));
            actions.click(estimateRepayments);
        }catch(Exception e){
            digitalActions.updateFailureStatus("Estimate Repayments Btn not found");
            log.error("Unable to click on Estimate Repayment");
        }
    }

    public void clickContinueBtn()
    {
        actions.waitForElementToBeDisplayed(continueBtn, Duration.ofSeconds(20));
        digitalActions.scrollByIndex(continueBtn);
        digitalActions.clickElementByActionClass(continueBtn);
    }


}
