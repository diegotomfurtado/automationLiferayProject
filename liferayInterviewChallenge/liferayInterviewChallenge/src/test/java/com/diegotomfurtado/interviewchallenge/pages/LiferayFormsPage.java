package com.diegotomfurtado.interviewchallenge.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.interviewchallenge.utils.CommonMethods;

public class LiferayFormsPage extends CommonMethods{
	
	private static final By labelLetsPartyRockLocator = xpath(".//*[contains(@class,\"lfr-ddm-form-page-description\")]");
	private static final By idNameFieldLocator = xpath("//*[contains(@id,\"_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$QualÉSeuNome\")]");
	private static final By idTextAreaLocator = xpath(".//*[contains(@id,\"_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$PorqueVocêIngressouNaÁreaDeTestes\")]");
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
		return returnElementFromPage(erroMessageWithNoNetwork);
	}

	public void inputFakeDateToTestMethodStatic(String calendar) {
		input(idCalendarLocator, calendar);
	}

	public String returnMessageErroFromNameArea() {
		return returnElementFromPage(nameFieldErroMessageLocator);
	}

	public String returnMessageTextErroMessage() {
		return returnElementFromPage(boxMessageErroMessageLocator);
	}

	public String returnMessageErroFromDateArea() {
		return returnElementFromPage(calendarLocator);
	}

	public String isPartyRockLabelVisible() {
		return returnElementFromPage(labelLetsPartyRockLocator);
	}

	public LiferayFormsPage fillANameOnField(String name) {
		input(idNameFieldLocator, name);
		return this;
	}

	public LiferayFormsPage fillBodyOnTextArea(String textArea) {
		input(idTextAreaLocator, textArea);
		return this;
	}

	public LiferayFormsPage chooseActualDateFromCalendarIcon() {
		chooseActualDateFromCalendarIcon(idCalendarLocator, idButtonCalendarLocator);
		return this;
	}

	public LiferayConfirmationPage clickButtonToSubmitOnForm()
			throws InterruptedException {

		clickOnButton(idButtonSubmitLocator);
		return new LiferayConfirmationPage(browser);
	}

}
