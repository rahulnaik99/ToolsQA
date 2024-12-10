Feature: Test Alerts, Frame & Windows

  Description: testing  Windows

  Scenario: Validate the Textbox Functionality
    When User Navigates to Home Page and select Alerts, Frame & Windows
    Then User Select Browser Windows From Alerts, Frame & Windows
    When User click on the Tab Button

  Scenario: Validate Alerts
    When User Navigates to Home Page and select Alerts, Frame & Windows
    Then User Select Alerts From Alerts, Frame & Windows
    When User click on Alert and Validate
    When User click on Dynamic Alert and Validate
    When User click on Yes or No Alert and Validate
    When User click on input Alert and Validate

  Scenario: Validate the Frame
    When User Navigates to Home Page and select Alerts, Frame & Windows
    Then User Select Frames From Alerts, Frame & Windows
    Then User select between Parent Frame and Child Frame

  Scenario: Validate the Frame
    When User Navigates to Home Page and select Alerts, Frame & Windows
    Then User Select Nested Frames From Alerts, Frame & Windows
    Then User select between Nested Parent Frame and Child Frame

  Scenario: Validate the Dialog Boxes
    When User Navigates to Home Page and select Alerts, Frame & Windows
    Then User Select Modal Dialogs From Alerts, Frame & Windows
    Then User select Small Modals
    Then User select Large Modals



