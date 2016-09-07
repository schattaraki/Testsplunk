package com.splunk.pages;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */

public class SplunkHunkDownloadsPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	protected static String currentUrl=null;
	protected static String splunkHunkURL="splunk.com/en_us/products/hunk.html";
	protected static String thankYouDownloadingURL="splunk.com/en_us/download/hunk/thank-you-for-downloading.html";
	private static Log logger = LogUtil.getLog(SplunkHunkDownloadsPage.class);
	protected static String downloadsFolderPath;
	
	public SplunkHunkDownloadsPage(WebDriver driver) {
		super(driver);
		if(Boolean.valueOf(PropertyManager.getProperty("isSauce"))){
			downloadsFolderPath=PropertyManager.getProperty("downloads1");
		}else{
			downloadsFolderPath=PropertyManager.getProperty("downloads");
		}
		logger.info("downloadsFolderPath @@@@@@@@@@@@@@@:"+downloadsFolderPath);
	}


	// Get HomePage
	public void getHomePage() {
		
		String baseUrl = getBaseURL();
		String currentUrl=baseUrl.split("splunk.com")[0];
		currentUrl =currentUrl+splunkHunkURL;
		openUrl(driver,currentUrl);
	}
	
	// thank-you-for-downloading page
		public void getThankYouDownloadingPageURL() {
			
			String baseUrl = getBaseURL();
			String currentUrl=baseUrl.split("splunk.com")[0];
			currentUrl =currentUrl+thankYouDownloadingURL;
			openUrl(driver,currentUrl);
		}


	public void verifySplunkHunkLinux64DownloadsTGZ(String username,String password,String pageTitle,String donwloadFileName) {
//		deleteAllFiles(downloadsFolderPath, "Download folder: All the files ");
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("DownloadHunkLink");
		sleep(5000);
		
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("HunkForLinux64BitTGZ");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle, donwloadFileName," Linux64 Bit");
	}
	
	public void verifySplunkHunkLinux64DownloadsDEB(String username,String password,String pageTitle,String donwloadFileName) {
//		deleteAllFiles(downloadsFolderPath, "Download folder: All the files ");
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("DownloadHunkLink");
		sleep(5000);
		
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("HunkForLinux64BitDEB");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle, donwloadFileName," Linux64 Bit");
	}
	
	public void verifySplunkHunkLinux64DownloadsRPM(String username,String password,String pageTitle,String donwloadFileName) {
//		deleteAllFiles(downloadsFolderPath, "Download folder: All the files ");
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("DownloadHunkLink");
		sleep(5000);
		
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("HunkForLinux64BitRPM");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle, donwloadFileName," Linux64 Bit");
	}
	
	
	public void verifySplunkEnterpriseDownloads(String username,String password,String pageTitle,String downloadFileName,String message) {
		
		//Click on Login here link
		sleep(5000);
		clickOnVisibleElement("loginHereLink");
		
		//login functionality
		loginSplunkCom(username, password);
		sleep(30000);
		Assert.assertEquals(driver.getTitle(),pageTitle, "Splunk Hunk "+message+" thank you download page title not matched.");
		
		boolean flag ;
		flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		logger.info("isFileDownloaded return values:"+flag);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Hunk "+message+" direct downloads not working.");
		
	}


	public void verifySplunkHunkMD5Downloads(String downloadFileName,String message) {
		//Navigate to Thank you download page URL
		getThankYouDownloadingPageURL();
		//Click on MD5 download link		
		clickOnVisibleElement("downloadMD5Link");
		sleep(30000);
		
		boolean flag ;
		flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Hunk download MD5 file  "+message);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Hunk download "+message+" MD5 file not downloaded sucessfully.");
		
	}


	public void verifySplunkHunkDownloadsNotStartedLink(String downloadFileName,String chromeFileName, String message) {
		
		//Navigate to Thank you download page URL
		getThankYouDownloadingPageURL();
		
		//Click on Download not started Link				
		clickOnVisibleElement("manualDownloadLink");
		
		sleep(20000);
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName, chromeFileName, "Splunk Hunk download not started link ");
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Hunk download "+message+" not started link not downloaded sucessfully.");
	}
	
	/*public void verifySplunkHunkDownloadsNotStartedLink(String downloadFileName, String message) {
		
		//Navigate to Thank you download page URL
		getThankYouDownloadingPageURL();
		
		//Click on Download not started Link				
		clickOnVisibleElement("manualDownloadLink");
		
		sleep(20000);
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Hunk download not started link ");
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Hunk download "+message+" not started link not downloaded sucessfully.");
	}*/

public void verifySplunkHunkDownloadsGetThisURLLink(String downloadFileName,String chromeFileName,String message) {
		
		//Navigate to Thank you download page URL
		getThankYouDownloadingPageURL();
		//Click on get This URL link
		clickOnVisibleElement("getThisURLLink");
		sleep(5000);
		
		String getThisURLText= getTextOfElement("getThisURLText");
		
		String getThisURL= getThisURLText.split("'")[1];
		String parentWindow = driver.getWindowHandle();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL, "t")).perform();
		
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			if(!window.equals(parentWindow)){
				driver.switchTo().window(window);
			}
		}
		sleep(3000);
		driver.navigate().to(getThisURL);
		sleep(2000);
		
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,chromeFileName,  "Splunk Hunk "+message+" Get This URL Link file ");
		
		action.sendKeys(Keys.chord(Keys.CONTROL,Keys.F4)).perform();
		driver.switchTo().window(parentWindow);
		sleep(5000);
		//Logout functionality
		logOutSplunkCom();
		driver.manage().deleteAllCookies();
		Assert.assertTrue(flag, "Splunk Hunk "+message+" Get This URL Link file not downloaded sucessfully.");
	}
	
	/*public void verifySplunkHunkDownloadsGetThisURLLink(String downloadFileName,String message) {
		
		//Navigate to Thank you download page URL
		getThankYouDownloadingPageURL();
		//Click on get This URL link
		clickOnVisibleElement("getThisURLLink");
		sleep(5000);
		
		String getThisURLText= getTextOfElement("getThisURLText");
		
		String getThisURL= getThisURLText.split("'")[1];
		String parentWindow = driver.getWindowHandle();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL, "t")).perform();
		
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			if(!window.equals(parentWindow)){
				driver.switchTo().window(window);
			}
		}
		sleep(3000);
		driver.navigate().to(getThisURL);
		sleep(2000);
		
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Hunk "+message+" Get This URL Link file ");
		
		action.sendKeys(Keys.chord(Keys.CONTROL,Keys.F4)).perform();
		driver.switchTo().window(parentWindow);
		sleep(5000);
		//Logout functionality
		logOutSplunkCom();
		driver.manage().deleteAllCookies();
		Assert.assertTrue(flag, "Splunk Hunk "+message+" Get This URL Link file not downloaded sucessfully.");
	}*/
}
