package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EventsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventsPageTests {

    private static final String BASE_URL = "http://localhost:3000/";
    private static final String EVENTS_URL = "http://localhost:3000/events";

    private WebDriver driver;
    private EventsPage eventsPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        eventsPage = new EventsPage(driver);

        eventsPage.openPage(BASE_URL);
        eventsPage.clickEventsButton();

        assertEquals(
                EVENTS_URL,
                driver.getCurrentUrl()
        );
    }

    @Test
    public void eventsPageShouldOpenCorrectUrl() {

        assertEquals(
                EVENTS_URL,
                driver.getCurrentUrl()
        );
    }

    @Test
    public void firstEventShouldOpenDetailsPage()
            throws InterruptedException {

        eventsPage.clickOnEvent(0);

        String currentUrl = driver.getCurrentUrl();

        assertNotNull(currentUrl);

        assertTrue(
                currentUrl.startsWith(EVENTS_URL + "/")
        );

        assertFalse(
                currentUrl.equals(EVENTS_URL)
        );
    }

    @Test
    public void selectedEventShouldDisplayDetails()
            throws InterruptedException {

        eventsPage.clickOnEvent(0);

        String eventTitle = eventsPage.getEventTitle();
        String eventDate = eventsPage.getEventDate();
        String eventLocation = eventsPage.getEventLocation();
        String eventDescription = eventsPage.getEventDescription();
        String eventImage = eventsPage.getEventImageSource();

        assertNotNull(eventTitle);
        assertNotNull(eventDate);
        assertNotNull(eventLocation);
        assertNotNull(eventDescription);
        assertNotNull(eventImage);

        assertFalse(eventTitle.isEmpty());
        assertFalse(eventDate.isEmpty());
        assertFalse(eventLocation.isEmpty());
        assertFalse(eventDescription.isEmpty());
        assertFalse(eventImage.isEmpty());
    }

    @Test
    public void backButtonShouldReturnToEventsPage()
            throws InterruptedException {

        eventsPage.clickOnEvent(0);

        eventsPage.clickBackToEventsButton();

        assertEquals(
                EVENTS_URL,
                driver.getCurrentUrl()
        );
    }

    @Test
    public void backButtonShouldHaveCorrectBackgroundColor()
            throws InterruptedException {

        eventsPage.clickOnEvent(0);

        assertEquals(
                "#9c27b0",
                eventsPage.getBackToEventsButtonColor()
        );
    }

    @Test
    public void eventDetailsUrlShouldContainEventsPath()
            throws InterruptedException {

        eventsPage.clickOnEvent(0);

        String currentUrl = driver.getCurrentUrl();

        assertTrue(
                currentUrl.contains("/events/")
        );
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}