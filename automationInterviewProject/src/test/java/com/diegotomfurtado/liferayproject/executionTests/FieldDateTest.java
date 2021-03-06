package com.diegotomfurtado.liferayproject.executionTests;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;

import java.util.concurrent.BrokenBarrierException;

import org.apache.poi.hssf.usermodel.examples.NewLinesInCells;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.SetUpBrowser;

public class FieldDateTest {

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

		assertEquals("This field is required.", new LiferayFormsPage(browser).returnMessageErroFromDateArea());
		System.out.println(new LiferayFormsPage(browser).returnMessageErroFromDateArea());
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

		assertEquals("This field is required.", new LiferayFormsPage(browser).returnMessageErroFromDateArea());
		
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
		
		assertEquals("This field is required.", new LiferayFormsPage(browser).returnMessageErroFromDateArea());
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

		Assert.assertEquals("There was an error when trying to validate your form.",
				new LiferayFormsPage(browser).returnErroMessageWithoutNetwork());
	}
	
	@Test
	public void testInputOnDateAreaFromCalendarIcon(){
		new LiferayFormsPage(browser).chooseDateFromCalendarIcon();
		
	}

	public void findCalendar(String calendar) {
		new LiferayFormsPage(browser).inputFakeDateToTestMethodStatic(calendar);
	}
	
}
