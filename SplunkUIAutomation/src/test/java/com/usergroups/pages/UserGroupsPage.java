package com.usergroups.pages;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */

public class UserGroupsPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 2;
	protected static int footer_followus = 1;
	private static Log logger = LogUtil.getLog(UserGroupsPage.class);

	public UserGroupsPage(WebDriver driver) {
		super(driver);
	}


	// Get copy rights text from Footer
	public void getCopyRightsText(String expValue) {
		scrollTo(driver,0, 5000);
		sleep(5000);
		WebElement copyRightsLoc = driver.findElement(By.xpath(PropertyManager.getProperty("copyRights")
				+ copyright_index + "]"));

		copyright_index++;
		
		//Verifying Copy Rights text
		Assert.assertEquals(getText(copyRightsLoc), expValue,
				"Copy Rights text not matched.");
	}

	// Get HomePage
	public void getHomePage() {
		String baseUrl = getBaseURL();
		logger.info("\n\n" + "URL: " + baseUrl + "\n\n");
		openUrl(driver,baseUrl);
		sleep(5000);
	}

	// Verify footer links
	public void verifyfooterLinks(String linkText, String title, String URL) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		System.out.println("Footer Links::"+PropertyManager.getProperty("footerLinks")+ footer_index +"]/a");
		WebElement footerLink = driver.findElement(By.xpath(PropertyManager.getProperty("footerLinks")+ footer_index +"]/a"));
		String footerLinkText = getText(footerLink);

		footerLink.click();
		sleep(3000);

		footer_index++;
		
		String cTitle=driver.getTitle();
		String cURL=driver.getCurrentUrl();
		
		driver.navigate().back();
		//Verified Footer link text
		Assert.assertEquals(footerLinkText, linkText,
				"Footer linktext not matched.");
		
		//Verified target page URL
		Assert.assertTrue(cURL.contains(URL),
				"URL not matched");
		
		//Verified target page Title
		Assert.assertEquals(cTitle, title, "Title not matched");

	}

	//Verify FollowUS text and links
	public void verifyFooterFollowUS(String expText, String expValues) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		if(footer_followus==1){
			WebElement followUSTxt = driver.findElement(By.xpath(PropertyManager.getProperty("followUSText")));
			Assert.assertEquals(followUSTxt.getText(), expText," Follow US: text not matched.");
		}
		WebElement footerLink = driver.findElement(By.xpath(PropertyManager.getProperty("followUSLinks")+ footer_followus + "]/a"));
		footer_followus++;
		Assert.assertEquals(footerLink.getAttribute("href"), expValues," Follow US links not matched.");
	}

	//Verify Splunk User Groups Link
	public void verifyFooterSplunkUGLink( String pageTitle,
			String URL) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		WebElement splunkUGLink = driver.findElement(By.xpath(PropertyManager.getProperty("splunkUGLink")));
		WaitForElementToBeClickable(splunkUGLink);
		splunkUGLink.click();
		sleep(5000);
		String title=driver.getTitle();
		String cURL=driver.getCurrentUrl();
