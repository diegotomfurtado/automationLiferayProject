package com.diegotomfurtado.liferayproject.executionTests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.Setup;

public class FieldNameTest {

	private WebDriver browser;

	@Before
	public void setUpOpenBrowser() throws Exception{
		browser = Setup.setUpBrowser();
	}

	@After
	public void teardown() throws Exception{
		browser.close();
	}

	/*
	 * Test requirements from Liferay
	 */

	@Test
	public void shouldDisplayMessageErrorWhenNameAreaIsEmpty()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("           ")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm();

		assertTrue("This field is required.".contains(new LiferayFormsPage(browser).returnMessageErroFromNameArea()));
		System.out.println(new LiferayFormsPage(browser).returnMessageErroFromNameArea());
	}

	/*
	 * From here, was created more test cases
	 */

	@Test
	public void shouldValidateAlphabetInputInNameArea()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("Diego Furtado")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateNumbersInput()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("1234567890")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateAlphanumericInput()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("ABC1234567890CBA")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateSpecialCharactersInput()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("!@#$%¨%$#$%¨&")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

}
