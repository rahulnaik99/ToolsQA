package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class formPage {
    WebDriver driver;
    commonMethods methods;
    public formPage() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }
    By firstName = By.cssSelector("#firstName");
    By lastName = By.cssSelector("#lastName");
    By email = By.cssSelector("#userEmail");
    By mobileNumber = By.cssSelector("input#userNumber");
    By dob = By.cssSelector("#dateOfBirthInput");
    By subjects = By.cssSelector("#subjectsInput");
    By genderMale = By.cssSelector("label[for='gender-radio-1']");
    By genderFemale = By.cssSelector("#gender-radio-2");
    By genderOther = By.cssSelector("#gender-radio-3");
    By hobbiesCheckbox1 = By.cssSelector("label[for='hobbies-checkbox-1']");
    By hobbiesCheckbox2 = By.cssSelector("label[for='hobbies-checkbox-2']");
    By hobbiesCheckbox3 = By.cssSelector("label[for='hobbies-checkbox-3']");
    By uploadPicture = By.cssSelector("input#uploadPicture");
    By currentAddress = By.cssSelector("#currentAddress");
    By state = By.cssSelector("#state");
    By city = By.cssSelector("#city");
    By submit = By.cssSelector("#submit");
    By month = By.cssSelector("Select[class$='month-select']");
    By year = By.cssSelector("Select[class$='year-select']");


    public void fillPracticeForm(Map<String,String> data) throws IOException, AWTException {
        methods.enter(firstName,data.get("firstName"));
        methods.enter(lastName,data.get("lastName"));
        methods.enter(email, data.get("email"));
        methods.click(By.cssSelector("label[for$='gender-radio-1']"));
        methods.enter(mobileNumber, data.get("mobileNumber"));
        methods.click(dob);
        methods.selectElement(methods.webElement(year)).selectByVisibleText(data.get("dobYear"));
        methods.selectElement(methods.webElement(month)).selectByVisibleText(data.get("dobMonth"));
        methods.click(By.xpath("(//div[text()='"+data.get("dobdate")+"'])[1]"));
        methods.enter(subjects, data.get("subjects"));
        methods.robotClassEnter();
        methods.webElement(genderMale).click();
        methods.webElement(hobbiesCheckbox1).click();
        methods.webElement(hobbiesCheckbox2).click();
        methods.webElement(hobbiesCheckbox3).click();
        methods.enter(uploadPicture,"C:\\Users\\"+System.getProperty("user.name")+"\\IdeaProjects\\ToolsQA\\screenshot.png");
        methods.enter(currentAddress,data.get("currentAddress"));
        methods.click(state);
        methods.click(By.xpath("//div[text()='"+data.get("state")+"']"));
        methods.click(city);
        methods.click(By.xpath("//div[text()='"+data.get("city")+"']"));
        methods.click(submit);
        methods.hightElement(By.cssSelector("div[class='modal-body']"));
        methods.click(By.id("closeLargeModal"));
        



    }
}
