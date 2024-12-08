package Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles/", glue = "Stepdefinition",
        plugin = {"pretty",                                     // Console output
                "html:TestEvidences/cucumber-reports/html-report.html", // HTML report
                "json:TestEvidences/cucumber-reports/cucumber.json",  // JSON report
                "junit:TestEvidences/cucumber-reports/cucumber.xml",  // JUnit report
                "rerun:TestEvidences/rerun.txt"})                      // Rerun failed scenarios})

public class TestRunner_End2End {
}
