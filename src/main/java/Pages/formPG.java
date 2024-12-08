package Pages;

import commonMethods.pageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class formPG {
    WebDriver driver;
    pageObjectManager pg;

    public formPG() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
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
        pg.methods().enter(firstName,data.get("firstName"));
        pg.methods().enter(lastName,data.get("lastName"));
        pg.methods().enter(email, data.get("email"));
        pg.methods().click(By.cssSelector("label[for$='gender-radio-1']"));
        pg.methods().enter(mobileNumber, data.get("mobileNumber"));
        pg.methods().click(dob);
        pg.objectManager().selectElement(pg.objectManager().webElement(year)).selectByVisibleText(data.get("dobYear"));
        pg.objectManager().selectElement(pg.objectManager().webElement(month)).selectByVisibleText(data.get("dobMonth"));
        pg.methods().click(By.xpath("(//div[text()='"+data.get("dobdate")+"'])[1]"));
        pg.methods().enter(subjects, data.get("subjects"));
        pg.methods().robotClassEnter();
        pg.objectManager().webElement(genderMale).click();
        pg.objectManager().webElement(hobbiesCheckbox1).click();
        pg.objectManager().webElement(hobbiesCheckbox2).click();
        pg.objectManager().webElement(hobbiesCheckbox3).click();
        pg.methods().enter(uploadPicture,"C:\\Users\\"+System.getProperty("user.name")+"\\IdeaProjects\\ToolsQA\\screenshot.png");
        pg.methods().enter(currentAddress,data.get("currentAddress"));
        pg.methods().click(state);
        pg.methods().click(By.xpath("//div[text()='"+data.get("state")+"']"));
        pg.methods().click(city);
        pg.methods().click(By.xpath("//div[text()='"+data.get("city")+"']"));
        pg.methods().click(submit);
        pg.methods().hightElement(By.cssSelector("div[class='modal-body']"));
        pg.methods().click(By.id("closeLargeModal"));
    }
}
