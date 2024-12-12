package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;

import java.io.IOException;
import java.time.Duration;

public class base {

    public static WebDriver driver;

    public WebDriver initializeDriver() throws AWTException {
        if (driver == null) {
            // Ensure the path to chromedriver is correct
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            org.openqa.selenium.Point leftPosition = new org.openqa.selenium.Point(0, 0); // x = 0, y = 0
            driver.manage().window().setPosition(leftPosition);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/");
            return driver;
        }
        return driver;
    }
}
