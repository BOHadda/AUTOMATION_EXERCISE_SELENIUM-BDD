@products
Feature: manage products
  I want to manage product modules

  Background: 
    Given I navigate to home page for Automation Exercise
    And I verify that home page is visible successfully
    And I click on Products button

  @search
  Scenario: [TC1] Search product
    When I verify user is navigated to ALL PRODUCTS page successfully
    And I enter product name 'dress' in search input
    And I click search button
    Then I verify 'SEARCHED PRODUCTS' is visible
    And I verify all the products related to search are visible

  @add
  Scenario: [TC2] Add product in carts
    When I hover over on first product
    And I click Add to cart
    And I click continue Shopping button
    And I hover over on second product
    And I click Add to cart the second product
    And I click View cart button
    #Then I verify both products are added to Cart
    And I verify caracteristics of first products
      | Fields   | values  |
      | Price    | Rs. 500 |
      | Quantity |       1 |
      | Total    | Rs.500  |
    And I verify caracteristics of second products
      | Fields   | values  |
      | Price    | Rs. 400 |
      | Quantity |       1 |
      | Total    | Rs.400  |
