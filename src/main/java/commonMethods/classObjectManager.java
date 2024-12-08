package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class classObjectManager {
    WebDriver driver;
    objectManager method;

    public classObjectManager() throws AWTException {
        method=new objectManager();
        driver= method.base().initializeDriver();
    }
    public WebElement webElement(By element) {
        return driver.findElement(element);
    }
    public Select selectElement(WebElement element) {
        return new Select(element);

    }
    public Actions actions() {
        return new Actions(driver);
    }
}
