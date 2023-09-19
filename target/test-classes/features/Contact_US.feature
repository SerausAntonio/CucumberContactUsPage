@contact-us @regression
Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When  I enter a unique first name
    And   I enter a unique last name
    And   I enter a unique email adress
    And   I enter a unique comment
    And   I click on the submit button
    Then  I should be presented with a succesful contact us submission message

  Scenario: Validate Unsuccesful Submission
    Given I access the webdriver university contact us page
    When  I enter a specific first name joe
    And   I enter a specific last name blogs
    And   I enter a specific email adress joe_blogs123@mail.com
    And   I enter a specific comment "How are you?"
    And   I click on the reset button
    Then  I should be presented with a empty contact Form

