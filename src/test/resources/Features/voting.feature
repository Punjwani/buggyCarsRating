@RegressionTest
Feature: Voting feature

  Scenario: Voting for best make and best model
    Given user is on main application page
    And registers a new user and logs in
    When user clicks on overall rating
    And user clicks on following models, write a comment and clicks on vote
      |Model      |Comment          |
      |Diablo     |vote for Diable  |
      |Zonda      |vote for Zonda   |
    Then following votes are successfully submitted with these comments
      |Model      |Comment          |
      |Diablo     |vote for Diable  |
      |Zonda      |vote for Zonda   |


