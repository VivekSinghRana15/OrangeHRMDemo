Feature: This feature is for printing the current entries on the home page

  @Working
  Scenario: This scenario is for printing the current entries on the home page
    Given We log in to Orange HRM using Admin credentials
    And We navigate to Users
    When We print the present values in the System User Table
    Then We logout & close the browser
