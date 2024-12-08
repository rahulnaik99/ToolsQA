Feature: Test Widgets

  Description: testing Widgets

  Scenario: Validate the Widgets Functionality
    When User Select the Widgets From the Homepage
    Then User Select Accordian From Widgets
    Then User Header and Validate the Text


  Scenario: Validate the Auto complete field Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Auto Complete From Widgets
    Then User Enter the info into the Autocomplete field

  Scenario: Validate the Date and Time Field
    When User Navigates to Home Page and select Widgets
    Then User Select Date Picker From Widgets
    Then User Select the Date
    Then User Select the Date and Time

  Scenario: Validate the Slider
    When User Navigates to Home Page and select Widgets
    Then User Select Progress Bar From Widgets
    Then User Select 40 from the Slider

  Scenario: Validate the Auto complete field Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Tabs From Widgets
    Then User Validate the Progress Bar

  Scenario: Validate the Tab Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Tabs From Widgets
    Then User Validate the Tab

  Scenario: Validate the Hover Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Tool Tips From Widgets
    Then User Hover and and Validate

  Scenario: Validate the Hover Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Menu From Widgets
    Then User Select the option from the menu

  Scenario: Validate the Hover Functionality
    When User Navigates to Home Page and select Widgets
    Then User Select Select Menu From Widgets
    Then User Select Value from the List
    Then User Select value from the Dropdown
    Then USer Select value from the multiselect drop down
    Then User Select multiple option

