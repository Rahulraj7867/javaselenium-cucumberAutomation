package com.techwith.steps.ui;
import com.techwith.ui.models.customUtils.elementCommonUtils;
import io.cucumber.java.Scenario;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import com.techwith.ui.pages.Custom_Methods;
import com.techwith.webdriver.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DashboardPageSteps extends WebDriverFactory {
    private String currentFeatureFileName;
    @Value("${test.AppUrl}")
    public String testUrl;
    @Autowired
    public Custom_Methods Custom_Methods;

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        currentFeatureFileName = scenario.getUri().toString();
    }

    public static String[] readConfig() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("LastBounce_Credentials.config");
        // load a properties file
        prop.load(input);
        // get the property value and print it out
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        return new String[]{username, password};
    }

    @When("Open the Url Of Lastbounce Application Validate First and Login with Valid Credentials")
    public void openTheUrlOfLastbounceApplicationValidateFirstAndLoginWithValidCredentials() throws IOException {
        getDriver().get(testUrl);
        String[] cred = readConfig();
        Custom_Methods.SignInToApplication(cred[0], cred[1]);
    }

    @Given("Validate the Dashboard Page")
    public void validateTheDashboardPage(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            String PageName = mapData.get("DashboardPage");
            Thread.sleep(10000);
            Custom_Methods.ValidateText(PageName, "DashboardPage");
        }
    }


    @Then("Validate Verify Submenu")
    public void validateVerifySubmenu(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("Verify Submenu1"), "Verify Submenu1"   );
            Custom_Methods.ValidateText(mapData.get("Verify Submenu2"), "Verify Submenu2"   );

        }
    }

    @Then("On Single Activity chart click on the No of days filter")
    public void onSingleActivityChartClickOnTheNoOfDaysFilter() throws InterruptedException {
        Custom_Methods.clickOnElement("NoOfDaysFilter");
        Thread.sleep(3000);

    }

    @Then("Validate  Days filter")
    public void validateDaysFilter(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateText(mapData.get("SingleActivity DaysFilter1"), "SingleActivity DaysFilter1"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivity DaysFilter2"), "SingleActivity DaysFilter2"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivity DaysFilter3"), "SingleActivity DaysFilter3"   );
        }
    }

    @Then("Hover on the Element")
    public void hoverOnTheElement(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Thread.sleep(2000);
        for (Map<String, String> mapData : data) {
            Custom_Methods.hoverOnTheElement(mapData.get("ElementName"));
        }
    }

    @Then("Validate Dashboard Page Navigation Menu")
    public void validateDashboardPageNavigationMenu(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateText(mapData.get("Dashboard Navigation"), "Dashboard Navigation"   );
            Custom_Methods.ValidateText(mapData.get("Verify Navigation"), "Verify Navigation"   );
            Custom_Methods.ValidateText(mapData.get("Phone Check Navigation"), "Phone Check Navigation"   );
            Custom_Methods.ValidateText(mapData.get("Account Navigation"), "Account Navigation "   );
            Thread.sleep(2000);
        }

    }

    @Then("Validate Account Submenu")
    public void validateAccountSubmenu(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            String Submenu = mapData.get("Logout Submenu");
            Thread.sleep(3000);
            Custom_Methods.ValidateText(Submenu, "Logout Submenu"   );
        }
    }

    @Then("On List Activity chart click Response filter")
    public void OnListActivityChartClickResponseFilter() {
        Custom_Methods.clickOnElement("ListActivityChartResponceFilter"   );
    }

    @Then("Select All Option filter From Response filter")
    public void selectAllOptionFilterFromResponseFilter() throws InterruptedException {
        Thread.sleep(3000);
        Custom_Methods.clickOnElement("AllResponseBtn"   );
    }


    @Then("Validate  Response filter After Selecting All filter Option")
    public void validateResponseFilterAfterSelectingAllFilterOption(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("ListActivityValid"), "ListActivityValid"   );
            Custom_Methods.ValidateText(mapData.get("ListActivityInvalid"), "ListActivityInvalid"   );
            Custom_Methods.ValidateText(mapData.get("ListActivityRisky"), "ListActivityRisky"   );
            Custom_Methods.ValidateText(mapData.get("ListActivityAcceptAll"), "ListActivityAcceptAll"   );
            Custom_Methods.ValidateText(mapData.get("ListActivityUnknown"), "ListActivityUnknown"   );
        }
    }

    @Then("Validate  Dashboard Page Contents")
    public void validateDashboardPageContents(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard LastBounce logo"), "Dashboard LastBounce logo"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Top navigation bar "), "Dashboard Top navigation bar "   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard List Activity Chart"), "Dashboard List Activity Chart"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Single Activity Chart"), "Dashboard Single Activity Chart"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard List History Table"), "Dashboard List History Table"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Single History Chart"), "Dashboard Single History Chart"   );
