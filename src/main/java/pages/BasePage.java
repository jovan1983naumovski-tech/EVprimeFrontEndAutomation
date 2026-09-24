package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public abstract class BasePage {

    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public void clear(By locator) {
        WebElement field = find(locator);
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.DELETE);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }

    public String getCssValue(By locator, String property) {
        return find(locator).getCssValue(property);
    }

    public String getBackgroundColor(By locator) {
        return Color.fromString(getCssValue(locator, "background-color")).asHex();
    }

    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void hover(By locator) {
        actions.moveToElement(find(locator)).perform();
    }

    public String getValidationMessage(By locator) {
        return getAttribute(locator, "validationMessage");
    }

    public String getImageSource(By locator) {
        return getAttribute(locator, "src");
    }

    public String getPseudoElementStyle(By locator, String pseudoElement, String cssProperty) {
        WebElement input = find(locator);
        WebElement parent = input.findElement(
                By.xpath("./ancestor::div[contains(@class,'MuiInputBase-root')]")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], arguments[1]).getPropertyValue(arguments[2]);",
                parent,
                pseudoElement,
                cssProperty
        );
    }

    public String getBeforeStyle(By locator, String property) {
        return getPseudoElementStyle(locator, "::before", property);
    }

    public String getAfterStyle(By locator, String property) {
        return getPseudoElementStyle(locator, "::after", property);
    }
}