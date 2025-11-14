package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class classObjectManager {
    WebDriver driver;
    objectManager method;

    public classObjectManager() throws IOException, AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
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

    public WebDriverWait wait(int Seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(Seconds));
    }
}
