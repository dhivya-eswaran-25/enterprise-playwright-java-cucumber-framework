Feature: SauceDemo Login

  @smoke
  Scenario: Valid login to SauceDemo
    Given I open SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should see products page
