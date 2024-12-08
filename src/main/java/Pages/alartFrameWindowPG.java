package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class alartFrameWindowPG {
    WebDriver driver;
    objectManager method;

    public alartFrameWindowPG() throws AWTException {
        method=new objectManager();
        driver= method.base().initializeDriver();
    }
    public void newTab(By Tab) throws IOException, AWTException {

        method.commonMethods().click(Tab);
        method.commonMethods().switchToTab();

    }
}
