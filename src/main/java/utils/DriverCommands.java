package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.wait.WaitUtil;

public class DriverCommands {

    WaitUtil waitUtil = new WaitUtil();
    Logger log = new Logger();
    Sleep sleep = new Sleep();

    public DriverCommands() {
    }

    public void clickElement(WebDriver driver, WebElement element) {
        log.debug("clickElement()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        element.click();
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    private void type(WebElement element, String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(text);
    }

    public void waitAndType(WebDriver driver, WebElement element, String text) {
        log.debug("waitAndType()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        type(element, text);
        sleep.sleepForMilliseconds(TimeoutLevel.MS_SHORTEST.value());
    }

    public void selectDropDownByValue(WebElement element, String value) {
        log.debug("selectDropDownByValue()");
        Select dropDownByValue = new Select(element);
        dropDownByValue.selectByValue(value);
    }

    /**
     * Is element present
     *
     * @param element element
     * @return boolean
     */
    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    /**
     * Scroll to element
     *
     * @param element element
     */
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        scrollHorizontally(driver, -100);
    }

    /**
     * Scroll to up or down in pixels (Negative number is up, positive number is
     * down)
     *
     * @param yPixels yPixels
     */
    public void scrollHorizontally(WebDriver driver, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + yPixels + ")");
    }

    /**
     * Click on element with JavaScript and wait for given milliseconds
     *
     * @param element element
     */
    public void clickElementJS(WebDriver driver, WebElement element) {
        log.debug("Click on element with js");
        waitUtil.waitForElementToBeVisible(driver, element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        scrollToElement(driver, element);
        js.executeScript("arguments[0].click();", element);
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    public String getText(WebDriver driver, WebElement element) {
        log.debug("getText()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        String text = element.getText();
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
        return text;
    }

    public void mouseOver(WebDriver driver, WebElement element) {
        log.debug("mouseOver()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

}
