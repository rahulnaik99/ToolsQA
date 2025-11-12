package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import commonMethods.commonMethods;

import java.awt.AWTException;
import java.net.URL;
import java.time.Duration;

public class base {

    public static WebDriver driver;

    public WebDriver initializeDriver() throws AWTException {
        if (driver == null) {
            try {
                // 👉 Use localhost if running Docker on your local machine
                // or replace with container name if test runs inside Docker (e.g. "http://selenium:4444")
                URL gridUrl = new URL("http://localhost:4444");

                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-gpu",
                        "--disable-extensions",
                        "--disable-software-rasterizer",
                        "--disable-site-isolation-trials",
                        "--remote-allow-origins=*",
                        "--window-size=1920,1080"
                );

                // options.addArguments("--headless=new"); // uncomment if you want headless mode

                driver = new RemoteWebDriver(gridUrl, options);
              if (driver instanceof RemoteWebDriver) {
                     ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                }
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

                driver.get(commonMethods.getProperty("url"));
                System.out.println(commonMethods.getProperty("url"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("⚠️ Failed to initialize WebDriver: " + e.getMessage());
            }
        }
        return driver;
    }
}
