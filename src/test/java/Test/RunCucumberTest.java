package Test;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasspathResource("FeatureFiles/testForms.feature") // This should match the *classpath-relative* folder
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "Stepdefinition")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
}
