package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.IOException;
import java.rmi.MarshalException;
import java.util.Objects;


public class StepdefinitionWidgets {
    WebDriver driver;
    objectManager method;

    public StepdefinitionWidgets() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }


    @Then("User Enter the info into the Autocomplete field")
    public void userEnterTheInfoIntoTheAutocompleteField() throws AWTException, IOException {
        By multiColorInput = By.cssSelector("input[id='autoCompleteMultipleInput']");
        By selectBlueSingal = By.xpath("//div[contains(@class,'auto-complete__option') and (text()='Blue') ]");
        By selectBlue = By.xpath("//div[text()='Blue']");
        By selectBlack = By.xpath("//div[text()='Black']");
        By selectRed  = By.xpath("//div[text()='Red']");
        By singalColorInput = By.cssSelector("input[id='autoCompleteSingleInput']");
        method.commonMethods().click(multiColorInput);
        method.classObjectManager().webElement(multiColorInput).sendKeys("Bl");
        method.commonMethods().click(selectBlue);
        method.classObjectManager().webElement(multiColorInput).sendKeys("Bl");
        method.commonMethods().click(selectBlack);
        method.classObjectManager().webElement(multiColorInput).sendKeys("Re");
        method.commonMethods().click(selectRed);
        method.classObjectManager().webElement(singalColorInput).sendKeys("Bl");
        method.commonMethods().click(selectBlueSingal);
    }

    @Then("User Select the Date")
    public void userSelectTheDate() throws AWTException, IOException {
        method.pageObjectManager().widgetsPG().setDate();
    }

    @Then("User Select the Date and Time")
    public void userSelectTheDateAndTime() throws AWTException, IOException {
        method.pageObjectManager().widgetsPG().setdateWithTime();
    }

    @Then("User Select {int} from the Slider")
    public void userSelectFromTheSlider(int arg0) throws AWTException, IOException {
        By sliders = By.cssSelector("input[id$='sliderValue']");
//        yet to build the logic
    }

    @Then("User Validate the Progress Bar")
    public void userValidateTheProgressBar() throws AWTException, IOException {
        method.pageObjectManager().widgetsPG().validatePorgessbar();
    }

    @Then("User Validate the {string} Tab")
    public void userValidateTheTab(String tab) throws AWTException, IOException {
        method.pageObjectManager().widgetsPG().tabs(tab);

    }

    @Then("User Hover and and Validate")
    public void userHoverAndAndValidate() throws AWTException, InterruptedException, IOException {
      method.pageObjectManager().widgetsPG().hoverButtonLinks();

    }

    @Then("User Select the option from the menu")
    public void userSelectTheOptionFromTheMenu() throws AWTException, IOException {
        method.pageObjectManager().widgetsPG().selectMenuHover();
    }

    @Then("User Select Value from the List")
    public void userSelectValueFromTheList() throws AWTException, IOException {

        method.pageObjectManager().widgetsPG().selectMenuDropDowns();

    }

    @Then("User Select value from the Dropdown")
    public void userSelectValueFromTheDropdown() {
    }

    @Then("USer Select value from the multiselect drop down")
    public void userSelectValueFromTheMultiselectDropDown() {
    }

    @Then("User Select multiple option")
    public void userSelectMultipleOption() {
    }

    @Then("User Validate the Text in the Header")
    public void userValidateTheTextInTheHeader() throws AWTException, IOException {

        By header1 = By.id("section1Heading");
        By header2 = By.id("section2Heading");
        By header3 = By.id("section3Heading");

        By content1 = By.id("section1Content");
        By content2 = By.id("section2Content");
        By content3 = By.id("section3Content");

        method.commonMethods().click(header1);
        method.commonMethods().hightElement(content1);
        method.commonMethods().click(header1);
        method.commonMethods().click(header2);
        method.commonMethods().hightElement(content2);
        method.commonMethods().click(header2);
        method.commonMethods().click(header3);
        method.commonMethods().hightElement(content3);
        method.commonMethods().click(header3);



    }


}
