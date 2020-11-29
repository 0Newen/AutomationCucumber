Feature: LoginFeature
  This feature deals with the login functionality of the application.

  Scenario: Login with correct username and password
    And I navigate to the login page
    Given a list of users in a table
      |username|password|
      |opensourcecms|opensourcecms|
    And I click login button
    Then I should see the dashboard page
