package common.shared.Test;

import common.digital.library.digitalConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest_Digital extends digitalConstant
{
    public static WebDriver driver;

    public static Properties prop ;

    public static String browserName;

    public static String appUrl;

    public static String userName;

    public static String password;

    public static MutableCapabilities capabilities;


    public void readProperty()
    {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/property/configDigital.properties");
            prop.load(fis);
            browserName = prop.getProperty("browser");
            appUrl = prop.getProperty("appUrl");
            userName = prop.getProperty("username");
            password = prop.getProperty("password");
        }catch (Exception e){}
    }

    public void lunchApplication() {
        readProperty();
        try {
            capabilities = new MutableCapabilities();
            HashMap<String, String> bstackOptions = new HashMap<>();
           bstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
            capabilities.setCapability("bstack:options", bstackOptions);
            driver = new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"),
                    capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(appUrl);
        }
    }

    public void lunchBrowserInLocal()
    {
        readProperty();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(appUrl);
    }


}
