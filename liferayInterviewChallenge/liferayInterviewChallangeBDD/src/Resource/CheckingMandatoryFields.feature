@TestRun 
Feature: All fields must be mandatory and contain an error message if they are not filled in.
	The system need to show which field was not filled at the moment to subimit a form.
	
Background: 
	Given already is on home page form 
	
Scenario Outline: 
	When the name field "<name's field>" is empty 
	And the calendar field "<the calendar field>" is empty 
	And the box area filed "<boxText Field>" is empty 
	Then the Submit button will be clicked and the message of mandatory fields will display to user 
	
	Examples: 
	
		| name's field | boxText Field |
		|||
