package Pages;

//import io.cucumber.java.en_old.Ac;

import commonMethods.objectManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class elementPG {
    WebDriver driver;
    objectManager method;

    public elementPG() throws AWTException {
        method = new objectManager();
        driver = method.base().initializeDriver();
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
    By tableFirstName = By.id("firstName");
    By tableLastName = By.id("lastName");
    By tableEmail = By.id("userEmail");
    By tableAge = By.id("age");
    By tableSalary = By.id("salary");
    By tableDepartment = By.id("department");
    By tableSubmit = By.id("submit");
    By seachTable = By.cssSelector("input[id='searchBox']");

    String Fullname = "Rahul Naik";
    String stringEmail = "test@gmail.com";
    String stringCurrentAddress = "23 Street Banglore";
    String stringPermanentAddress = "67 RD Rajaji Nagar";

    public void enterInfoTextBox() throws IOException, AWTException {

        method.commonMethods().enter(fullName, Fullname);
        method.commonMethods().enter(email, stringEmail);
        method.commonMethods().enter(currentAddress, stringCurrentAddress);
        method.commonMethods().enter(permanentAddress, stringPermanentAddress);
        method.commonMethods().scrollToElement(submit);

        method.commonMethods().click(submit);
    }

    public void selectMenu(String option) throws IOException, AWTException {
        method.commonMethods().homePage();
        By optionSelect = By.xpath("//h5[text()='" + option + "']");
        method.commonMethods().click(optionSelect);

    }

    public void validateTextboxOutput() throws AWTException {
        if (method.commonMethods().fetch(fullNameOutput).equalsIgnoreCase(Fullname) && method.commonMethods().fetch(emailOutput).equalsIgnoreCase(stringEmail) && method.commonMethods().fetch(currentAddressOutput).equalsIgnoreCase(stringCurrentAddress)) {
            method.commonMethods().fetch(permanentAddressOutput);
        }
    }

    public void checkBox(String[] selectingFolderFiles) throws IOException, AWTException {
        method.commonMethods().click(expandAll);
        for (String folderFile : selectingFolderFiles) {
            switch (folderFile) {
                case "Desktop":
                    method.commonMethods().click(deskTopSelect);
                    break;
                case "Notes":
                    method.commonMethods().click(notesSelect);
                    break;
                case "Commands":
                    method.commonMethods().click(commandsSelect);
                    break;
                case "Document":
                    method.commonMethods().click(documentSelect);
                    break;
                case "WorkSpace":
                    method.commonMethods().click(workspaceSelect);
                    break;
                case "React":
                    method.commonMethods().click(reactSelect);
                    break;
                case "Angular":
                    method.commonMethods().click(angularSelect);
                    break;
                case "Veu":
                    method.commonMethods().click(veuSelect);
                    break;
                case "Office":
                    method.commonMethods().click(officeSelect);
                    break;
                case "Public":
                    method.commonMethods().click(publicSelect);
                    break;
                case "Private":
                    method.commonMethods().click(privateSelect);
                    break;

                case "Classified":
                    method.commonMethods().click(classifiedSelect);
                    break;
                case "General":
                    method.commonMethods().click(generalSelect);
                    break;
                case "Downloads":
                    method.commonMethods().click(downloadsSelect);
                    break;
                case "Word File":
                    method.commonMethods().click(wordFlieSelect);
                    break;
                case "Excel File":
                    method.commonMethods().click(excelSelect);
                    break;

            }
        }

    }

    public void validateCheckboxOutput(String s) throws AWTException {
        method.commonMethods().scrollToElement(outputString);
        method.commonMethods().fetch(outputString);

    }

    public void radioButtonValidation(String button) throws AWTException {
        By radioButtonOutput = By.cssSelector("p[class='mt-3']");
        String[] parts = method.commonMethods().fetch(radioButtonOutput).split(" ");
        System.out.printf(parts[3]);
        Assert.assertTrue("Pass", parts[3].equalsIgnoreCase(button));
    }

    public void selectFromElements(String options) throws IOException, AWTException {
        By elementOption = By.xpath("//span[text()='" + options + "']");
        method.commonMethods().click(elementOption);
    }

    public void radioButton(String button) throws IOException, AWTException {
        By radioButton = By.xpath("//label[@for='" + button + "Radio']");
        method.commonMethods().click(radioButton);
        method.commonMethods().checkRadioButton(radioButton);
    }

    public void nowOfRowInTable() {
        By rowsNo = By.cssSelector("div[class='rt-tr-group']");
        List<WebElement> rows = driver.findElements(rowsNo);
        Assert.assertFalse("Table is Empty", rows.isEmpty());
        System.out.printf(String.valueOf(rows.size()));

    }

    public void addDateToTable(String name, String lastname, String email, String age, String salary, String department) throws IOException, AWTException {
        By rowsNo = By.cssSelector("div[class='rt-tr-group']");
        List<WebElement> rows = driver.findElements(rowsNo);


        method.commonMethods().click(addButton);
        method.commonMethods().enter(tableFirstName, name);
        method.commonMethods().enter(tableLastName, lastname);
        method.commonMethods().enter(tableEmail, email);
        method.commonMethods().enter(tableDepartment, department);
        method.commonMethods().enter(tableAge, age);
        method.commonMethods().enter(tableSalary, salary);
        method.commonMethods().click(tableSubmit);


    }

    public void editTable(String name, String lastname, String email, String age, String salary, String department) throws IOException, AWTException {
        By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Edit']");
        By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Edit']");
        try {
            method.commonMethods().click(editPathOdd);
        } catch (Exception e) {
            method.commonMethods().click(editPathEven);
        }
        method.commonMethods().enter(tableFirstName, name);
        method.commonMethods().enter(tableLastName, lastname);
        method.commonMethods().enter(tableEmail, email);
        method.commonMethods().enter(tableDepartment, department);
        method.commonMethods().enter(tableAge, age);
        method.commonMethods().enter(tableSalary, salary);
        method.commonMethods().click(tableSubmit);
        method.commonMethods().click(tableSubmit);

    }

    public void tableRowDelete(String name) throws IOException, AWTException {
        By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Delete']");
        By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Delete']");
        try {
            method.commonMethods().click(editPathOdd);
        } catch (Exception e) {
            method.commonMethods().click(editPathEven);
        }
    }

    public void tableSearch(String name) throws IOException, AWTException {

        method.commonMethods().enter(seachTable, name);
        By editPathOdd = By.xpath("//div[(text()='" + name + "')]");
        String searchResult = method.commonMethods().fetch(editPathOdd);
        Assert.assertTrue(name.equalsIgnoreCase(searchResult));

    }

    public void tableSort(String sortBy) throws IOException, AWTException {
        By sort = By.xpath("//div[text()='" + sortBy + "']");
        method.commonMethods().click(sort);


    }

    public void verifydoubleClick(String aDouble) throws AWTException {
        By doubleClicks = By.id("doubleClickBtn");
        By doubleClickOutput = By.id("doubleClickMessage");
        method.commonMethods().scrollToElement(doubleClicks);
        method.classObjectManager().actions().doubleClick(method.classObjectManager().webElement(doubleClicks)).perform();
        Assert.assertTrue(method.commonMethods().fetch(doubleClickOutput).equalsIgnoreCase("You have done a double click"));

    }

    public void verifyRightClick() throws AWTException {
        By rightClicks = By.xpath("//*[text()='Right Click Me']");
        By rightClickOutput = By.id("rightClickMessage");
        method.commonMethods().scrollToElement(rightClicks);
        method.classObjectManager().actions().contextClick(method.classObjectManager().webElement(rightClicks)).perform();
        Assert.assertTrue(method.commonMethods().fetch(rightClickOutput).equalsIgnoreCase("You have done a right click"));
    }

    public void verifyClickMe() throws AWTException {
        By dynamicClick = By.xpath("//*[text()='Click Me']");
        By dynamicClickOutput = By.id("dynamicClickMessage");
        method.commonMethods().scrollToElement(dynamicClick);
        method.classObjectManager().actions().click(method.classObjectManager().webElement(dynamicClick)).perform();
        Assert.assertTrue(method.commonMethods().fetch(dynamicClickOutput).equalsIgnoreCase("You have done a dynamic click"));
    }

    public void nextWindowValidation() throws IOException, AWTException {
        By link = By.cssSelector("a#simpleLink");
        method.commonMethods().click(link);
        method.commonMethods().handleMultplieWindow();

    }

    public void apiValidation(By Element) throws AWTException {

        System.out.printf(method.commonMethods().linkChecker(Element));

    }


    public void downLoad(By elementDownload) throws AWTException {
        method.classObjectManager().webElement(elementDownload).click();
        String downloadPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\sampleFile.jpeg";
        File downloadFile = new File(downloadPath);
        Assert.assertTrue(downloadFile.exists());


    }

    public void upLoad(By elementUpload) throws AWTException {
        method.classObjectManager().webElement(elementUpload).sendKeys("C:\\Users\\" + System.getProperty("user.name") + "\\IdeaProjects\\ToolsQA\\TestEvidences\\sampleFile.jpeg");
    }

    public void buttonValidate(int duration) throws AWTException {
        By beforeButton = By.id("enableAfter");
        By buttonColor = By.id("colorChange");
        Assert.assertFalse(method.commonMethods().isEnabled(beforeButton));
        String button = driver.findElement(buttonColor).getCssValue("color");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(beforeButton));
        Assert.assertFalse(driver.findElement(buttonColor).getCssValue("color").equalsIgnoreCase(button));
        Assert.assertTrue(method.commonMethods().isEnabled(beforeButton));

    }
}





