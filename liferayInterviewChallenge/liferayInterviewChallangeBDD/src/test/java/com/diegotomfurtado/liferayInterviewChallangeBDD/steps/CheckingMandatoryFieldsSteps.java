package com.diegotomfurtado.liferayInterviewChallangeBDD.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayInterviewChallangeBDD.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayInterviewChallangeBDD.utils.SetUp;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckingMandatoryFieldsSteps {

	private WebDriver browser;
	LiferayFormsPage liferayFormsPage = new LiferayFormsPage(browser);

	@Given("^already is on home page form$")
	public void alreadyIsOnHomePageForm() throws Throwable {

		browser = SetUp.setUp();
	}

	@When("^the name field \"([^\"]*)\" is empty$")
	public void theNameFieldIsEmpty(String name) throws Throwable {

		liferayFormsPage.fillANameOnField(name);
	}

	@When("^the calendar field \"([^\"]*)\" is empty$")
	public void theCalendarFieldIsEmpty(String calendar) throws Throwable {

		liferayFormsPage.inputFakeDateToTestMethodStatic(calendar);
	}

	@When("^the box area filed \"([^\"]*)\" is empty$")
	public void theBoxAreaFiledIsEmpty(String textArea) throws Throwable {

		liferayFormsPage.fillBodyOnTextArea(textArea);
	}

	@Then("^the Submit button will be clicked and the message of mandatory fields will display to user$")
	public void theSubmitButtonWillBeClickedAndTheMessageOfMandatoryFieldsWillDisplayToUser() throws Throwable {

		liferayFormsPage.clickButtonToSubmitOnForm();

		assertTrue("This field is required.".contains(liferayFormsPage.returnMessageErroFromNameArea()));

		assertTrue("This field is required.".contains(liferayFormsPage.returnMessageErroFromDateArea()));

		assertTrue("This field is required.".contains(liferayFormsPage.returnMessageTextErroMessage()));
	}
}
