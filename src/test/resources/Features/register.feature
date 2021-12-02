@RegressionTest
Feature: Registration feature

  Scenario: Check registration is successful
    Given user is on main application page
    When user clicks on register button
    And user fills in the registration form
    And user clicks on submit button
    Then registration is successful