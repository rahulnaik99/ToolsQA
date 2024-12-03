package commonMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testBase.base;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
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
        System.out.print("Element noty found");
        return false;

    }
    public void enter(By element, String value){
        if (driver.findElement(element).isDisplayed()){
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(value);
            return;

        }
        System.out.print("Element noty found");


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
        return new Actions(driver);
    }
    public WebElement webElement(By element){
        return driver.findElement(element);
    }
    public void handleMultplieWindow(){
        String Originalwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window:allWindows){
            driver.switchTo().window(window);
            driver.switchTo().window(Originalwindow);
            break;
        }

    }
    public String linkChecker(By link) {
        List<WebElement> images = driver.findElements(link);
        for (WebElement image : images) {
            String src = image.getAttribute("src");
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(src).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(src + " is broken with response code: " + responseCode);
                } else {
                    return (src + " is valid.");
                }
            } catch (Exception e) {
                return (src + " is invalid or throws an exception: " + e.getMessage());
            }
        }
        return null;
    }
    public boolean isEnabled(By button){
        return driver.findElement(button).isEnabled();
    }

}
