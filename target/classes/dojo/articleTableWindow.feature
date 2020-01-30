
Feature: Article window

	Background: User is aisle manager or admin

	Scenario: Select article
	Given There articles in the table
	When A row is clicked
	Then The corresponding details window opens
	
	Scenario: Cancel
	When The cancel button is clicked
	Then The window closes
	
	Scenario: Sort articles by name
	Given The articles are not sorted by name 
	When The name column headeris clicked
	Then The articles are sorted by name
	
	Scenario: Sort 