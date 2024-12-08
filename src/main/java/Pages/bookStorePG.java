package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;

public class bookStorePG {
    WebDriver driver;
    commonMethods methods;

    public bookStorePG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }

}
