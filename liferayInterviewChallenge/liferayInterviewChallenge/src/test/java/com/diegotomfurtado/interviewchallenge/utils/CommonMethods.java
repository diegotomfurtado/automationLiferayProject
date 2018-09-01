package com.diegotomfurtado.interviewchallenge.utils;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods{
	
	protected static WebDriver browser;
	private static WebDriverWait waitDriver = null;
	
	public CommonMethods(WebDriver browser) {
		CommonMethods.browser = browser;
		// TODO Auto-generated constructor stub
	}

	public void clickOnButton(By locator) {
		waitElementVisibilityAndBeClickable(locator);
		browser.findElement(locator).click();
	}

	public String returnElementFromPage(By locator) {
		return browser.findElement(locator).getText();
	}
	
	public CommonMethods input(By locator, String input) {
		waitElementVisibilityAndBeClickable(locator);
		browser.findElement(locator).clear();
		browser.findElement(locator).sendKeys(input);
		return this;
	}

	public void chooseActualDateFromCalendarIcon(By locator, By anotherLocator) {
		
		browser.findElement(locator).clear();

		DateFormat dateFormat2 = new SimpleDateFormat("dd");
		Date date2 = new Date();
		String today = dateFormat2.format(date2);

		browser.findElement(anotherLocator).click();

		WebElement dateWidget = browser.findElement(xpath("//*/tbody"));
		List<WebElement> columns = dateWidget.findElements(tagName("td"));

		for (WebElement cell : columns) {
			if (cell.getText().equals(today.replaceFirst("^0+(?!$)", ""))) {
				cell.click();
				break;
			}
		}
		
	}
	
	public void waitElementAppearOnScreen(By locator) {
		getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitElementVisibilityAndBeClickable(By locator) {
		waitElementAppearOnScreen(locator);
		getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebDriverWait getWaitDriver() {
		if (waitDriver == null) {
			waitDriver = new WebDriverWait(browser, 10);
		}
		return waitDriver;
	}
	
}
