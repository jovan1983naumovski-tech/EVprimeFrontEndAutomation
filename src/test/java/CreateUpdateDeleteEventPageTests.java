import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateEventPage;
import pages.EventsPage;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUpdateDeleteEventPageTests {

    private static final String BASE_URL = "http://localhost:3000/";
    private static final String EVENTS_URL = "http://localhost:3000/events";

    private WebDriver driver;
    private LoginSignupPage loginSignupPage;
    private CreateEventPage createEventPage;
    private EventsPage eventsPage;

    private String currentEventTitle;

    @BeforeEach
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginSignupPage = new LoginSignupPage(driver);
        createEventPage = new CreateEventPage(driver);
        eventsPage = new EventsPage(driver);

        loginSignupPage.openPage(BASE_URL);
        loginSignupPage.clickLoginMenuButton();

        loginSignupPage.enterEmail("jovan_naumovski@yahoo.com");
        loginSignupPage.enterPassword("078281350");
        loginSignupPage.clickGoButton();

        loginSignupPage.hoverOverAddEventButton();
        loginSignupPage.clickCreateEventButton();

        currentEventTitle = "QA Automation Workshop";

        createEventPage.enterEventTitle(currentEventTitle);

        createEventPage.enterEventImage(
                "https://picsum.photos/id/180/800/600.jpg"
        );

        createEventPage.enterEventDate("18.08.2026");
        createEventPage.enterEventLocation("Bitola");

        createEventPage.enterEventDescription(
                "Automated event created for frontend UI testing."
        );

        createEventPage.clickCreateEventButton();
    }

    @Test
    public void validateCreatedEventTest() throws InterruptedException {

        eventsPage.clickOnEventByTitle(currentEventTitle);

        assertEquals(
                currentEventTitle,
                eventsPage.getEventTitle()
        );

        assertEquals(
                "https://picsum.photos/id/180/800/600.jpg",
                eventsPage.getEventImageSource()
        );

        assertEquals(
                "18.08.2026",
                eventsPage.getEventDate()
        );

        assertEquals(
                "Bitola",
                eventsPage.getEventLocation()
        );

        assertEquals(
                "Automated event created for frontend UI testing.",
                eventsPage.getEventDescription()
        );
    }

    @Test
    public void validateEventButtonColorsTest() throws InterruptedException {

        eventsPage.clickOnEventByTitle(currentEventTitle);

        assertEquals(
                "#304ffe",
                eventsPage.getEditEventButtonColor()
        );

        assertEquals(
                "#d32f2f",
                eventsPage.getDeleteEventButtonColor()
        );

        eventsPage.clickDeleteEventButton();

        assertEquals(
                "#9c27b0",
                eventsPage.getCancelDeleteButtonColor()
        );

        eventsPage.clickCancelDeleteButton();
    }

    @Test
    public void cancelDeleteEventTest() throws InterruptedException {

        eventsPage.clickOnEventByTitle(currentEventTitle);

        eventsPage.clickDeleteEventButton();
        eventsPage.clickCancelDeleteButton();

        assertFalse(eventsPage.isEventDeleted());
    }

    @Test
    public void editAndValidateEventTest() throws InterruptedException {

        eventsPage.clickOnEventByTitle(currentEventTitle);
        eventsPage.clickEditEventButton();

        eventsPage.clearEventTitleField();
        eventsPage.clearEventImageField();
        eventsPage.clearEventDateField();
        eventsPage.clearEventLocationField();
        eventsPage.clearEventDescriptionField();

        String updatedTitle = "Advanced QA Workshop";

        String updatedImage =
                "https://picsum.photos/id/0/800/600.jpg";

        String updatedDate = "25.08.2026";
        String updatedLocation = "Bitola";

        String updatedDescription =
                "Updated automated event for Selenium testing.";

        eventsPage.enterEventTitle(updatedTitle);
        eventsPage.enterEventImage(updatedImage);
        eventsPage.enterEventDate(updatedDate);
        eventsPage.enterEventLocation(updatedLocation);
        eventsPage.enterEventDescription(updatedDescription);

        eventsPage.clickUpdateEventButton();

        currentEventTitle = updatedTitle;

        assertEquals(
                updatedTitle,
                eventsPage.getEventTitle()
        );

        assertEquals(
                updatedImage,
                eventsPage.getEventImageSource()
        );

        assertEquals(
                updatedDate,
                eventsPage.getEventDate()
        );

        assertEquals(
                updatedLocation,
                eventsPage.getEventLocation()
        );

        assertEquals(
                updatedDescription,
                eventsPage.getEventDescription()
        );
    }

    @AfterEach
    public void tearDown() throws InterruptedException {

        if (driver != null) {

            eventsPage.openPage(EVENTS_URL);

            if (eventsPage.isEventDisplayed(currentEventTitle)) {

                eventsPage.clickOnEventByTitle(currentEventTitle);
                eventsPage.clickDeleteEventButton();
                eventsPage.clickConfirmDeleteButton();

                assertTrue(eventsPage.isEventDeleted());
            }

            driver.quit();
        }
    }
}