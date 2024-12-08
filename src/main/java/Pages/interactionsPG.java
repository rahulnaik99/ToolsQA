package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;

public class interactionsPG {
    WebDriver driver;
    commonMethods methods;

    public interactionsPG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }

}
