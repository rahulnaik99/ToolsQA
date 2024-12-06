package Stepdefinition;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testBase.base;
import Pages.formPage;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class StepdefinitionForms  {
    WebDriver driver;
    base base;
    formPage Page;

    public StepdefinitionForms() throws AWTException {

        this.base = new base();
        this.driver = base.initializeDriver();
        this.Page = new formPage();
    }


    @When("^User Enter the information in the PracticeForm and Submit$")
    public void practiceForm() throws IOException, AWTException {
        Map<String,String> data = new HashMap<>();
        data.put("firstName", "John");
        data.put("lastName", "Doe");
        data.put("email", "john.doe@example.com");
        data.put("gender", "Male"); // Use "Male", "Female", or "Other" as needed
        data.put("mobileNumber", "9876543210");
        data.put("dobMonth", "March");
        data.put("dobYear", "2009");
        data.put("dobdate", "2");
        data.put("subjects", "Physics"); // Subjects can be comma-separated
        data.put("hobbies", "Reading, Sports"); // Hobbies can be comma-separated
        data.put("uploadPicture", "path/to/picture.jpg");
        data.put("currentAddress", "1234 Elm Street, Springfield");
        data.put("state", "NCR");
        data.put("city", "Delhi");
        Page.fillPracticeForm(data);
    }
}
