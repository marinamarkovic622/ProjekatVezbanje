package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverCommands;
import utils.Logger;
import utils.wait.WaitUtil;

public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@title = 'Contact Us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//img[@class = 'logo img-responsive']")
    private WebElement yourLogoImage;

    protected WebDriver driver;
    protected WaitUtil waitUtil = new WaitUtil();

    DriverCommands commands = new DriverCommands();
    Logger log = new Logger();

    public BasePage(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtil.waitPageReady(driver);
    }

    /** Click on the SignIn link
     *
     * @return LogInPage
     */
    public LogInPage clickSignInLink() {
        signInLink.click();
        return new LogInPage(driver);
    }

    /** Click on the Contact Us button
     *
     * @return ContactUs page
     */
    public ContactUsPage clickContactUsButton() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public void selectDropDownByValue(WebElement element, String value) {
        Select dropDownByValue = new Select(element);
        dropDownByValue.selectByValue(value);
    }

    public HomePage clickYourLogo() {
        log.debug("clickYourLogo()");
        commands.clickElement(driver, yourLogoImage);
        return new HomePage(driver);
    }
}
