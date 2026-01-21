package Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions
        (features = "src/test/resources/FeatureFiles/testBookStoreApplication.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "rerun:target/rerun.txt"
        },
        monochrome = true
)
public class TestRunnerBookStore extends AbstractTestNGCucumberTests {

    // Enable ONLY when Grid parallel is ready
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}