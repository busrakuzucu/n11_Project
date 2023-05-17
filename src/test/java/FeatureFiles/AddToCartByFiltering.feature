Feature: User should be able to add item to cart by filtering categories

  Background:
    Given Navigate to web site
    When Enter valid username and password
    And Click on the login button
    Then User should login successfully

  Scenario:
    When Hower to element in dialog content
      | elektronik |
    And Click on the element in dialog content
      | bilgisayar        |
      | dizustuBilgisayar |
    And Send key to element in dialog content
      | minPrice | 10000 |
      | maxPrice | 30000 |
    And jsClick on the element in dialog content
      | intelCoreI7      |
      | islemci          |
      | bellekKapasitesi |
      | otuzIkiGB        |
    And Add the product to the basket randomly from result list
    And Click on the element in dialog content
      | sepet |
    Then Verify that the product is in the cart


