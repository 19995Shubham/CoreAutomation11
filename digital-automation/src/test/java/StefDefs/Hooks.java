package StefDefs;

import common.shared.Test.BaseTest_Digital;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseTest_Digital
{
    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getName().contains("Grade step")) {
            lunchApplication();
        }
    }
    @After(order = 0)
    public void quitBrowser(Scenario scenario) {
        if (scenario.getName().contains("MIY step")) {
            if (driver != null) {
                driver.quit();
            }
        }
   }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            if (driver != null) {
                byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcePath, "image/png", screenshotName);
            }

        }
    }
}
