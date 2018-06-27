package com.diegotomfurtado.liferayproject.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LiferayConfirmationPage extends BasePages {

	public LiferayConfirmationPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	private static final By returnSuccessMessageHeaderLocator = xpath(".//*[@class=\"ddm-form-name\"]");

	public String returnSuccessMessageHeaderLocator()
			throws InterruptedException {

		Thread.sleep(5000);
		String returnFeedback = browser.findElement(
				returnSuccessMessageHeaderLocator).getText();

		return returnFeedback;
	}
}
