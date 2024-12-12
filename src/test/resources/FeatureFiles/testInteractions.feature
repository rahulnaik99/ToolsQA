Feature: Test Interaction Functionality

  Description: Interaction Functionality

  Scenario: Validate the Sorting Functionality
    When User Navigates to Home Page and select Interactions
    Then User Select Sortable From Interactions
    Then User Sort the List Tab
    Then User Sort the Grid Tab

#  Scenario: Validate the Select Functionality
#    When User Navigates to Home Page and select Interactions
#    Then User Select Selectable From Interactions
#    Then User Select the List Tab
#    Then User Select the Grid Tab
##
#  Scenario: Validate the Resizable Functionality
#    When User Navigates to Home Page and select Interactions
#    Then User Select Selectable From Interactions
#    Then User Resize the tab
#
#  Scenario: Validate the Resizable Functionality
#    When User Navigates to Home Page and select Interactions
#    Then User Select Droppable From Interactions
#    Then User Drag and drop in Simple Tab
#    Then User Drag and drop in Accept Tab
#    Then User Drag and drop in Prevent Propogation Tab
#    Then User Drag and drop in Revert Draggable Tab
#
#  Scenario: Validate the Resizable Functionality
#    When User Navigates to Home Page and select Interactions
#    Then User Select Dragabble From Interactions
#    Then User Drag in Simple Tab
#    Then User Drag in Axis Restricted Tab
#    Then User Drag in Container Restricted Tab
#    Then User Drag in Cursor Style Tab