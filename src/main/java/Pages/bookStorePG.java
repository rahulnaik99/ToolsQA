package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.WebDriver;
import testBase.base;
import commonMethods.objectManager;

import java.awt.*;

public class bookStorePG {
    WebDriver driver;
    objectManager method;

    public bookStorePG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

}