//		driver.navigate().back();
		Assert.assertEquals(title, pageTitle," Splunk User Groups link target page title not matched.");
		Assert.assertTrue(cURL.contains(URL)," Splunk User Groups link target page URL not matched.");
	}


	public void getHeaderLogoLink() {
		WebElement splunkUGLink = driver.findElement(By.xpath(PropertyManager.getProperty("usergroups_Logo")));
		verifyAndClick(splunkUGLink);
	}


	public String getSplunkComLink() {
		WebElement splunkComLink = driver.findElement(By.xpath(PropertyManager.getProperty("splunkComLink")));
		String linkText = splunkComLink.getText();
		verifyAndClick(splunkComLink);
		return linkText;
	}


	public String getSupportServicesLinkText() {
		WebElement supportServicesLink = driver.findElement(By.xpath(PropertyManager.getProperty("supportServicesLink")));
		String linkText = supportServicesLink.getText();
		
		verifyAndClick(supportServicesLink);
		return linkText;
	}
	
	public String getSupportServicesSubNavLinkText() {
		return getLinkText("supportServicesSubNavLinks");
	}

	public String getSupportServicesSubNavLinks() {
		return getNavLinks("supportServicesSubNavLinks");
	}


	public String getMyAccountLinkText() {
		driver.navigate().refresh();
		WebElement myAccountLink = driver.findElement(By.xpath(PropertyManager.getProperty("myAccountLink")));
		String myaccount= myAccountLink.getText();
		
		verifyAndClick(myAccountLink);
		return myaccount;
	}
	
	public String getMyAccountSubNavLinkText() {
		return getLinkText("myAccountSubNavLinks");
	}
	
	public String getMyAccountSubNavLinks() {
		return getNavLinks("myAccountSubNavLinks");
	}


	public String getLinkText(String xPath) {
		sleep(5000);
		List<WebElement> subNavLinks = driver.findElements(By.xpath(PropertyManager.getProperty(xPath)));
		String linkText = "";
		int index=1;
		for (WebElement webElement : subNavLinks) {
			
			if(index==1){
				linkText=webElement.getText();
			}else{
				linkText=linkText+","+webElement.getText();
			}
			index++;
		}
		return linkText;
	}
	
	public String getNavLinks(String xPath) {
		List<WebElement> subNavLinks = driver.findElements(By.xpath(PropertyManager.getProperty(xPath)));
		String URLs = "";
		int index=1;
		for (WebElement webElement : subNavLinks) {
			
			if(index==1){
				URLs=webElement.getAttribute("href");
			}else{
				URLs=URLs+","+webElement.getAttribute("href");
			}
			index++;
		}
		return URLs;
	}


	public void getHelpOrContactUsForm(String firstName,String lastName, String emailID, String mobileNo, String country, String stateName,String postalCode, String issue) {
		String applyLeaderURL = "apply-leader.html";
		String baseURL = getBaseURL();
		driver.navigate().to(baseURL+applyLeaderURL);
		clickOnElement("contactUsButton");
		
		sleep(3000);
		enterText("firstName_field",firstName);
		enterText("lastName_field",lastName);
		enterText("emailId_field",emailID);
		enterText("mobileNo_field",mobileNo);
		enterText("countryName_field",country);
		enterText("stateName_field",stateName);
		enterText("postalCode_field",postalCode);
		enterText("issue_field",issue);
		sleep(30000);
//		clickOnElement("sendButton");
		
	}



	public void getApplyGroupLeader(String firstName, String lastName,String emailID, String mobileNo, String country, String stateName,
			String postalCode, String issue,String username,String password) {
		
		String applyLeaderURL = "apply-leader.html";
		String baseURL = getBaseURL();
		driver.navigate().to(baseURL+applyLeaderURL);
		clickOnElement("applyGroupLeaderButton");
		sleep(3000);
		
		//Login
		enterText("username_login",username);
		enterText("password_login",password);
		clickOnElement("submit_login");
		sleep(3000);
		
		clickOnElement("applyGroupLeaderButton");
		sleep(3000);
		/*enterText("firstName_field",firstName);
		enterText("lastName_field",lastName);
		enterText("emailId_field",emailID);*/
		enterText("mobile_field",mobileNo);
		enterText("country_field",country);
		enterText("state_field",stateName);
		enterText("postal_field",postalCode);
		enterText("message_field",issue);
		
		clickOnElement("showIntrest");
		
		clickOnElement("showIntrest1");
		sleep(30000);
//		clickOnElement("signUpButton");
		sleep(3000);
		clickOnElement("userprofileName");
		
		sleep(3000);
		clickOnElement("logOutButton");
		
	}


	public String findMoreGroupsFromHeader(String location) {
		enterText("findMoreGroupsInput", location);
		sleep(3000);
		clickOnVisibleElement("groupsFirstLocation");
		
		new Actions(driver).sendKeys(Keys.ENTER);
		sleep(5000);
		return getTextOfElement("getsearchLocation");
	}


	public String findMoreGroupsFromBody(String location) {
		clickOnVisibleElement("getsearchLocation");
		scrollTo(driver, 900, 500);
		sleep(5000);
		
		enterText("findMoreGroupsInputBody", location);
		sleep(5000);
		clickOnVisibleElement("groupsFirstLocationBody");
		
		new Actions(driver).sendKeys(Keys.ENTER);
		sleep(3000);
		return getTextOfElement("getsearchLocation");
	}


	public String getGroupSearchNoResults(String location) {
		findMoreGroupsFromHeader(location);
		sleep(3000);
		
		String peoplesIntrestHeader = getTextOfElement("peopleShownIntrestHeader");
		String applyHeader = getTextOfElement("applyLeaderHeader");
		String showIntrestHeader1 = getTextOfElement("showIntrestHeader");
		return peoplesIntrestHeader+", "+applyHeader+", "+showIntrestHeader1;
	}


	public String getGroupSearchResults(String location) {
		findMoreGroupsFromHeader(location);
		sleep(3000);
		
		String groupHeader = getTextOfElement("groupHeader");
		String groupLocation = getTextOfElement("groupLocation");
		String groupDescription = getTextOfElement("groupDescription");
		String groupMembers = getTextOfElement("groupMembers");
		return groupHeader+", "+groupLocation+", "+groupDescription+", "+groupMembers;
	}


	public StringBuilder getLeaderApplicationForNewGroups(String username,String password) {
		String applyLeaderURL = "admin";
		String baseURL = getBaseURL();
		driver.navigate().to(baseURL);
		sleep(3000);
		clickOnElement("myAccountLink");
		sleep(3000);
		clickOnElement("myAccountSubNavLinks");
		
		sleep(3000);
		
		//Login
		enterText("username_login",username);
		enterText("password_login",password);
		clickOnElement("submit_login");
		sleep(3000);
		driver.navigate().to(baseURL+applyLeaderURL);
		sleep(8000);
		String pendingUsers=getTextOfElement("adminPendingUsers");
		try{
		pendingUsers=pendingUsers.substring(0,pendingUsers.indexOf('(' )-1);
		}catch(Exception e){
			
		}
		String pendingUsersTableHeaders = getTextOfElement("adminPendingUsersHeaders");
		String pendingUsersTableHeaders1 = getTextOfElement("adminPendingUsersHeaders1");
		String pendingUsersTableHeaders2= getTextOfElement("adminPendingUsersHeaders2");
		String pendingUsersTableHeaders3 = getTextOfElement("adminPendingUsersHeaders3");
		
		String adminPendingUsersInfo = getTextOfElement("adminPendingUsersInfo");
		String adminPendingUsersInfo1 = getTextOfElement("adminPendingUsersInfo1");
		String adminPendingUsersInfo2 = getTextOfElement("adminPendingUsersInfo2");
		String userInfoFlag=null;
		if(adminPendingUsersInfo.length()!=0 && adminPendingUsersInfo1.length()!=0 && adminPendingUsersInfo2.length()!=0){
			 userInfoFlag="PendingUserInfoListed";
		}
		
		System.out.println("adminPendingUsersInfo::"+adminPendingUsersInfo+","+adminPendingUsersInfo1+","+adminPendingUsersInfo2);
		
		String adminPendingUsersApprove = getAttributeValueOfElement("adminPendingUsersApprove","class");
		String adminPendingUsersDelete = getAttributeValueOfElement("adminPendingUsersDelete","class");
		
		StringBuilder pendingUsersText=new StringBuilder();  
		pendingUsersText.append(pendingUsers+":"+pendingUsersTableHeaders+","+pendingUsersTableHeaders1+","+pendingUsersTableHeaders2+","+pendingUsersTableHeaders3+":"+adminPendingUsersApprove+","+adminPendingUsersDelete+":"+userInfoFlag); 
		System.out.println("pendingUsersText::"+pendingUsersText);
		sleep(3000);
/*		clickOnElement("userprofileName");
		
		sleep(3000);
		clickOnElement("logOutButton");*/
		return pendingUsersText;
	}
	
	public StringBuilder getLeaderNominations() {
		sleep(5000);
		String header=getTextOfElement("AdminLeaderNaminationsHeader");
		try{
			header=header.substring(0,header.indexOf('(' )-1);
			}catch(Exception e){
				
			}
		String tableHeader = getTextOfElement("LNTableHeader");
		String tableHeader1 = getTextOfElement("LNTableHeader1");
		String tableHeader2= getTextOfElement("LNTableHeader2");
		String tableHeader3 = getTextOfElement("LNTableHeader3");
		String tableHeader4 = getTextOfElement("LNTableHeader4");
		String tableHeader5 = getTextOfElement("LNTableHeader5");
		
		String LNTableHeaderText = getTextOfElement("LNTableHeaderText");
		String LNTableHeaderText1 = getTextOfElement("LNTableHeaderText1");
		String LNTableHeaderText2 = getTextOfElement("LNTableHeaderText2");
		String LNTableHeaderText3 = getTextOfElement("LNTableHeaderText3");
		String LNTableHeaderText4 = getTextOfElement("LNTableHeaderText4");
		
		String userInfoFlag=null;
		if(LNTableHeaderText.length()!=0 && LNTableHeaderText1.length()!=0 && LNTableHeaderText2.length()!=0 && LNTableHeaderText3.length()!=0 && LNTableHeaderText4.length()!=0 ){
			 userInfoFlag="NominationsInfoListed";
		}
		
		
		String adminLNApprove = getAttributeValueOfElement("LNTableHeaderApprove","class");
		String adminPLNDelete = getAttributeValueOfElement("LNTableHeaderDelete","class");
		
		StringBuilder leaderNominationText=new StringBuilder();  
		leaderNominationText.append(header+":"+tableHeader+","+tableHeader1+","+tableHeader2+","+tableHeader3+","+tableHeader4+","+tableHeader5+":"+adminLNApprove+","+adminPLNDelete+":"+userInfoFlag); 
		System.out.println("leaderNominationText::"+leaderNominationText);
		return leaderNominationText;
	}
}
