package commonMethods;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xslf.usermodel.*;
import org.openqa.selenium.*;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.*;


public class commonMethods {
    private static XMLSlideShow ppt;
    public static String testEvidence;
    WebDriver driver;
    objectManager method;

    public commonMethods() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
    }

    public boolean click(By element) throws IOException, AWTException {
        scrollToElement(element);
        hightElement(element);
        if (driver.findElement(element).isDisplayed()) {


            driver.findElement(element).click();
            return true;
        }
        System.out.print("Element noty found");
        return false;

    }

    public void enter(By element, String value) throws IOException, AWTException {
        hightElement(element);
        if (driver.findElement(element).isDisplayed()) {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(value);
            return;

        }
        System.out.print("Element noty found");


    }

    public String fetch(By element) {
        return driver.findElement(element).getText();
    }

    public void scrollToElement(By element) {
        WebElement elementWeb = driver.findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementWeb);

    }

    public void homePage() {
        driver.get("https://demoqa.com/");
    }

    public void checkRadioButton(By radioButton) {
        driver.findElement(radioButton).isSelected();
    }

    public void handleMultplieWindow() {
        String Originalwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            driver.switchTo().window(Originalwindow);
            break;
        }

    }

    public String linkChecker(By link) {
        List<WebElement> images = driver.findElements(link);
        for (WebElement image : images) {
            String src = image.getAttribute("src");
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(src).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(src + " is broken with response code: " + responseCode);
                } else {
                    return (src + " is valid.");
                }
            } catch (Exception e) {
                return (src + " is invalid or throws an exception: " + e.getMessage());
            }
        }
        return null;
    }

    public boolean isEnabled(By button) {
        return driver.findElement(button).isEnabled();
    }

    public void hightElement(By element) throws IOException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid green'", method.classObjectManager().webElement(element));
        addToPPT("Slide");
    }
    public void hightText(By element) throws IOException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='yellow'", method.classObjectManager().webElement(element));
        addToPPT("Slide");
    }

    public void unhightElement(By element) throws AWTException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=''", method.classObjectManager().webElement(element));
    }

    public void addToPPT(String titleSlide) throws IOException {

        if (ppt == null) {
            ppt = new XMLSlideShow();
        }

        // Capture a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot.png"));

        // Create a new slide
        XSLFSlide slide = ppt.createSlide(ppt.getSlideMasters().get(0).getLayout(SlideLayout.TITLE));

        // Add a title text to the slide
        XSLFTextShape title = slide.createTextBox();
        title.setAnchor(new Rectangle(50, 30, 600, 40));
        XSLFTextParagraph p = title.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();
        r.setText("Screenshot " + ppt.getSlides().size());
        r.setFontColor(Color.WHITE);
        r.setFontSize(20.0);

        XSLFTextShape header = slide.createTextBox();
        header.setAnchor(new Rectangle(50, 10, 600, 20));
        XSLFTextParagraph headerParagraph = header.addNewTextParagraph();
        XSLFTextRun headerRun = headerParagraph.addNewTextRun();
        headerRun.setText("Header");
        headerRun.setFontColor(Color.BLACK);
        headerRun.setFontSize(16.0);

        // Add the screenshot to the slide
        XSLFPictureData pd = ppt.addPicture(new File("screenshot.png"), XSLFPictureData.PictureType.PNG);
        XSLFPictureShape pic = slide.createPicture(pd);

        // Set the position and size of the screenshot
        pic.setAnchor(new Rectangle(50, 100, 600, 400));

        // Delete the screenshot file (optional)
//                FileUtils.forceDelete(new File("screenshot.png"));


        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/TestEvidences/PowerPoint/" + testEvidence + ".ppt");
        ppt.write(out);
        out.close();

    }

    public void dateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yymmddHHMMSS");
        System.out.println(now.format(format));

    }

    public void robotClassEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void switchToTab() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = allWindowHandles.iterator();
        String parentWindow = windowIterator.next();
        String childWindow = windowIterator.next();
        driver.switchTo().window(childWindow);
        driver.switchTo().window(parentWindow);
    }

    public void closeTab() {
        driver.close();
    }
    public void dragAndDrop(By Element,int xAxis,int yAxis) throws AWTException {
        method.classObjectManager().actions().clickAndHold(method.classObjectManager().webElement(Element)).moveByOffset(xAxis,yAxis).release().perform();
    }

}




