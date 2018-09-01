package com.diegotomfurtado.liferayInterviewChallangeBDD.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.liferayInterviewChallangeBDD.utils.CommonMethods;

public class LiferayConfirmationPage extends CommonMethods {

	public LiferayConfirmationPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	private static final By returnSuccessMessageHeaderLocator = xpath(".//*[@class=\"ddm-form-name\"]");

	public String returnSuccessMessageHeaderLocator() {

		return returnElementFromPage(returnSuccessMessageHeaderLocator);
	}
}
