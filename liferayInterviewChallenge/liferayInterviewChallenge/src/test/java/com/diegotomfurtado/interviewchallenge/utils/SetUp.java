package com.diegotomfurtado.interviewchallenge.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {

	public static WebDriver setUp() {

		SeleniumReadProperties.ConfigFileReader();
		
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(SeleniumReadProperties.getImplicitlyWait(), TimeUnit.SECONDS);
		browser.get(SeleniumReadProperties.getApplicationUrl());

		return browser;
	}
}
