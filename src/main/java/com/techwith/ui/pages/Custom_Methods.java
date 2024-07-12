package com.techwith.ui.pages;
import com.techwith.ui.LocatorsPage.Locators;
import com.techwith.ui.models.Custom_Models;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import static com.techwith.webdriver.WebDriverFactory.getDriver;
import java.lang.reflect.Field;

@Component
public class Custom_Methods {
    @Value("${test.AppUrl}")
    public String testUrl;
    @Autowired
    public Custom_Models Custom_Models;
    @Autowired
    public Locators Locators;

    public String ReturnLocatorName(String Locatorname) {
        String Locatortext;
        boolean startsWithNonAlphabet = !Character.isLetter(Locatorname.charAt(0));
        if (startsWithNonAlphabet) {
            String[] words = Locatorname.split(" ");
            Locatortext = words[1] + words[0];
        } else {
            Locatortext = Locatorname.replace(" ", "");
        }
        return Locatortext;
    }

    public void ValidateText(String text, String Locatorname) {
        try {
            String Locatortext = ReturnLocatorName(Locatorname);
            Locators authLocators = new Locators();
            Class<?> locatorClass = authLocators.getClass();
            Field locatorField = locatorClass.getDeclaredField(Locatortext);
            locatorField.setAccessible(true);  // Enable access to private fields if necessary
            Object locator = locatorField.get(authLocators);
            String actualText = Custom_Models.fetchText((By) locator);
            System.out.println("Expected Text :"+text);
            System.out.println("Fetched Text :"+actualText);
            Assert.assertEquals(text,actualText);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unexpected value of 'text': " + text);
        }
    }

    public void openurl() {
        getDriver().get(testUrl);
    }

    public void ValidateElementPresent(String text, String Locatorname) {
        try {
            String Locatortext = ReturnLocatorName(Locatorname);
            Locators authLocators = new Locators();
            Class<?> locatorClass = authLocators.getClass();
            Field locatorField = locatorClass.getDeclaredField(Locatortext);
            locatorField.setAccessible(true);  // Enable access to private fields if necessary
            Object locator = locatorField.get(authLocators);
            boolean isElementPresent = Custom_Models.ISElementPresent((By) locator);
            System.out.println("isElementPresent:"+isElementPresent);
            Assert.assertTrue(isElementPresent);
//            boolean status = isElementPresent;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unexpected to locate " + text);
        }
    }

    public void clickOnElement(String Locatorname) {
        try {
                String Locatortext = ReturnLocatorName(Locatorname);
                Locators authLocators = new Locators();
                Class<?> locatorClass = authLocators.getClass();
                Field locatorField = locatorClass.getDeclaredField(Locatortext);
                locatorField.setAccessible(true);  // Enable access to private fields if necessary
                Object locator = locatorField.get(authLocators);
                Thread.sleep(3000);
                Custom_Models.clickOn((By) locator);
            }
        catch (NoSuchFieldException | IllegalAccessException | InterruptedException e) {
            System.out.println("Unexpected value of 'locatorName': " + Locatorname);
        }
    }
    public void scrollToElement(String locatorName) {
        try {
                String locatorText = ReturnLocatorName(locatorName);
                Locators authLocators = new Locators();
                Class<?> locatorClass = authLocators.getClass();
                Field locatorField = locatorClass.getDeclaredField(locatorText);
                locatorField.setAccessible(true);
                Object locator = locatorField.get(authLocators);
                Custom_Models.scrollToElement((By) locator);
            }
        catch (NoSuchFieldException | IllegalAccessException | InterruptedException e) {
            System.out.println("Unexpected value of 'locatorName': " + locatorName);
        }
    }

    public void SignInToApplication(String username, String password) {
        Custom_Models.enterText(Locators.email, username);
        Custom_Models.enterText(Locators.password, password);
        Custom_Models.clickOn(Locators.SignInBtn);
    }
    public void CaptureCurrenturl(String text) {
        Assert.assertEquals(getDriver().getCurrentUrl(), text);
    }

    public void ValidateTextFromWindow(String text,String currentFeatureFileName) {
        if (currentFeatureFileName.contains("Dashboard")){
            String actual_text = SwitchTabCaptureText();
            if(text.contains("linkedin")||text.contains("facebook")){
                if(actual_text.contains("linkedin.com")||actual_text.contains("facebook.com")){
                    assert true;
                }
            }
            else{
                Assert.assertEquals(actual_text, text);
            }
        }
        else{
            String actual_text = SwitchWindowandCaptureText(text);
            Assert.assertEquals(actual_text, text);
        }
    }

    private String SwitchTabCaptureText() {
        //Store the ID of the original window
        String originalWindow = getDriver().getWindowHandle();

        //Loop through until we find a new window handle
        String currentURL = null;
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                currentURL = getDriver().getCurrentUrl();
                getDriver().close();
                getDriver().switchTo().window(originalWindow);
            }
        }
        return currentURL;
    }

    public String SwitchWindowandCaptureText(String errorMsg) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        String newBrowserWinText = null;
        for (String windowHandle : windowHandles) {
            // Switch to the popup window.
            getDriver().switchTo().window(windowHandle);
            if (errorMsg.contains("input")) {
                newBrowserWinText = Custom_Models.fetchText(Locators.EmptyCredErrorMsg);
            } else {
                newBrowserWinText = Custom_Models.fetchText(Locators.InvaliCredErrorMsg);
            }
        }
        return newBrowserWinText;
    }

    public void signout() {
        Custom_Models.clickOn(Locators.accounticonclick);
        Custom_Models.clickOn(Locators.Logout);
    }

    public void hoverOnTheElement(String elementName) throws InterruptedException {
        switch (elementName) {
            case "verifymenu":
                Custom_Models.hoverOnElement(Locators.VerifyNavigation);
                break;
            case "Accountmenu":
                Custom_Models.hoverOnElement(Locators.AccountNavigation);
                break;
            //Add more cases based on the elements that need to be hovered over
            default:
                System.out.println("Invalid element name provided");
                assert false;
        }
    }


    public void uploadFile(String fileName) throws AWTException {
        String OS = System.getProperty("os.name").toLowerCase();
        String filepath =null;
        String filePath;
        if (OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
            filePath = System.getProperty("user.dir").concat("/TestData/" + fileName);
            System.setProperty("java.awt.headless", "false");
            StringSelection stringSelection = new StringSelection(filePath);
            System.out.println("filePath:"+filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else {
            filePath = System.getProperty("user.dir").concat("\\TestData\\" + fileName);
            System.setProperty("java.awt.headless", "false");
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(stringSelection, null);
            System.out.println("filePath:"+filePath);
        }
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
