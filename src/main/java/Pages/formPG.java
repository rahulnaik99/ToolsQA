package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class formPG {
    WebDriver driver;
    objectManager method;

    public formPG() throws IOException, AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
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


    public void fillPracticeForm(Map<String, String> data) throws IOException, AWTException {
        method.commonMethods().enter(firstName, data.get("firstName"));
        method.commonMethods().enter(lastName, data.get("lastName"));
        method.commonMethods().enter(email, data.get("email"));
        method.commonMethods().click(By.cssSelector("label[for$='gender-radio-1']"));
        method.commonMethods().enter(mobileNumber, data.get("mobileNumber"));
        method.commonMethods().click(dob);
        method.classObjectManager().selectElement(method.classObjectManager().webElement(year)).selectByVisibleText(data.get("dobYear"));
        method.classObjectManager().selectElement(method.classObjectManager().webElement(month)).selectByVisibleText(data.get("dobMonth"));
        method.commonMethods().click(By.xpath("(//div[text()='" + data.get("dobdate") + "'])[1]"));
        method.commonMethods().enter(subjects, data.get("subjects"));
        method.commonMethods().robotClassEnter();
        method.classObjectManager().webElement(genderMale).click();
        method.classObjectManager().webElement(hobbiesCheckbox1).click();
        method.classObjectManager().webElement(hobbiesCheckbox2).click();
        method.classObjectManager().webElement(hobbiesCheckbox3).click();
        File file = new File("src\\main\\resources\\screenshot.png");
        method.commonMethods().enter(uploadPicture,file.getAbsolutePath());
        method.commonMethods().enter(currentAddress, data.get("currentAddress"));
        method.commonMethods().click(state);
        method.commonMethods().click(By.xpath("//div[text()='" + data.get("state") + "']"));
        method.commonMethods().click(city);
        method.commonMethods().click(By.xpath("//div[text()='" + data.get("city") + "']"));
        method.commonMethods().click(submit);
        method.commonMethods().hightElement(By.cssSelector("div[class='modal-body']"));
//        method.commonMethods().click(By.id("closeLargeModal"));
    }
}
