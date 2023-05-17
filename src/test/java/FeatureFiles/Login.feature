Feature:Login Functionaliy

  Background:
    Given Navigate to web site

  Scenario: Login functionality with valid username and password
    When Enter valid username and password
    And Click on the login button
    Then User should login successfully


  Scenario Outline: Login Negative with multiple data
    When User enter email as "<email>"  password  as "<password>"
    And Click on the login button
    Then User should not login successfully
    Examples:
      | email                      | password |
      | bughunters2023@hotmail.com | 1234     |
      | aaaaa                      | Brd.2023 |


