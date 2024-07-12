
package com.techwith.steps.ui;

import com.techwith.ui.pages.Custom_Methods;
import com.techwith.webdriver.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ListVerifyPageSteps extends WebDriverFactory {
    private String currentFeatureFileName;
    @Value("${test.AppUrl}")
    public String testUrl;
    @Autowired
    public Custom_Methods Custom_Methods;

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        currentFeatureFileName = scenario.getUri().toString();
    }

    @Then("Click List Verify")
    public void clickListVerify() throws InterruptedException {
        Custom_Methods.clickOnElement("VerifySubmenu1");
        Thread.sleep(4000);
    }

    @Then("verify columns name of Results History table")
    public void verifyColumnsNameOfResultsHistoryTable(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateText(mapData.get("File Name"), "File Name");
            Custom_Methods.ValidateText(mapData.get("Records"), "Records");
            Custom_Methods.ValidateText(mapData.get("Uploaded"), "Uploaded");
            Custom_Methods.ValidateText(mapData.get("Processed"), "Processed");
            Custom_Methods.ValidateText(mapData.get("Status"), "Status");
            Custom_Methods.ValidateText(mapData.get("Action"), "Action");
            Custom_Methods.ValidateText(mapData.get("Delete"), "Delete");
            Custom_Methods.ValidateText(mapData.get("View"), "View");

        }
    }
    @Then("Verify the tabs are displayed under Results History table")
    public void verifyTheTabsAreDisplayedUnderResultsHistoryTable(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateElementPresent(mapData.get("AllTab"), "AllTab");
            Custom_Methods.ValidateElementPresent(mapData.get("Completed"), "Completed");
            Custom_Methods.ValidateElementPresent(mapData.get("Verifying"), "Verifying");
            Custom_Methods.ValidateElementPresent(mapData.get("Ready to verify"), "Ready to verify");
            Custom_Methods.ValidateElementPresent(mapData.get("Error"), "Error");
            Custom_Methods.ValidateElementPresent(mapData.get("Trash"), "Trash");
        }
    }

    @Then("Verify page heading")
    public void verifyPageHeading(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(4000);
            Custom_Methods.ValidateText(mapData.get("ListVerifypageHeading"), "ListVerifypageHeading");
        }
    }

    @Then("Click and Verify that user is able to click anywhere on the Drag & Drop section to upload a document")
    public void clickAndVerifyThatUserIsAbleToClickAnywhereOnTheDragDropSectionToUploadADocument() throws InterruptedException, AWTException {
        Custom_Methods.clickOnElement("ListVerifyFileUpload");
        Thread.sleep(2000);
    }

    @Then("Validate List Verify page Elements")
    public void validateListVerifyPageElements(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateElementPresent(mapData.get("ListVerifyFileUpload"), "ListVerifyFileUpload");
            Custom_Methods.ValidateElementPresent(mapData.get("Single Verify window"), "Single Verify window");
            Custom_Methods.ValidateElementPresent(mapData.get(" Results History table"), " Results History table");

        }
    }

    @Then("Drag & Drop a batch file to the upload section")
    public void dragDropABatchFileToTheUploadSection(DataTable dataTable) throws InterruptedException, AWTException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(2000);
            Custom_Methods.clickOnElement("ListVerifyFileUpload");
            Custom_Methods.uploadFile(mapData.get("ListVerifyFileUpload"));
        }
    }


    @Then("Validate uploaded file")
    public void validateUploadedFile(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(4000);
            Custom_Methods.ValidateElementPresent(mapData.get("VerifyBtnfromfileupload"), "VerifyBtnfromfileupload");
        }
    }

    @Then("Verify the details in upload section")
    public void verifyTheDetailsInUploadSection(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateElementPresent(mapData.get("ListVerifyFileUpload"), "ListVerifyFileUpload");
            Custom_Methods.ValidateText(mapData.get("DragandDropYourCSVfilehereorclicktoupload"), "DragandDropYourCSVfilehereorclicktoupload");
            Custom_Methods.ValidateElementPresent(mapData.get("Upload icon"), "Upload icon");

        }
    }

    @Then("Click on all tab")
    public void clickOnAllTab() throws InterruptedException {
        Thread.sleep(2000);
        Custom_Methods.clickOnElement("resultHistoryTableAllTab");
    }

    @Then("Go to the Results History table")
    public void goToTheResultsHistoryTable() {
        Custom_Methods.scrollToElement("ResultsHistorytable");
    }

    @Then("Click On Completed tab")
    public void clickOnCompletedTab() throws InterruptedException {
        Thread.sleep(1000);
        Custom_Methods.clickOnElement("Completed");
        Thread.sleep(2000);
    }

    @Then("Verify options for quick single verification")
    public void verifyOptionsForQuickSingleVerification(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("SingleVerifyText"), "SingleVerifyText");
            Thread.sleep(2000);
            Custom_Methods.ValidateElementPresent(mapData.get("EmailTextBox"), "EmailTextBox");
        }
    }
}
