package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testBase.base;

import java.awt.*;


public class commonMethods {
    WebDriver driver;
    public commonMethods() throws AWTException {
        base base = new base();
        this.driver=base.initializeDriver();
    }
    public boolean click(By element){
        scrollToElement(element);
        if (driver.findElement(element).isDisplayed()){


            driver.findElement(element).click();
            return true;
        }
        System.out.printf("Element noty found");
        return false;

    }
    public boolean enter(By element,String value){
        if (driver.findElement(element).isDisplayed()){
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(value);
            return true;

        }
        System.out.printf("Element noty found");
        return false;


    }

    public String fetch(By element){
        return driver.findElement(element).getText();
    }

    public void scrollToElement(By element){
        WebElement elementWeb = driver.findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",elementWeb);

    }
    public void homePage(){
        driver.get("https://demoqa.com/");
    }
    public boolean checkRadioButton(By radioButton){
        return driver.findElement(radioButton).isSelected();

    }
    public Actions actions(){
        Actions action = new Actions(driver);
        return action;
    }
    public WebElement webElement(By element){
         WebElement webElement = driver.findElement(element);
         return webElement;
    }

}
