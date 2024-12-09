package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class widgetsPG {
    WebDriver driver;
    objectManager method;

    public widgetsPG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }
    By time = By.id("dateAndTimePickerInput");
    By monthOption = By.cssSelector("span[class='react-datepicker__month-read-view--down-arrow']");
    By monthName = By.xpath("//div[contains(@class,'react-datepicker__month-option') and text()='April']");
    By YearOption =  By.cssSelector("span[class='react-datepicker__year-read-view--down-arrow']");
    By yearValue = By.xpath("//div[contains(@class,'react-datepicker__year-option') and text()='2023']");
    By dateoption = By.xpath("//div[contains(@class,'day--weekend') and text()='15']");
    By timeValue = By.xpath("//li[contains(@class,'react-datepicker__time-list-item ') and text()='10:15']");
    By monthDrop = By.className("react-datepicker__month-select");
    By YearDrop = By.className("react-datepicker__year-select");
    By date = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--025']");
    By dateOnly = By.id("datePickerMonthYearInput");



    public void setDate() throws AWTException, IOException {
        
        method.commonMethods().click(dateOnly);
        method.classObjectManager().selectElement(method.classObjectManager().webElement(monthDrop)).selectByVisibleText("December");
        method.classObjectManager().selectElement(method.classObjectManager().webElement(YearDrop)).selectByVisibleText("2024");
        method.classObjectManager().webElement(date).click();
        
    }
    public void setdateWithTime() throws AWTException, IOException {
        method.commonMethods().click(time);
        method.commonMethods().click(monthOption);
        method.commonMethods().click(monthName);
        method.commonMethods().click(YearOption);
        method.commonMethods().click(yearValue);
        method.commonMethods().click(dateoption);
        method.commonMethods().click(timeValue);
    }
}
