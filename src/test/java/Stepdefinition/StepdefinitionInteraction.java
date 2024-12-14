package Stepdefinition;

import commonMethods.objectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;


public class StepdefinitionInteraction {
    WebDriver driver;
    objectManager method;

    public StepdefinitionInteraction() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    @Then("User Sort the List Tab")
    public void userSortTheListTab() throws InterruptedException, AWTException {
        method.pageObjectManager().interactionsPG().listTabInteraction();

    }

    @Then("User Sort the Grid Tab")
    public void userSortTheGridTab() throws AWTException, InterruptedException, IOException {
        method.pageObjectManager().interactionsPG().gridTabInteraction();
    }


    @Then("User Resize the tab")
    public void userResizeTheTab() throws AWTException, InterruptedException {
        By resizeHandle = By.xpath("(//span[contains(@class,'react-resizable-handle')])[1]");
        method.commonMethods().scrollToElement(resizeHandle);
        method.commonMethods().dragAndDrop(resizeHandle,50,50);
        method.commonMethods().dragAndDrop(resizeHandle,0,50);
        method.commonMethods().dragAndDrop(resizeHandle,50,0);
        method.commonMethods().dragAndDrop(resizeHandle,-250,-250);
        By resizeHandleSmall = By.xpath("(//span[contains(@class,'react-resizable-handle')])[2]");
        method.commonMethods().scrollToElement(resizeHandleSmall);
        method.commonMethods().dragAndDrop(resizeHandleSmall,150,150);
        method.commonMethods().dragAndDrop(resizeHandleSmall,0,150);
        method.commonMethods().dragAndDrop(resizeHandleSmall,150,0);
        method.commonMethods().dragAndDrop(resizeHandleSmall,-70,-20);


    }

    @Then("User Drag and drop in Simple Tab")
    public void userDragAndDropInSimpleTab() throws AWTException, IOException, InterruptedException {
        By simpleTab = By.cssSelector("a[id='droppableExample-tab-simple']");
        method.commonMethods().scrollToElement(simpleTab);
        By dragMe = By.xpath("//div[text()='Drag me']");
        By dropHere = By.xpath("(//p[text()='Drop here'])[1]");
        method.classObjectManager().actions().dragAndDrop(
                method.classObjectManager().webElement(dragMe)
                , method.classObjectManager().webElement(dropHere)).perform();
    }


    @Then("User Drag and drop in Prevent Propogation Tab")
    public void userDragAndDropInPreventPropogationTab() throws AWTException, IOException, InterruptedException {
        By pPropTab = By.cssSelector("a#droppableExample-tab-preventPropogation");
        method.commonMethods().click(pPropTab);
        By DragMe = By.id("dragBox");
        By outerDrop1 = By.id("notGreedyDropBox");
        By outerDrop2 = By.cssSelector("div#greedyDropBox");

        method.classObjectManager().actions().dragAndDrop(method.classObjectManager().webElement(DragMe),method.classObjectManager().webElement(outerDrop1)).perform();
        method.commonMethods().dragAndDrop(DragMe,0,-70);
        method.classObjectManager().actions().dragAndDrop(method.classObjectManager().webElement(DragMe),method.classObjectManager().webElement(outerDrop2)).perform();
        method.commonMethods().scrollToElement(outerDrop2);
        method.commonMethods().dragAndDrop(DragMe,0,100);
    }

    @Then("User Drag and drop in Revert Draggable Tab")
    public void userDragAndDropInRevertDraggableTab() throws AWTException, IOException {
        By revertDragable = By.cssSelector("a#droppableExample-tab-revertable");
        By willR    = By.cssSelector("div#revertable");
        By willNtR  = By.cssSelector("div#notRevertable");
        By drop = By.xpath("(//div[contains(@id,droppable)])[84]");
        method.commonMethods().click(revertDragable);
        method.classObjectManager().actions().dragAndDrop(
                method.classObjectManager().webElement(willR),
                method.classObjectManager().webElement(drop)).release().perform();
        method.commonMethods().hightElement(willR);
        method.commonMethods().unhightElement(willR);
        method.commonMethods().click(revertDragable);
        method.classObjectManager().actions().dragAndDrop(
                method.classObjectManager().webElement(willNtR),
                method.classObjectManager().webElement(drop)).release().perform();
        method.commonMethods().hightElement(willNtR);

    }

