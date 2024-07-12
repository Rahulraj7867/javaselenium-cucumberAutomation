package com.techwith.ui.models.customUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

import static com.techwith.webdriver.WebDriverFactory.getDriver;

@Component
public class elementCommonUtils {

    public static JavascriptExecutor js;
    public static void ElementDisplay(By by) {
        boolean val = getDriver().findElement(by).isDisplayed();
    }
    public static void SendKeyBy(By by, String sendingKeys)  {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).click();
        getDriver().findElement(by).sendKeys(sendingKeys);
    }
    public static void KeyBoardEvents(By by , Keys key){
        getDriver().findElement(by).sendKeys(key);
    }
    public static void KeyBoardEvents(By by , String keySequence){
        getDriver().findElement(by).sendKeys(keySequence);
    }

    public static void ClickBy(By by) {
        getDriver().findElement(by).click();
    }

    public static String fetchDataByInput(By by) {
        return getDriver().findElement(by).getAttribute("value");
    }

    public static String fetchDataByGetTexts(By by , int i){
        return getDriver().findElements(by).get(i).getText();
    }

    public static String fetchDataByGetText(By by){
        System.out.println("getDriver().findElement(by).getText():"+getDriver().findElement(by).getText());
        return getDriver().findElement(by).getText();
    }

    public static WebElement ElementBy(By by) {
        return getDriver().findElement(by);
    }

    public static WebElement elementFromString(String str1, String name, String str2) {
        String finalString = str1 + name + str2;
        return getDriver().findElement(By.xpath(finalString));
    }

    public static WebElement elementFromStringX4(String str1, String name, String str2 , int i , String str3) {
        String finalString = str1 + name + str2 + i + str3;
        return getDriver().findElement(By.xpath(finalString));
    }

    public static List<WebElement> ListElements(By by) {
        return getDriver().findElements(by);
    }

    public static List<WebElement> ListElements(WebElement element,By by) {
        return element.findElements(by);
    }

    public static void waitForElement(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120, 1));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void ClickByJavaScript(By by) {
        js = (JavascriptExecutor) getDriver();
        WebElement ele = getDriver().findElement(by);
        js.executeScript("arguments[0].click();", ele);
    }

    public static void ClickByJavaScript(WebElement element) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void ClickByJavaScript(String Str1, String Name, String Str3) {
        String finalString = Str1 + Name + Str3;
        WebElement element = getDriver().findElement(By.xpath(finalString));
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static By StringToByWithIntegerForXpath(String Str1, int Name, String Str3){
        String finalString = Str1 + Name + Str3;
        return By.xpath(finalString);
    }

    public static void ScrollIntoElement(WebElement element) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void DropDownBySelect(By locator, String type, String value) {
        Select select = new Select(ElementBy(locator));
        switch (type) {
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            default:
                System.out.println("Please pass the correct selection criteria...");
                break;
        }


    }



}
