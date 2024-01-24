package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "StefDefs",
        features = "src/test/resources/feature",
        tags = "@digital",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
 public class TestDigitalRunner extends AbstractTestNGCucumberTests{
}
