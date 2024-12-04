package Pages;

import commonMethods.commonMethods;
//import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.base;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class elementPG {
    WebDriver driver;
    commonMethods methods;

    public elementPG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }

    By outputString = By.cssSelector("div[class='display-result mt-4']");
    By fullName = By.cssSelector("input[placeholder='Full Name']");
    By email = By.cssSelector("input[placeholder='name@example.com']");
    By currentAddress = By.cssSelector("textarea[placeholder='Current Address']");
    By permanentAddress = By.cssSelector("textarea[id='permanentAddress']");
    By submit = By.cssSelector("button[class='btn btn-primary']");
    By fullNameOutput = By.cssSelector("p[id='name']");
    By emailOutput = By.cssSelector("p[id='email']");
    By currentAddressOutput = By.cssSelector("p[id='currentAddress']");
    By permanentAddressOutput = By.cssSelector("p[id='permanentAddress']");
    By expandAll = By.cssSelector("Button[class='rct-option rct-option-expand-all']");
    By deskTopSelect = By.cssSelector("input#tree-node-desktop + .rct-checkbox");
    By documentSelect = By.cssSelector("input#tree-node-documents + .rct-checkbox");
    By downloadsSelect = By.cssSelector("input#tree-node-downloads + .rct-checkbox");
    By notesSelect = By.cssSelector("input#tree-node-notes + .rct-checkbox");
    By commandsSelect = By.cssSelector("input#tree-node-commands + .rct-checkbox");
    By workspaceSelect = By.cssSelector("input#tree-node-workspace + .rct-checkbox");
    By reactSelect = By.cssSelector("input#tree-node-react + .rct-checkbox");
    By angularSelect = By.cssSelector("input#tree-node-angular + .rct-checkbox");
    By veuSelect = By.cssSelector("input#tree-node-veu + .rct-checkbox");
    By officeSelect = By.cssSelector("input#tree-node-office + .rct-checkbox");
    By publicSelect = By.xpath("//span[text()='Public']");
    By privateSelect = By.xpath("//span[text()='Private']");
    By classifiedSelect = By.xpath("//span[text()='Classified']");
    By generalSelect = By.xpath("//span[text()='General']");
    By wordFlieSelect = By.cssSelector("input#tree-node-wordFile + .rct-checkbox");
    By excelSelect = By.cssSelector("input#tree-node-excelFile + .rct-checkbox");
    By addButton = By.id("addNewRecordButton");
    By tableFirstName= By.id("firstName");
    By tableLastName= By.id("lastName");
    By tableEmail= By.id("userEmail");
    By tableAge= By.id("age");
    By tableSalary= By.id("salary");
    By tableDepartment= By.id("department");
    By tableSubmit= By.id("submit");
    By seachTable = By.cssSelector("input[id='searchBox']");

    String Fullname = "Rahul Naik";
    String stringEmail = "test@gmail.com";
    String stringCurrentAddress = "23 Street Banglore";
    String stringPermanentAddress = "67 RD Rajaji Nagar";

    public boolean enterInfoTextBox() throws IOException {

        methods.enter(fullName, Fullname);
        methods.enter(email, stringEmail);
        methods.enter(currentAddress, stringCurrentAddress);
        methods.enter(permanentAddress, stringPermanentAddress);
        methods.scrollToElement(submit);

        if (methods.click(submit)) {
            return true;
        }

        return false;
    }

    public boolean selectMenu(String option) {
        methods.homePage();
        By optionSelect = By.xpath("//h5[text()='" + option + "']");
        methods.click(optionSelect);
        return true;

    }

    public boolean validateTextboxOutput() {
        return methods.fetch(fullNameOutput).equalsIgnoreCase(Fullname) &&
                methods.fetch(emailOutput).equalsIgnoreCase(stringEmail) &&
                methods.fetch(currentAddressOutput).equalsIgnoreCase(stringCurrentAddress) &&
                methods.fetch(permanentAddressOutput).equalsIgnoreCase(stringPermanentAddress);
    }

    public boolean checkBox(String[] selectingFolderFiles) {
        methods.click(expandAll);
        for (String folderFile : selectingFolderFiles) {
            switch (folderFile) {
                case "Desktop":
                    methods.click(deskTopSelect);
                    break;
                case "Notes":
                    methods.click(notesSelect);
                    break;
                case "Commands":
                    methods.click(commandsSelect);
                    break;
                case "Document":
                    methods.click(documentSelect);
                    break;
                case "WorkSpace":
                    methods.click(workspaceSelect);
                    break;
                case "React":
                    methods.click(reactSelect);
                    break;
                case "Angular":
                    methods.click(angularSelect);
                    break;
                case "Veu":
                    methods.click(veuSelect);
                    break;
                case "Office":
                    methods.click(officeSelect);
                    break;
                case "Public":
                    methods.click(publicSelect);
                    break;
                case "Private":
                    methods.click(privateSelect);
                    break;

                case "Classified":
                    methods.click(classifiedSelect);
                    break;
                case "General":
                    methods.click(generalSelect);
                    break;
                case "Downloads":
                    methods.click(downloadsSelect);
                    break;
                case "Word File":
                    methods.click(wordFlieSelect);
                    break;
                case "Excel File":
                    methods.click(excelSelect);
                    break;

            }
        }
        return true;

    }

    public boolean validateCheckboxOutput(String folderFile) {
        methods.scrollToElement(outputString);
        return folderFile.equalsIgnoreCase(methods.fetch(outputString));

    }
    public void radioButtonValidation(String button) {
        By radioButtonOutput  = By.cssSelector("p[class='mt-3']");
        String[] parts = methods.fetch(radioButtonOutput).split(" ");
        System.out.printf(parts[3]);
        Assert.assertTrue("Pass",parts[3].equalsIgnoreCase(button));
    }

    public void selectFromElements(String options) {
        By elementOption = By.xpath("//span[text()='"+options+"']");
        methods.click(elementOption);
    }
    public boolean  radioButton(String button) {
        By radioButton  = By.xpath("//label[@for='"+button+"Radio']");
        methods.click(radioButton);
            return methods.checkRadioButton(radioButton);
        }
        public void nowOfRowInTable(){
            By rowsNo = By.cssSelector("div[class='rt-tr-group']");
            List<WebElement> rows = driver.findElements(rowsNo);
            Assert.assertTrue("Table is Empty", rows.size() > 0);
            System.out.printf(String.valueOf(rows.size()));

        }
        public void addDateToTable(String name,String lastname,String email,String age,String salary,String department) throws IOException {
            By rowsNo = By.cssSelector("div[class='rt-tr-group']");
            List<WebElement> rows = driver.findElements(rowsNo);


           methods.click(addButton);
           methods.enter(tableFirstName,name);
           methods.enter(tableLastName,lastname);
           methods.enter(tableEmail,email);
           methods.enter(tableDepartment,department);
           methods.enter(tableAge,age);
           methods.enter(tableSalary,salary);
           methods.click(tableSubmit);



        }
        public void editTable(String name,String lastname,String email,String age,String salary,String department) throws IOException {
            By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Edit']");
            By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Edit']");
            try{
                methods.click(editPathOdd);
            }
            catch (Exception e){
                methods.click(editPathEven);
            }
                methods.enter(tableFirstName, name);
                methods.enter(tableLastName, lastname);
                methods.enter(tableEmail, email);
                methods.enter(tableDepartment, department);
                methods.enter(tableAge, age);
                methods.enter(tableSalary, salary);
                methods.click(tableSubmit);
                methods.click(tableSubmit);

        }
        public void tableRowDelete(String name) {
            By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Delete']");
            By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Delete']");
            try{
                methods.click(editPathOdd);
            }
            catch (Exception e){
                methods.click(editPathEven);
            }
        }

    public void tableSearch(String name) throws IOException {

        methods.enter(seachTable,name);
        By editPathOdd = By.xpath("//div[(text()='" + name + "')]");
        String searchResult = methods.fetch(editPathOdd);
        Assert.assertTrue(name.equalsIgnoreCase(searchResult));

    }

    public void tableSort(String sortBy) {
        By sort = By.xpath("//div[text()='"+sortBy+"']");
        methods.click(sort);


    }

    public void verifydoubleClick(String button) {
        By doubleClicks = By.id("doubleClickBtn");
        By doubleClickOutput= By.id("doubleClickMessage");
        methods.scrollToElement(doubleClicks);
        methods.actions().doubleClick(methods.webElement(doubleClicks)).perform();
        Assert.assertTrue(methods.fetch(doubleClickOutput).equalsIgnoreCase("You have done a double click"));

    }

    public void verifyRightClick() {
        By rightClicks = By.xpath("//*[text()='Right Click Me']");
        By rightClickOutput= By.id("rightClickMessage");
        methods.scrollToElement(rightClicks);
        methods.actions().contextClick(methods.webElement(rightClicks)).perform();
        Assert.assertTrue(methods.fetch(rightClickOutput).equalsIgnoreCase("You have done a right click"));
    }
    public void verifyClickMe() {
        By dynamicClick = By.xpath("//*[text()='Click Me']");
        By dynamicClickOutput= By.id("dynamicClickMessage");
        methods.scrollToElement(dynamicClick);
        methods.actions().click(methods.webElement(dynamicClick)).perform();
        Assert.assertTrue(methods.fetch(dynamicClickOutput).equalsIgnoreCase("You have done a dynamic click"));
    }

    public void nextWindowValidation() {
        By link = By.cssSelector("a#simpleLink");
        methods.click(link);
        methods.handleMultplieWindow();

    }

    public void apiValidation(By Element) throws IOException {

        System.out.printf(methods.linkChecker(Element));

        }


    public void downLoad(By elementDownload) {
        methods.webElement(elementDownload).click();
        String downloadPath = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\sampleFile.jpeg";

        File downloadFile = new File(downloadPath);
        Assert.assertTrue(downloadFile.exists());


    }

    public void upLoad(By elementUpload) {
        methods.webElement(elementUpload).sendKeys("C:\\Users\\"+System.getProperty("user.name")+"\\IdeaProjects\\ToolsQA\\TestEvidences\\sampleFile.jpeg");
    }

    public void buttonValidate(int  duration) {
        By beforeButton = By.id("enableAfter");
        By buttonColor = By.id("colorChange");
        Assert.assertFalse(methods.isEnabled(beforeButton));
        String button = driver.findElement(buttonColor).getCssValue("color");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(beforeButton));
        Assert.assertFalse(driver.findElement(buttonColor).getCssValue("color").equalsIgnoreCase(button));
        Assert.assertTrue(methods.isEnabled(beforeButton));

    }
}





