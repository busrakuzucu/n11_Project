Feature: User should be able to add items from favorite to cart
  Background:
    Given Navigate to web site
    When Enter valid username and password
    And Click on the login button
    And Click on the element in dialog content
    |favoriteButton|

    Scenario: Select the highest product to add to cart
      When Choose and add product the highest from favorite list
      And Click on the element in dialog content
      |sepeteEkle|
      |sepet     |
      Then Verify that favorite product is in the cart

