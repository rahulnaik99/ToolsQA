package Pages;

//import io.cucumber.java.en_old.Ac;
import commonMethods.pageObjectManager;
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
    pageObjectManager pg;

    public elementPG() throws AWTException {
        pg=new pageObjectManager();
        driver= pg.base().initializeDriver();
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

    public boolean enterInfoTextBox() throws IOException, AWTException {
        
        pg.methods().enter(fullName, Fullname);
        pg.methods().enter(email, stringEmail);
        pg.methods().enter(currentAddress, stringCurrentAddress);
        pg.methods().enter(permanentAddress, stringPermanentAddress);
        pg.methods().scrollToElement(submit);

        return pg.methods().click(submit);
    }

    public void selectMenu(String option) throws IOException, AWTException {
        pg.methods().homePage();
        By optionSelect = By.xpath("//h5[text()='" + option + "']");
        pg.methods().click(optionSelect);

    }

    public void validateTextboxOutput() throws AWTException {
        if (pg.methods().fetch(fullNameOutput).equalsIgnoreCase(Fullname) && pg.methods().fetch(emailOutput).equalsIgnoreCase(stringEmail) && pg.methods().fetch(currentAddressOutput).equalsIgnoreCase(stringCurrentAddress)) {
            pg.methods().fetch(permanentAddressOutput);
        }
    }

    public void checkBox(String[] selectingFolderFiles) throws IOException, AWTException {
        pg.methods().click(expandAll);
        for (String folderFile : selectingFolderFiles) {
            switch (folderFile) {
                case "Desktop":
                    pg.methods().click(deskTopSelect);
                    break;
                case "Notes":
                    pg.methods().click(notesSelect);
                    break;
                case "Commands":
                    pg.methods().click(commandsSelect);
                    break;
                case "Document":
                    pg.methods().click(documentSelect);
                    break;
                case "WorkSpace":
                    pg.methods().click(workspaceSelect);
                    break;
                case "React":
                    pg.methods().click(reactSelect);
                    break;
                case "Angular":
                    pg.methods().click(angularSelect);
                    break;
                case "Veu":
                    pg.methods().click(veuSelect);
                    break;
                case "Office":
                    pg.methods().click(officeSelect);
                    break;
                case "Public":
                    pg.methods().click(publicSelect);
                    break;
                case "Private":
                    pg.methods().click(privateSelect);
                    break;

                case "Classified":
                    pg.methods().click(classifiedSelect);
                    break;
                case "General":
                    pg.methods().click(generalSelect);
                    break;
                case "Downloads":
                    pg.methods().click(downloadsSelect);
                    break;
                case "Word File":
                    pg.methods().click(wordFlieSelect);
                    break;
                case "Excel File":
                    pg.methods().click(excelSelect);
                    break;

            }
        }

    }

    public void validateCheckboxOutput(String folderFile) throws AWTException {
        pg.methods().scrollToElement(outputString);
        pg.methods().fetch(outputString);

    }
    public void radioButtonValidation(String button) throws AWTException {
        By radioButtonOutput  = By.cssSelector("p[class='mt-3']");
        String[] parts = pg.methods().fetch(radioButtonOutput).split(" ");
        System.out.printf(parts[3]);
        Assert.assertTrue("Pass",parts[3].equalsIgnoreCase(button));
    }

    public void selectFromElements(String options) throws IOException, AWTException {
        By elementOption = By.xpath("//span[text()='"+options+"']");
        pg.methods().click(elementOption);
    }
    public void radioButton(String button) throws IOException, AWTException {
        By radioButton  = By.xpath("//label[@for='"+button+"Radio']");
        pg.methods().click(radioButton);
        pg.methods().checkRadioButton(radioButton);
    }
        public void nowOfRowInTable(){
            By rowsNo = By.cssSelector("div[class='rt-tr-group']");
            List<WebElement> rows = driver.findElements(rowsNo);
            Assert.assertFalse("Table is Empty", rows.isEmpty());
            System.out.printf(String.valueOf(rows.size()));

        }
        public void addDateToTable(String name,String lastname,String email,String age,String salary,String department) throws IOException, AWTException {
            By rowsNo = By.cssSelector("div[class='rt-tr-group']");
            List<WebElement> rows = driver.findElements(rowsNo);


           pg.methods().click(addButton);
           pg.methods().enter(tableFirstName,name);
           pg.methods().enter(tableLastName,lastname);
           pg.methods().enter(tableEmail,email);
           pg.methods().enter(tableDepartment,department);
           pg.methods().enter(tableAge,age);
           pg.methods().enter(tableSalary,salary);
           pg.methods().click(tableSubmit);



        }
        public void editTable(String name,String lastname,String email,String age,String salary,String department) throws IOException, AWTException {
            By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Edit']");
            By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Edit']");
            try{
                pg.methods().click(editPathOdd);
            }
            catch (Exception e){
                pg.methods().click(editPathEven);
            }
                pg.methods().enter(tableFirstName, name);
                pg.methods().enter(tableLastName, lastname);
                pg.methods().enter(tableEmail, email);
                pg.methods().enter(tableDepartment, department);
                pg.methods().enter(tableAge, age);
                pg.methods().enter(tableSalary, salary);
                pg.methods().click(tableSubmit);
                pg.methods().click(tableSubmit);

        }
        public void tableRowDelete(String name) throws IOException, AWTException {
            By editPathOdd = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -odd')]//span[@title='Delete']");
            By editPathEven = By.xpath("//div[(text()='" + name + "')]/ancestor::div[(@class='rt-tr -even')]//span[@title='Delete']");
            try{
                pg.methods().click(editPathOdd);
            }
            catch (Exception e){
                pg.methods().click(editPathEven);
            }
        }

    public void tableSearch(String name) throws IOException, AWTException {

        pg.methods().enter(seachTable,name);
        By editPathOdd = By.xpath("//div[(text()='" + name + "')]");
        String searchResult = pg.methods().fetch(editPathOdd);
        Assert.assertTrue(name.equalsIgnoreCase(searchResult));

    }

    public void tableSort(String sortBy) throws IOException, AWTException {
        By sort = By.xpath("//div[text()='"+sortBy+"']");
        pg.methods().click(sort);


    }

    public void verifydoubleClick(String aDouble) throws AWTException {
        By doubleClicks = By.id("doubleClickBtn");
        By doubleClickOutput= By.id("doubleClickMessage");
        pg.methods().scrollToElement(doubleClicks);
        pg.objectManager().actions().doubleClick(pg.objectManager().webElement(doubleClicks)).perform();
        Assert.assertTrue(pg.methods().fetch(doubleClickOutput).equalsIgnoreCase("You have done a double click"));

    }

    public void verifyRightClick() throws AWTException {
        By rightClicks = By.xpath("//*[text()='Right Click Me']");
        By rightClickOutput= By.id("rightClickMessage");
        pg.methods().scrollToElement(rightClicks);
        pg.objectManager().actions().contextClick(pg.objectManager().webElement(rightClicks)).perform();
        Assert.assertTrue(pg.methods().fetch(rightClickOutput).equalsIgnoreCase("You have done a right click"));
    }
    public void verifyClickMe() throws AWTException {
        By dynamicClick = By.xpath("//*[text()='Click Me']");
        By dynamicClickOutput= By.id("dynamicClickMessage");
        pg.methods().scrollToElement(dynamicClick);
        pg.objectManager().actions().click(pg.objectManager().webElement(dynamicClick)).perform();
        Assert.assertTrue(pg.methods().fetch(dynamicClickOutput).equalsIgnoreCase("You have done a dynamic click"));
    }

    public void nextWindowValidation() throws IOException, AWTException {
        By link = By.cssSelector("a#simpleLink");
        pg.methods().click(link);
        pg.methods().handleMultplieWindow();

    }

    public void apiValidation(By Element) throws AWTException {

        System.out.printf(pg.methods().linkChecker(Element));

        }


    public void downLoad(By elementDownload) throws AWTException {
        pg.objectManager().webElement(elementDownload).click();
        String downloadPath = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\sampleFile.jpeg";
        File downloadFile = new File(downloadPath);
        Assert.assertTrue(downloadFile.exists());


    }

    public void upLoad(By elementUpload) throws AWTException {
        pg.objectManager().webElement(elementUpload).sendKeys("C:\\Users\\"+System.getProperty("user.name")+"\\IdeaProjects\\ToolsQA\\TestEvidences\\sampleFile.jpeg");
    }

    public void buttonValidate(int  duration) throws AWTException {
        By beforeButton = By.id("enableAfter");
        By buttonColor = By.id("colorChange");
        Assert.assertFalse(pg.methods().isEnabled(beforeButton));
        String button = driver.findElement(buttonColor).getCssValue("color");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(beforeButton));
        Assert.assertFalse(driver.findElement(buttonColor).getCssValue("color").equalsIgnoreCase(button));
        Assert.assertTrue(pg.methods().isEnabled(beforeButton));

    }
}





