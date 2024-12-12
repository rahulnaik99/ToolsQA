package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;


public class StepdefinitionInteraction {
    WebDriver driver;
    objectManager method;

    public StepdefinitionInteraction() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @Then("User Sort the List Tab")
    public void userSortTheListTab() throws InterruptedException, AWTException {

        By listContent= By.xpath("//div[contains(@class,'vertical-list-container mt-4')]//div[contains(@class,'list-group-item list-group-item-action')]");
        java.util.List<WebElement> list = driver.findElements(listContent);
        method.classObjectManager().actions().clickAndHold(list.get(1)).moveToElement(list.get(2)).build().perform();



    }

    @Then("User Sort the Grid Tab")
    public void userSortTheGridTab() {
    }


    @Then("User Resize the tab")
    public void userResizeTheTab() {
    }

    @Then("User Drag and drop in Simple Tab")
    public void userDragAndDropInSimpleTab() {
    }


    @Then("User Drag and drop in Prevent Propogation Tab")
    public void userDragAndDropInPreventPropogationTab() {
    }

    @Then("User Drag and drop in Revert Draggable Tab")
    public void userDragAndDropInRevertDraggableTab() {
    }

    @Then("User Drag in Simple Tab")
    public void userDragInSimpleTab() {
    }

    @Then("User Drag in Axis Restricted Tab")
    public void userDragInAxisRestrictedTab() {
    }

    @Then("User Drag in Container Restricted Tab")
    public void userDragInContainerRestrictedTab() {
    }

    @Then("User Drag in Cursor Style Tab")
    public void userDragInCursorStyleTab() {
    }
}
