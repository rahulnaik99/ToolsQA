package Stepdefinition;

import Pages.elementPG;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testBase.base;
import org.openqa.selenium.chrome.ChromeDriver;



import javax.swing.*;
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


    @When("^User Select the (.*) From the Homepage$")
    public void testTextbox(String option) throws AWTException {
        page.selectMenu(option);

    }

    @Then("^User Select (.*) From Elements$")
    public void enterInfo(String option){
                page.selectFromElements(option);

    }

    @Then("User Validates the Results")
    public void userValidatesTheResults() {
        page.validateTextboxOutput();
    }
    @Then("^User Select the Radio Button (.*)$")
    public void userSelectRadioButton(String radio) {
        page.radioButton(radio);
    }
    @Then("^User Select the Folder and Files$")
    public void userSelectFolderFiles() {
        page.checkBox(new String[]{"Downloads"});
    }

    @And("^Validates the Check box output$")
    public void validatesTheCheckBoxOutput() {
        page.validateCheckboxOutput("You have selected : downloads wordFile excelFile");
    }
    @And("^Validates the Radio Button output for (.*)$")
    public void validatesRadioButtonOutput(String expectedButton) {
        page.radioButtonValidation(expectedButton);
    }

    @Then("^User Enter the information in the Text Box$")
    public void userEnterTheInformationInTheTextBox() {
        page.enterInfoTextBox();
    }


    @When("User Verify that Table is Loaded")
    public void userVerifyThatTableIsLoaded() {
        page.nowOfRowInTable();

    }

    @Then("User Add a New Record")
    public void userAddANewRecord() {
        page.addDateToTable("test","test","test@bdd.com","21","21121","Automation");
    }

    @Then("User edit an Existing Record")
    public void userEditAnExistingRecord() {
        page.editTable("Cierra","","test@bdd.com","","","");
    }

    @Then("USer Delete the Record")
    public void userDeleteTheRecord() {
        page.tableRowDelete("test");
    }

    @Then("User search for the Record")
    public void userSearchForTheRecord() {
        page.tableSearch("Cierra");
    }

    @Then("User Sort the Column")
    public void userSortTheColumn() {
        page.tableSort("First Name");
        page.tableSort("Last Name");
        page.tableSort("Age");
        page.tableSort("Email");
        page.tableSort("Salary");
        page.tableSort("Department");
    }


    @When("^User Verify double click me Button$")
    public void userVerifyDoubleClickButton() {
        page.verifydoubleClick("double");
    }
    @When("^User Verify right click Button$")
    public void userVerifyRightClickButton() {
        page.verifyRightClick();
    }

    @When("User Verify dynamic click Button")
    public void userVerifyDynamicClickButton() {
        page.verifyClickMe();
    }
}