import lib.webDriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void marinTest() {
        String expectedHeader = "Automation Practice Website";

        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver();


        String actualHeader = driver.findElement(By.xpath("//h1")).getText();

        assert  actualHeader.equals(expectedHeader);

        driver.quit();


    }
}
