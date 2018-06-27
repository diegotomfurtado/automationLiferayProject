package com.diegotomfurtado.liferayproject.pages;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiferayFormsPage extends BasePages {

	private static final By labelLetsPartyRockLocator = xpath(".//*[contains(@class,\"lfr-ddm-form-page-description\")]");
	private static final By idNameFieldLocator = xpath(".//*[contains(@class,\"input-group-item\")]/input");
	private static final By idTextAreaLocator = xpath(".//*[contains(@class,\"input-group\")]/textarea");
	private static final By idCalendarLocator = xpath(".//*[contains(@class,\"input-group input-group-container\")]/input");
	private static final By idButtonSubmitLocator = xpath("//button[@class='btn btn-primary lfr-ddm-form-submit pull-right']");
	private static final By idButtonCalendarLocator = xpath("//span[@class=\"icon-calendar\"]");
	private static final By boxMessageErroMessageLocator = xpath(".//*[contains(@class,\"col-md-8\")]/div/div/div[2]");
	private static final By calendarLocator = xpath(".//*[contains(@class,\"col-md-4\")]/div/div/div[2]");
	private static final By nameFieldErroMessageLocator = xpath(".//*[contains(@class,\"col-md-12\")]/div/div/div[2]");
	private static final By erroMessageWithNoNetwork = xpath(".//*[contains(@class,\"container-fluid-1280 ddm-form-builder-app\"]/div[1]/div");

	public LiferayFormsPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public String returnErroMessageWithoutNetwork() {
		return browser.findElement(erroMessageWithNoNetwork).getText();
	}

	public void inputFakeDateToTestMethodStatic(String calendar) {
		browser.findElement(idCalendarLocator).sendKeys(calendar);
	}

	public String returnMessageErroFromNameArea() {
		return browser.findElement(nameFieldErroMessageLocator).getText();
	}

	public String returnTextErroMessage() {
		return browser.findElement(boxMessageErroMessageLocator).getText();
	}

	public String returnMessageErroFromDateArea() {
		return browser.findElement(calendarLocator).getText();
	}

	public String isPartyRockLabelVisible() {
		return browser.findElement(labelLetsPartyRockLocator).getText();
	}

	public LiferayFormsPage fillANameOnField(String name) {
		browser.findElement(idNameFieldLocator).sendKeys(name);
		return this;
	}

	public LiferayFormsPage fillBodyOnTextArea(String textArea) {
		browser.findElement(idTextAreaLocator).sendKeys(textArea);
		return this;
	}

	public LiferayFormsPage chooseDateFromCalendarIcon() {

		browser.findElement(idCalendarLocator).clear();

		DateFormat dateFormat2 = new SimpleDateFormat("dd");
		Date date2 = new Date();
		String today = dateFormat2.format(date2);

		browser.findElement(idButtonCalendarLocator).click();

		WebElement dateWidget = browser.findElement(xpath("//*/tbody"));
		List<WebElement> columns = dateWidget.findElements(tagName("td"));

		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}
		return this;
	}

	public LiferayConfirmationPage clickButtonToSubmitOnForm()
			throws InterruptedException {

		Thread.sleep(5000);
		browser.findElement(idButtonSubmitLocator).click();
		return new LiferayConfirmationPage(browser);
	}

}
