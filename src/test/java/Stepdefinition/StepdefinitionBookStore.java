package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class StepdefinitionBookStore {
    WebDriver driver;
    objectManager method;

    public StepdefinitionBookStore() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @Then("User Enter the User name and Password")
    public void userEnterTheUserNameAndPassword() {
    }

    @Then("User Enter Registration details and Register")
    public void userEnterRegistrationDetailsAndRegister() {
    }

    @Then("User Search Book in the search bar")
    public void userSearchBookInTheSearchBar() {
    }

    @Then("USer Select the Book")
    public void userSelectTheBook() {
    }

}
