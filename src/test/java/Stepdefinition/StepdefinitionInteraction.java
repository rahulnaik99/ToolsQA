package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class StepdefinitionInteraction {
    WebDriver driver;
    objectManager method;

    public StepdefinitionInteraction() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @Then("User Sort the List Tab")
    public void userSortTheListTab() {
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
