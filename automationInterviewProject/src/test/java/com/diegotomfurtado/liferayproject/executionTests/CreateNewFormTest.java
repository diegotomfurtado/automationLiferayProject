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
import com.diegotomfurtado.liferayproject.utils.Setup;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InputInformation.csv")

public class CreateNewFormTest {

	private WebDriver browser;

	@Before
	public void setUpOpenBrowser() {
		browser = Setup.setUpBrowser();
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
		
		assertTrue("This field is required.".contains(new LiferayFormsPage(browser).returnMessageErroFromNameArea()));
		System.out.println(new LiferayFormsPage(browser).returnMessageErroFromNameArea());
		
		
		assertTrue("This field is required.".contains(new LiferayFormsPage(browser).returnMessageErroFromDateArea()));
		System.out.println(new LiferayFormsPage(browser).returnMessageErroFromDateArea());
		
		assertTrue("This field is required.".contains(new LiferayFormsPage(browser).returnTextErroMessage()));
		System.out.println(new LiferayFormsPage(browser).returnTextErroMessage());
		
	}
	
	@Test
	public void testToValidateEndToEndProcess(@Param(name = "name") String name,
			@Param(name = "textArea") String textArea)
			throws InterruptedException {

		String returnFeedback = new LiferayFormsPage(browser)
				.fillANameOnField(name)
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea(textArea)
				.clickButtonToSubmitOnForm()
				.returnSuccessMessageHeaderLocator();

		assertEquals("Informações enviadas", returnFeedback);
		System.out.println(returnFeedback);
	}

}
