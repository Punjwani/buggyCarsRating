@RegressionTest
Feature: Login feature

  Scenario Outline: Login should be successful with correct credentials and unsuccessful with incorrect credentials
    Given user is on main application page
    When user enters <username> and <password>
    And user clicks on login button
    Then user is <status> logged in

    Examples:
    |username       |password       |status |
    |abc123         |Password!23    |true   |
    |wrongusername  |wrongpassword  |false  |
