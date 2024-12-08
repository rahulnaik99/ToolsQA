package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class objectManager {
    WebDriver driver;
    pageObjectManager pg;

    public objectManager() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
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
