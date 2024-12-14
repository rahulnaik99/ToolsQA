package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

public class interactionsPG {
    WebDriver driver;
    objectManager method;

    public interactionsPG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    public void listTabInteraction() throws AWTException, InterruptedException {
        By listTab = By.cssSelector("a#demo-tab-list");
        By listContent= By.xpath("//div[contains(@class,'vertical-list-container mt-4')]//div[contains(@class,'list-group-item list-group-item-action')]");

        method.commonMethods().scrollToElement(listTab);
        java.util.List<WebElement> list = driver.findElements(listContent);
        Thread.sleep(5000);
        method.classObjectManager().actions().clickAndHold(list.get(3)).moveToElement(list.get(5)).release().perform();

    }
    public void gridTabInteraction() throws AWTException, InterruptedException, IOException {
        By gridTab = By.cssSelector("a#demo-tab-grid");
        By listContent= By.xpath("//div[contains(@class,'grid-container mt-4')]//div[contains(@class,'list-group-item list-group-item-action')]");
        method.commonMethods().click(gridTab);
        method.commonMethods().scrollToElement(gridTab);
        java.util.List<WebElement> list = driver.findElements(listContent);
        Thread.sleep(5000);
        method.classObjectManager().actions().clickAndHold(list.get(3)).moveToElement(list.get(5)).release().perform();
        Thread.sleep(2000);
        method.classObjectManager().actions().clickAndHold(list.get(2)).moveToElement(list.get(8)).release().perform();
        Thread.sleep(2000);
        method.classObjectManager().actions().clickAndHold(list.get(1)).moveToElement(list.get(5)).release().perform();
        Thread.sleep(2000);
        method.classObjectManager().actions().clickAndHold(list.get(2)).moveToElement(list.get(8)).release().perform();
    }

    public void ListTabClick() throws AWTException, InterruptedException {
        By list = By.cssSelector("a#demo-tab-list");
        By listElements = By.cssSelector("li[class$='mt-2 list-group-item list-group-item-action']");
        method.commonMethods().scrollToElement(list);
        java.util.List<WebElement> listElement = driver.findElements(listElements);
        for(WebElement i:listElement){
            Thread.sleep(1000);
            method.classObjectManager().actions().click(i).perform();
        }
        By listElementsActive = By.cssSelector("li[class$='mt-2 list-group-item active list-group-item-action']");
        listElement=driver.findElements(listElementsActive);
        for(WebElement i:listElement){
            Thread.sleep(1000);
            method.classObjectManager().actions().click(i).perform();
        }

    }


    public void gridTabClick() throws AWTException, IOException, InterruptedException {

        By grid = By.cssSelector("a#demo-tab-grid");
        By listElements = By.xpath("//div[contains(@class,'grid-container mt-4')]//div[contains(@class,'list-group list-group-horizontal-sm')]//li[contains(@class,'list-group-item list-group-item-action')]");
        method.commonMethods().click(grid);
        java.util.List<WebElement> listElement = driver.findElements(listElements);
        for(WebElement i:listElement){
            Thread.sleep(1000);
            method.classObjectManager().actions().click(i).perform();
        }
        By listElementsActive = By.xpath("//div[contains(@class,'grid-container mt-4')]//div[contains(@class,'list-group list-group-horizontal-sm')]//li[contains(@class,'list-group-item active list-group-item-action')]");
        listElement=driver.findElements(listElementsActive);
        for(WebElement i:listElement){
            Thread.sleep(1000);
            method.classObjectManager().actions().click(i).perform();
        }
    }


    public void AcceptTab(Boolean flag) throws AWTException, IOException {
        driver.navigate().refresh();
        By acceptTab = By.cssSelector("a#droppableExample-tab-accept");
        method.commonMethods().click(acceptTab);
        By accept = By.cssSelector("div#acceptable");
        By notAccepted = By.cssSelector("div#notAcceptable");
        By dropHere = By.xpath("(//p[text()='Drop here'])[2]");
        if(flag){
            method.classObjectManager().actions().dragAndDrop(method.classObjectManager().webElement(accept),method.classObjectManager().webElement(dropHere)).perform();
        }
        else {

            method.classObjectManager().actions().dragAndDrop(method.classObjectManager().webElement(notAccepted),method.classObjectManager().webElement(dropHere)).perform();
        }

    }
}
