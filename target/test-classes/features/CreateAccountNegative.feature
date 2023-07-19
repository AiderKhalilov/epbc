Feature: Creating new EPBC account with invalid credentials

  Background:
    When user clicks the sign up button

  @regression @createAccountNegativeTest
  Scenario Outline: Creating user with invalid credentials
    When user enter invalid "<email>" "<confirmEmail>" "<password>" "<confirmPassword>"
    Then user gets warning message
    Examples:
      | email           | confirmEmail | password  | confirmPassword |
      | Epbc            | Epbc1        | Epbc2023  | EPBC!           |
      | @gmail.com      | Epbc1        | Epbc20!   | EPBC!           |
      | 11111           | Epbc1        | Epbc!     | EPBC!           |
      | Epbc@gmail .com |              | epbc2023! | EPBC!           |
      |                 |              | EPBC2023! | EPBC!           |