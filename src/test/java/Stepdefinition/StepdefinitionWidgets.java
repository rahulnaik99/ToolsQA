package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class StepdefinitionWidgets {
    WebDriver driver;
    objectManager method;

    public StepdefinitionWidgets() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @Then("User Header and Validate the Text")
    public void userHeaderAndValidateTheText() {
    }

    @Then("User Enter the info into the Autocomplete field")
    public void userEnterTheInfoIntoTheAutocompleteField() {
    }

    @Then("User Select the Date")
    public void userSelectTheDate() {
    }

    @Then("User Select the Date and Time")
    public void userSelectTheDateAndTime() {
    }

    @Then("User Select {int} from the Slider")
    public void userSelectFromTheSlider(int arg0) {
    }

    @Then("User Validate the Progress Bar")
    public void userValidateTheProgressBar() {
    }

    @Then("User Validate the Tab")
    public void userValidateTheTab() {
    }

    @Then("User Hover and and Validate")
    public void userHoverAndAndValidate() {
    }

    @Then("User Select the option from the menu")
    public void userSelectTheOptionFromTheMenu() {
    }

    @Then("User Select Value from the List")
    public void userSelectValueFromTheList() {
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

}
