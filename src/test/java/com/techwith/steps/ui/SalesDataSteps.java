package com.techwith.steps.ui;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

public class SalesDataSteps {
    WebDriver driver;

    @Given("the user is logged in")
    public void userIsLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://application.url/login");

        // Add login steps
        // ...
    }

    @When("the user uploads an excel file {string}")
    public void userUploadsExcel(String fileName) {
        File excelFile = new File(fileName);
        // Code to upload the file
        // ...
    }

    @When("the user navigates to the PIBO operation section")
    public void navigateToPIBO() {
        // Code to navigate to PIBO operation
        // ...
    }

    @When("the user selects {string}")
    public void selectOption(String option) {
        // Code to select "Sales Details"
        // ...
    }

    @When("the user enters sales details from the excel file")
    public void enterSalesDetails() {
        // Code to read from Excel and enter details in the form
        try (FileInputStream fis = new FileInputStream("path/to/excel/file")) {
            // Create workbook instance holding reference to .xlsx file
            // Your logic
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user generates EPR Invoice Number")
    public void generateInvoiceNumber() {
        // Code to generate EPR Invoice Number
        // ...
    }

    @Then("the user updates the form with the generated EPR invoice number")
    public void updateFormWithInvoiceNumber() {
        // Code to update the form
        // ...
    }

    @Then("the user uploads the updated excel file")
    public void uploadUpdatedExcel() {
        // Code to upload updated excel file
        try (FileOutputStream fos = new FileOutputStream("path/to/updated/excel/file")) {
            // Writing and saving updated data
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
