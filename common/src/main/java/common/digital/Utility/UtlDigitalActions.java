package common.digital.Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UtlDigitalActions
{
    private final WebDriver driver;

    public UtlDigitalActions(WebDriver driver) {
        this.driver = driver;
    }
    public void TestBrokenLink()
    {
        String url = null;
        try {
            List<WebElement> anchorTagsList = driver.findElements
                    (By.tagName("a"));
            for (WebElement link : anchorTagsList) {
                url = link.getAttribute("href");

                URL links = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) links.openConnection();
                httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode() == 400 || httpURLConnection.getResponseCode() == 404) {
                    System.out.println(url + " - " + httpURLConnection.getResponseMessage()+ " - " + "is a broken link");
                } else {
                    System.out.println(url + " - " + httpURLConnection.getResponseMessage());
                }
            }
        }catch(Exception e){
            System.out.println(url + " - " + "is a broken link");
        }
    }
    public void horizontalScroll(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + pixels + ", 0);");
    }

    public void verticalScroll(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ");");
    }

    public void updateFailureStatus(String failureReason)
    {
        System.out.println("Failure Reason: "+failureReason);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(
                String.format(
                        "browserstack_executor: {\"action\": \"setSessionStatus\", " +
                                "\"arguments\": {\"status\":\"failed\", \"reason\": \"%s\"}}",
                        failureReason)
        );

    }

    public void scrollByIndex(By element)
    {
        WebElement ele = driver.findElement(element);
        Point loc = ele.getLocation();
        int x = loc.getX();
        int y=loc.getY();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void clickElementByActionClass(By element)
    {
        Actions actionss = new Actions(driver);
        WebElement ele = driver.findElement(element);
        actionss.moveToElement(ele)
                .build().perform();
        ele.click();
    }
}
