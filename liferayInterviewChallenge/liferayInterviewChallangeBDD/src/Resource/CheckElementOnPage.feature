@TestRun
Feature: The text ""party rock"" must be present in the form.
	I should be able to see a part rock's label on Forms page.
	
Background:
	Given a user is on home page.
	
Scenario:
	When a user looks at the left side from the Forms page
	Then a user should see a message "party rock"  