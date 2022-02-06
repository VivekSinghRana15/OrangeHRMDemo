Feature: This feature is to test the login for Orange HRM Demo application

  Scenario Outline:"<Sr>": Login to Orange HR Demo Website using provided username & password
    Given We Open the Orange HRM website login page
    And We enter the "<UserName>" and "<Password>"
    When We click on Login
    Then We should successfully login to the application
    And Logout and close Browser
    Examples:
      | Sr  | UserName | Password |
      | 001 | Admin    | admin123 |