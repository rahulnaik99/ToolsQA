package stepDefinitions;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;
import java.io.IOException;


public class StepdefinitionBookStore extends base {
    objectManager method;

    public StepdefinitionBookStore() throws IOException, AWTException {
        method = new objectManager();
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
