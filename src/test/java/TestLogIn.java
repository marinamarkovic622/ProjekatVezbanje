import lib.pages.HomePage;
import lib.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLogIn {
    @Test

    public void testLogInFuncionality() {
        String email = "bilosta";
        String password = "lozinka";

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        try {
            HomePage homePage = new HomePage(driver);

            LogInPage logInPage = homePage.clickSignInLink();

            Thread.sleep(3000);

            logInPage.typeEmail(email)
                    .typePassword(password);

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
    }

    }
}