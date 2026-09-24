package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventsPage extends BasePage {

    public By eventCards =
            By.xpath("//*[@id='root']/div/div/main/div[2]/ul/li");

    public By eventsButton =
            By.xpath("//*[@id='root']/div/div/div/div/div/ul/li[2]/div/div[2]/span");

    public By eventTitle =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div[1]/div[1]/div[1]/h2");

    public By eventDate =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div[1]/div[1]/div[2]/h6");

    public By eventLocation =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div[1]/div[1]/div[3]/h6");

    public By eventDescription =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div[2]/span");

    public By eventImage =
            By.xpath("//*[@id='root']/div/div[1]/main/div[2]/div[2]/div/img");

    public By eventTitleField = By.name("title");

    public By eventImageField = By.name("image");

    public By eventDateField = By.name("date");

    public By eventLocationField = By.name("location");

    public By eventDescriptionField =
            By.xpath("//form//textarea[@name='description']");

    public By backToEventsButton =
            By.xpath("//*[@id='root']/div/div/main/div[2]/div[1]/div[2]/button");

    public By editEventButton =
            By.xpath("//*[@id='root']/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");

    public By deleteEventButton =
            By.xpath("//*[@id='root']/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");

    public By confirmDeleteButton =
            By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");

    public By cancelDeleteButton =
            By.xpath("/html/body/div[2]/div[3]/div/div/button[2]");

    public By updateEventButton =
            By.xpath("//*[@id='root']/div/div[1]/main/div[2]/form/div/button");

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEventsButton() {
        click(eventsButton);
    }

    public void clickBackToEventsButton() {
        click(backToEventsButton);
    }

    public void clickOnEvent(int eventIndex) throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> cards = driver.findElements(eventCards);

        if (eventIndex < 0 || eventIndex >= cards.size()) {
            throw new IndexOutOfBoundsException(
                    "Event index is not valid. Number of events: " + cards.size()
            );
        }

        cards.get(eventIndex).click();
    }

    public void clickOnEventByTitle(String title) throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> cards = driver.findElements(eventCards);
        boolean eventFound = false;

        for (WebElement card : cards) {
            if (card.getText().contains(title)) {
                card.click();
                eventFound = true;
                break;
            }
        }

        if (!eventFound) {
            throw new IllegalArgumentException(
                    "Event with title '" + title + "' was not found."
            );
        }
    }

    public String getEventTitle() {
        return getText(eventTitle);
    }

    public String getEventImageSource() {
        return getImageSource(eventImage);
    }

    public String getEventDate() {
        return getText(eventDate);
    }

    public String getEventLocation() {
        return getText(eventLocation);
    }

    public String getEventDescription() {
        return getText(eventDescription);
    }

    public String getBackToEventsButtonColor() {
        return getBackgroundColor(backToEventsButton);
    }

    public void clickEditEventButton() {
        click(editEventButton);
    }

    public String getEditEventButtonColor() {
        return getBackgroundColor(editEventButton);
    }

    public void clickDeleteEventButton() {
        click(deleteEventButton);
    }

    public String getDeleteEventButtonColor() {
        return getBackgroundColor(deleteEventButton);
    }

    public void clickCancelDeleteButton() {
        click(cancelDeleteButton);
    }

    public String getCancelDeleteButtonColor() {
        return getBackgroundColor(cancelDeleteButton);
    }

    public void clickConfirmDeleteButton() throws InterruptedException {
        Thread.sleep(1000);
        click(confirmDeleteButton);
    }

    public boolean isEventDeleted() {
        return driver.getCurrentUrl().equals("http://localhost:3000/events");
    }

    public void clickUpdateEventButton() throws InterruptedException {
        click(updateEventButton);
        Thread.sleep(4000);
    }

    public String getUpdateEventButtonColor() {
        return getBackgroundColor(updateEventButton);
    }

    public void clearEventTitleField() throws InterruptedException {
        clear(eventTitleField);
        Thread.sleep(500);
    }

    public void clearEventImageField() throws InterruptedException {
        clear(eventImageField);
        Thread.sleep(500);
    }

    public void clearEventDateField() throws InterruptedException {
        clear(eventDateField);
        Thread.sleep(500);
    }

    public void clearEventLocationField() throws InterruptedException {
        clear(eventLocationField);
        Thread.sleep(500);
    }

    public void clearEventDescriptionField() throws InterruptedException {
        clear(eventDescriptionField);
        Thread.sleep(500);
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

    public boolean isEventDisplayed(String title) {
        List<WebElement> cards = driver.findElements(eventCards);

        for (WebElement card : cards) {
            if (card.getText().contains(title)) {
                return true;
            }
        }

        return false;
    }
}