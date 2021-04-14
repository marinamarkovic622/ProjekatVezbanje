package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    @FindBy(xpath = "//*[@id = 'id_contact']")
    private WebElement subjectHeadingDropDown;

    @FindBy(xpath = "//select[@name = 'id_order']")
    private WebElement orderReferenceDropDown;

    @FindBy(xpath = "//*[@id = 'message']")
    private WebElement inputMessage;

    @FindBy(xpath = "//*[@id = 'submitMessage']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//p[@class = 'alert alert-success']")
    private WebElement confirmationMessage;

    public ContactUsPage(WebDriver driver) { super(driver); }

    public ContactUsPage selectSubjectHeading(String subjectHeading) {
        commands.selectDropDownByValue(subjectHeadingDropDown, subjectHeading);
        return this;
    }

    public ContactUsPage selectOrderReference(String orderReference) {
        commands.selectDropDownByValue(orderReferenceDropDown, orderReference);
        return this;
    }

    public void typeMessage(String message) {
        commands.waitAndType(driver, inputMessage, message);
    }

    public ContactUsPage clickSendMessageButton() {
        commands.clickElement(driver, sendMessageButton);
        return this;
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }





}