package com.splunk.common;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

/**
 * @author Avneet Dhanoa
 */

public abstract class BasePage implements Constants {

	static public Map<String, String> map = new HashMap<String, String>();
	static Logger logger = Logger.getLogger(BasePage.class);
	private static String chromeDownloadFile = ".crdownload";
	private static String firefoxDownloadFile = ".part";
	protected static WebDriver driver;

	public BasePage(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify and click on element
	 *
	 * @author Avneet Dhanoa
	 */

	public void verifyAndClick(WebElement element) {
		logger.info("Verify and Click XPath: " + element);
		Assert.assertNotNull(element);
		waitForElementToBeVisible(element);
		element.click();

	}

	/**
	 * Verify and click on element
	 *
	 * @param
	 */

	public void verifyAttribute(WebElement element, String attrKey,
			String expectedValue) {
		Assert.assertNotNull(element);
		Assert.assertEquals(element.getAttribute(attrKey), expectedValue);
	}

	/**
	 * check if element is present or not . If present returns true otherwise
	 * false
	 *
	 * @return
	 */
	public boolean isElementVisible(WebElement element) {
		assertNotNull(element);
		return element.isDisplayed();
	}

	/**
	 * check if element is present or not . If present returns true otherwise
	 * false
	 *
	 * @return
	 */
	public void verifyElementVisible(WebElement element) {
		assertNotNull(element);
		assertTrue(element.isDisplayed());
	}

	/**
	 * To Type into text box . takes two parameter
	 *
	 * @param value
	 *            :- Value to be typed
	 * 
	 *            Triggers Javascript Blur Event
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void blurType(WebElement element, String value)
			throws InterruptedException {
		assertNotNull(element);
		element.clear();
		element.sendKeys(value);
		JavascriptLibrary lib = new JavascriptLibrary();
		lib.callEmbeddedSelenium(driver, "triggerEvent", element, "blur");
	}

	public void focusType(WebElement element, String value)
			throws InterruptedException {
		assertNotNull(element);
		element.clear();
		element.sendKeys(value);
		JavascriptLibrary lib = new JavascriptLibrary();
		lib.callEmbeddedSelenium(driver, "triggerEvent", element, "focus");
	}

	public static void sendBlur(WebDriver driver, String selector) {
		String js = String.format("yam.$('%s').blur()", selector);
		((JavascriptExecutor) driver).executeScript(js);
	}

	/**
	 * To Type into text box . takes two parameter
	 *
	 * @param value
	 *            :- Value to be typed
	 */

	public void type(WebElement element, String value) {
		assertNotNull(element);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * To select a value from drop down box
	 *
	 * @param value
	 *            :value to be selected
	 */
	public void selectDropDownByVisibleText(WebElement element, String value) {
		assertNotNull(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * To select a value from drop down box
	 *
	 * @param value
	 *            :value to be selected
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Assert.assertNotNull(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * Wait for a element Present
	 *
	 * @param elmLocator
	 *            Locator of the element
	 * @param timeInSecs
	 *            time in seconds
	 */
	public void waitForElementPresent(By elmLocator, long timeInSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		wait.until(ExpectedConditions.presenceOfElementLocated(elmLocator));
	}

	public void WaitForElementToBeClickable(WebElement element, long timeInSecs) {
		assertNotNull(element);
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void WaitForElementToBeClickable(WebElement element) {
		assertNotNull(element);
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeVisible(WebElement element) {
		assertNotNull(element);
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForTextToBePresentInWebElement(WebElement element,
			String text) {
		assertNotNull(element);
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Wait for a element Present
	 *
	 * @param elmLocator
	 *            Locator of the element
	 */
	public void waitForElementPresent(By elmLocator) {
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(elmLocator));
	}

	/*
	 * without wait time
	 */
	public void waitForElementClickable(By elmLocator) {
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(elmLocator));
	}

	public void verifyElementSelected(WebElement element) {

		Assert.assertNotNull(element);
		Assert.assertTrue(element.isSelected());
	}

	public void verifyElementContainText(WebElement element, String text) {
		Assert.assertNotNull(element);
		Assert.assertTrue(element.getText().contains(text));
	}

	/**
	 * Verify Page Title
	 */
	public void verifyPageTitle(String pageTitle) {
		String pTitle = driver.getTitle();
		Assert.assertTrue(pTitle.toLowerCase()
				.contains(pageTitle.toLowerCase()));
	}

	/**
	 * Get count of web element list and validate the count
	 * 
	 * @param element
	 * @param text
	 */
	public void verifyElementCount(List<WebElement> element, String text) {
		Assert.assertNotNull(element);
		Assert.assertEquals(element.size(), text);
	}

	public void verifyAssertionTrue(boolean condition, String failureMessage) {
		Assert.assertTrue(condition, failureMessage);
	}

	/**
	 * Asserts that two objects are equal. If they are not, an AssertionError,
	 * with the given message, is thrown.
	 * 
	 * @param actual
	 *            : actual the actual value
	 * @param expected
	 *            : expected the expected value
	 * @param failureMessage
	 *            : message the assertion error message
	 */
	public void verifyAssertionTrue(Object actual, Object expected,
			String failureMessage) {
		Assert.assertEquals(actual, expected, failureMessage);
	}

	/**
	 * Opens given url
	 * 
	 * @param driver
	 *            : driver object
	 * @param url
	 *            : URL you wish to navigate to
	 */
	public void openUrl(WebDriver driver,String bURL) {
		try {
			logger.info("Opening url: " + bURL);
			System.out.println(bURL);
			driver.navigate().to(bURL);
			sleep(5000);
		} catch (Exception e) {
			logger.info("Exception in Open URL: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * verify whether element is present or not
	 * 
	 * @param element
	 *            : webElement object
	 * @return true if element is present, false otherwise
	 */
	public boolean isElementPresent(WebElement element) {
		try {
			element.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Clear the values of the Element
	 */

	public void clearField(WebElement element) {
		element.clear();
	}

	/*
	 * Verify Date in Asc/Desc Order
	 * 
	 * @author Avneet
	 */
	public boolean verifyDateOrder(String order, String xPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME,
					5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
			List<WebElement> dateOrder = driver.findElements(By.xpath(xPath));
			System.out.println("dateOrder Size:" + dateOrder.size());
			for (WebElement el : dateOrder) {
				System.out.println(el.getText());
			}
			if (dateOrder.size() > 0) {
				if (order.equalsIgnoreCase("Asc")) {
					System.out.println("\nASC Order\n");
					for (int i = 0; i < dateOrder.size(); i++) {
						for (int j = i + 1; j < dateOrder.size(); j++) {
							// compare list.get(i) and list.get(j)
							String firstDate = dateOrder.get(i).getText();
							String secondDate = dateOrder.get(j).getText();
							SimpleDateFormat format = new SimpleDateFormat();
							format = new SimpleDateFormat("MM/dd/yyyy");
							Date date1 = format.parse(firstDate);
							Date date2 = format.parse(secondDate);
							System.out.println("list.get(" + i + ") =" + date1
									+ "\nlist.get(" + j + ") = " + date2);
							Assert.assertTrue(date1.compareTo(date2) <= 0);
							System.out.println("Pass");
						}
					}
					return true;
				} else if (order.equalsIgnoreCase("Desc")) {
					System.out.println("\nDesc Order\n");
					for (int i = 0; i < dateOrder.size(); i++) {
						for (int j = i + 1; j < dateOrder.size(); j++) {
							// compare list.get(i) and list.get(j)
							String firstDate = dateOrder.get(i).getText();
							String secondDate = dateOrder.get(j).getText();
							SimpleDateFormat format = new SimpleDateFormat();
							format = new SimpleDateFormat("MM/dd/yyyy");
							Date date1 = format.parse(firstDate);
							Date date2 = format.parse(secondDate);
							System.out.println("list.get(" + i + ") = " + date1
									+ "\nlist.get(" + j + ") = " + date2);
							Assert.assertTrue(date1.compareTo(date2) >= 0);
							System.out.println("Pass");
						}
					}
					return true;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in verifyDateOrder: " + e.getMessage());
			logger.info("Error in verifyDateOrder: " + e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * Verify Asc/Desc Order
	 * 
	 * @author Avneet
	 */
	public boolean verifyOrder(String order, String xPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME,
					5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
			List<WebElement> dateOrder = driver.findElements(By.xpath(xPath));
			System.out.println("dateOrder Size:" + dateOrder.size());
			for (WebElement el : dateOrder) {
				System.out.println(el.getText());
			}
			if (dateOrder.size() > 0) {
				if (order.equalsIgnoreCase("Asc")) {
					System.out.println("\nASC Order\n");
					for (int i = 0; i < dateOrder.size(); i++) {
						for (int j = i + 1; j < dateOrder.size(); j++) {
							// compare list.get(i) and list.get(j)
							String firstDate = dateOrder.get(i).getText();
							String secondDate = dateOrder.get(j).getText();
							System.out.println("list.get(" + i + ") ="
									+ firstDate + "\nlist.get(" + j + ") = "
									+ secondDate);
							Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);
							System.out.println("Pass");
						}
					}
					return true;
				} else if (order.equalsIgnoreCase("Desc")) {
					System.out.println("\nDesc Order\n");
					for (int i = 0; i < dateOrder.size(); i++) {
						for (int j = i + 1; j < dateOrder.size(); j++) {
							// compare list.get(i) and list.get(j)
							String firstDate = dateOrder.get(i).getText();
							String secondDate = dateOrder.get(j).getText();
							System.out.println("list.get(" + i + ") ="
									+ firstDate + "\nlist.get(" + j + ") = "
									+ secondDate);
							Assert.assertTrue(firstDate.compareTo(secondDate) >= 0);
							System.out.println("Pass");
						}
					}
					return true;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in verifyDateOrder: " + e.getMessage());
			logger.info("Error in verifyDateOrder: " + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Get Text from HTML
	 */
	public String getText(WebElement element) {
		Assert.assertNotNull(element);
		return element.getText();
	}

	/**
	 * Get Text from HTML Add Values to Map
	 */
	public void mapAddText(String key, WebElement element) {
		try {
			System.out.println("Element: " + element);
			Assert.assertNotNull(element);
			String txt = element.getText().toString();
			System.out.println("Adding to Map\nKey: " + key + "\nValue: " + txt);
			map.put(key, txt);
		} catch (Exception e) {
			System.out.println("Error in mapAddText: " + e.getMessage());
		}
	}

	// @author move control to Default Content
	public void defCon() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Mouse Hover on given Webelement
	 */
	public void mouseHover(WebElement element) {
		Assert.assertNotNull(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * Load Support Site Based upon Environment
	 */
	public void loadSupportSite() {

		System.out.println("Support Site Dev Env: "
				+ PropertyManager.getProperty("devEnv"));
		System.out.println("Support Site Stg Env: "
				+ PropertyManager.getProperty("stgEnv"));
		if (Boolean.valueOf(PropertyManager.getProperty("devEnv"))) {
			logger.info("\n\n************************\n Support Site Dev Env Selected"
					+ "\n\n************************\n");
			System.out
					.println("\n\n************************\n Support Site Dev Env Selected"
							+ "\n\n************************\n");
			driver.get(PropertyManager.getProperty("devSupportSiteURI"));
		} else if (Boolean.valueOf(PropertyManager.getProperty("stgEnv"))) {
			logger.info("\n\n************************\n Support Site Stagging Env Selected"
					+ "\n\n************************\n");
			System.out
					.println("\n\n************************\n Support Site Stagging Env Selected"
							+ "\n\n************************\n");
			driver.get(PropertyManager.getProperty("devSupportSiteURI"));
		} else {
			driver.quit();
			System.out
					.println("\n\nNO ENVIRONMENT SPECIFIED TO LOAD SUPPORT SITE\n\n");
			logger.info("\n\nNO ENVIRONMENT SPECIFIED TO LOAD SUPPORT SITE\n\n");
		}
	}

	/**
	 * Login to Publc Site
	 */
	public void loginPublicSite(WebElement username,
			WebElement usernameContinue, WebElement password,
			WebElement passwordContinue, String supportSiteUsername,
			String supportSitePwd) {
		try {
			// logic for public site login in progress
			username.clear();
			username.sendKeys(supportSiteUsername);
			usernameContinue.click();
			password.clear();
			password.sendKeys(supportSitePwd);
			passwordContinue.click();
		} catch (Exception e) {
			System.out.println("Error in loginSupportSite: " + e.getMessage());
			logger.info("Error in loginSupportSite: " + e.getMessage());
		}
	}

	/**
	 * Login to Publc Site for FirstTime
	 */
	public void loginPublicSiteFirstTime(WebElement username,
			WebElement usernameContinue, WebElement password,
			WebElement passwordContinue, String supportSiteUsername,
			String supportSitePwd, WebElement cancelLink) {
		try {
			// logic for public site login in progress
			username.clear();
			username.sendKeys(supportSiteUsername);
			usernameContinue.click();
			password.clear();
			password.sendKeys(supportSitePwd);
			passwordContinue.click();
			cancelLink.click();
		} catch (Exception e) {
			System.out.println("Error in loginSupportSite: " + e.getMessage());
			logger.info("Error in loginSupportSite: " + e.getMessage());
		}
	}

	/**
	 * Login to Support Site
	 */
	public void loginSupportSite(WebElement username, WebElement password,
			WebElement loginBtn, String supportSiteUsername,
			String supportSitePwd) {
		try {
			username.clear();
			username.sendKeys(supportSiteUsername);
			password.clear();
			password.sendKeys(supportSitePwd);
			loginBtn.click();
		} catch (Exception e) {
			System.out.println("Error in loginSupportSite: " + e.getMessage());
			logger.info("Error in loginSupportSite: " + e.getMessage());
		}
	}

	/**
	 * Switch To Active Element
	 */
	public void activeElement() {
		try {
			driver.switchTo().activeElement();
		} catch (Exception e) {
			System.out.println("Error in activeElement: " + e.getMessage());
			logger.info("Error in activeElement: " + e.getMessage());
		}
	}

	// Unique Email Id
	public String email(int length) {
		String emailId = "";
		Random random = new Random((new Date()).getTime());
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9' };

		for (int i = 0; i < length; i++) {
			int idx = random.nextInt(values.length);
			emailId += values[idx];
		}
		return "automation_" + emailId + "@c1.stg";
	}

	/**
	 * Enter Investor Funnel from Open An Account Button on Invest Page
	 */
	public void enterInvestorFunnel1() {
		try {
			driver.findElement(By.xpath("//a[@data-q='header-invest']"))
					.click();
			driver.findElement(
					By.xpath("//a[contains(text(),'Open an Account')]"))
					.click();
		} catch (Exception e) {
			System.out.println("Error in enterInvestorFunnel1: "
					+ e.getMessage());
			logger.info("Error in enterInvestorFunnel1: " + e.getMessage());
		}
	}

	public void enterInvestorFunnelJoinNow() {
		try {
			driver.findElement(By.xpath("//a[@data-q='header-join-now']"))
					.click();
			driver.findElement(By.xpath("//a[contains(text(),'Get Started')]"))
					.click();
		} catch (Exception e) {
			System.out.println("Error in enterInvestorFunnelJoinNow: "
					+ e.getMessage());
			logger.info("Error in enterInvestorFunnelJoinNow: "
					+ e.getMessage());
		}
	}

	public void enterInvestorFunnelSubMenu() {
		try {
			driver.findElement(By.cssSelector("a[href*='invest']")).click();
			driver.findElement(
					By.xpath("//a[contains(text(),'Open an Account')]"))
					.click();
		} catch (Exception e) {
			System.out.println("Error in enterInvestorFunnelSubMenu: "
					+ e.getMessage());
			logger.info("Error in enterInvestorFunnelSubMenu: "
					+ e.getMessage());
		}
	}

	/**
	 * @author Avneet Dhanoa
	 */
	public Boolean verifyURL(String expectedURL) {
		boolean flag = false;
		String cmp = expectedURL.toLowerCase();
		if (driver.getCurrentUrl().toLowerCase().contains(cmp)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * scrollTo
	 * 
	 * @param height
	 * @param width
	 */
	public void scrollTo(WebDriver driver,int height, int width) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + height + "," + width + ");");
	}

	public void sleep(long milliseconds) {

		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnDashboardLoginLink(){
		WebElement myAccountLink = driver.findElement(By.xpath(PropertyManager.getProperty("myAccountLink")));
		WaitForElementToBeClickable(myAccountLink);
		myAccountLink.click();
		
		WebElement loginLink = driver.findElement(By.xpath(PropertyManager.getProperty("loginLink")));
		WaitForElementToBeClickable(loginLink);
		loginLink.click();
	}
	/**
	 * Login to Splunk com Site
	 */
	public void loginSplunkCom(String usernameText, String passwordText) {
		try{
		WebElement usernameObj = driver.findElement(By.xpath(PropertyManager.getProperty("username")));
		usernameObj.sendKeys(usernameText);
		
		WebElement passwordObj = driver.findElement(By.xpath(PropertyManager.getProperty("password")));
		passwordObj.sendKeys(passwordText);
		
		WebElement submitButton = driver.findElement(By.xpath(PropertyManager.getProperty("submitBtn")));
		WaitForElementToBeClickable(submitButton);
		submitButton.click();
		
		}catch(Exception e){
			logger.info("Error while logging: "
					+ e.getMessage());
		}
	}
	
	public void enterText(String locator,String text){
		WebElement usernameObj = driver.findElement(By.xpath(PropertyManager.getProperty(locator)));
		usernameObj.sendKeys(text);
	}
	
	/**
	 * takeScreenShot: Take the screen shot when the test failed
	 * @param targetFilePath
	 */
	public static void takeScreenShot(String screenshotName){
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			String screenShotPath = PropertyManager.getProperty("screenshot_directory");
			logger.info("Screen shot file Path::"+screenShotPath+screenshotName+".png");
			FileUtils.copyFile(screenshot, new File(screenShotPath+"/"+screenshotName+".png"));
			logger.info("Screenshot have been taken "+screenshotName);
		} catch (Exception e) {
			logger.info("Error occured while taking screen shot "
					+ screenshotName);
		}
	}
	
	/**
	 * LogOut to Splunk com Site
	 */
	public void logOutSplunkCom() {
		try{
			
		WebElement myAccountLink = driver.findElement(By.xpath(PropertyManager.getProperty("usernameLink")));
		WaitForElementToBeClickable(myAccountLink);
		myAccountLink.click();
		
		WebElement loginLink = driver.findElement(By.xpath(PropertyManager.getProperty("logoutLink")));
		WaitForElementToBeClickable(loginLink);
		loginLink.click();
		
		driver.manage().deleteAllCookies();
		
		}catch(Exception e){
			logger.info("Error while logging Out: "
					+ e.getMessage());
		}
	}
	
	/**
	 * Click on Element
	 */
	public void clickOnElement(String locator){
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty(locator)));
		selectlocation.click();
	}
	
	/**
	 * Click on Visible Element 
	 */
	public void clickOnVisibleElement(String locator){
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty(locator)));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
	}

	public String getTextOfElement(String locator){
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty(locator)));
		return selectlocation.getText();
	}
	
	public void deleteAllFiles(String imagesFolderPath,String message) {

		try {
			File folder = new File(imagesFolderPath);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length > 0) {
				for (File file : listOfFiles) {
					file.delete();
				}
			}
			File folder1 = new File(imagesFolderPath);
			File[] listOfFiles1 = folder1.listFiles();

			if (listOfFiles1.length == 0) {
				logger.info(message+" have been deleted");
			} else {
				logger.info(message+" are not deleted");
			}
		} catch (Exception e) {
			logger.info("Error while deleting "+message + e.getStackTrace());
		}

	}
	
	
	public boolean isFileDownloaded(String downloadsFolderPath,String fileName,String chromeFileName, String message) {
		boolean fileFindFlag=false;
		try {
			driver.navigate().to(downloadsFolderPath);
			sleep(2000);
			driver.navigate().refresh();
			sleep(3000);
			logger.info("@@@@@@@@@@@@@@@@@@@@@Before downloads files verification");
			List<WebElement> filenames= driver.findElements(By.xpath(PropertyManager.getProperty("downloadFileNames")));
			for (WebElement filename : filenames) {
				logger.info("Actual filename @@@@@@@@"+filename.getText());
				if(filename.getText().equals(fileName) || filename.getText().equals(chromeFileName) ||filename.getText().equals(chromeFileName+chromeDownloadFile) || filename.getText().equals(fileName+firefoxDownloadFile)){
					logger.info("A file name: "+filename.getText());
		        	logger.info("E file name: "+fileName);
					fileFindFlag=true;
				}
			}
		} catch (Exception e) {
			logger.info("Error while downloading file "+message + e.getStackTrace());
		}
		return fileFindFlag;

	}
	
	public boolean isFileDownloaded(String downloadsFolderPath,String fileName, String message) {
		boolean fileFindFlag=false;
		try {
			driver.navigate().to(downloadsFolderPath);
			sleep(5000);
			List<WebElement> filenames= driver.findElements(By.xpath(PropertyManager.getProperty("downloadFileNames")));
			logger.info("filenames size###################::"+filenames.size());
			for (WebElement filename : filenames) {
				logger.info("Actual filename @@@@@@@@"+filename.getText());
				if(filename.getText().equals(fileName) || filename.		getText().equals(fileName+chromeDownloadFile) || filename.getText().equals(fileName+firefoxDownloadFile)){
					logger.info("A file name: "+filename.getText());
		        	logger.info("E file name: "+fileName);
					fileFindFlag=true;
				}
			}
		} catch (Exception e) {
			logger.info("Error while downloading file "+message + e.getStackTrace());
		}
		return fileFindFlag;

	}
	public boolean isFileDownloaded_old(String downloadsFolderPath,String fileName,String message) {
		boolean fileFindFlag=false;
		try {
			sleep(5000);
			File folder = new File(downloadsFolderPath);
			if(folder.exists()){
				logger.info("################# folder donwload exists::");
			}
			File[] listOfFiles = folder.listFiles();
			logger.info("@@@@@@@@@@@ listOfFiles  ::"+listOfFiles.length);
			 for (int i = 0; i < listOfFiles.length; i++) {
				 logger.info("List of file names : "+i +" : "+listOfFiles[i].getName());
//				 && !(listOfFiles[i].getName().contains(".part"))
		        if (listOfFiles[i].getName().contains(fileName)){
		        	logger.info("A file name: "+listOfFiles[i].getName());
		        	logger.info("E file name: "+fileName);
		            fileFindFlag=true;
		            }
			 }

			if (fileFindFlag) {
				logger.info(message+" has been downloaded");
			} else {
				logger.info(message+" has not downloaded");
			}
			//Delete all the files from download folder
//			deleteAllFiles(downloadsFolderPath, "Download folder: All the files ");
		} catch (Exception e) {
			logger.info("Error while downloading file "+message + e.getStackTrace());
		}
		return fileFindFlag;

	}
	
	public String getBaseURL(){
		String baseUrl = null;
		if (PropertyManager.getProperty("qaEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qaurl");
		} else if(PropertyManager.getProperty("stgEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgurl");
		} else if(PropertyManager.getProperty("prodEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("produrl");
		}else if (PropertyManager.getProperty("qaUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qausergroupsurl");
		} else if(PropertyManager.getProperty("stgUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgusergroupsurl");
		}
		logger.info("\n\n" + "URL: " + baseUrl + "\n\n");
		
		return baseUrl;
	}
	
	public static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(timeoutSeconds, TimeUnit.MINUTES)
	            .pollingEvery(500, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);

	    return wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver webDriver) {
	            return driver.findElement(locator);
	        }
	    });
	}
	
	public void handleDownloadsDialog(){
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			sleep(5000);
		} catch (AWTException e) {
			logger.info("Downloads Dialog was not found::"+e.getMessage());
		}
       
	}
	
	public String getAttributeValueOfElement(String xPath,String attribute) {
		WebElement get = driver.findElement(By.xpath(PropertyManager.getProperty(xPath)));
		return get.getAttribute(attribute);
	}
}
