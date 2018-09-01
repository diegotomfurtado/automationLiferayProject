package com.diegotomfurtado.liferayInterviewChallangeBDD.testsuites;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = SnippetType.CAMELCASE, 
		dryRun = false,
		features = {
			"src/Resource/CheckElementOnPage.feature"
			,"src/Resource/CreateNewForm.feature"
			,"src/Resource/MandatoryFields.feature"
		},
		glue = { "com.diegotomfurtado.liferayInterviewChallangeBDD.steps"}, 
		tags = {
			"@TestRun"
		})


public class RunAllTests {
	//nothing to do, for while.

}