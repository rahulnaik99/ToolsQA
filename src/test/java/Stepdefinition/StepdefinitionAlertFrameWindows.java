package Stepdefinition;
import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.io.IOException;


public class StepdefinitionAlertFrameWindows {
    WebDriver driver;
    objectManager method;

    public StepdefinitionAlertFrameWindows() throws AWTException {
        method=new  objectManager();
        driver= method.base().initializeDriver();
    }

    @When("^User click on the Tab Button$")
    public void newTab() throws IOException, AWTException {
        method.pageObjectManager().alartFrameWindowPG().newTab(By.cssSelector("#tabButton"));
        method.pageObjectManager().alartFrameWindowPG().newTab(By.cssSelector("button[id='windowButton']"));
        method.pageObjectManager().alartFrameWindowPG().newTab(By.id("messageWindowButton"));
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
