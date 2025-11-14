package Test;

import io.cucumber.core.options.Constants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.testng.annotations.DataProvider;


@Suite
@SelectClasspathResource("FeatureFiles/testForms.feature") // This should match the *classpath-relative* folder
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)  // This makes scenarios inside this runner parallel
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
