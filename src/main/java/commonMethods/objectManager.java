package commonMethods;

import org.openqa.selenium.WebDriver;
import testBase.base;
import java.awt.*;
import java.io.IOException;
public class objectManager {
    WebDriver driver;
    base base;

    public objectManager() throws IOException, AWTException {
        base= new base();
        driver= base.initializeDriver();
    }
    public classObjectManager classObjectManager() throws IOException, AWTException {
        return new classObjectManager();
    }
    public pageObjectManager pageObjectManager() throws IOException, AWTException {
        return new pageObjectManager();
    }
    public commonMethods commonMethods() throws IOException, AWTException {
        return new commonMethods();
    }
    public base base(){
        return new base();

    }
}
