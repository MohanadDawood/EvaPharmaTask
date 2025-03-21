Feature: OrangeHRM Admin Functionality

  Scenario Outline: Add and Delete a User in OrangeHRM
    Given I navigate to the OrangeHRM login page
    When I login with username "<username>" and password "<password>"
    And I click on the Admin tab
    And I get the number of records
    And I add a new user with employee name "<employeeName>", username "<newUsername>", password "<newPassword>", user role "<userRole>", and status "<status>"
    Then the number of records should increase by 1
    And the user with username "<newUsername>" should exist
    When I search for the user with username "<newUsername>"
    And I delete the user
    Then the number of records should decrease by 1

    Examples:
      | username | password | employeeName   | newUsername     | newPassword | userRole | status  |
      | Admin    | admin123 | name           | pharmatesttt8   | Password123 | Admin    | Enabled |