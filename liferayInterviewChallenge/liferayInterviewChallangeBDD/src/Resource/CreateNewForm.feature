@TestRun 
Feature: A successful message should appear after the form has been successfully submitted.
	I should be able to create a new form with all diferent inputs.
	
Background: 
	Given a user is on home page
	
Scenario Outline: 
	When a user type anything on "<name field>" name field
	And a user choose any date from calendar 
	And a user type anything on "<boxText Field>" boxText field
	And a user click on Submit button 
	Then a message will display to user 
	
	Examples: 
	
		| name field | boxText Field |
		| Diego Furtado | What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industrys standard dummy... |
		| 1234567890 | 1234567890 |
		| !@#$%^&*(&^%$#@!) | !@#$%^&*(*&^%$#) |
