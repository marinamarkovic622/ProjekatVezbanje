import lib.pages.ContactUsPage;
import lib.pages.HomePage;
import lib.pages.LogInPage;
import lib.webDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestSendMessage {
    @Test

    public void testSendMessage() {
        String email = "mail.test@test.com";
        String password = "password";
        String sSubjectHeading = "1";
        String sMessage = "This is message";
        String sExpectedConfirmationMessage = "Your message has been successfully sent to our team.";

        WebDriver driver = WebDriverFactory.getDriver();

        try {
            HomePage homePage = new HomePage(driver);

            LogInPage logInPage = homePage.clickSignInLink();

            ContactUsPage contactUsPage = new ContactUsPage(driver);

            logInPage.typeEmail(email)
                    .typePassword(password)
                    .clickSignInButton()
                    .clickContactUsButton();

            contactUsPage.selectSubjectHeading(sSubjectHeading)
                    .typeMessage(sMessage);

            contactUsPage.clickSendMessageButton();

            String sActualConfirmationMessage = contactUsPage.getConfirmationMessage();
            assert sActualConfirmationMessage.equals(sExpectedConfirmationMessage):"Expected is [" + sExpectedConfirmationMessage + "], but actual is [" + sActualConfirmationMessage + "].";

        }
        finally {
            driver.quit();
        }
    }
}
