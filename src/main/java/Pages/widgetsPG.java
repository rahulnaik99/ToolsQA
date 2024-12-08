package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;
import java.io.IOException;

public class widgetsPG {
    WebDriver driver;
    commonMethods methods;

    public widgetsPG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }

}
