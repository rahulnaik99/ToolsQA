package Stepdefinition;
import commonMethods.objectManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class hooks {
    WebDriver driver;
    objectManager method;

    public hooks() throws AWTException {
        method=new objectManager();
        driver= method.base().initializeDriver();
    }
    @After
    public void close()
    {
        driver.quit();
    }
}