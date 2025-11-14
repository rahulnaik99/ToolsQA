package commonMethods;

import Pages.*;
import testBase.base;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class pageObjectManager {
    WebDriver driver;
    objectManager method;

    public pageObjectManager() throws IOException, AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    public alartFrameWindowPG alartFrameWindowPG() throws IOException, AWTException {
        return new alartFrameWindowPG();
    }

    public bookStorePG bookstorePG() throws IOException, AWTException {
        return new bookStorePG();
    }

    public elementPG elementPG() throws IOException, AWTException {
        return new elementPG();
    }

    public interactionsPG interactionsPG() throws IOException, AWTException {
        return new interactionsPG();
    }

    public formPG formPG() throws IOException, AWTException {
        return new formPG();
    }

    public widgetsPG widgetsPG() throws IOException, AWTException {
        return new widgetsPG();
    }


}
