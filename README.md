# EVPrime FrontEnd Automation

Frontend UI automation testing project for the EVPrime application.

## Technologies

- Java 17
- Maven
- Selenium WebDriver
- JUnit 5

## Project Structure

The project follows the Page Object Model (POM) design pattern.

### Pages

- BasePage
- LoginSignupPage
- CreateEventPage
- EventsPage
- ContactsPage
- SidePanel

## Automated UI Tests

The project contains automated tests for the main EVPrime frontend functionalities.

### Login and Signup

- Login functionality
- Signup functionality
- Validation of login and signup elements

### Create Event

- Creating a new event
- Validation of event form elements

### Events

- Display and validation of events
- Event interaction

### Update and Delete Event

- Updating an existing event
- Deleting an event

### Contacts

- Validation of Contacts page
- Validation of page elements

### Side Panel

- Navigation testing
- Menu open and close functionality
- Validation of navigation elements
- Font and style validation

## Test Design

The automation framework uses the Page Object Model to separate page functionality from test logic.

Reusable methods are implemented in BasePage and individual page classes.

## Running the Tests

Tests can be executed using Maven:

mvn test

## Project

EVPrime FrontEnd Automation Project
