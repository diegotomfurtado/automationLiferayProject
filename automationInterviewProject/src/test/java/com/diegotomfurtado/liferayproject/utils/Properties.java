package com.diegotomfurtado.liferayproject.utils;

public class Properties {

	static final String URL = "https://forms.liferay.com/web/forms/shared/-/form/372406";
	static final String CHROME_PATH = "C:\\Drivers\\DrivesAutomations\\chromedriver.exe";
	static final String FIREFOX_PATH = "C:\\Drivers\\DrivesAutomations\\";

	public static boolean CLOSE_BROWSER;

	/*
	 * Here you can change the browser for your tests.
	 * */
	public static Browsers driver = Browsers.CHROME;

	public enum Browsers {
		CHROME, 
		FIREFOX
	}

	public String returnURL() {
		return URL;
	}

	public String returnChromePath() {
		return System.setProperty("webdriver.chrome.driver", CHROME_PATH);
	}

	public String returnFirefoxPath() {
		return System.setProperty("webdriver.chrome.driver", FIREFOX_PATH);
	}

}