    @Then("User Drag in Simple Tab")
    public void userDragInSimpleTab() throws AWTException {
        By dragMe = By.cssSelector("div#dragBox");
        method.commonMethods().dragAndDrop(dragMe,300,0);

    }

    @Then("User Drag in Axis Restricted Tab")
    public void userDragInAxisRestrictedTab() throws AWTException, IOException {
        By axisRest = By.cssSelector("a#draggableExample-tab-axisRestriction");
        By xAxisOnly = By.id("restrictedX");
        By yAxisOnly = By.id("restrictedY");
        method.commonMethods().click(axisRest);
        method.commonMethods().hightElement(xAxisOnly);
        method.commonMethods().unhightElement(xAxisOnly);
        method.commonMethods().dragAndDrop(xAxisOnly,150,0);
        method.commonMethods().hightElement(xAxisOnly);
        method.commonMethods().unhightElement(xAxisOnly);
        method.commonMethods().dragAndDrop(xAxisOnly,-200,0);
        method.commonMethods().hightElement(xAxisOnly);
        method.commonMethods().unhightElement(xAxisOnly);
        method.commonMethods().dragAndDrop(yAxisOnly,0,200);
        method.commonMethods().hightElement(yAxisOnly);
        method.commonMethods().unhightElement(yAxisOnly);
        method.commonMethods().dragAndDrop(yAxisOnly,0,-250);
        method.commonMethods().hightElement(yAxisOnly);
        method.commonMethods().unhightElement(yAxisOnly);
    }


    @Then("User Drag in Container Restricted Tab")
    public void userDragInContainerRestrictedTab() throws AWTException, IOException {
        By container = By.cssSelector("a#draggableExample-tab-containerRestriction");
        method.commonMethods().click(container);
        By insideCont = By.cssSelector("div[class='draggable ui-widget-content ui-draggable ui-draggable-handle']");
        By insideCont2 = By.cssSelector("span[class='ui-widget-header ui-draggable ui-draggable-handle']");
        method.commonMethods().click(container);
        method.commonMethods().dragAndDrop(insideCont,50,50);
        method.commonMethods().hightElement(insideCont);
        method.commonMethods().unhightElement(insideCont);

        method.commonMethods().dragAndDrop(insideCont2,5,50);
        method.commonMethods().hightElement(insideCont2);
        method.commonMethods().unhightElement(insideCont2);
        

        
    }

    @Then("User Drag in Cursor Style Tab")
    public void userDragInCursorStyleTab() throws AWTException, IOException {
        By cursorStyle = By.cssSelector("a#draggableExample-tab-cursorStyle");
        By cursorCenter = By.id("cursorCenter");
        By cursorMiddle = By.id("cursorTopLeft");
        By cursorBottom = By.id("cursorBottom");



        method.commonMethods().click(cursorStyle);
        method.commonMethods().dragAndDrop(cursorCenter,50,3);
        method.commonMethods().hightText(cursorCenter);
        method.commonMethods().unhightElement(cursorCenter);

        method.commonMethods().dragAndDrop(cursorMiddle,50,3);
        method.commonMethods().hightText(cursorMiddle);
        method.commonMethods().unhightElement(cursorMiddle);

        method.commonMethods().dragAndDrop(cursorBottom,250,100);
        method.commonMethods().hightText(cursorBottom);
        method.commonMethods().unhightElement(cursorBottom);
    }

    @Then("User Select the List Tab")
    public void userSelectTheListTab() throws AWTException, InterruptedException {
        method.pageObjectManager().interactionsPG().ListTabClick();




    }

    @Then("User Select the Grid Tab")
    public void userSelectTheGridTab() throws AWTException, InterruptedException, IOException {
        method.pageObjectManager().interactionsPG().gridTabClick();
    }

    @Then("User Drag and drop in Accept Tab")
    public void userDragAndDropInAcceptTab() throws AWTException, IOException {

        method.pageObjectManager().interactionsPG().AcceptTab(true);
        method.pageObjectManager().interactionsPG().AcceptTab(false);




    }
}
