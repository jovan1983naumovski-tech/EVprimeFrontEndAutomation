package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactsPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactsPageTests {

    private static final String BASE_URL = "http://localhost:3000/";
    private static final String CONTACTS_URL = "http://localhost:3000/contact";

    private WebDriver driver;
    private ContactsPage contactsPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        contactsPage = new ContactsPage(driver);

        contactsPage.openPage(BASE_URL);
        contactsPage.clickContactsButton();
    }

    @Test
    public void contactPageUrlAndTitleTest() {

        assertAll(
                () -> assertEquals(
                        CONTACTS_URL,
                        driver.getCurrentUrl()
                ),
                () -> assertEquals(
                        "Want to reach out?",
                        contactsPage.getContactsPageTitle()
                )
        );
    }

    @Test
    public void userNameBorderWidthOnHoverTest()
            throws InterruptedException {

        String borderBeforeHover =
                contactsPage.getUserNameBorderWidthBeforeHover();

        assertEquals(
                "0.8px",
                borderBeforeHover
        );

        contactsPage.hoverOverUserNameField();

        String borderAfterHover =
                contactsPage.getUserNameBorderWidthBeforeHover();

        assertEquals(
                "1.6px",
                borderAfterHover
        );
    }

    @Test
    public void emptyUserNameValidationTest() {

        contactsPage.clickSendButton();

        assertEquals(
                "Please fill out this field.",
                contactsPage.getUserNameValidationMessage()
        );
    }

    @Test
    public void emptyEmailValidationTest() {

        contactsPage.enterUserName("Frontend QA User");
        contactsPage.clickSendButton();

        assertEquals(
                "Please fill out this field.",
                contactsPage.getEmailValidationMessage()
        );
    }

    @Test
    public void emailWithoutAtSymbolValidationTest() {

        contactsPage.enterEmail("qatestmail.com");

        assertEquals(
                "Please include an '@' in the email address. " +
                        "'qatestmail.com' is missing an '@'.",
                contactsPage.getEmailValidationMessage()
        );
    }

    @Test
    public void invalidEmailDotPositionValidationTest()
            throws InterruptedException {

        contactsPage.enterEmail("qatest@.com");

        assertEquals(
                "'.' is used at a wrong position in '.com'.",
                contactsPage.getEmailValidationMessage()
        );

        contactsPage.clearEmailField();
    }

    @Test
    public void incompleteEmailValidationTest()
            throws InterruptedException {

        contactsPage.enterEmail("qatest@");

        assertEquals(
                "Please enter a part following '@'. " +
                        "'qatest@' is incomplete.",
                contactsPage.getEmailValidationMessage()
        );

        contactsPage.clearEmailField();
    }

    @Test
    public void emailWithMultipleAtSymbolsValidationTest()
            throws InterruptedException {

        contactsPage.enterEmail("qatest@@");

        assertEquals(
                "A part following '@' should not contain the symbol '@'.",
                contactsPage.getEmailValidationMessage()
        );

        contactsPage.clearEmailField();
    }

    @Test
    public void emptyMessageValidationTest() {

        contactsPage.enterUserName("Frontend QA User");
        contactsPage.enterEmail("frontend.qa@example.com");
        contactsPage.clickSendButton();

        assertEquals(
                "Please fill out this field.",
                contactsPage.getMessageValidationMessage()
        );
    }

    @Test
    public void completedContactFormValidationTest() {

        contactsPage.fillContactForm(
                "Frontend QA User",
                "frontend.qa@example.com",
                "Automated message created during contact form testing."
        );

        contactsPage.clickSendButton();

        assertAll(
                () -> assertEquals(
                        "",
                        contactsPage.getUserNameValidationMessage()
                ),
                () -> assertEquals(
                        "",
                        contactsPage.getEmailValidationMessage()
                ),
                () -> assertEquals(
                        "",
                        contactsPage.getMessageValidationMessage()
                )
        );
    }

    @Test
    public void sendButtonBackgroundColorTest() {

        assertEquals(
                "#304ffe",
                contactsPage.getSendButtonColor()
        );
    }

    @Test
    public void contactInformationTest() {

        assertAll(
                () -> assertEquals(
                        "Rampo Lefkata 1",
                        contactsPage.getAddressText()
                ),
                () -> assertEquals(
                        "ev@rampo.com",
                        contactsPage.getContactEmailText()
                ),
                () -> assertEquals(
                        "+389 78 285 355",
                        contactsPage.getPhoneNumberText()
                )
        );
    }

    @Test
    public void userNameBorderColorAfterClickTest() {

        assertEquals(
                "#6b6b6b",
                contactsPage.getUserNameBorderColorBeforeClick()
        );

        contactsPage.clickUserNameField();

        assertEquals(
                "#304ffe",
                contactsPage.getUserNameBorderColorAfterClick()
        );
    }

    @Test
    public void requiredUserNameBorderColorTest()
            throws InterruptedException {

        contactsPage.enterUserName("Temporary QA User");
        contactsPage.clickSendButton();

        contactsPage.clearUserNameField();
        contactsPage.clickSendButton();

        assertEquals(
                "#d32f2f",
                contactsPage.getUserNameBorderColorAfterClick()
        );
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}