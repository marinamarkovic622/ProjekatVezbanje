package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//img[@title = 'Blouse'])[1]")
    private WebElement firstBlouse;

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage mouseOverFirstBlouse() {
        log.debug("mouseOverFirstBlouse()");
        commands.mouseOver(driver, firstBlouse);
        return this;
    }
}
