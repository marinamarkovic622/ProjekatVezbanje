package utils.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logger;
import utils.TimeoutLevel;
import utils.wait.conditions.DocumentReadyStateCondition;
import utils.wait.conditions.JQueryAnimationDoneCondition;
import utils.wait.conditions.JQueryInactiveCondition;

public class WaitUtil {

    Logger log = new Logger();

    public WaitUtil() {
    }

    public void waitPageReady(final WebDriver driver) {
        log.debug("waitPageReady()");
        ExpectedCondition<Boolean> jsLoad = new DocumentReadyStateCondition();
        ExpectedCondition<Boolean> jQueryLoad = new JQueryInactiveCondition();
        ExpectedCondition<Boolean> jQueryAnimation = new JQueryAnimationDoneCondition();
        new WebDriverWait(driver, TimeoutLevel.LONG.value()).until(ExpectedConditions.and(jsLoad, jQueryLoad, jQueryAnimation));

    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        log.debug("waitForElementToBeVisible()");
        WebDriverWait wait = new WebDriverWait(driver, TimeoutLevel.NORMAL.value());
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}

