import lib.pages.HomePage;
import lib.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAssertLogIn {
    @Test

    public void testAssertLogIn() throws InterruptedException {
        String email = "mail.test@test.com";
        String password = "password";

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        String expectedHeader = "Welcome to your account. Here you can manage all of your personal information and orders.";

        try {
            HomePage homePage = new HomePage(driver);

            LogInPage logInPage = homePage.clickSignInLink();

            Thread.sleep(3000);

            logInPage.typeEmail(email)
                    .typePassword(password);

            Thread.sleep(3000);

            logInPage.clickSignInButton();

            Thread.sleep(3000);

            String actualHeader = driver.findElement(By.xpath("//p[@class = 'info-account']")).getText();

            assert  actualHeader.equals(expectedHeader);

            Thread.sleep(3000);

        } finally {
            driver.quit();
        }

    }
}
