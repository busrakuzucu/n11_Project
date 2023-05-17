Feature: User should be able to add item to favorite list

  Background:
    Given Navigate to web site
    When Enter valid username and password
    And Click on the login button
    Then User should login successfully

  Scenario:
    Given Send key to element in dialog content
      | inputSearch | saat |
    And Click on the element in dialog content
      | searchButton |
    And Choose products randomly from search list
    And Click on the element in dialog content
      | favoriteButton |
    Then Verify that the products are in the favorite list




