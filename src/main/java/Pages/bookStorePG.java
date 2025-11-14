package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.WebDriver;
import testBase.base;
import commonMethods.objectManager;

import java.awt.*;
import java.io.IOException;

public class bookStorePG {
    WebDriver driver;
    objectManager method;

    public bookStorePG() throws IOException, AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

}
