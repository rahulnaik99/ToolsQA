package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class widgetsPG {
    WebDriver driver;
    objectManager method;

    public widgetsPG() throws IOException, AWTException {
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
    public void validatePorgessbar() throws AWTException, IOException {
        By startButton = By.id("startStopButton");
        By progressBar = By.cssSelector("div[role='progressbar']");
        method.commonMethods().click(startButton);
        while (true) {

            String progressText = method.classObjectManager().webElement(progressBar).getAttribute("aria-valuenow");
            assert progressText != null;
            if (progressText.equals("100"))
            {
                method.commonMethods().hightElement(progressBar);
                break;
            }
        }
    }
    public void tabs(String tab) throws AWTException, IOException {
        By allTab = By.cssSelector("a[id$="+tab+"]");
        By tabContent = By.xpath("//p[contains(@class,'mt-3')]/parent::div[contains(@id,'demo-tabpane-"+tab+"')]");
        method.commonMethods().click(allTab);
        method.commonMethods().hightText(tabContent);
    }
    public void selectMenuHover() throws AWTException, IOException {
        int i=1;
        while (i<4) {
            By mainButon= By.xpath("//*[text()='Main Item "+i+"']");
            method.classObjectManager().actions().click(method.classObjectManager().webElement(mainButon)).perform();
            if(i == 2){
                By submenu1 = By.xpath("(//*[text()='Sub Item'])[1]");
                By submenu2 = By.xpath("(//*[text()='Sub Item'])[2]");
                By submenu3 = By.xpath("//*[text()='SUB SUB LIST »']");
                By subItem1 = By.xpath("(//*[text()='Sub Sub Item 1'])");
                By subItem2 = By.xpath("(//*[text()='Sub Sub Item 2'])");
                method.classObjectManager().actions().click(method.classObjectManager().webElement(submenu1)).click().perform();
                method.commonMethods().addToPPT("");
                method.classObjectManager().actions().click(method.classObjectManager().webElement(submenu2)).click().perform();
                method.commonMethods().addToPPT("");
                method.classObjectManager().actions().click(method.classObjectManager().webElement(submenu3)).click().perform();
                method.commonMethods().addToPPT("");
                method.classObjectManager().actions().click(method.classObjectManager().webElement(subItem1)).click().perform();
                method.commonMethods().addToPPT("");
                method.classObjectManager().actions().click(method.classObjectManager().webElement(subItem2)).click().perform();
            }
                method.commonMethods().addToPPT("");
            i++;
        }

    }
    public void hoverButtonLinks() throws AWTException, IOException {
        By hoverButton = By.id("toolTipButton");
        By inputField = By.id("toolTipTextField");
        By link = By.xpath("//a[text()='Contrary']");
        method.classObjectManager().actions().moveToElement(method.classObjectManager().webElement(hoverButton)).perform();
        method.commonMethods().addToPPT("overed");
        method.classObjectManager().actions().moveToElement(method.classObjectManager().webElement(inputField)).perform();
        method.commonMethods().addToPPT("overed");
        method.classObjectManager().actions().moveToElement(method.classObjectManager().webElement(link)).perform();
        method.commonMethods().addToPPT("overed");
    }


    public void selectMenuDropDowns() throws AWTException, IOException {

        By selectValueDropDown = By.xpath("(//div[contains(@class,'css-yk16xz-control')])[1]");
        By selectOneDropDown = By.xpath("(//div[contains(@class,' css-1hwfws3')])[2]");
        By colorDropdown = By.id("oldSelectMenu");
        By grpop1 = By.id("react-select-2-option-0-0");
        By mr = By.id("react-select-3-option-0-4");
        By multipleDropdown = By.xpath("(//div[contains(@class,' css-1hwfws3')])[3]");
        By blue = By.xpath("//div[text()='Blue']");
        By black = By.xpath("//div[text()='Black']");
        By multiSelect = By.cssSelector("select[name='cars']");
        method.commonMethods().click(selectValueDropDown);
        method.commonMethods().click(grpop1);
        method.commonMethods().click(selectOneDropDown);
        method.commonMethods().click(mr);
        method.classObjectManager().selectElement(method.classObjectManager().webElement(colorDropdown)).selectByVisibleText("Purple");
        method.commonMethods().click(multipleDropdown);
        method.commonMethods().click(blue);
        method.commonMethods().click(black);
        method.classObjectManager().selectElement(method.classObjectManager().webElement(multiSelect)).selectByValue("volvo");
        method.classObjectManager().selectElement(method.classObjectManager().webElement(multiSelect)).selectByValue("opel");
    }

}
