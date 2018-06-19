package com.diegotomfurtado.liferayproject.executionTests;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayproject.pages.LiferayFormsPage;
import com.diegotomfurtado.liferayproject.utils.SetUpBrowser;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InputInformation.csv")
public class FieldBoxMessageTest {

	public final By boxMessageErroMessageLocator = xpath("//label[text() = 'Porque você ingressou na área de testes? ']/following-sibling::div[2]");

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
	public void shouldDisplayMessageErrorWhenBoxAreaIsEmpty()
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field boxMessage validation.")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea("            ")
				.clickButtonToSubmitOnForm();

		String returnOfField = browser
				.findElement(boxMessageErroMessageLocator).getText();

		assertTrue("This field is required.".contains(returnOfField));
		System.out.println(returnOfField);
	}

	@Test
	public void shouldValidateAlphanumericInput(
			@Param(name = "textArea") String textArea)
			throws InterruptedException {

		new LiferayFormsPage(browser).fillBodyOnTextArea(textArea);
	}

	@Test
	@Ignore
	public void shouldValidateLoadTestAtBoxMessage(
			@Param(name = "textArea") String textArea)
			throws InterruptedException {

		new LiferayFormsPage(browser)
				.fillANameOnField("Static Test for field boxMessage validation.")
				.chooseDateFromCalendarIcon()
				.fillBodyOnTextArea(textArea)
				.clickButtonToSubmitOnForm();
	}
}
