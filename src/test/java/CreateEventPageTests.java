package evprimetests.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateEventPage;
import pages.EventsPage;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateEventPageTests {

    private static final String BASE_URL = "http://localhost:3000/";
    private static final String EVENTS_URL = "http://localhost:3000/events";

    private WebDriver driver;
    private LoginSignupPage loginSignupPage;
    private CreateEventPage createEventPage;
    private EventsPage eventsPage;

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
    }

    @Test
    public void validateTextFields() {

        assertEquals(
                "Event Title",
                createEventPage.getEventTitleLabelText()
        );

        assertEquals(
                "Event Image",
                createEventPage.getEventImageLabelText()
        );

        assertEquals(
                "Event Date",
                createEventPage.getEventDateLabelText()
        );

        assertEquals(
                "Event Location",
                createEventPage.getEventLocationLabelText()
        );

        assertEquals(
                "Event Description",
                createEventPage.getEventDescriptionLabelText()
        );
    }

    @Test
    public void validateCreateEventButtonColorAndText() {

        assertEquals(
                "#304ffe",
                createEventPage.getCreateEventButtonColor()
        );

        assertEquals(
                "CREATE EVENT",
                createEventPage.getCreateEventButtonText()
        );
    }

    @Test
    public void validateCreateEventButtonFont() {

        assertEquals(
                "\"Josefin Sans\"",
                createEventPage.getCreateEventButtonFontFamily()
        );

        assertEquals(
                "normal",
                createEventPage.getCreateEventButtonFontStyle()
        );
    }

    @Test
    public void borderThickensOnHoverTest()
            throws InterruptedException {

        String borderBefore =
                createEventPage.getEventTitleBorderWidth();

        createEventPage.hoverOverEventTitleField();

        String borderAfter =
                createEventPage.getEventTitleBorderWidth();

        assertEquals("0.8px", borderBefore);
        assertEquals("1.6px", borderAfter);
    }

    @Test
    public void successfullyCreateNewEventTest()
            throws InterruptedException {

        String eventTitle = "QA Automation Workshop";

        String eventImage =
                "https://picsum.photos/id/180/800/600.jpg";

        String eventDate = "18.08.2026";
        String eventLocation = "Bitola";

        String eventDescription =
                "Automated event created for frontend UI testing.";

        createEventPage.enterEventTitle(eventTitle);
        createEventPage.enterEventImage(eventImage);
        createEventPage.enterEventDate(eventDate);
        createEventPage.enterEventLocation(eventLocation);
        createEventPage.enterEventDescription(eventDescription);

        createEventPage.clickCreateEventButton();

        eventsPage.clickOnEventByTitle(eventTitle);

        assertEquals(
                eventTitle,
                eventsPage.getEventTitle()
        );

        assertEquals(
                eventImage,
                eventsPage.getEventImageSource()
        );

        assertEquals(
                eventDate,
                eventsPage.getEventDate()
        );

        assertEquals(
                eventLocation,
                eventsPage.getEventLocation()
        );

        assertEquals(
                eventDescription,
                eventsPage.getEventDescription()
        );

        eventsPage.openPage(EVENTS_URL);

        eventsPage.clickOnEventByTitle(eventTitle);
        eventsPage.clickDeleteEventButton();
        eventsPage.clickConfirmDeleteButton();

        assertTrue(
                eventsPage.isEventDeleted()
        );
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}