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
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @When("^User click on the Tab Button$")
    public void newTab() throws IOException, AWTException {
        method.pageObjectManager().alartFrameWindowPG().newTab(By.cssSelector("#tabButton"));
        method.pageObjectManager().alartFrameWindowPG().newTab(By.cssSelector("button[id='windowButton']"));
        method.pageObjectManager().alartFrameWindowPG().newTab(By.id("messageWindowButton"));
    }

    @When("User click on Alert and Validate")
    public void userClickOnAlertAndValidate() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().manageAlertandAccept();

    }

    @When("User click on Dynamic Alert and Validate")
    public void userClickOnDynamicAlertAndValidate() throws AWTException, IOException, InterruptedException {
        method.pageObjectManager().alartFrameWindowPG().managerTimerAlert();
    }

    @When("User click on Yes or No Alert and Validate")
    public void userClickOnYesOrNoAlertAndValidate() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().acceptandDecline();

    }

    @When("User click on input Alert and Validate")
    public void userClickOnInputAlertAndValidate() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().enterStringIntoPromt();
    }

    @Then("User select between Parent Frame and Child Frame")
    public void userSelectBetweenParentFrameAndChildFrame() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().switchFrames();

    }

    @Then("User select Small Modal")
    public void userSelectSmallModal() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().smallModal();
    }

    @Then("User select Large Modal")
    public void userSelectLargeModal() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().largeModal();
    }

    @Then("User select between Nested Parent Frame and Child Frame")
    public void userSelectBetweenNestedParentFrameAndChildFrame() throws AWTException, IOException {
        method.pageObjectManager().alartFrameWindowPG().switchNestedFrames();
    }
}
