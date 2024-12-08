package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class interactionsPG {
    WebDriver driver;
    objectManager method;

    public interactionsPG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

}
