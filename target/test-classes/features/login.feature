@login @regression
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

  Scenario Outline: Validate - Succesfull & Unsuccessfull Login
  When I enter a username "<username>"
    And I enter a password "<password>"
    And I click on the login button
    Then I should be presented with the following login validation message "<loginValidationMessage>"

    Examples:
      | username  | password     | loginValidationMessage |  |
      | webdriver | webdriver123 | validation succeeded   |  |
      | webdriver | webdriver1   | validation failed      |  |
      | joe_blogs | password1    | validation failed      |  |