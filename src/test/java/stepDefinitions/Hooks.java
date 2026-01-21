package stepDefinitions;
import com.aventstack.extentreports.Status;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import testBase.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.commonMethods;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import testBase.ExtentTestManager;
import testBase.base;

import java.awt.*;
import java.io.IOException;

public class Hooks extends base {
    ExtentTest test;
    @Before
    public void start(Scenario scenario) throws AWTException, IOException {
        // Use the ThreadLocal driver directly
        this.test =
                ExtentManager.getExtent().createTest(scenario.getName());

        ExtentManager.setTest(test);
        WebDriver driver = initializeDriver();
        driver.get(commonMethods.getProperty("url"));
        System.out.println("✅ Hooks invoked, browser started");
        System.out.println(System.getProperty("BROWSER"));
    }

    @After
    public void close() {
        quitDriver(); // Proper ThreadLocal cleanup
        System.out.println("✅ Hooks invoked, browser closed");
        ExtentTestManager.unload();
        this.test.getExtent().flush();
    }
    public void afterEachStep(Scenario scenario) {
        String stepName = scenario.getName(); // scenario name only

        if (scenario.isFailed()) {
            ExtentTestManager.getTest()
                    .log(Status.FAIL, "Step failed");
        } else {
            ExtentTestManager.getTest()
                    .log(Status.PASS, "Step passed");
        }
    }

}
