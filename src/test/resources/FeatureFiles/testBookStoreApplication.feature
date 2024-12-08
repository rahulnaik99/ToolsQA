Feature: Test Book Store Application
  Description: testing Book Store Application

  Scenario: Validate the Login Functionality
    When User Navigates to Home Page and select Book Store Application
    Then User Select Login From Book Store Application
    Then User Enter the User name and Password

  Scenario: Validate the Register Functionality
    When User Navigates to Home Page and select Book Store Application
    Then User Select Login From Book Store Application
    Then User Enter Registration details and Register

  Scenario: Validate the Register Functionality
    When User Navigates to Home Page and select Book Store Application
    Then User Select Login From Book Store Application
    Then User Search Book in the search bar
    Then USer Select the Book