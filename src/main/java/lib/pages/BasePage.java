package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signInLink;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** Click on th SignIn link
     *
     * @return LogInPage
     */
    public LogInPage clickSignInLink() {
        signInLink.click();
        return new LogInPage(driver);
    }
}
