package com.diegotomfurtado.liferayproject.executionTests;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.SetUpBrowser;

public class FieldDateTest {
	private final By idCalendarLocator = xpath("//label[text() = 'Qual é a data do seu nascimento? ']/following-sibling::div/input");
	public final By calendarLocator = xpath("//label[text() = 'Qual é a data do seu nascimento? ']/following-sibling::div[2]");
	private final By erroMessageWithNoNetwork = xpath("//div[@class='container-fluid-1280 ddm-form-builder-app']/div[1]/div");

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
	public void shouldDisplayMessageErrorWhenDateAreaIsEmpty()
			throws InterruptedException {

		findCalendar("       ");
		new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field DATE validation.")
				.fillBodyOnTextArea("Static Test for field DATE validation.")
				.clickButtonToSubmitOnForm();

		String returnOfField = browser.findElement(calendarLocator).getText();

		assertEquals("This field is required.", returnOfField);
		System.out.println(returnOfField);
	}

	/*
	 * The correct validation is missing - the message is default for anything
	 */
	@Test
	public void shouldValidateAlphanumericInput()
			throws InterruptedException {

		findCalendar("testString");
		new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field DATE validation.")
				.fillBodyOnTextArea("Static Test for field DATE validation.")
				.clickButtonToSubmitOnForm();

		String returnOfField = browser.findElement(calendarLocator).getText();
		assertEquals("This field is required.", returnOfField);
		
		System.out.println("Should have another type of message, like: Invalid Date");
	}
	

	/*
	 * There are BUGs: It's accepting different date formats However, I will not
	 * setup as bug, because I haven't all requirements necessary
	 */

	/*
	 * this test should fail purposely
	 */

	@Test
	public void shouldValidateNumbersInput()
			throws InterruptedException {
		
		findCalendar("1234567890");
		new LiferayFormsPage(browser)
		.fillANameOnField("Static Test for field DATE validation.")
		.fillBodyOnTextArea("Static Test for field DATE validation.")
		.clickButtonToSubmitOnForm();
		
		String returnOfField = browser.findElement(calendarLocator).getText();
		
		assertEquals("This field is required.", returnOfField);
	}
	
	/*
	 * this test should fail purposely
	 */
	
	@Test  
	public void shouldValidateDifferentFormatDateInput()
			throws InterruptedException {

		findCalendar("08/01/167");
		String returnFeedback = new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field DATE validation.")
				.fillBodyOnTextArea("Static Test for field DATE validation.")
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();

		Assert.assertTrue(returnFeedback, returnFeedback.isEmpty());

	}

	/*
	 * this test should fail purposely
	 */

	@Test 
	public void shouldValidateWhenTheNetworkIsDown()
			throws InterruptedException {

		findCalendar("testingNoNetwork");
		new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field DATE validation.")
				.fillBodyOnTextArea("Static Test for field DATE validation.")
				.clickButtonToSubmitOnForm();

		String returnErroMessage = browser.findElement(erroMessageWithNoNetwork).getText();

		Assert.assertEquals("There was an error when trying to validate your form.",
				returnErroMessage);
	}
	
	@Test
	public void testInputOnDateAreaFromCalendarIcon(){
		new LiferayFormsPage(browser).chooseDateFromCalendarIcon();
		
	}

	public void findCalendar(String calendar) {
		browser.findElement(idCalendarLocator).sendKeys(calendar);
	}
	
}
