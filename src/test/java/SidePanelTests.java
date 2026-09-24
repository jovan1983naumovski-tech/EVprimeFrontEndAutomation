package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SidePanel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SidePanelTests {

    private static final String BASE_URL = "http://localhost:3000/";

    private WebDriver driver;
    private SidePanel sidePanel;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        sidePanel.openPage(BASE_URL);
    }

    @Test
    public void navigationTextTest()
            throws InterruptedException {

        sidePanel.clickMenuIcon();

        assertAll(
                () -> assertEquals(
                        "Home",
                        sidePanel.getHomeButtonText()
                ),
                () -> assertEquals(
                        "Events",
                        sidePanel.getEventsButtonText()
                ),
                () -> assertEquals(
                        "Contact",
                        sidePanel.getContactButtonText()
                ),
                () -> assertEquals(
                        "Login",
                        sidePanel.getLoginButtonText()
                )
        );
    }

    @Test
    public void navigationFontFamilyTest()
            throws InterruptedException {

        sidePanel.clickMenuIcon();

        assertAll(
                () -> assertEquals(
                        "\"Josefin Sans\"",
                        sidePanel.getHomeButtonFontFamily()
                ),
                () -> assertEquals(
                        "\"Josefin Sans\"",
                        sidePanel.getEventsButtonFontFamily()
                ),
                () -> assertEquals(
                        "\"Josefin Sans\"",
                        sidePanel.getContactButtonFontFamily()
                ),
                () -> assertEquals(
                        "\"Josefin Sans\"",
                        sidePanel.getLoginButtonFontFamily()
                )
        );
    }

    @Test
    public void navigationFontStyleTest()
            throws InterruptedException {

        sidePanel.clickMenuIcon();

        assertAll(
                () -> assertEquals(
                        "normal",
                        sidePanel.getHomeButtonFontStyle()
                ),
                () -> assertEquals(
                        "normal",
                        sidePanel.getEventsButtonFontStyle()
                ),
                () -> assertEquals(
                        "normal",
                        sidePanel.getContactButtonFontStyle()
                ),
                () -> assertEquals(
                        "normal",
                        sidePanel.getLoginButtonFontStyle()
                )
        );
    }

    @Test
    public void closeSidePanelTest()
            throws InterruptedException {

        sidePanel.clickMenuIcon();
        Thread.sleep(1000);

        sidePanel.clickCloseMenuButton();

        assertTrue(
                sidePanel.isMenuClosed()
        );
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
