@login
Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page
    When I enter username "webdriver"

  Scenario: Validate successful - Login Page
    And I enter password "webdriver123"
    And I click on the login button
    Then I should get an Alert with "validation succeeded"


  Scenario: Validate unsuccessful - Login Page
    And I enter password "webdriver1"
    And I click on the login button
    Then I should get an Alert with "validation failed"