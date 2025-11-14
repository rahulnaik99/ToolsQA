package Pages;

import commonMethods.objectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.awt.*;
import java.io.IOException;

public class alartFrameWindowPG {
    WebDriver driver;
    objectManager method;

    public alartFrameWindowPG() throws IOException, AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    By pauseAlert = By.id("timerAlertButton");
    By seeAlert = By.id("alertButton");
    By acceptOrDecline = By.id("confirmButton");
    By outputString = By.id("confirmResult");
    By outputStringPromt = By.id("promptResult");
    By sendKeysAlert = By.id("promtButton");
    By nestedParentFrame = By.cssSelector("iframe#frame1");
    By nestedParentContent = By.xpath("//*[text()='Parent frame']");
    By nestedChildFrame = By.cssSelector("iframe[srcdoc='<p>Child Iframe</p>']");
    By nestedChildContent = By.xpath("//*[text()='Child Iframe']");
    By frame1 = By.id("frame1");
    By frame2 = By.id("frame2");
    By frameContent = By.cssSelector("h1[id$='sampleHeading']");
    By smallModal = By.id("showSmallModal");
    By modalText = By.className("modal-body");
    By closeSmall = By.id("closeSmallModal");
    By largeModal = By.id("showLargeModal");
    By closeLarge = By.id("closeLargeModal");

    public void newTab(By Tab) throws IOException, AWTException {

        method.commonMethods().click(Tab);
        method.commonMethods().switchToTab();

    }

    public void manageAlertandAccept() throws AWTException, IOException {
        method.commonMethods().click(seeAlert);
        driver.switchTo().alert().accept();

    }

    public void managerTimerAlert() throws AWTException, IOException, InterruptedException {
        method.commonMethods().click(pauseAlert);
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void acceptandDecline() throws AWTException, IOException {
        method.commonMethods().click(acceptOrDecline);
        driver.switchTo().alert().accept();
        Assert.assertEquals("You selected Ok", method.commonMethods().fetch(outputString),"");
        method.commonMethods().click(acceptOrDecline);
        driver.switchTo().alert().dismiss();

        Assert.assertEquals("You selected Cancel", method.commonMethods().fetch(outputString));
    }

    public void enterStringIntoPromt() throws AWTException, IOException {

        method.commonMethods().click(sendKeysAlert);
        driver.switchTo().alert().sendKeys("Test String");
        Assert.assertEquals("You selected Cancel", method.commonMethods().fetch(outputStringPromt));

    }

    public void switchFrames() throws AWTException, IOException {
        driver.switchTo().frame(method.classObjectManager().webElement(frame1));
        method.commonMethods().hightElement(frameContent);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(method.classObjectManager().webElement(frame2));
        method.commonMethods().hightElement(frameContent);
        driver.switchTo().defaultContent();
    }

    public void switchNestedFrames() throws AWTException, IOException {
        driver.switchTo().frame(method.classObjectManager().webElement(nestedParentFrame));
        method.commonMethods().hightElement(nestedParentContent);
        driver.switchTo().frame(method.classObjectManager().webElement(nestedChildFrame));
        method.commonMethods().hightElement(nestedChildContent);
    }

    public void smallModal() throws AWTException, IOException {
        method.commonMethods().click(smallModal);
        method.commonMethods().hightElement(modalText);
        method.commonMethods().click(closeSmall);
    }

    public void largeModal() throws AWTException, IOException {
        method.commonMethods().click(largeModal);
        method.commonMethods().hightElement(modalText);
        method.commonMethods().click(closeLarge);

    }
}