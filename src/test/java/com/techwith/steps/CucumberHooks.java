package com.techwith.steps;

import com.techwith.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CucumberHooks {

    public Response response;
    /**
     * Runs before each test(features)
     */
    @Before("@ui")
    public void beforeEach() {
        WebDriverFactory.createDriver();
    }

    public static Response confluencePost(String path, File file){
        return given()
                .auth().preemptive()
                .basic("akasht@appliedaiconsulting.com" ,"NRG00aI8rsgZSFfvRppe5014")
                .multiPart("file",file , "multipart/form-data")
                .header("X-Atlassian-Token","no-check")
                .post(path).thenReturn();
    }

    /**
     * Runs before each test(features)
     */
    @After("@ui")
    public void afterEach(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getName(), "image/png", new ByteArrayInputStream(
                    ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)), "png");
        }
////        File file = new File("target/cucumber-reports/");
////        String[] pathNames = file.list();
////        for (String pathname : pathNames) {
//            File finalFile = new File("target/cucumber-reports/Cucumber.html");
//            System.out.println("File Name is : " + finalFile);
//            Thread.sleep(5000);
//            response = confluencePost("https://pureincubation.atlassian.net/wiki/rest/api/content/16829120531/child/attachment", finalFile);
//            System.out.println("This is the response of the Report upload : " + response.prettyPrint());
//            System.out.println("Report Uploaded Successfully!!!");
            Thread.sleep(7000);
//            //deleteDirectory(finalFile);
            WebDriverFactory.cleanUpDriver();
        }

    @AfterSuite()
    public static void before_or_after_all() throws InterruptedException, IOException {
        Runtime rt = Runtime.getRuntime();
        rt.wait(1000);
        Process pr = rt.exec("allure generate");
        pr.exitValue();
    }


    }

