package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Practice {

    public static WebDriver driver;
//    @Test
    public void prac() throws InterruptedException, IOException, InvalidFormatException {

        // Ensure the path to chromedriver is correct
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\IdeaProjects\\ToolsQA\\src\\main\\resources\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
//            org.openqa.selenium.Point leftPosition = new org.openqa.selenium.Point(0, 0); // x = 0, y = 0
//            driver.manage().window().setPosition(leftPosition);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.naukri.com/nlogin/login?URL=http://www.naukri.com/mnjuser/recommendedjobs");
                                                        driver.manage().window().maximize();
            driver.findElement(By.id("usernameField")).sendKeys("naikrahul661@gmail.com");
        driver.findElement(By.id("passwordField")).sendKeys("Charle@777");
        driver.findElement(By.cssSelector("button[class$='blue-btn textTransform']")).click();

        driver.findElement(By.xpath("(//div[contains(@class,'tab-list-item')])[2]")).click();


        for(int i=1;i<6;i++){
            driver.findElement(By.xpath("(//i[contains(@class,'dspIB naukicon naukicon-ot-checkbox')])["+i+"]")).click();
        }
              JavascriptExecutor js = (JavascriptExecutor) driver;

//        js.executeScript("arguments[0].scrollIntoView(true);",By.cssSelector("button[class$='multi-apply-button typ-16Bold']")) ;

        driver.findElement(By.cssSelector("button[class='multi-apply-button typ-16Bold ']")).click();



    }

    }

