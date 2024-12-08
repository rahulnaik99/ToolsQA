package Stepdefinition;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;

public class hooks {
    WebDriver driver;
    base base;

    public hooks() throws AWTException {
        base= new base();
        driver= base.initializeDriver();
    }
    @After
    public void close()
    {
        driver.quit();
    }
}