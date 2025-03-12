@CartTest
Feature: Add to Cart functionality

   Background: User is logged in
    Given User opens the Sauce Demo login page
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks the login button
    Then User is logged in successfully

  @CartTest
  Scenario: User adds a product to the cart
    Given User is on the inventory page
    When User adds the "Sauce Labs Backpack" to the cart
    Then The cart should have 1 item
    And The "Sauce Labs Backpack" should be in the cart

  @BeforeStep
  Scenario: Log before each step
    Given Log the start of the step

  @AfterStep
  Scenario: Log after each step
    Given Log the end of the step
