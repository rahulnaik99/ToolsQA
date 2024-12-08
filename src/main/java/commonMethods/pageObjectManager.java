package commonMethods;

import Pages.*;
import testBase.base;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class pageObjectManager {
    WebDriver driver;
    objectManager method;

    public pageObjectManager() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    public alartFrameWindowPG alartFrameWindowPG() throws AWTException {
        return new alartFrameWindowPG();
    }

    public bookStorePG bookstorePG() throws AWTException {
        return new bookStorePG();
    }

    public elementPG elementPG() throws AWTException {
        return new elementPG();
    }

    public interactionsPG interactionsPG() throws AWTException {
        return new interactionsPG();
    }

    public formPG formPG() throws AWTException {
        return new formPG();
    }

    public widgetsPG widgetsPG() throws AWTException {
        return new widgetsPG();
    }


}
