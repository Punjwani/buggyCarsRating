package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"StepDefinitions"},
        monochrome = true,
        plugin =
                {
                "pretty", "html:target/Reports/HtmlReports/report.html",
                "pretty", "json:target/Reports/JsonReports/report.json",
                "pretty", "junit:target/Reports/JunitReports/report.xml"
                },
        tags = "@RegressionTest"
)
public class testRunner {
}
