package stepDefinitions;

import commonMethods.commonMethods;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;
import java.io.IOException;

public class Hooks extends base {

    @Before
    public void start() throws AWTException, IOException {
        // Use the ThreadLocal driver directly
        WebDriver driver = initializeDriver();
        driver.get(commonMethods.getProperty("url"));
        System.out.println("✅ Hooks invoked, browser started");
    }

    @After
    public void close() {
        quitDriver(); // Proper ThreadLocal cleanup
        System.out.println("✅ Hooks invoked, browser closed");
    }
}
