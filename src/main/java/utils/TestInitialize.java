package utils;

import lib.pages.HomePage;
import lib.pages.LogInPage;
import org.openqa.selenium.WebDriver;

public class TestInitialize {
    public WebDriver driver;
    public String sEmail = UserProperties.getEmail();
    public String sPassword = UserProperties.getPassword();


    public void loginToApp(WebDriver driver) {
        HomePage homePage = new HomePage(driver);

        LogInPage logInPage = homePage.clickSignInLink();

        logInPage.typeEmail(sEmail)
                .typePassword(sPassword)
                .clickSignInButton();


    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }

}

