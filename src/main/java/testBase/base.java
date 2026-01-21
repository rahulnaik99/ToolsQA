package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import commonMethods.commonMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class base {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver initializeDriver() throws IOException, AWTException {

        if (driver.get() == null) {

            String mode = commonMethods.getProperty("driver")
                    .toLowerCase()
                    .trim();

            if (mode.equals("remote")) {
                driver.set(remoteDriver());
                System.out.println("✅ Remote WebDriver initialized");
            }
            else if (mode.equals("local")) {
                driver.set(localDriver());
                System.out.println("✅ Local WebDriver initialized");
            }
            else {
                throw new IllegalArgumentException(
                        "Invalid 'driver' property. Must be 'remote' or 'local'."
                );
            }

            driver.get().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    // ===================== REMOTE =====================
    private WebDriver remoteDriver() throws IOException {

        URL gridUrl = new URL("http://localhost:4444");

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--remote-allow-origins=*",
                "--window-size=1920,1080"
        );

        RemoteWebDriver remoteDriver =
                new RemoteWebDriver(gridUrl, options);

        remoteDriver.setFileDetector(new LocalFileDetector());
        return remoteDriver;
    }

    // ===================== LOCAL ======================
    private WebDriver localDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // 🚀 Selenium Manager will auto-download ARM driver
        return new ChromeDriver(options);
    }

    // ===================== GET / QUIT =================
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            System.out.println("🧹 Driver closed and removed from ThreadLocal");
        }
    }
}