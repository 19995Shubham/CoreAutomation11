package common.digital.pom.pages;


import com.browserstack.BrowserStackSdk;
import com.browserstack.PercySDK;
import common.digital.Utility.UtlDigitalActions;
import common.digital.pom.locator.login;
import common.shared.Utility.UtlActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class digitalLoginPage extends login
{
    private WebDriver driver;
    UtlActions actions;
    UtlDigitalActions digitalActions;
    MutableCapabilities capabilities;
    public static Logger log = LogManager.getLogger(digitalLoginPage.class);


    public digitalLoginPage(WebDriver driver) {
        this.driver = driver;
        loginLocators();
        androidLocator();
        actions = new UtlActions(driver);
        digitalActions = new UtlDigitalActions(driver);
    }

    HashMap<String, Object> currentPlatform = BrowserStackSdk.getCurrentPlatform();
       // System.out.println("currentPlatform.." + currentPlatform);

    Object os = currentPlatform.get("os");
    Object osVersion = currentPlatform.get("osVersion");
    Object browserName = currentPlatform.get("browserName");
    Object deviceName = currentPlatform.get("deviceName");

    public boolean validatePageLoad() {
        boolean chkUserTxtDisplayed = false;
        try{
        chkUserTxtDisplayed = actions
                .waitForElementToBeDisplayed(userNameTxt, Duration.ofSeconds(10));
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("UserName not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
        return chkUserTxtDisplayed;
    }

    public void setUsername(String userName)
    {
        try{
        log.info("Logged in User Name is: "+userName);
        System.out.println("Useranme locator: "+userNameTxt);
        actions.setText(userNameTxt, userName);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("UserName not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void setPassword(String userPass)
    {
        try{
        actions.setText(passwordTxt, userPass);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Password not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickLogin()
    {
        try{
        actions.click(loginBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("SignIn Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void setLogInCredentials(String userName, String password)
    {
        try {
            setUsername(userName);
            setPassword(password);
            clickLogin();
            PercySDK.screenshot(driver, "Home");
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Unable to Login with username "+userName+
                    " and password "+password);
            log.error("Unable to login: "+e.getMessage());
        }
    }

    public void validateHomePageBrokenLinks()
    {
        try{
        actions.waitForElementToBeDisplayed(mazdaLogo, Duration.ofSeconds(10));
        digitalActions.TestBrokenLink();
        }catch(Exception e)
        {
            System.out.println("Unable to locate element: "+e.getMessage());
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickBuyingTools(String buttonName)
    {

        try {
            if(os != null) {
                if ("Edge".equals(browserName) && "Windows".equals(os) ||
                        "chrome".equals(browserName) && "OS X".equals(os)) {
            System.out.println("Inside if block");
            String actualButtonName = buyingToolsBtn.replace("sampleText", buttonName);
            By buyingToolsBtns = By.xpath(actualButtonName);
            actions.waitForElementToBeDisplayed(buyingToolsBtns, Duration.ofSeconds(10));
            actions.click(buyingToolsBtns);
                }
            }
            else if(deviceName != null) {
                if ("chrome".equals(browserName) && "Samsung Galaxy S22 Ultra".equals(deviceName) ||
                        "safari".equals(browserName) && "iPhone 15 Pro".equals(deviceName)) {
                    System.out.println("Inside else block");
                    actions.waitForElementToBeDisplayed(humburgerMenu, Duration.ofSeconds(10));
                    actions.click(humburgerMenu);
                    actions.click(buyingToolPlusIcon);
                }
            }
        } catch (Exception e) {
            digitalActions.updateFailureStatus("Buying tool option not found");
            log.error("Unable to locate element: " + e.getMessage());
        }
    }

    public void clickBuildYourMazda()
    {
      try {
          if(os != null) {
              if ("Edge".equals(browserName) && "Windows".equals(os) ||
                      "chrome".equals(browserName) && "OS X".equals(os))
          actions.waitForElementToBeDisplayed(buildYourMazdaBtn, Duration.ofSeconds(10));
          actions.click(buildYourMazdaBtn);
          }

           else if(deviceName != null) {
                  if ("chrome".equals(browserName) && "Samsung Galaxy S22 Ultra".equals(deviceName) ||
                          "safari".equals(browserName) && "iPhone 15 Pro".equals(deviceName)) {
                      actions.waitForElementToBeDisplayed(buildYourMazdaBtnAndroid, Duration.ofSeconds(10));
                      actions.click(buildYourMazdaBtnAndroid);
                  }
                  }
      } catch (Exception e) {
          digitalActions.updateFailureStatus("Build Your Mazda not found");
          log.error("Unable to locate element: " + e.getMessage());
      }
    }

    public void validateBuildYourMazdaText(String actualBuildYourMazdaText)
    {
        if ("Edge".equals(browserName) && "Windows".equals(os) ||
                "Chrome".equals(browserName) && "OS X".equals(os)) {
            try {
                actions.waitForElementToBeDisplayed(buildYourMazdaText, Duration.ofSeconds(10));
                String expectedBuildYourMazdaText = actions.getText(buildYourMazdaText);
                Assert.assertEquals(expectedBuildYourMazdaText, actualBuildYourMazdaText);
                log.info("Actual Build your Mazda Text is: " + actualBuildYourMazdaText);
                log.info("Expected Build your Mazda Text is: " + expectedBuildYourMazdaText);
            } catch (Exception e) {
                digitalActions.updateFailureStatus(actualBuildYourMazdaText+" not found");
                log.error("Unable to locate element: " + e.getMessage());
            }
       }
    }

    public void clickCloseBtn()
    {
        try{
        actions.waitForElementToBeDisplayed(popUpCloseBtn, Duration.ofSeconds(10));
        actions.click(popUpCloseBtn);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Close Btn not found");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }

    public void clickSelectedModel(String expectedModelName)
    {
        try{
        String modelType = actions.getText(mazdaC60ModelType);
        Assert.assertEquals(modelType,"Medium SUV");
        String actualModelname = actions.getText(mazdaC60ModelLink);
        Assert.assertTrue(actualModelname.contains(expectedModelName));
        actions.click(mazdaC60ModelLink);
        }catch(Exception e)
        {
            digitalActions.updateFailureStatus("Model name not matching");
            log.error("Unable to locate element: "+e.getMessage());
        }
    }
     public String enterAndSelectPostCode(String postcode)
     {
         String postCodeName = null;
         try {
             actions.waitForElementToBeDisplayed(postCodeTxt, Duration.ofSeconds(10));
             actions.setText(postCodeTxt, postcode);
             Thread.sleep(5000);
             actions.waitForElementToBeDisplayed(postCodeValue, Duration.ofSeconds(10));
             postCodeName = actions.getText(postCodeValue);
             actions.click(postCodeValue);
         } catch(Exception e){
             digitalActions.updateFailureStatus(postCodeName+" not found");
             log.error("Unable to enter post code: "+e.getMessage());
         }
         return postCodeName;
     }
     public void validateBuyerType(String buyerTypeName)
     {
         try{
         List<WebElement> element = driver.findElements(buyerType);
         boolean status = false;
         for(WebElement buyertype:element)
         {
             if(buyertype.getAttribute("name").equalsIgnoreCase(buyerTypeName))
             {
                status = buyertype.isSelected();
                break;
             }
         }
         Assert.assertTrue(status, "Buyer Type selected as: "+buyerTypeName);
         }catch(Exception e)
         {
             digitalActions.updateFailureStatus(buyerTypeName+" not found");
             log.error("Unable to locate element: "+e.getMessage());
         }
     }

     public void clickOnSubmit()
     {
         try{
         actions.waitForElementToBeDisplayed(submitBtn, Duration.ofSeconds(10));
         actions.click(submitBtn);
         }catch(Exception e)
         {
             digitalActions.updateFailureStatus("Submit Btn not found");
             log.error("Unable to locate element: "+e.getMessage());
         }
     }

}
