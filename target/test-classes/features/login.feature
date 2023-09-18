@login
Feature: WebDriver University - Login Page

  Scenario: Validate successful - Login Page
    Given I access the webdriver university login page
    When I enter username "webdriver"
    And I enter password "webdriver123"
    And I click on the login button
    Then I should get an Alert with "validation succeeded"


  Scenario: Validate unsuccessful - Login Page
    Given I access the webdriver university login page
    When I enter username "webdriver"
    And I enter password "webdriver1"
    And I click on the login button
    Then I should get an Alert with "validation failed"