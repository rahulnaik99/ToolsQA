Feature: Test Elements functions

  Description: testing Elements
  Background:
    When User Navigates to Home Page and select Elements


  Scenario: Validate the Textbox Functionality
    Then User Select Text Box From Elements
    Then User Enter the information in the Text Box
    Then User Validates the Results

#  Scenario: Validate the Checkbox Functionality
#    Then User Select Check Box From Elements
#    Then User Select the Folder and Files
#    And Validates the Check box output
#
#  Scenario: Validate the Rado Button Functionality
#    Then User Select Radio Button From Elements
#    Then User Select the Radio Button yes
#    And Validates the Radio Button output for yes
#    Then User Select the Radio Button impressive
#    And Validates the Radio Button output for impressive

#  Scenario: Validate the Web Tables Functionality
#    When User Navigates to Home Page and select Elements
#    Then User Select Web Tables From Elements
#    When User Verify that Table is Loaded
#    Then User Add a New Record
#    Then User edit an Existing Record
#    Then USer Delete the Record
#    Then User Sort the Column
#    Then User search for the Record
#
#  Scenario: Validate the Dynamic Button Functionality
#    When User Navigates to Home Page and select Elements
#    Then User Select Buttons From Elements
#    When User Verify double click me Button
#    When User Verify right click Button
#    When User Verify dynamic click Button
#
#  Scenario: Validate the Links Functionality
#    When User Navigates to Home Page and select Elements
#    Then User Select Links From Elements
#    When User Verify new Window Link
#    When User Validates the Links with API Status
#
#  Scenario: Validate the broken Link and Image
#    When User Navigates to Home Page and select Elements
#    Then User Select Broken Links - Images From Elements
#    Then Validate that the Image has a broken Link
#
#  Scenario: validate Upload And Download Feature
#    When User Navigates to Home Page and select Elements
#    Then User Select Upload and Download From Elements
#    Then User download the file
#    Then User upload the file
#
#  Scenario: validate button with dynamic in function
#    When User Navigates to Home Page and select Elements
#    Then User Select Dynamic Properties From Elements
#    Then User Click button is enable after 5 seconds and also check the Color of the button
