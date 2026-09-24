package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage extends BasePage {

    public By loginPageTitle =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div/div/form/div/div[1]");

    public By emailField = By.name("email");

    public By passwordField = By.name("password");

    public By goButton =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");

    public By createUserButton =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");

    public By loginMenuButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[4]/div/div[2]/span");

    public By emailLabel =
            By.xpath("//label[text()='E-Mail']");

    public By passwordLabel =
            By.xpath("//label[text()='Password']");

    public By generalErrorMessage =
            By.xpath("//span[contains(@class,'MuiTypography-subject2')]");

    public By emailErrorMessage =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div/div/form/div/ul/li[1]");

    public By passwordErrorMessage =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div/div/form/div/ul/li[2]");

    public By addEventButton =
            By.xpath("//*[@id='root']/div/div[2]/button");

    public By logoutButton =
            By.xpath("//*[@id='root']/div/div[1]/div/div/ul/li/div");

    public By createEventButton =
            By.xpath("//*[@id='SpeedDial-actions']/button");

    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginMenuButton() {
        click(loginMenuButton);
    }

    public String getLoginPageTitle() {
        return getText(loginPageTitle);
    }

    public void enterEmail(String emailAddress) {
        type(emailField, emailAddress);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void fillLoginForm(String emailAddress, String password) {
        enterEmail(emailAddress);
        enterPassword(password);
    }

    public void clickGoButton() throws InterruptedException {
        click(goButton);
        Thread.sleep(1000);
    }

    public void clickCreateUserButton() throws InterruptedException {
        click(createUserButton);
        Thread.sleep(1000);
    }

    public void clickLogoutButton() throws InterruptedException {
        click(logoutButton);
        Thread.sleep(1000);
    }

    public void hoverOverAddEventButton() throws InterruptedException {
        hover(addEventButton);
        Thread.sleep(1000);
    }

    public void clickCreateEventButton() throws InterruptedException {
        click(createEventButton);
        Thread.sleep(1000);
    }

    public String getEmailLabelText() {
        return getText(emailLabel);
    }

    public String getPasswordLabelText() {
        return getText(passwordLabel);
    }

    public String getGoButtonText() {
        return getText(goButton);
    }

    public String getCreateUserButtonText() {
        return getText(createUserButton);
    }

    public String getEmailErrorMessage() {
        return getText(emailErrorMessage);
    }

    public String getPasswordErrorMessage() {
        return getText(passwordErrorMessage);
    }

    public String getGeneralErrorMessage() {
        return getText(generalErrorMessage);
    }

    public String getGoButtonColor() {
        return getBackgroundColor(goButton);
    }

    public String getCreateUserButtonColor() {
        return getBackgroundColor(createUserButton);
    }

    public String getEmailFieldFontStyle() {
        return getCssValue(emailField, "font-style");
    }

    public String getEmailFieldFontFamily() {
        return getCssValue(emailField, "font-family");
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(addEventButton);
    }

    public boolean isCreateUserModeOpened() {
        return driver.getCurrentUrl().contains("mode=signup");
    }

    public void clearEmailField() throws InterruptedException {
        Thread.sleep(500);
        clear(emailField);
    }

    public void clearPasswordField() throws InterruptedException {
        Thread.sleep(500);
        clear(passwordField);
    }

    public boolean isGeneralErrorMessageDisplayed() {
        return isDisplayed(generalErrorMessage);
    }

    public boolean isEmailErrorMessageDisplayed() {
        return isDisplayed(emailErrorMessage);
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return isDisplayed(passwordErrorMessage);
    }
}