//            Custom_Methods.switchFrame("Dashboard Support side pull-out window"   );
            Thread.sleep(3000);
            Custom_Methods.clickOnElement("Dashboard Support side pull-out window"   );
            Thread.sleep(3000);
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Support side pull-out window"), "Dashboard Support side pull-out window"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard  Functionality footer "), "Dashboard  Functionality footer "   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Knowledge footer"), "Dashboard Knowledge footer"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Complex Verification Simplified footer"), "Dashboard Complex Verification Simplified footer"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Copyright information"), "Dashboard Copyright information"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard DemandScience logo"), "Dashboard DemandScience logo"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Privacy Policy links "), "Dashboard Privacy Policy links "   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Terms and Conditions link"), "Dashboard Terms and Conditions link"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Dashboard Social media links"), "Dashboard Social media links"   );

        }
    }

    @Then("Select fifteen Days option from the days filter")
    public void selectFifteenDaysOptionFromTheDaysFilter() throws InterruptedException {
        Thread.sleep(3000);
        Custom_Methods.clickOnElement("SingleActivityDaysFilter2"   );
    }

    @Then("Validate selected Days option")
    public void validateSelectedDaysOption(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("SingalActivitydaysfilter15"), "SingalActivitydaysfilter15"   );
        }
    }

    @Then("Click on Response Filter Button on List Activity Chart")
    public void clickOnResponseFilterButtonOnListActivityChart() {
        Custom_Methods.clickOnElement("ResponseFilterButtonOnListActivityChart"   );
    }

    @Then("Click on the No of days filter On List Activity chart")
    public void clickOnTheNoOfDaysFilterOnListActivityChart() {
        Custom_Methods.clickOnElement("clickOnTheNoOfDaysFilterOnListActivityChart"   );
    }

    @Then("Validate Responses Filter Options on List Activity Chart")
    public void validateResponsesFilterOptionsOnListActivityChart(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter1"), "ListActivity ResponseFilter1"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter2"), "ListActivity ResponseFilter2"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter3"), "ListActivity ResponseFilter3"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter4"), "ListActivity ResponseFilter4"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter5"), "ListActivity ResponseFilter5"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter6"), "ListActivity ResponseFilter6"   );
            Custom_Methods.ValidateText(mapData.get("ListActivity ResponseFilter7"), "ListActivity ResponseFilter7"   );
        }
    }

    @Then("Select fifteen Days option from the days filter On List Activity chart")
    public void selectFifteenDaysOptionFromTheDaysFilterOnListActivityChart() {
        Custom_Methods.clickOnElement("SingleActivityDaysFilter2"   );
    }

    @Then("Validate selected Days option in List Activity chart")
    public void validateSelectedDaysOptionInListActivityChart(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("ListActivitydays15option"), "ListActivitydays15option"   );

        }
    }

    @Then("Scroll down to List History table")
    public void scrollDownToListHistoryTable() throws InterruptedException {
        Custom_Methods.scrollToElement("Dashboard List History Table"   );

    }

    @Then("Validate list History table batch file with corresponding details")
    public void validateListHistoryTableBatchFileWithCorrespondingDetails(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(2000); 
            //Custom_Methods.clickOnElement("ListHistoryTableFirstCsv"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateElementPresent(mapData.get("ListHistoryTablefilename"), "ListHistoryTablefilename"   );
            Custom_Methods.ValidateElementPresent(mapData.get("fileStatus"), "fileStatus"   );
        }
    }

    @Then("On the left side of the Dashboard click Support")
    public void onTheLeftSideOfTheDashboardClickSupport() {
        Custom_Methods.clickOnElement("supportpopup");
    }

    @Then("Contact Support pop-out window is shown")
    public void contactSupportPopOutWindowIsShown(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(2000); 
            Custom_Methods.clickOnElement("ContactSupport"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateText("Contact Support",mapData.get("ContactSupport"));
        }
    }

    @Then("Scroll down to bottom of page")
    public void scrollDownTobottomofpage() {
        Custom_Methods.scrollToElement("facebookurl"   );
    }

    @Then("Validate social media urls")
    public void validateSocialMediaUrls(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.clickOnElement("twitterurl");
            Thread.sleep(3000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("twitterurl"),currentFeatureFileName);
            Thread.sleep(3000);
            Custom_Methods.clickOnElement("linkedinurl");
            Thread.sleep(3000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("linkedinurl"),currentFeatureFileName);
            Thread.sleep(3000);
            Custom_Methods.clickOnElement("facebookurl");
            Thread.sleep(3000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("facebookurl"),currentFeatureFileName);
        }
    }

    @Then("Validate Terms and Condition link")
    public void validateTermsAndConditionLink(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("termsandconditions"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("termsandconditions"),currentFeatureFileName);
        }
    }

    @Then("Validate privacy policy links")
    public void validatePrivacyPolicyLinks(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("privacypolicy"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("privacypolicy"),currentFeatureFileName);
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("CCPA"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("CCPA"),currentFeatureFileName);
        }
    }

    @Then("Validate DS links under Complex Verification Simplified footer")
    public void validateDSLinksUnderComplexVerificationSimplifiedFooter(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("complexverificationsimplifiedDSlink"   );
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("complexverificationsimplifiedDSlink"),currentFeatureFileName);
        }
    }

    @Then("Validate links under Knowledge footer")
    public void validateLinksUnderKnowledgeFooter(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("validemailsfooter"   );
            Custom_Methods.ValidateText(mapData.get("validemailsfooter"),"validemailsfooter");
            Custom_Methods.scrollToElement("facebookurl"   );
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("invalidemailsfooter"   );
            Custom_Methods.ValidateText(mapData.get("invalidemailsfooter"),"invalidemailsfooter");
            Custom_Methods.scrollToElement("facebookurl"   );
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("riskyemailsfooter"   );
            Custom_Methods.ValidateText(mapData.get("riskyemailsfooter"),"riskyemailsfooter");
            Custom_Methods.scrollToElement("facebookurl"   );
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("acceptallemailsfooter"   );
            Custom_Methods.ValidateText(mapData.get("acceptallemailsfooter"),"acceptallemailsfooter");
            Custom_Methods.scrollToElement("facebookurl"   );
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("unknownemailsfooter"   );
            Custom_Methods.ValidateText(mapData.get("unknownemailsfooter"),"unknownemailsfooter");
        }
    }

    @Then("Validate links under Functionality footer")
    public void validateLinksUnderFunctionalityFooter(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("dashboardfooterlink"   );
            Custom_Methods.CaptureCurrenturl(mapData.get("dashboardfooterlink"));
            Thread.sleep(1000);
            Custom_Methods.scrollToElement("facebookurl"   );
            Custom_Methods.clickOnElement("listverifyfooterlink"   );
            Custom_Methods.CaptureCurrenturl(mapData.get("listverifyfooterlink"));
            Thread.sleep(1000);
            Custom_Methods.scrollToElement("facebookurl"   );
            Custom_Methods.clickOnElement("singleverifyfooterlink"   );
            Custom_Methods.CaptureCurrenturl(mapData.get("singleverifyfooterlink"));
        }
    }

    @Then("Scroll down to Single Verify table")
    public void scrollDownToSingleVerifyTable() {
        Custom_Methods.scrollToElement("listhistorpgnarrow");
    }

    @Then("Click on link icon beside single history and validate page is redirected")
    public void clickOnLinkIconBesideSingleHistoryAndValidatePageIsRedirected(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("singlehistoryhyperlink"   );
            Custom_Methods.CaptureCurrenturl(mapData.get("singlehistoryhyperlink"));
        }
    }

    @Then("Click on link icon beside list verify and validate page is redirected")
    public void clickOnLinkIconBesideListVerifyAndValidatePageIsRedirected(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("listverifyhyperlink"   );
            Custom_Methods.CaptureCurrenturl(mapData.get("listverifyhyperlink"));
        }
    }

    @Then("Click on batch with ready status")
    public void clickOnBatchWithReadyStatus() throws InterruptedException {
        Custom_Methods.scrollToElement("Listverifysearch");
        Thread.sleep(1000);
        Custom_Methods.clickOnElement("readystatustext");
    }

    @Then("validate batch details")
    public void validateBatchDetails(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(2000);
            Custom_Methods.ValidateText(mapData.get("preverifyResultdetails"),"preverifyResultdetails");
            Custom_Methods.ValidateText(mapData.get("batchfilename"),"batchfilename");
            Custom_Methods.ValidateText(mapData.get("typosfound"),"typosfound");
            Custom_Methods.ValidateText(mapData.get("totalrecords"),"totalrecords");
        }
    }

    @Then("Validate verify button and fix typo toggle")
    public void validateVerifyButtonAndFixTypoToggle(DataTable dataTable) throws InterruptedException{
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateElementPresent(mapData.get("Verify Button"),"Verify Button");
        }
    }

    @Then("Click on view icon for any email")
    public void clickOnViewIconForAnyEmail() {
        Custom_Methods.scrollToElement("singlehistorysearch");
        Custom_Methods.clickOnElement("singlehistoryviewicon");
    }

    @Then("Validate batch details")
    public void validateBatchDetails() {
        Custom_Methods.ValidateElementPresent("singlehistorystatus","singlehistorystatus");
        Custom_Methods.ValidateElementPresent("singlehistorymailserver","singlehistorymailserver");
        Custom_Methods.ValidateElementPresent("singlehistoryattr","singlehistoryattr");
        Custom_Methods.ValidateText("virgilio.so@demandscience.com","singlehistoremailtext");

    }

    @Then("Select batch from the table with Completed status")
    public void selectBatchFromTheTableWithCompletedStatus(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        int i;
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            String expectedStatus = mapData.get("Status");
            for (i = 1; i <= 4; i++) {
                String actualText = elementCommonUtils.fetchDataByGetText(By.xpath("(//p[contains(@id,'tablecell-lv-ht-status-')])[" + i + "]"));
                if (expectedStatus.equals(actualText) && actualText.equalsIgnoreCase("Completed")) {
                    Thread.sleep(2000);
                    elementCommonUtils.ClickBy(By.xpath("(//td[contains(@id,'tablecell-lv-ht-file-name')])[" + i + "]"));
                    break;
                }
            }
        }
    }
    @Then("Validate batch file details")
    public void validateBatchFileDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateElementPresent(mapData.get("ListHistoryTablefilename"), "ListHistoryTablefilename"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Uploaded timestamp "), "Uploaded timestamp "   );
            Custom_Methods.ValidateElementPresent(mapData.get("Completed timestamp "), "Completed timestamp "   );
            Custom_Methods.ValidateElementPresent(mapData.get("fileStatus"), "fileStatus"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Total noof records"), "Total noof records"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Total noof Duplicate records"), "Total noof Duplicate records"   );
            Custom_Methods.ValidateElementPresent(mapData.get("Responses and their totalpercentage"), "Responses and their totalpercentage"   );
            Custom_Methods.ValidateElementPresent(mapData.get("percentagewhenhovered"), "percentagewhenhovered"   );

        }
    }

    @Then("Validate functionality footer")
    public void validateFunctionalityFooter(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateText(mapData.get("dashboardfooterlink"),"dashboardfooterlink");
            Custom_Methods.ValidateText(mapData.get("listverifyfooterlink"),"listverifyfooterlink");
            Custom_Methods.ValidateText(mapData.get("singleverifyfooterlink"),"singleverifyfooterlink");
        }
    }

    @Then("validate Knowledge footer")
    public void validateKnowledgeFooter(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Custom_Methods.ValidateText(mapData.get("validemailsfooter"),"validemailsfooter");
            Custom_Methods.ValidateText(mapData.get("invalidemailsfooter"),"invalidemailsfooter");
            Custom_Methods.ValidateText(mapData.get("riskyemailsfooter"),"riskyemailsfooter");
            Custom_Methods.ValidateText(mapData.get("acceptallemailsfooter"),"acceptallemailsfooter");
            Custom_Methods.ValidateText(mapData.get("unknownemailsfooter"),"unknownemailsfooter");
        }
    }

    @Then("Validate text under Complex Verification Simplified footer")
    public void validateTextUnderComplexVerificationSimplifiedFooter() {
        Custom_Methods.ValidateText("LastBounce is the email intelligence platform by Demand Science, offering accurate email verification at source and at scale. Learn more by visiting DemandScience",
                "complexverificationsimplifiedtext");
    }
    @Then("Validate Social media link")
    public void validateSocialMediaLink(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("facebookurl");
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("facebookurl"),currentFeatureFileName);
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("twitterurl");
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("twitterurl"),currentFeatureFileName);
            Thread.sleep(1000);
            Custom_Methods.clickOnElement("linkedinurl");
            Thread.sleep(1000);
            Custom_Methods.ValidateTextFromWindow(mapData.get("linkedinurl"),currentFeatureFileName);

        }
    }

    @Then("On Single Activity chart click Response filter")
    public void onSingleActivityChartClickResponseFilter() {
        Custom_Methods.clickOnElement("responseFilterOnSingleActivity");
    }

    @Then("Validate  Response filter")
    public void validateResponseFilter(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("SingleActivityValid"), "SingleActivityValid"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityInvalid"), "SingleActivityInvalid"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityRisky"), "SingleActivityRisky"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityAcceptAll"), "SingleActivityAcceptAll"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityUnknown"), "SingleActivityUnknown"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityValidNInvalid"), "SingleActivityValidNInvalid"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityAll"), "SingleActivityAll"   );

        }
    }

    @Then("Select All Option filter From Response filter on Single activity")
    public void selectAllOptionFilterFromResponseFilterOnSingleActivity() {
        Custom_Methods.clickOnElement("SingleActivityAll");
    }

    @Then("Validate  Response filter at bottom")
    public void validateResponseFilterAtBottom(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> mapData : data) {
            Thread.sleep(3000);
            Custom_Methods.ValidateText(mapData.get("SingleActivityValid"), "SingleActivityValidValidatn"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityInvalid"), "SingleActivityInvalidValidatn"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityRisky"), "SingleActivityRiskyValidatn"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityAcceptAll"), "SingleActivityAcceptAllValidatn"   );
            Custom_Methods.ValidateText(mapData.get("SingleActivityUnknown"), "SingleActivityUnknownValidatn"   );
        }
    }

    @Given(":when i login ornagehrm")
    public void whenILoginOrnagehrm() {


    }
}
