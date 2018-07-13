package com.diegotomfurtado.liferayproject.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpBrowser {

	static final String URL = "https://forms.liferay.com/web/forms/shared/-/form/372406";

	public static WebDriver setUpBrowser() {

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		browser.get(URL);
		return browser;
	}
}
