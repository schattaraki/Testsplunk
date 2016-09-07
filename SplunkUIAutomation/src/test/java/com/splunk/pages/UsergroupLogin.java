package com.splunk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsergroupLogin extends com.splunk.common.BasePage {

	public UsergroupLogin(WebDriver driver) {
		super(driver);
	}

	/**
	 * xPath for My Account Link on Homepage
	 */
	@FindBy(xpath = ".//*[@id='userName']")
	WebElement myAccountLinkXpath;

	/**
	 * xPath for Login Link in Dropdown on Homepage
	 */
	@FindBy(xpath = ".//*[@id='loginId']")
	WebElement loginLinkXpath;

	/**
	 * xPath for Username Textbox on Login Page
	 */
	@FindBy(xpath = ".//*[@id='username']")
	WebElement usernameTextBoxXpath;

	/**
	 * xPath for Username Textbox on Login Page
	 */
	@FindBy(xpath = ".//*[@id='password']")
	WebElement passwordTextBoxXpath;

	/**
	 * xPath for Username Textbox on Login Page
	 */
	@FindBy(xpath = ".//*[@id='login-submit']")
	WebElement loginButtonXpath;

	// public static final String myAccountLinkXpath1=".//*[@id='userName']";
	// public static final String loginLinkXpath=".//*[@id='loginId']";
	// public static final String usernameTextBoxXpath = ".//*[@id='username']";
	// public static final String passwordTextBoxXpath = ".//*[@id='password']";
	// public static final String loginButtonXpath = ".//*[@id='login-submit']";

	/**
	 * Click on My Account Link
	 */
	public void clickMyAccount() {
		verifyAndClick(myAccountLinkXpath);
	}

	/**
	 * Click on Login Link
	 */
	public void clickLogin() {
		verifyAndClick(loginLinkXpath);
	}

	/**
	 * Enter Username
	 */
	public void typeUsername(String username) {
		type(usernameTextBoxXpath, username);
	}

	/**
	 * Enter Password
	 */
	public void typePassword(String pwd) {
		type(passwordTextBoxXpath, pwd);
	}

	/**
	 * Click Login Button
	 */
	public void clickLoginButton() {
		verifyAndClick(loginButtonXpath);
	}

	/**
	 * Verify Login Success
	 */
	public void verifyloginSuccess(String username) {
		verifyElementContainText(loginLinkXpath, username);
	}
}
