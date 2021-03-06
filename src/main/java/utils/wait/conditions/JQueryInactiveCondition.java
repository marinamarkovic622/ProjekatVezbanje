package utils.wait.conditions;

import utils.Logger;
import utils.StackTraceUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JQueryInactiveCondition implements ExpectedCondition<Boolean> {

    private static final Logger LOG = new Logger();

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object result = javascriptExecutor.executeScript("return jQuery == undefined ? 0 : jQuery.active");
            return (Long) result == 0;
        } catch (Exception e) {
            if (e.getMessage() != null && (e.getMessage().contains("jQuery is not defined")
                    || e.getMessage().contains("Can't find variable: jQuery"))) {
                // skip, then jQuery is not an indicator
                return true;
            }
            LOG.error("Caught previously ignored exception for debugging purposes, will continue with execution: "
                    + StackTraceUtil.filter(e));
            return true;
        }
    }
}
