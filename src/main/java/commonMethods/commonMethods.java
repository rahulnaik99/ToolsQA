package commonMethods;


import org.apache.commons.io.FileUtils;
import org.apache.poi.xslf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import testBase.base;

import java.awt.Rectangle;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class commonMethods {
    WebDriver driver;
    private static XMLSlideShow ppt;
    public static String testEvidence;

    public commonMethods() throws AWTException {
        base base = new base();
        this.driver = base.initializeDriver();
    }

    public boolean click(By element) {
        scrollToElement(element);
        if (driver.findElement(element).isDisplayed()) {


            driver.findElement(element).click();
            return true;
        }
        System.out.print("Element noty found");
        return false;

    }

    public void enter(By element, String value) throws IOException {
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

    public boolean checkRadioButton(By radioButton) {
        return driver.findElement(radioButton).isSelected();

    }

    public Actions actions() {
        return new Actions(driver);
    }

    public WebElement webElement(By element) {
        return driver.findElement(element);
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

    public void hightElement(By element) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid green'", webElement(element));
        addToPPT("Slide");
    }

    public void unhightElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=''", webElement(element));
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

        // Save the PowerPoint presentation
        if (testEvidence==null){
            testEvidence=driver.getClass().fe;
        }
        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"/TestEvidences/PowerPoint/"+testEvidence+".ppt");
        ppt.write(out);
        out.close();

    }
    public String dateTime(){
        LocalDateTime now =  LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yymmddHHMMSS");
        return now.format(format);

    }
}



