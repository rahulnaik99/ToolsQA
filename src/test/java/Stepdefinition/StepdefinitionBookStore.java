package Stepdefinition;

import commonMethods.pageObjectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class StepdefinitionBookStore {
    WebDriver driver;
    pageObjectManager pg;

    public StepdefinitionBookStore() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
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
