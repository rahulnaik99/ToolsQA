package Pages;

import commonMethods.pageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class alartFrameWindowPG {
    WebDriver driver;
    pageObjectManager pg;

    public alartFrameWindowPG() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
    }
    public void newTab(By Tab) throws IOException, AWTException {

        pg.methods().click(Tab);
        pg.methods().switchToTab();

    }
}
