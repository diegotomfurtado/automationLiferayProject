package com.diegotomfurtado.liferayproject.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpBrowser {

	static final String URL = "https://forms.liferay.com/web/forms/shared/-/form/372406";
	static final String LOCAL_PATH = "C:\\Drivers\\DrivesAutomations\\chromedriver.exe";

	public static WebDriver setUpBrowser() {

		new SetUpBrowser();

		System.setProperty("webdriver.chrome.driver", LOCAL_PATH);

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		browser.get(URL);
		return browser;
	}
}
