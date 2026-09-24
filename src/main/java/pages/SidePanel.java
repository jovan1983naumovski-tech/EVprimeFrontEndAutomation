package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {

    public By menuIcon =
            By.xpath("//*[@id='root']/div/div/header/div/button");

    public By homeButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[1]/div/div[2]/span");

    public By eventsButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[2]/div/div[2]/span");

    public By contactButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[3]/div/div[2]/span");

    public By loginButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[4]/div/div[2]/span");

    public By closeMenuButton =
            By.xpath("//*[@data-testid='ChevronLeftIcon']");

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    public void clickMenuIcon() throws InterruptedException {
        click(menuIcon);
        Thread.sleep(500);
    }

    public void clickCloseMenuButton() throws InterruptedException {
        click(closeMenuButton);
        Thread.sleep(500);
    }

    public void clickHomeButton() throws InterruptedException {
        click(homeButton);
        Thread.sleep(500);
    }

    public void clickEventsButton() throws InterruptedException {
        click(eventsButton);
        Thread.sleep(500);
    }

    public void clickContactButton() throws InterruptedException {
        click(contactButton);
        Thread.sleep(500);
    }

    public void clickLoginButton() throws InterruptedException {
        click(loginButton);
        Thread.sleep(500);
    }

    public String getHomeButtonText() {
        return getText(homeButton);
    }

    public String getEventsButtonText() {
        return getText(eventsButton);
    }

    public String getContactButtonText() {
        return getText(contactButton);
    }

    public String getLoginButtonText() {
        return getText(loginButton);
    }

    public String getHomeButtonFontFamily() {
        return getCssValue(homeButton, "font-family");
    }

    public String getEventsButtonFontFamily() {
        return getCssValue(eventsButton, "font-family");
    }

    public String getContactButtonFontFamily() {
        return getCssValue(contactButton, "font-family");
    }

    public String getLoginButtonFontFamily() {
        return getCssValue(loginButton, "font-family");
    }

    public String getHomeButtonFontStyle() {
        return getCssValue(homeButton, "font-style");
    }

    public String getEventsButtonFontStyle() {
        return getCssValue(eventsButton, "font-style");
    }

    public String getContactButtonFontStyle() {
        return getCssValue(contactButton, "font-style");
    }

    public String getLoginButtonFontStyle() {
        return getCssValue(loginButton, "font-style");
    }

    public boolean isMenuIconDisplayed() {
        return isDisplayed(menuIcon);
    }

    public boolean isMenuClosed() {
        return isDisplayed(menuIcon);
    }

    public boolean isHomeButtonDisplayed() {
        return isDisplayed(homeButton);
    }

    public boolean isEventsButtonDisplayed() {
        return isDisplayed(eventsButton);
    }

    public boolean isContactButtonDisplayed() {
        return isDisplayed(contactButton);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
}