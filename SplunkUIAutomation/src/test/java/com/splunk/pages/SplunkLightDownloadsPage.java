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

public class SplunkLightDownloadsPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	protected static String baseUrl=null;
	protected static String splunkLightURL="splunk.com/en_us/download/splunk-light.html";
	private static Log logger = LogUtil.getLog(SplunkLightDownloadsPage.class);
	protected static String donwloadsFolderPath=PropertyManager.getProperty("downloads");
	public SplunkLightDownloadsPage(WebDriver driver) {
		super(driver);
	}

	// Get HomePage
	public void getHomePage() {
		baseUrl = getBaseURL();
		String cUrl=baseUrl.split("splunk.com")[0];
		openUrl(driver, cUrl+splunkLightURL);
	}



	public void verifySplunkLightDownloadsForWindows(String username,String password,String pageTitle,String donwloadFileName) {
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "windosDownloadBtn", "windowsProductDownloadLink");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Windows ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Windows direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux64RPM(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux64RPM");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 64 .RPM ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 64 .RPM direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux64TGZ(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux64TGZ");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 64 .TGZ ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 64 .TGZ direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux64DEB(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux64DEB");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 64 .DEB ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 64 .DEB direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux32DEB(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux32DEB");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 32 .DEB ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 32 .DEB direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux32TGZ(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux32TGZ");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 32 .TGZ ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 32 .TGZ direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsLinux32RPM(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "linuxDownloadBtn", "splunkLightForLinux32RPM");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For Linux 32 .RPM ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For Linux 32 .RPM direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsMACOSIntelDMG(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "macOSDownloadBtn", "splunkLightForMacOSIntelDMG");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For MacOS Intel .DMG ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For MacOS Intel .DMG direct downloads not working.");
		
	}
	
	public void verifySplunkLightDownloadsMACOSTGZ(String username,String password,String pageTitle,String donwloadFileName) {
		//Load the Splunk light URL
		getHomePage();
		//direct downloads for Windows OS
		directDownloadsNavigation(username, password, pageTitle, donwloadFileName, "macOSDownloadBtn", "splunkLightForMacOSTGZ");
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  " Splunk Light For MacOS .TGZ ");
		logger.info("isFileDownloaded return values:"+flag);
		Assert.assertTrue(flag, "Splunk Light For MacOS .TGZ direct downloads not working.");
		
	}
	
	public void directDownloadsNavigation(String username,String password,String pageTitle,String donwloadFileName,String downloadOSBtn,String downloadLink){
		//Scroll 
		scrollTo(driver, 0, 400);
		//Click on Windows
		clickOnVisibleElement(downloadOSBtn);
		sleep(5000);
		//Click on Model window Windows link
		clickOnVisibleElement(downloadLink);
		sleep(2000);
		//Click on Login here link
		clickOnVisibleElement("loginHereLink");
		
		//login functionality
		loginSplunkCom(username, password);
		sleep(30000);
		Assert.assertEquals(driver.getTitle(),pageTitle, "Splunk Light thank you download page title not matched.");
	}


	public void verifySplunkLightMD5Downloads(String donwloadFileName,String message) {
		//Click on MD5 download link		
		clickOnVisibleElement("downloadMD5Link");
		sleep(20000);
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  "Splunk Light download MD5 file  ");
		Assert.assertTrue(flag, "Splunk Light download "+message+" MD5 file not downloaded sucessfully.");
	}


	public void verifySplunkLightDownloadsNotStartedLink(String donwloadFileName, String message) {
		//Click on Download not started Link				
		clickOnVisibleElement("manualDownloadLink");
		
		sleep(20000);
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  "Splunk Light download not started link ");
		Assert.assertTrue(flag, "Splunk Light download "+message+" not started link not downloaded sucessfully.");
	}


	public void verifySplunkLightDownloadsGetThisURLLink(String donwloadFileName,String message) {
		
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
		sleep(20000);
		
		boolean flag =isFileDownloaded(donwloadsFolderPath, donwloadFileName,  "Splunk Light Get This URL Link file ");
		action.sendKeys(Keys.chord(Keys.CONTROL,Keys.F4)).perform();
		driver.switchTo().window(parentWindow);
		sleep(10000);
//		driver.navigate().refresh();
//		sleep(5000);
		//Logout functionality
		logOutSplunkCom();
		driver.manage().deleteAllCookies();
		Assert.assertTrue(flag, "Splunk Sem "+message+" Get This URL Link file not downloaded sucessfully.");
		
	}

}
