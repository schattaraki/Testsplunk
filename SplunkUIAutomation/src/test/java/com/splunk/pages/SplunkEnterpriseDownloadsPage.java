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

public class SplunkEnterpriseDownloadsPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	protected static String currentUrl=null;
	protected static String splunkEnterpriseURL="splunk.com/en_us/download/splunk-enterprise.html";
	private static Log logger = LogUtil.getLog(SplunkEnterpriseDownloadsPage.class);
	protected static String downloadsFolderPath=PropertyManager.getProperty("downloads");
	public SplunkEnterpriseDownloadsPage(WebDriver driver) {
		super(driver);
	}


	// Get HomePage
	public void getHomePage() {
		String baseUrl = getBaseURL();
		String currentUrl=baseUrl.split("splunk.com")[0];
		currentUrl =currentUrl+splunkEnterpriseURL;
		openUrl(driver,currentUrl);
	}


	public void verifySplunkEnterpriseWindows64Downloads(String username,String password,String pageTitle,String donwloadFileName) {
		deleteAllFiles(PropertyManager.getProperty("downloads"), "Download folder: All the files ");
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("windosDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseWindows64BitMSI");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle, donwloadFileName," Windows64 Bit");
	}
	
	public void verifySplunkEnterpriseWindows32ZIPDownloads(String username,String password,String pageTitle,String donwloadFileName) {
		
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("windosDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseWindows32BitZIP");
		verifySplunkEnterpriseDownloads(username, password, pageTitle, donwloadFileName," Windows32 Bit ZIP");
	}
	
	public void verifySplunkEnterpriseWindows86MSIDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {

		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("windosDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseWindows86BitMSI");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Windows86 Bit MSI");
	}
	
	/*public void verifySplunkEnterpriseWindows64ZIPDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {

		getHomePage();
		//Scroll 
		scrollTo(0, 400);
		//Click on Windows
		clickOnVisibleElement("windosDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseWindows86BitMSI");
		sleep(5000);
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Windows64 Bit ZIP");
	}
	public void verifySplunkEnterpriseKernelLinuxDistributions64tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(0, 400);
		// Click on 64tgz
		clickOnVisibleElement("KernelLinuxDistributions64tgz");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 64tgz");
	}
	
	public void verifySplunkEnterpriseKernelLinuxDistributionsamd64debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(0, 400);
		// Click on Amd64deb
		clickOnVisibleElement("KernelLinuxDistributionsAmd64deb");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions Amd 64 .deb");
	}
	
	public void verifySplunkEnterpriseKernelLinuxDistributions64rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(0, 400);
		// Click on 64 .rpm
		clickOnVisibleElement("KernelLinuxDistributions64rpm");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 64 .rpm");
	}*/
	
	public void verifySplunkEnterpriseKernelLinuxDistributions32tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseLinuxtgz");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 32tgz");
	}
	
	public void verifySplunkEnterpriseKernelLinuxDistributionsamd32debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseLinuxdeb");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions Amd 32 .deb");
	}
	
	public void verifySplunkEnterpriseKernelLinuxDistributions32rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("linuxDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseLinuxrpm");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 32 .rpm");
	}
	
	public void verifySplunkEnterpriseSolaris64tarZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		clickOnVisibleElement("solarisOSDownloadBtn");
		sleep(5000);
		
		clickOnVisibleElement("splunkEnterpriseSolaristarZ");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 tar Z ");
	}
	
	public void verifySplunkEnterpriseSolaris64pkgZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		clickOnVisibleElement("solarisOSDownloadBtn");
		sleep(5000);
		clickOnVisibleElement("splunkEnterpriseSolarispkgZ");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 pkg Z ");
	}
	
	public void verifySplunkEnterpriseSolaris64p5pDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		clickOnVisibleElement("solarisOSDownloadBtn");
		sleep(5000);
		clickOnVisibleElement("splunkEnterpriseSolarisp5p");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 p5p");
	}
	
	public void verifySplunkEnterpriseOSXtgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Amd32deb
		clickOnVisibleElement("OSXtgz");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " OSX .tgz ");
	}
	
	public void verifySplunkEnterpriseOSXdmgDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32 .rpm
		clickOnVisibleElement("OSXdmg");
		sleep(5000);
		verifySplunkEnterpriseDownloads(username, password, pageTitle,
		donwloadFileName, " OSX .dmg");
	}
	
	public void verifySplunkEnterpriseDownloads(String username,String password,String pageTitle,String downloadFileName,String message) {
		
		//Click on Login here link
		sleep(5000);
		clickOnVisibleElement("loginHereLink");
		
		//login functionality
		loginSplunkCom(username, password);
		sleep(30000);
		Assert.assertEquals(driver.getTitle(),pageTitle, "Splunk Enterprise "+message+" thank you download page title not matched.");
		
		boolean flag ;
		flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		logger.info("isFileDownloaded return values:"+flag);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Enterprise "+message+" direct downloads not working.");
		
	}


	public void verifySplunkEnterpriseMD5Downloads(String downloadFileName,String message) {
		//Click on MD5 download link		
		clickOnVisibleElement("downloadMD5Link");
		sleep(30000);
		
		boolean flag ;
		flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Enterprise download MD5 file  "+message);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Enterprise download "+message+" MD5 file not downloaded sucessfully.");
		
	}


	public void verifySplunkEnterpriseDownloadsNotStartedLink(String downloadFileName,String message) {
		//Click on Download not started Link				
		clickOnVisibleElement("manualDownloadLink");
		
		sleep(20000);
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Enterprise download not started link ");
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Enterprise download "+message+" not started link not downloaded sucessfully.");
	}


	public void verifySplunkEnterpriseDownloadsGetThisURLLink(String downloadFileName,String message) {
		
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
		
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Enterprise "+message+" Get This URL Link file ");
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		
		action.sendKeys(Keys.chord(Keys.CONTROL,Keys.F4)).perform();
		driver.switchTo().window(parentWindow);
		sleep(10000);
		driver.navigate().refresh();
		sleep(5000);
		//Logout functionality
		logOutSplunkCom();
		driver.manage().deleteAllCookies();
		Assert.assertTrue(flag, "Splunk Enterprise "+message+" Get This URL Link file not downloaded sucessfully.");
	}
}
