Feature:LoginFeature
  This feature deals with the login functionality of the application.

  Scenario: Correct username and password
    And I navigate to the login page
    Given a list of users in a table
      | username      | password      |
      | opensourcecms | opensourcecms |
    And I click login button
    Then I should see the dashboard page

  Scenario: Wrong username and password
    And I navigate to the login page
    Given a list of users in a table
      | username | password      |
      | admin    | opensourcecms |
    And I click login button
    Then I check the error message Appears

  Scenario: Lost my password
    And I navigate to the login page
    And I click lost your password?
    Then I check the button for recovery