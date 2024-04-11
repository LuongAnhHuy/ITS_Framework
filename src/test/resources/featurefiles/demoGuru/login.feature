@uiChrome
Feature: Test web Guru
  Scenario: Verify login to homepage
    When I open page on Guru "https://www.demo.guru99.com/v4/index.php"
    And I fill "mngr554220" to username
    And I fill "nahyqAj" to password
    And I click to login button
    Then I verify homepage name "Welcome To Manager's Page of Guru99 Bank"