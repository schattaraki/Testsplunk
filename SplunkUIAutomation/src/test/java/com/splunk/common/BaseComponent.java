package com.splunk.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Avneet Dhanoa
 * */

public abstract class BaseComponent {
	
	protected WebDriver driver;

	public BaseComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForPageToLoad();
		verifyPageElements();
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	


	public abstract void waitForPageToLoad();

	public abstract void verifyPageElements();


}
