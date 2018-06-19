package com.diegotomfurtado.liferayproject.executionTests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.SetUpBrowser;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InputInformation.csv")

public class CreateNewFormTest {

	private WebDriver browser;

	@Before
	public void setUpOpenBrowser() {
		browser = SetUpBrowser.setUpBrowser();
	}

	@After
	public void teardown() {
		browser.close();
	}

	/*
	 * Test Case from requirement specification
	 */
	@Test
	public void testToValidateIfContainsPartyRockLabel() {

		String labelName = new LiferayFormsPage(browser)
				.isPartyRockLabelVisible();
		assertThat(labelName, containsString("party rock"));
	}
	
	@Test
	public void testToSendAFormWithoutFieldsFilled() throws InterruptedException {
		
		new LiferayFormsPage(browser).clickButtonToSubmitOnForm();
		
		FieldNameTest chekingNameArea = new FieldNameTest();
		String returnMessageErroFromNameArea = browser.findElement(chekingNameArea.nameFieldErroMessageLocator).getText();
		assertTrue("This field is required.".contains(returnMessageErroFromNameArea));
		System.out.println(returnMessageErroFromNameArea);
		
		FieldDateTest chekingDateArea = new FieldDateTest();
		String returnMessageErroFromDateArea = browser.findElement(chekingDateArea.calendarLocator).getText();
		assertTrue("This field is required.".contains(returnMessageErroFromDateArea));
		System.out.println(returnMessageErroFromDateArea);
		
		FieldBoxMessageTest chekingBoxArea = new FieldBoxMessageTest();
		String returnMessageErroFromBoxArea = browser.findElement(chekingBoxArea.boxMessageErroMessageLocator).getText();
		assertTrue("This field is required.".contains(returnMessageErroFromBoxArea));
		System.out.println(returnMessageErroFromBoxArea);
		
	}
	
	@Test
	public void testToValidateEndToEndProcess(@Param(name = "name") String name,
			@Param(name = "textArea") String textArea)
			throws InterruptedException {

		String returnFeedback = new LiferayFormsPage(browser)
				.fillANameOnField(name).chooseDateFromCalendarIcon()
				.fillBodyOnTextArea(textArea).clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();

		assertEquals("Informações enviadas", returnFeedback);
		System.out.println(returnFeedback);
	}

}
