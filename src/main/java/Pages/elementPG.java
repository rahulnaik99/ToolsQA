package Pages;

import commonMethods.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.base;

import java.awt.*;

public class elementPG {
    WebDriver driver;
    commonMethods methods;

    public elementPG() throws AWTException {
        base base = new base();
        methods = new commonMethods();
        driver=base.initializeDriver();
    }

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

    String Fullname="Rahul Naik";
    String stringEmail = "test@gmail.com";
    String stringCurrentAddress = "23 Street Banglore";
    String stringPermanentAddress = "67 RD Rajaji Nagar";

    public boolean enterInfoTextBox(){
        methods.click(textBox);
        methods.enter(fullName,Fullname);
        methods.enter(email,stringEmail);
        methods.enter(currentAddress,stringCurrentAddress);
        methods.enter(permanentAddress,stringPermanentAddress);
        methods.scrollToElement(submit);

        if(methods.click(submit)){
            return true;
        }

        return false;
    }

    public boolean selectMenu(String option){
        By optionSelect = By.xpath("//h5[text()='"+option+"']");

        if(methods.click(optionSelect)){
            return true;
        }
        return false;
    }

    public boolean validateOutput(){
        return methods.fetch(fullNameOutput).equalsIgnoreCase(Fullname) &&
                methods.fetch(emailOutput).equalsIgnoreCase(stringEmail) &&
                methods.fetch(currentAddressOutput).equalsIgnoreCase(stringCurrentAddress) &&
                methods.fetch(permanentAddressOutput).equalsIgnoreCase(stringPermanentAddress);
    }
}
