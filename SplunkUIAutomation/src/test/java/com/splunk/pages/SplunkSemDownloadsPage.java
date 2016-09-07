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

public class SplunkSemDownloadsPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	protected static String currentUrl=null;
	protected static String splunkSemURL="splunk.com/en_us/download/sem.html";
	private static Log logger = LogUtil.getLog(SplunkSemDownloadsPage.class);
	protected static String downloadsFolderPath=PropertyManager.getProperty("downloads");
	public SplunkSemDownloadsPage(WebDriver driver) {
		super(driver);
	}


	// Get HomePage
	public void getHomePage() {
		driver.manage().deleteAllCookies();
		String baseUrl = getBaseURL();
		String currentUrl=baseUrl.split("splunk.com")[0];
		currentUrl =currentUrl+splunkSemURL;
		openUrl(driver, currentUrl);
	}


	public void verifySplunkSemWindows64Downloads(String username,String password,String pageTitle,String donwloadFileName) {
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("windowsOS64Bit");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle, donwloadFileName," Windows64 Bit");
	}
	
	public void verifySplunkSemWindows32ZIPDownloads(String username,String password,String pageTitle,String donwloadFileName) {
		
		getHomePage();
		//Scroll 
		scrollTo(driver,0, 400);
		//Click on Windows
		clickOnVisibleElement("windowsOS32ZIP");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle, donwloadFileName," Windows32 Bit ZIP");
	}
	
	public void verifySplunkSemWindows86MSIDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {

		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Windows
		clickOnVisibleElement("windowsOS86MSI");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Windows86 Bit MSI");
	}
	
	public void verifySplunkSemWindows64ZIPDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {

		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Windows
		clickOnVisibleElement("windowsOS64ZIP");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Windows64 Bit ZIP");
	}
	public void verifySplunkSemKernelLinuxDistributions64tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver, 0, 400);
		// Click on 64tgz
		clickOnVisibleElement("KernelLinuxDistributions64tgz");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 64tgz");
	}
	
	public void verifySplunkSemKernelLinuxDistributionsamd64debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Amd64deb
		clickOnVisibleElement("KernelLinuxDistributionsAmd64deb");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions Amd 64 .deb");
	}
	
	public void verifySplunkSemKernelLinuxDistributions64rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 64 .rpm
		clickOnVisibleElement("KernelLinuxDistributions64rpm");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 64 .rpm");
	}
	
	public void verifySplunkSemKernelLinuxDistributions32tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32tgz
		clickOnVisibleElement("KernelLinuxDistributions32tgz");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 32tgz");
	}
	
	public void verifySplunkSemKernelLinuxDistributionsamd32debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Amd32deb
		clickOnVisibleElement("KernelLinuxDistributionsAmd32deb");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions Amd 32 .deb");
	}
	
	public void verifySplunkSemKernelLinuxDistributions32rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32 .rpm
		clickOnVisibleElement("KernelLinuxDistributions32rpm");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Kernel Linux Distributions 32 .rpm");
	}
	
	public void verifySplunkSemSolaris64tarZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32tgz
		clickOnVisibleElement("Solaris64tarZ");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 tar Z ");
	}
	
	public void verifySplunkSemSolaris64pkgZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Amd32deb
		clickOnVisibleElement("Solaris64pkgZ");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 pkg Z ");
	}
	
	public void verifySplunkSemSolaris64p5pDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32 .rpm
		clickOnVisibleElement("Solaris64p5p");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " Solaris 64 p5p");
	}
	
	public void verifySplunkSemOSXtgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on Amd32deb
		clickOnVisibleElement("OSXtgz");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " OSX .tgz ");
	}
	
	public void verifySplunkSemOSXdmgDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		getHomePage();
		// Scroll
		scrollTo(driver,0, 400);
		// Click on 32 .rpm
		clickOnVisibleElement("OSXdmg");
		sleep(5000);
		verifySplunkSemDownloads(username, password, pageTitle,
		donwloadFileName, " OSX .dmg");
	}
	
	public void verifySplunkSemDownloads(String username,String password,String pageTitle,String downloadFileName,String message) {
		
		//Click on Login here link
		sleep(5000);
		clickOnVisibleElement("loginHereLink");
		
		//login functionality
		loginSplunkCom(username, password);
		sleep(30000);
		Assert.assertEquals(driver.getTitle(),pageTitle, "Splunk Sem "+message+" thank you download page title not matched.");
		
		boolean flag ;
		flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		logger.info("isFileDownloaded return values:"+flag);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Sem "+message+" direct downloads not working.");
		
	}


	public void verifySplunkSemMD5Downloads(String downloadFileName,String message) {
		//Click on MD5 download link		
		clickOnVisibleElement("downloadMD5Link");
		sleep(30000);
		
		boolean flag ;
		flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Sem download MD5 file  "+message);
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Sem download "+message+" MD5 file not downloaded sucessfully.");
		
	}


	public void verifySplunkSemDownloadsNotStartedLink(String downloadFileName,String message) {
		//Click on Download not started Link				
		clickOnVisibleElement("manualDownloadLink");
		
		sleep(20000);
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Sem download not started link ");
		if(!flag){
			handleDownloadsDialog();
			flag=isFileDownloaded(downloadsFolderPath, downloadFileName,  "Download folder: The file "+message);
		}
		Assert.assertTrue(flag, "Splunk Sem download "+message+" not started link not downloaded sucessfully.");
	}


	public void verifySplunkSemDownloadsGetThisURLLink(String downloadFileName,String message) {
		
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
		
		boolean flag =isFileDownloaded(downloadsFolderPath, downloadFileName,  "Splunk Sem "+message+" Get This URL Link file ");
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
		Assert.assertTrue(flag, "Splunk Sem "+message+" Get This URL Link file not downloaded sucessfully.");
	}
}
