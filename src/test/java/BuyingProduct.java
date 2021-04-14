import lib.pages.ContactUsPage;
import lib.pages.HomePage;
import lib.pages.LogInPage;
import lib.webDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.TestInitialize;

public class BuyingProduct extends TestInitialize {
    @Test

    public void testBuyingProduct() {

        WebDriver driver = WebDriverFactory.getDriver();

        try {
            loginToApp(driver);

            HomePage homePage = new HomePage(driver);

            homePage.clickYourLogo()
                    .mouseOverFirstBlouse();









        }
        finally {
            driver.quit();
        }
        }
    }
