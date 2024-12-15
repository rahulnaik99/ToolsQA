package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class StepdefinitionElement {
    WebDriver driver;
    objectManager method;

    public StepdefinitionElement() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }


    @When("^User Navigates to Home Page and select (.*)$")
    public void testTextbox(String option) throws IOException, AWTException {
        method.pageObjectManager().elementPG().selectMenu(option);

    }

    @Then("^User Select (.*) From (.*)$")
    public void enterInfo(String option, String option2) throws IOException, AWTException {
        method.pageObjectManager().elementPG().selectFromElements(option);

    }

    @Then("User Validates the Results")
    public void userValidatesTheResults() throws AWTException {
        method.pageObjectManager().elementPG().validateTextboxOutput();
    }

    @Then("^User Select the Radio Button (.*)$")
    public void userSelectRadioButton(String radio) throws IOException, AWTException {
        method.pageObjectManager().elementPG().radioButton(radio);
    }

    @Then("^User Select the Folder and Files$")
    public void userSelectFolderFiles() throws IOException, AWTException {
        method.pageObjectManager().elementPG().checkBox(new String[]{"Downloads"});
    }

    @And("^Validates the Check box output$")
    public void validatesTheCheckBoxOutput() throws AWTException {
        method.pageObjectManager().elementPG().validateCheckboxOutput("You have selected : downloads wordFile excelFile");
    }

    @And("^Validates the Radio Button output for (.*)$")
    public void validatesRadioButtonOutput(String expectedButton) throws AWTException {
        method.pageObjectManager().elementPG().radioButtonValidation(expectedButton);
    }

    @Then("^User Enter the information in the Text Box$")
    public void userEnterTheInformationInTheTextBox() throws IOException, AWTException {
        method.pageObjectManager().elementPG().enterInfoTextBox();
    }


    @When("User Verify that Table is Loaded")
    public void userVerifyThatTableIsLoaded() throws AWTException {
        method.pageObjectManager().elementPG().nowOfRowInTable();

    }

    @Then("User Add a New Record")
    public void userAddANewRecord() throws IOException, AWTException {
        method.pageObjectManager().elementPG().addDateToTable("test", "test", "test@bdd.com", "21", "21121", "Automation");
    }

    @Then("User edit an Existing Record")
    public void userEditAnExistingRecord() throws IOException, AWTException {
        method.pageObjectManager().elementPG().editTable("Cierra", "", "test@bdd.com", "", "", "");
    }

    @Then("USer Delete the Record")
    public void userDeleteTheRecord() throws IOException, AWTException {
        method.pageObjectManager().elementPG().tableRowDelete("test");
    }

    @Then("User search for the Record")
    public void userSearchForTheRecord() throws IOException, AWTException {
        method.pageObjectManager().elementPG().tableSearch("Cierra");
    }

    @Then("User Sort the Column")
    public void userSortTheColumn() throws IOException, AWTException {
        method.pageObjectManager().elementPG().tableSort("First Name");
        method.pageObjectManager().elementPG().tableSort("Last Name");
        method.pageObjectManager().elementPG().tableSort("Age");
        method.pageObjectManager().elementPG().tableSort("Email");
        method.pageObjectManager().elementPG().tableSort("Salary");
        method.pageObjectManager().elementPG().tableSort("Department");
    }


    @When("^User Verify double click me Button$")
    public void userVerifyDoubleClickButton() throws AWTException {
        method.pageObjectManager().elementPG().verifydoubleClick();
    }

    @When("^User Verify right click Button$")
    public void userVerifyRightClickButton() throws AWTException {
        method.pageObjectManager().elementPG().verifyRightClick();
    }

    @When("^User Verify dynamic click Button$")
    public void userVerifyDynamicClickButton() throws AWTException {
        method.pageObjectManager().elementPG().verifyClickMe();
    }

    @When("User Verify new Window Link")
    public void userVerifyNewWindowLink() throws IOException, AWTException {
        method.pageObjectManager().elementPG().nextWindowValidation();
    }

    @When("User Validates the Links with API Status")
    public void userValidatesTheLinksWithAPIStatus() throws AWTException {
        method.pageObjectManager().elementPG().apiValidation(By.tagName("a"));
    }

    @Then("Validate that the Image has a broken Link")
    public void validateThatTheImageHasABrokenLink() throws AWTException {
        method.pageObjectManager().elementPG().apiValidation(By.xpath("(//img[@src='/images/Toolsqa.jpg'])[2]"));
        method.pageObjectManager().elementPG().apiValidation(By.xpath("//img[@src='/images/Toolsqa_1.jpg']"));
        method.pageObjectManager().elementPG().apiValidation(By.cssSelector("a[href=\"http://the-internet.herokuapp.com/status_codes/500\"]"));
    }

    @Then("Valdate that the Link is broken or not")
    public void valdateThatTheLinkIsBrokenOrNot() {
    }

    @Then("User download the file")
    public void userDownloadTheFile() throws AWTException {
        By downloadFile = By.cssSelector("a[id='downloadButton']");
        method.pageObjectManager().elementPG().downLoad(downloadFile);

    }

    @Then("User upload the file")
    public void userUploadTheFile() throws AWTException {
        By uploadFileCss = By.cssSelector("input#uploadFile");
        method.pageObjectManager().elementPG().upLoad(uploadFileCss);
    }

    @Then("User Click button is enable after {int} seconds and also check the Color of the button")
    public void userClickButtonIsEnableAfterSeconds(int arg0) throws AWTException {
        method.pageObjectManager().elementPG().buttonValidate(arg0);
    }

}
