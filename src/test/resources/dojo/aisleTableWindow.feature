
Feature: Aisle window

	Background: The user is admin
	
	Scenario: Select aisle
	Given There are aisles in the table
	When A row is clicked
	Then The corresponding aisle window opens
	
	Scenario: Cancel
	When The cancel button is clicked
	Then The window closes
