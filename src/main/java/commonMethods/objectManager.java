package commonMethods;

import org.openqa.selenium.WebDriver;
import testBase.base;
import java.awt.*;
public class objectManager {
    WebDriver driver;
    base base;

    public objectManager() throws AWTException {
        base= new base();
        driver= base.initializeDriver();
    }
    public classObjectManager classObjectManager() throws AWTException {
        return new classObjectManager();
    }
    public pageObjectManager pageObjectManager() throws AWTException {
        return new pageObjectManager();
    }
    public commonMethods commonMethods() throws AWTException {
        return new commonMethods();
    }
    public base base(){
        return new base();

    }
}
