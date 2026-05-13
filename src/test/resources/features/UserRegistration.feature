Feature: Rolnopol Registration

  Background: Go to Home Page and navigate to registration form
    Given user opens Rolnopol Home Page
    When user clicks the register button

  @tobito
  Scenario: User successfully registers new account
    When user fills registration form with random data
    And user clicks the Create Account button
    Then success notification should appear on screen with "Registration successful!" message

  @tobito
  Scenario: User successfully registers new account with optional fields left empty
    When user fills registration form with random data leaving optional fields empty
    And user clicks the Create Account button
    Then success notification should appear on screen with "Registration successful!" message

  @tobito
  Scenario: User verifies that duplicated users cannot be added to the system
    When user fills registration form with random data
    And user clicks the Create Account button
    Then success notification should appear on screen with "Registration successful!" message
    When user navigates back to Register page via top menu
    And user fills registration form with duplicated data
    And user clicks the Create Account button
    Then error notification should appear on screen with "User with this email already exists" message