Feature: This feature is for adding a new user & verifying that is has been added

  Background: Login to the Orange HRM application using Admin credentials
    Given We login to Orange HRM using Admin credentials

    @Working
  Scenario Outline: Sr-"<Sr>"- Add a new Contact
    Given We hover over Admin tab and select UserManagement and then click Users
    When we click on Add button
    And On Add User Page we enter "<UserRole>","<EmployeeName>","<UserName>","<Status>" and "<Password>"
    And Click on Save
    Then We should be able to Search for the Created User
    And Data Appearing should match the entered values
    And logout and close the browser
    Examples:
      | Sr  | UserRole | EmployeeName  | UserName | Status  | Password    |
      | 001 | Admin      | Anthony Nolan | Vivek | Disabled | Password123 |

