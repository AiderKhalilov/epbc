Feature: Invalid Date of birth scenario

  @regression @invalidDateOfBirthScenario
  Scenario: Sign into the newly created account and fill out invalid DOB
    When user logs in to the account
    Then user is successfully logged in can view the personal information section
    And  user enters personal information, invalid DOB and clicks save button
    Then verify that the invalid DOB was not saved