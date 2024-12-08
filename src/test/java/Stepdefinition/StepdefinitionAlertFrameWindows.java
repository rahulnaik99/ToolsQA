package Stepdefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonMethods.pageObjectManager;
import java.awt.*;
import java.io.IOException;


public class StepdefinitionAlertFrameWindows {
    WebDriver driver;
    pageObjectManager pg;

    public StepdefinitionAlertFrameWindows() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
    }

    @When("^User click on the Tab Button$")
    public void newTab() throws IOException, AWTException {
        pg.alartFrameWindowPG().newTab(By.cssSelector("#tabButton"));
        pg.alartFrameWindowPG().newTab(By.cssSelector("button[id='windowButton']"));
        pg.alartFrameWindowPG().newTab(By.id("messageWindowButton"));
    }

    @When("User click on Alert and Validate")
    public void userClickOnAlertAndValidate() {
    }

    @When("User click on Dynamic Alert and Validate")
    public void userClickOnDynamicAlertAndValidate() {
    }

    @When("User click on Yes or No Alert and Validate")
    public void userClickOnYesOrNoAlertAndValidate() {
    }

    @When("User click on input Alert and Validate")
    public void userClickOnInputAlertAndValidate() {
    }

    @Then("User select between Parent Frame and Child Frame")
    public void userSelectBetweenParentFrameAndChildFrame() {
    }

    @Then("User select Small Modal")
    public void userSelectSmallModal() {
    }

    @Then("User select Large Modal")
    public void userSelectLargeModal() {
    }
}
