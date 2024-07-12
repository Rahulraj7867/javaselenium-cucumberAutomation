package com.techwith.ui.models;
import com.techwith.ui.models.customUtils.elementCommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import static com.techwith.ui.models.customUtils.elementCommonUtils.*;
import static com.techwith.webdriver.WebDriverFactory.getDriver;

@Component
public class Custom_Models {
    public String fetchText(By element) {
        return fetchDataByGetText(element);
    }

    public void enterText(By xpath, String text) {
        elementCommonUtils.KeyBoardEvents(xpath, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        SendKeyBy(xpath, text);
    }

    public void clickOn(By BtnName) {
        ClickBy(BtnName);
    }

    public boolean ISElementPresent(By Element) {
        try {
            ElementDisplay(Element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void hoverOnElement(By by) throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(getDriver());
        WebElement element = getDriver().findElement(by);
        act.moveToElement(element).perform();
    }

    public void switchFrame(By by) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = getDriver().findElement(by);
        getDriver().switchTo().frame(element);
    }

    public void scrollToElement(By by) throws InterruptedException {
        WebElement scrollElement = elementCommonUtils.ElementBy(by);
        elementCommonUtils.ScrollIntoElement(scrollElement);
    }
}
