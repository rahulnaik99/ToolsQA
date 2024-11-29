package Stepdefinition;

import Pages.elementPG;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;

public class StepdefinitionElement {
    elementPG page;
    WebDriver driver;
    base basePage;
    public StepdefinitionElement() throws AWTException {
        basePage = new  base();
        page = new elementPG();
        this.driver=basePage.initializeDriver();
    }


    @When("^User Select the (.*)$")
    public void testTextbox(String option) throws AWTException {
        page.selectMenu(option);

    }

    @Then("^User Enter the information$")
    public void enterInfo(){
        page.enterInfoTextBox();

    }

    @Then("User Validates the Results")
    public void userValidatesTheResults() {
        page.validateOutput();
    }
}
