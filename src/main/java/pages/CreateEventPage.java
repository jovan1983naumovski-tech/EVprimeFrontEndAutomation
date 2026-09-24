package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateEventPage extends BasePage {

    public By eventTitleField = By.name("title");

    public By eventImageField = By.name("image");

    public By eventDateField = By.name("date");

    public By eventLocationField = By.name("location");

    public By eventDescriptionField =
            By.xpath("//form//textarea[@name='description']");

    public By createEventButton =
            By.xpath("//*[@id='root']/div/div[1]/main/div[2]/form/div/button");

    public By eventTitleLabel =
            By.xpath("//input[@name='title']/ancestor::div[contains(@class,'MuiFormControl-root')]//label");

    public By eventImageLabel =
            By.xpath("//input[@name='image']/ancestor::div[contains(@class,'MuiFormControl-root')]//label");

    public By eventDateLabel =
            By.xpath("//input[@name='date']/ancestor::div[contains(@class,'MuiFormControl-root')]//label");

    public By eventLocationLabel =
            By.xpath("//input[@name='location']/ancestor::div[contains(@class,'MuiFormControl-root')]//label");

    public By eventDescriptionLabel =
            By.xpath("//textarea[@name='description']/ancestor::div[contains(@class,'MuiFormControl-root')]//label");

    public CreateEventPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverEventTitleField() throws InterruptedException {
        hover(eventTitleField);
        Thread.sleep(1000);
    }

    public void enterEventTitle(String title) throws InterruptedException {
        type(eventTitleField, title);
        Thread.sleep(500);
    }

    public void enterEventImage(String imageUrl) throws InterruptedException {
        type(eventImageField, imageUrl);
        Thread.sleep(500);
    }

    public void enterEventDate(String date) throws InterruptedException {
        type(eventDateField, date);
        Thread.sleep(500);
    }

    public void enterEventLocation(String location) throws InterruptedException {
        type(eventLocationField, location);
        Thread.sleep(500);
    }

    public void enterEventDescription(String description) throws InterruptedException {
        type(eventDescriptionField, description);
        Thread.sleep(500);
    }

    public void fillCreateEventForm(
            String title,
            String imageUrl,
            String date,
            String location,
            String description
    ) throws InterruptedException {

        enterEventTitle(title);
        enterEventImage(imageUrl);
        enterEventDate(date);
        enterEventLocation(location);
        enterEventDescription(description);
    }

    public void clickCreateEventButton() throws InterruptedException {
        click(createEventButton);
        Thread.sleep(1000);
    }

    public String getEventTitleLabelText() {
        return getText(eventTitleLabel);
    }

    public String getEventImageLabelText() {
        return getText(eventImageLabel);
    }

    public String getEventDateLabelText() {
        return getText(eventDateLabel);
    }

    public String getEventLocationLabelText() {
        return getText(eventLocationLabel);
    }

    public String getEventDescriptionLabelText() {
        return getText(eventDescriptionLabel);
    }

    public String getCreateEventButtonText() {
        return getText(createEventButton);
    }

    public String getCreateEventButtonColor() {
        return getBackgroundColor(createEventButton);
    }

    public String getCreateEventButtonFontFamily() {
        return getCssValue(createEventButton, "font-family");
    }

    public String getCreateEventButtonFontStyle() {
        return getCssValue(createEventButton, "font-style");
    }

    public String getEventTitleBorderWidth() {
        return getBeforeStyle(
                eventTitleField,
                "border-bottom-width"
        );
    }

    public void clearEventTitleField() throws InterruptedException {
        Thread.sleep(500);
        clear(eventTitleField);
    }

    public void clearEventImageField() throws InterruptedException {
        Thread.sleep(500);
        clear(eventImageField);
    }

    public void clearEventDateField() throws InterruptedException {
        Thread.sleep(500);
        clear(eventDateField);
    }

    public void clearEventLocationField() throws InterruptedException {
        Thread.sleep(500);
        clear(eventLocationField);
    }

    public void clearEventDescriptionField() throws InterruptedException {
        Thread.sleep(500);
        clear(eventDescriptionField);
    }

    public String getEventTitleValidationMessage() {
        return getValidationMessage(eventTitleField);
    }

    public String getEventImageValidationMessage() {
        return getValidationMessage(eventImageField);
    }

    public String getEventDateValidationMessage() {
        return getValidationMessage(eventDateField);
    }

    public String getEventLocationValidationMessage() {
        return getValidationMessage(eventLocationField);
    }

    public String getEventDescriptionValidationMessage() {
        return getValidationMessage(eventDescriptionField);
    }

    public boolean isCreateEventButtonDisplayed() {
        return isDisplayed(createEventButton);
    }
}