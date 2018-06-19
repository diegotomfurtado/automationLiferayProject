package com.diegotomfurtado.liferayproject.executionTests;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.SetUpBrowser;

public class FieldNameTest {

	public final By nameFieldErroMessageLocator = xpath("//label[text() = 'Qual é seu nome? ']/following-sibling::div[2]");

	private WebDriver browser;

	@Before
	public void setUpOpenBrowser() throws Exception{
		browser = SetUpBrowser.setUpBrowser();
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

		new LiferayFormsPage(browser).fillANameOnField("           ")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm();

		String returnOfField = browser.findElement(nameFieldErroMessageLocator)
				.getText();

		assertTrue("This field is required.".contains(returnOfField));
		System.out.println(returnOfField);
	}

	/*
	 * From here, was created more test cases
	 */

	@Test
	public void shouldValidateAlphabetInputInNameArea()
			throws InterruptedException {

		new LiferayFormsPage(browser).fillANameOnField("Diego Furtado")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateNumbersInput()
			throws InterruptedException {

		new LiferayFormsPage(browser).fillANameOnField("1234567890")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateAlphanumericInput()
			throws InterruptedException {

		new LiferayFormsPage(browser).fillANameOnField("ABC1234567890CBA")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

	@Test
	public void shouldValidateSpecialCharactersInput()
			throws InterruptedException {

		new LiferayFormsPage(browser).fillANameOnField("!@#$%¨%$#$%¨&")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("Static Test for field name validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();
	}

}
