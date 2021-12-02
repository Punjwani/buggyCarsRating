@RegressionTest
Feature: Edit user profile feature

  Scenario Outline: To change user's details and password
    Given user is on main application page
    When user enters <username> and <password>
    And user clicks on login button
    And user clicks on Profile button
    And user edits basic info <firstname> and <lastname>
    And user edits additional info <gender>, <age>, <address>, <phone> and <hobby>
    And user edits password <password> and enters new password <newPassword>
    And user clicks on Save button
    Then the profile details are successfully edited

    Examples:
      |username |password       |firstname  |lastname |gender |age |address   |phone      |hobby    |newPassword    |
      |buggy1   |Password!23    |user       |buggy    |Male   |20  |Queenstown|9876543210 |Biking   |newPassword!23 |
      |buggy1   |newPassword!23 |buggy      |user     |Female |24  |Dunedin   |9999999999 |Jogging  |Password!23    |
      |buggy2   |Password!23    |buggy      |car      |Female |26  |Auckland  |0123456789 |Drawing  |newPassword!23 |
      |buggy2   |newPassword!23 |car        |buggy    |Male   |29  |Hamilton  |0000000000 |Working  |Password!23    |



