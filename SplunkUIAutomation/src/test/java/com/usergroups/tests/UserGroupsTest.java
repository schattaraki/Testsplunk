package com.usergroups.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.util.LogUtil;
import com.usergroups.pages.UserGroupsPage;

/**
 * @author Maheshwar Kanchetty
 */
public class UserGroupsTest extends TestBase {
	UserGroupsPage userGroupsPage;

	private static Log logger = LogUtil.getLog(UserGroupsTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			userGroupsPage = new UserGroupsPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "UserGroups", groups = { "Regression","Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying footer landing page");
		userGroupsPage.getHomePage();

		logger.info("Page Title::"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
	}

	@Test(priority = 2, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyFooterCopyRightsText(String expValues) {
		logger.info("Verifying footer copy rights text");

		userGroupsPage.getCopyRightsText(expValues);

		logger.info("Verified footer copy rights text");
	}
	
	@Test(priority = 3, dataProvider = "UserGroups",  groups = { "Regression" },enabled = true)
	public void testVerifyFooterFollowUS(String text,String link) {
		logger.info("Verifying footer follow US text and links");

		userGroupsPage.verifyFooterFollowUS(text,link);

		logger.info("Verified footer follow US text and links");
	}

	@Test(priority = 6, dataProvider = "globalFooter",  groups = { "Regression" },enabled = true)
	public void testVerifyFooterLinks(String linkText, String URL, String title) {
		logger.info("Verifying footer links");

		userGroupsPage.verifyfooterLinks(linkText, URL, title);

		logger.info("Verified footer links");
	}
	
	@Test(priority = 5, dataProvider = "UserGroups",  groups = { "Regression" },enabled = true)
	public void testVerifyFooterSplunkUGLink(String pageTitle, String URL) {
		logger.info("Verifying footer Splunk User Groups link");

		userGroupsPage.verifyFooterSplunkUGLink(pageTitle, URL);

		logger.info("Verified footer Splunk User Groups link");
	}
	
	@Test(priority = 6, dataProvider = "UserGroups",  groups = { "Regression" },enabled = true)
	public void testVerifySplunkHeaderLogo(String pageTitle, String ugLogo) {
		logger.info("Verifying header logo link");

		userGroupsPage.getHeaderLogoLink();
		Assert.assertEquals(driver.getTitle(), pageTitle, "Title not matched");
	}
	
	@Test(priority = 7, dataProvider = "UserGroups",  groups = { "Regression" },enabled = true)
	public void testVerifySplunkComLink(String expLinkText, String URL, String pageTitle) {
		logger.info("Verifying SplunkCom link");

		String linkText = userGroupsPage.getSplunkComLink();
		Assert.assertEquals(linkText, expLinkText, "SplunkCom linktext not matched");
		
		Assert.assertEquals(driver.getCurrentUrl(), URL, "URL not matched");
		
		Assert.assertEquals(driver.getTitle(), pageTitle, "Title not matched");
		
		driver.navigate().back();

		logger.info("Verified SplunkCom link");
	}
	
	@Test(priority = 8, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifySupportServicesLink(String expLinkText, String subNavlinkText,String URLs) {
		logger.info("Verifying Support and Services links");

		String linkText = userGroupsPage.getSupportServicesLinkText();
		String subNavLinksText = userGroupsPage.getSupportServicesSubNavLinkText();
		String subNavlinks = userGroupsPage.getSupportServicesSubNavLinks();
		Assert.assertEquals(linkText, expLinkText, "Splunk and Services linktext not matched");
		
		Assert.assertEquals(subNavLinksText, subNavlinkText, "Sub nav links linktext not matched");
		
		Assert.assertEquals(subNavlinks, URLs, "URLs not matched");

		logger.info("Verifying Support and Services links");
	}
	
	@Test(priority = 9, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyMyAccountLink(String expLinkText, String subNavlinkText,String URLs) {
		logger.info("Verifying MyAccount links");

		String linkText = userGroupsPage.getMyAccountLinkText();
		
		String subNavLinkText = userGroupsPage.getMyAccountSubNavLinkText();
		String subNavlinks = userGroupsPage.getMyAccountSubNavLinks();
		Assert.assertEquals(linkText, expLinkText, "Splunk and Services linktext not matched");
		
		Assert.assertEquals(subNavLinkText, subNavlinkText, "Sub nav links linktext not matched");
		
		Assert.assertEquals(subNavlinks, URLs, "URLs not matched");

		logger.info("Verifying MyAccount links");
	}
	
	@Test(priority = 10, dataProvider = "UserGroups", groups = { "Regression","Sanity" },enabled = true)
	public void testVerifyGetHelpOrContactUsForm(String title, String firstName,String lastName, String emailID, String mobileNo, String country, String stateName,String postalCode, String issue) {
		logger.info("Verifying Help Or ContactUs Form");
		userGroupsPage.getHelpOrContactUsForm( firstName, lastName,  emailID,  mobileNo,  country,  stateName, postalCode,  issue);

		logger.info("Page Title::"+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
		logger.info("Verifying Help Or ContactUs Form");
	}
	
	@Test(priority = 11, dataProvider = "UserGroups", groups = { "Regression","Sanity" },enabled = true)
	public void testVerifyApplyGroupLeader(String title, String firstName,String lastName, String emailID, String mobileNo, String country, String stateName,String postalCode, String issue, String username, String password) {
		logger.info("Verifying Apply Group Leader Form");
		userGroupsPage.getApplyGroupLeader( firstName, lastName,  emailID,  mobileNo,  country,  stateName, postalCode,  issue, username, password);

		logger.info("Page Title::"+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
		logger.info("Verifying Apply Group Leader Form");
	}
	
	@Test(priority = 12, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyGroupSearchFunctionality(String location, String location1) {
		logger.info("Verifying Groups search functionality");

		String firstLocation = userGroupsPage.findMoreGroupsFromHeader(location);
		
		String secondLocation = userGroupsPage.findMoreGroupsFromBody(location1);
		
		
		Assert.assertEquals(firstLocation, location, "User Groups header find my location header was not matched");
		
		Assert.assertEquals(secondLocation, location1, "User Groups header find my location body was not matched");
		
		logger.info("Verifying Groups search functionality");
	}
	
	@Test(priority = 13, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyGroupSearchInputValidation(String location, String expected) {
		logger.info("Verifying Groups search functionality input validation");

		String getLocation = userGroupsPage.findMoreGroupsFromHeader(location);
		
		Assert.assertEquals(getLocation, expected, "User Groups input data validation not matched");
		
		logger.info("Verifying Groups search functionality input validation");
	}
	
	@Test(priority = 14, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyGroupSearchNoResults(String location, String expected) {
		logger.info("Verifying Groups search functionality with no results");

		String noResultsText = userGroupsPage.getGroupSearchNoResults(location);
		System.out.println("noResultsText:::"+noResultsText);
		
//		Assert.assertEquals(getLocation, expected, "User Groups input data validation not matched");
		
		logger.info("Verifying Groups search functionality  with no results");
	}
	
	@Test(priority = 15, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyGroupSearchWithResults(String location, String expected) {
		logger.info("Verifying Groups search functionality with results");

		String resultsText = userGroupsPage.getGroupSearchResults(location);
		System.out.println("resultsText:::"+resultsText);
		
		Assert.assertEquals(resultsText, expected, "User Groups search results validation not matched");
		
		logger.info("Verifying Groups search functionality  with results");
	}
	
	@Test(priority = 16, dataProvider = "UserGroups", groups = { "Regression" },enabled = true)
	public void testVerifyLeaderApplicationForNewGroups(String username, String password,String expLeaderApplicationInfo,String expLeaderNominationInfo) {
		logger.info("Verifying Leader Application For New Groups");
		System.out.println("Account credentials:::"+username+" , "+password);
		StringBuilder leaderApplicationInfo = userGroupsPage.getLeaderApplicationForNewGroups(username,password);
		
		StringBuilder leaderNominationInfo = userGroupsPage.getLeaderNominations();
		System.out.println("A:"+leaderApplicationInfo.toString());
		System.out.println("E:"+expLeaderApplicationInfo);
		Assert.assertEquals(leaderApplicationInfo.toString(), expLeaderApplicationInfo, "Leader Application Results not matched");
		Assert.assertEquals(leaderNominationInfo.toString(), expLeaderNominationInfo, "Leader Nomination Results not matched");
		logger.info("Verified Leader Application For New Groups");
	}
}
