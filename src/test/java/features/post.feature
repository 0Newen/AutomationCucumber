Feature: PostFeature
  This feature describe the post functionality create, edit and fast edit.

  Scenario: Create a new post
    And I navigate to the login page
    Given a list of users in a table
      | username      | password      |
      | opensourcecms | opensourcecms |
    And I click login button
    Then I should see the dashboard page
    And I click in Post menu
    And I click in newPost
    Given a new title and body
      | title            | body                           |
      | Amazing Cucumber | This is a better test scenario |
    And I click on Publish
    Then I validate the labelPublished
    And I click in Post menu
    And I check the Post on table
