package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class widgetsPG {
    WebDriver driver;
    objectManager method;

    public widgetsPG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

}
