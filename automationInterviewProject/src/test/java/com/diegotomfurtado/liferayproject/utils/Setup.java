package com.diegotomfurtado.liferayproject.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

	public static WebDriver browser;

	public static WebDriver setUpBrowser() {

		new Setup();

		if (browser == null) {
			switch (Properties.driver) {
			case CHROME:

				new Properties().returnChromePath();
				browser = new ChromeDriver();
				browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				browser.get(new Properties().returnURL());
				break;

			case FIREFOX:

				new Properties().returnChromePath();
				browser = new ChromeDriver();
				browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				browser.get(new Properties().returnURL());
				break;
			}
		}
		return browser;
	}
}
