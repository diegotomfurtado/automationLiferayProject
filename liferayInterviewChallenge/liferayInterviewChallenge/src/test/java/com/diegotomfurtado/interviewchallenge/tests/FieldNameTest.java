package com.diegotomfurtado.interviewchallenge.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.interviewchallenge.pages.LiferayFormsPage;
import com.diegotomfurtado.interviewchallenge.utils.SetUp;

public class FieldNameTest {

	private WebDriver browser;
	LiferayFormsPage liferayFormsPage = new LiferayFormsPage(browser);	
	
	
	@Before
	public void setUpOpenBrowser() throws Exception{
		browser = SetUp.setUp();
		
	}

	@After
	public void teardown() throws Exception{
		browser.close();
	}
	
	@Test
	public void shouldDisplayMessageErrorWhenNameAreaIsEmpty()
			throws InterruptedException {

		liferayFormsPage
				.fillANameOnField("           ")
				.chooseActualDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm();

		assertTrue("This field is required.".contains(liferayFormsPage.returnMessageErroFromNameArea()));
		System.out.println(new LiferayFormsPage(browser).returnMessageErroFromNameArea());
	}

	@Test
	public void shouldValidateAlphabetInputInNameArea()
			throws InterruptedException {

		liferayFormsPage
				.fillANameOnField("Diego Furtado")
				.chooseActualDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateNumbersInput()
			throws InterruptedException {

		liferayFormsPage
				.fillANameOnField("1234567890")
				.chooseActualDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateAlphanumericInput()
			throws InterruptedException {

		liferayFormsPage
				.fillANameOnField("ABC1234567890CBA")
				.chooseActualDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateSpecialCharactersInput()
			throws InterruptedException {

		liferayFormsPage
				.fillANameOnField("!@#$%¨%$#$%¨&")
				.chooseActualDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

}
