package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ContactsPage extends BasePage {

    public By contactsButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[3]/div/div[2]/span");

    public By contactsPageTitle =
            By.xpath("//*[@id='root']/div/div/main/div[2]/form/div[1]/h2");

    public By userNameField = By.id(":r0:");

    public By emailField = By.id(":r1:");

    public By messageField = By.id(":r2:");

    public By sendButton =
            By.xpath("//*[@id='root']/div/div/main/div[2]/form/div[1]/button");

    public By address =
            By.xpath("//*[@id='root']/div/div/main/div[2]/form/div[2]/div[2]/p[1]");

    public By contactEmail =
            By.xpath("//*[@id='root']/div/div/main/div[2]/form/div[2]/div[2]/p[2]");

    public By phoneNumber =
            By.xpath("//*[@id='root']/div/div/main/div[2]/form/div[2]/div[2]/p[3]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void clickContactsButton() {
        click(contactsButton);
    }

    public String getContactsPageTitle() {
        return getText(contactsPageTitle);
    }

    public void clickUserNameField() {
        click(userNameField);
    }

    public void clickSendButton() {
        click(sendButton);
    }

    public void enterUserName(String userName) {
        type(userNameField, userName);
    }

    public void enterEmail(String emailAddress) {
        type(emailField, emailAddress);
    }

    public void enterMessage(String messageText) {
        type(messageField, messageText);
    }

    public void fillContactForm(
            String userName,
            String emailAddress,
            String messageText
    ) {
        enterUserName(userName);
        enterEmail(emailAddress);
        enterMessage(messageText);
    }

    public void hoverOverUserNameField() throws InterruptedException {
        hover(userNameField);
        Thread.sleep(1000);
    }

    public void clearEmailField() throws InterruptedException {
        Thread.sleep(1000);
        clear(emailField);
    }

    public void clearUserNameField() throws InterruptedException {
        Thread.sleep(1000);
        clear(userNameField);
    }

    public void clearMessageField() throws InterruptedException {
        Thread.sleep(1000);
        clear(messageField);
    }

    public String getAddressText() {
        return getText(address);
    }

    public String getContactEmailText() {
        return getText(contactEmail);
    }

    public String getPhoneNumberText() {
        return getText(phoneNumber);
    }

    public String getUserNameValidationMessage() {
        return getValidationMessage(userNameField);
    }

    public String getEmailValidationMessage() {
        return getValidationMessage(emailField);
    }

    public String getMessageValidationMessage() {
        return getValidationMessage(messageField);
    }

    public boolean isUserNameFieldDisplayed() {
        return isDisplayed(userNameField);
    }

    public boolean isEmailFieldDisplayed() {
        return isDisplayed(emailField);
    }

    public boolean isMessageFieldDisplayed() {
        return isDisplayed(messageField);
    }

    public String getSendButtonColor() {
        return getBackgroundColor(sendButton);
    }

    public String getUserNameBorderWidthBeforeHover() {
        return getBeforeStyle(
                userNameField,
                "border-bottom-width"
        );
    }

    public String getUserNameBorderColorBeforeClick() {
        String color = getBeforeStyle(
                userNameField,
                "border-bottom-color"
        );

        return Color.fromString(color).asHex();
    }

    public String getUserNameBorderColorAfterClick() {
        String color = getAfterStyle(
                userNameField,
                "border-bottom-color"
        );

        return Color.fromString(color).asHex();
    }
}