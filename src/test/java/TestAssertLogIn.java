import lib.pages.HomePage;
import lib.pages.LogInPage;
import lib.webDriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAssertLogIn {
    @Test

    public void testAssertLogIn() throws InterruptedException {
        String email = "mail.test@test.com";
        String password = "password";

        String expectedHeader = "Welcome to your account. Here you can manage all of your personal information and orders.";

        WebDriver driver = WebDriverFactory.getDriver();

        try {
            HomePage homePage = new HomePage(driver);

            LogInPage logInPage = homePage.clickSignInLink();


            logInPage.typeEmail(email)
                    .typePassword(password);

            logInPage.clickSignInButton();

            String actualHeader = driver.findElement(By.xpath("//p[@class = 'info-account']")).getText();

            assert  actualHeader.equals(expectedHeader);

        } finally {
            driver.quit();
        }

    }
}
