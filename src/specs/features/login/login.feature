@smoke
Feature: Login User
  I want to login

  Background: 
    Given I navigate to home page for Automation Exercise
    And I verify that home page is visible successfully
    And I click on Signup / Login button
    And I Verify meassage of login 'Login to your account' is visible

  @validlogin
  Scenario: [TC1] Login user with correct email and password
    When I enter correct email address "zaineb.sammoud@gmail.com"
    And I enter the valid password "formation2023"
    And I click login button
    Then I verify that 'Logged in as username' is visible
    #When I click Delete Account button
    #Then I verify that the message of delete 'ACCOUNT DELETED!' is visible

  @invalidlogin
  Scenario: [TC2] Login user with incorrect email and password
    When I enter incorrect email address "bouchagraouihadda@gmail.com"
    And I enter the invalid password "rima20242"
    And I click login button
    Then I verify error message 'Your email or password is incorrect!' is visible
