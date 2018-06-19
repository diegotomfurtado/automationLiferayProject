package com.diegotomfurtado.liferayproject.pages;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LiferayFormsPage extends BasePages {

	private final By labelLetsPartyRockLocator = xpath("//following-sibling::div/div/div/div/div/div/h4");
	private final By idNameFieldLocator = xpath("//label[text() = 'Qual é seu nome? ']/following-sibling::div/div/input");
	private final By idTextAreaLocator = xpath("//label[text() = 'Porque você ingressou na área de testes? ']/following-sibling::div/textarea");
	private final By idCalendarLocator = xpath("//label[text() = 'Qual é a data do seu nascimento? ']/following-sibling::div/input");
	private final By idButtonSubmitLocator = xpath("//button[@class='btn btn-primary lfr-ddm-form-submit pull-right']");
	private final By idButtonCalendarLocator = xpath("//span[@class=\"icon-calendar\"]");
	public final By nameFieldErroMessageLocator = xpath("//label[text() = 'Qual é seu nome? ']/following-sibling::div[2]");

	public LiferayFormsPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
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
		browser.findElement(idButtonSubmitLocator).sendKeys(Keys.ENTER);
		return new LiferayConfirmationPage(browser);
	}

}
