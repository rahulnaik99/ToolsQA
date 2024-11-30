package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;
import java.util.Locale;

public class elementPG {
    WebDriver driver;
    commonMethods methods;

    public elementPG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver = base.initializeDriver();
    }
    By outputString = By.cssSelector("div[class='display-result mt-4']");
    By elements = By.cssSelector("path[d$='16z']");
    By textBox = By.xpath("//span[text()='Text Box']");
    By fullName = By.cssSelector("input[placeholder='Full Name']");
    By email = By.cssSelector("input[placeholder='name@example.com']");
    By currentAddress = By.cssSelector("textarea[placeholder='Current Address']");
    By permanentAddress = By.cssSelector("textarea[id='permanentAddress']");
    By submit = By.cssSelector("button[class='btn btn-primary']");
    By fullNameOutput = By.cssSelector("p[id='name']");
    By emailOutput = By.cssSelector("p[id='email']");
    By currentAddressOutput = By.cssSelector("p[id='currentAddress']");
    By permanentAddressOutput = By.cssSelector("p[id='permanentAddress']");

    String Fullname = "Rahul Naik";
    String stringEmail = "test@gmail.com";
    String stringCurrentAddress = "23 Street Banglore";
    String stringPermanentAddress = "67 RD Rajaji Nagar";

    public boolean enterInfoTextBox() {
        methods.click(textBox);
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
        By checkBox = By.xpath("//span[text()='Check Box']");
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


        methods.click(checkBox);
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
    public boolean validateCheckboxOutput(String folderFile){
        methods.scrollToElement(outputString);

       return folderFile.equalsIgnoreCase(methods.fetch(outputString));
    }



}
