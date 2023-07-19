Feature: Creating new EPBC account and filling up personal info

  Background:
    When user clicks the sign up button and registers with the SPBC
    And user fills in the email and password
    And user authorizes EPBC to use personal information
    Then verify successful registration

  @regression @createAccount
  Scenario: Sign into the newly created account and fill out personal information
    When user logs in to their newly created account
    Then user is successfully logged in can view the personal information section
    And  user enters personal information and clicks save button
    Then verify that personal info is successfully saved
