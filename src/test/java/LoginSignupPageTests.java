package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSignupPageTests {

    private static final String BASE_URL = "http://localhost:3000/";

    private static final String VALID_EMAIL =
            "jovan_naumovski@yahoo.com";

    private static final String VALID_PASSWORD =
            "0782813650";

    private WebDriver driver;
    private LoginSignupPage loginSignupPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginSignupPage = new LoginSignupPage(driver);

        loginSignupPage.openPage(BASE_URL);
        loginSignupPage.clickLoginMenuButton();
    }

    @Test
    public void loginPageTitleTest() {

        assertEquals(
                "Log in",
                loginSignupPage.getLoginPageTitle()
        );
    }

    @Test
    public void loginFieldLabelsTest() {

        assertAll(
                () -> assertEquals(
                        "E-Mail",
                        loginSignupPage.getEmailLabelText()
                ),
                () -> assertEquals(
                        "Password",
                        loginSignupPage.getPasswordLabelText()
                )
        );
    }

    @Test
    public void loginButtonTextTest() {

        assertAll(
                () -> assertEquals(
                        "GO",
                        loginSignupPage.getGoButtonText()
                ),
                () -> assertEquals(
                        "CREATE USER",
                        loginSignupPage.getCreateUserButtonText()
                )
        );
    }

    @Test
    public void emailFieldFontTest() {

        assertAll(
                () -> assertEquals(
                        "\"Josefin Sans\"",
                        loginSignupPage.getEmailFieldFontFamily()
                ),
                () -> assertEquals(
                        "normal",
                        loginSignupPage.getEmailFieldFontStyle()
                )
        );
    }

    @Test
    public void loginButtonColorsTest() {

        assertAll(
                () -> assertEquals(
                        "#304ffe",
                        loginSignupPage.getGoButtonColor()
                ),
                () -> assertEquals(
                        "#9c27b0",
                        loginSignupPage.getCreateUserButtonColor()
                )
        );
    }

    @Test
    public void createUserButtonTextAfterClickTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();

        assertEquals(
                "LOG IN",
                loginSignupPage.getCreateUserButtonText()
        );
    }

    @Test
    public void emptyLoginFormValidationTest()
            throws InterruptedException {

        loginSignupPage.clickGoButton();

        assertEquals(
                "Authentication failed.",
                loginSignupPage.getGeneralErrorMessage()
        );
    }

    @Test
    public void invalidCredentialsLoginTest()
            throws InterruptedException {

        loginSignupPage.enterEmail(
                "invalid.qa.user@example.com"
        );

        loginSignupPage.enterPassword(
                "WrongPassword987"
        );

        loginSignupPage.clickGoButton();

        assertEquals(
                "Authentication failed.",
                loginSignupPage.getGeneralErrorMessage()
        );
    }

    @Test
    public void loginWithoutPasswordTest()
            throws InterruptedException {

        loginSignupPage.enterEmail(
                "qa.login.user@example.com"
        );

        loginSignupPage.clickGoButton();

        assertEquals(
                "Authentication failed.",
                loginSignupPage.getGeneralErrorMessage()
        );
    }

    @Test
    public void createUserFormOpeningTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();

        assertTrue(
                loginSignupPage.isCreateUserModeOpened()
        );
    }

    @Test
    public void emptySignupFormValidationTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();
        loginSignupPage.clickGoButton();

        assertAll(
                () -> assertEquals(
                        "Invalid email.",
                        loginSignupPage.getEmailErrorMessage()
                ),
                () -> assertEquals(
                        "Invalid password. Must be at least 6 characters long.",
                        loginSignupPage.getPasswordErrorMessage()
                ),
                () -> assertEquals(
                        "User signup failed due to validation errors.",
                        loginSignupPage.getGeneralErrorMessage()
                )
        );
    }

    @Test
    public void invalidSignupEmailTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();

        loginSignupPage.enterEmail(
                "jovan-invalid-email"
        );

        loginSignupPage.enterPassword(
                "TestPassword123"
        );

        loginSignupPage.clickGoButton();

        assertAll(
                () -> assertEquals(
                        "Invalid email.",
                        loginSignupPage.getEmailErrorMessage()
                ),
                () -> assertEquals(
                        "User signup failed due to validation errors.",
                        loginSignupPage.getGeneralErrorMessage()
                )
        );
    }

    @Test
    public void shortSignupPasswordTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();

        loginSignupPage.enterEmail(
                "qa.new.account@example.com"
        );

        loginSignupPage.enterPassword("12345");

        loginSignupPage.clickGoButton();

        assertAll(
                () -> assertEquals(
                        "Invalid password. Must be at least 6 characters long.",
                        loginSignupPage.getPasswordErrorMessage()
                ),
                () -> assertEquals(
                        "User signup failed due to validation errors.",
                        loginSignupPage.getGeneralErrorMessage()
                )
        );
    }

    @Test
    public void existingEmailSignupTest()
            throws InterruptedException {

        loginSignupPage.clickCreateUserButton();

        loginSignupPage.enterEmail(VALID_EMAIL);
        loginSignupPage.enterPassword(VALID_PASSWORD);

        loginSignupPage.clickGoButton();

        assertAll(
                () -> assertEquals(
                        "Email exists already.",
                        loginSignupPage.getEmailErrorMessage()
                ),
                () -> assertEquals(
                        "User signup failed due to validation errors.",
                        loginSignupPage.getGeneralErrorMessage()
                )
        );
    }

    @Test
    public void successfulLoginTest()
            throws InterruptedException {

        loginSignupPage.enterEmail(VALID_EMAIL);
        loginSignupPage.enterPassword(VALID_PASSWORD);

        loginSignupPage.clickGoButton();

        assertTrue(
                loginSignupPage.isUserLoggedIn()
        );
    }

    @Test
    public void successfulLogoutTest()
            throws InterruptedException {

        loginSignupPage.enterEmail(VALID_EMAIL);
        loginSignupPage.enterPassword(VALID_PASSWORD);

        loginSignupPage.clickGoButton();

        assertTrue(
                loginSignupPage.isUserLoggedIn()
        );

        loginSignupPage.clickLogoutButton();

        assertFalse(
                loginSignupPage.isUserLoggedIn()
        );
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}