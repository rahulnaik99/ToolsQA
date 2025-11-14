package Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/FeatureFiles/testElements.feature", glue = "stepDefinitions",
        plugin = {"pretty",                                     // Console output
                "html:TestEvidences/cucumber-reports/html-report.html", // HTML report
                "json:TestEvidences/cucumber-reports/cucumber.json",  // JSON report
                "junit:TestEvidences/cucumber-reports/cucumber.xml",  // JUnit report
                "rerun:TestEvidences/rerun.txt"})                      // Rerun failed scenarios})

public class TestRunnerElements extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)  // This makes scenarios inside this runner parallel
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
