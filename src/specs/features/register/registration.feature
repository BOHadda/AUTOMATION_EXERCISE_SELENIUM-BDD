@regression
Feature: Register User
  I want to add a new user

  Background: 
    Given I navigate to home page for Automation Exercise
    And I verify that home page is visible successfully
    And I click on Signup / Login button
    And I Verify 'New User Signup!' is visible

  @validregister
  Scenario: [TC1] Register user with valid contact details
    When I enter name "Hadda"
    And I enter email address "bouchagraouihadda5@gmail.com"
    And I click Signup button
    And I verify that 'ENTER ACCOUNT INFORMATION' is visible
    And I check the title "Mrs"
    And I fill the password "rima2024"
    And I select Date of birth " 17 09 1995 "
    And I select checkbox 'Sign up for our newsletter!'
    And I select the second checkbox 'Receive special offers from our partners!'
    And I enter details with their values
      | Fields        | values       |
      | First name    | Hadda        |
      | Last name     | Bouchagraoui |
      | Company       | nebrass      |
      | Address       | Ariana       |
      | Address 2     | Ariana2      |
      | Country       | Canada       |
      | State         | Etudiant     |
      | City          | Montreal     |
      | Zipcode       |         1234 |
      | Mobile Number |     22172757 |
    And I click Create Account button
    Then A message 'ACCOUNT CREATED!' is visible
    When I click Continue button
    Then 'Logged in as Hadda' is visible

  @invalidregister
  Scenario: [TC2] Register user with existing email
    When I fill the name "Rima"
    And I fill email address already exist "bouchagraouihadda5@gmail.com"
    And I click Signup button
    Then An error message 'Email Address already exist!' is visible
