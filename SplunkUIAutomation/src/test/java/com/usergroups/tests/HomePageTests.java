package com.usergroups.tests;

import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.util.LogUtil;
import com.usergroups.pages.HomePage;

/**
 * @author Maheshwar Kanchetty
 */
public class HomePageTests extends TestBase {
	HomePage homePage;

	private static Log logger = LogUtil.getLog(HomePageTests.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			homePage = new HomePage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "homePage", groups = { "Regression",
			"Sanity" })
	public void tesetVerifyLandingPage(String title) {
		logger.info("Verifying Home landing page");
		homePage.getHomePage();

		logger.info("Verifying landing page title");
		logger.info("Page TItle::"+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
		logger.info("Verified Home landing page");
	}
	
	@Test(priority = 2, dataProvider = "homePage", groups = { "Regression",
	"Sanity" }, enabled=true)
	public void testVerifyCreateGroupFuntionality(String username,String password,String groupNameText,String desc,String leaderText,String locationText,String tags){
		logger.info("Verify Create group functionality");
		homePage.verifyCreateGroupFuntionality(username,password, groupNameText, desc, leaderText, locationText, tags);
		logger.info("Verified Create group functionality");
	}
	
	@Test(priority = 3, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testVerifyJoinThisGroupFuntionality(String username,String password,String address){
		
		logger.info("Verify join this group functionality");
		homePage.joinThisGroup(username,password,address);
		logger.info("Verified join this group functionality");
	}
	
	@Test(priority = 4, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testVerifyLeaveThisGroupFuntionality(String username,String password,String address){
		
		logger.info("Verify leave this group functionality");
		homePage.leaveThisGroup(username,password,address);
		logger.info("Verified leave this group functionality");
	}
	
	@Test(priority = 5, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testVerifyCreateEventFuntionality(String username, String password,
			String address,String eventName,String eventDesc,String locationName,String locationAddress){
		
		logger.info("Verify create event functionality");
		homePage.verifyCreateEventFuntionality( username,  password,
				 address, eventName, eventDesc, locationName, locationAddress);
		logger.info("Verified create event functionality");
	}
	
	@Test(priority = 6, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testVerifyDraftEventFuntionality(String username, String password,
			String address,String eventName,String eventDesc,String locationName,String locationAddress){
		
		logger.info("Verify create event functionality");
		homePage.verifyDraftEventFuntionality( username,  password,
				 address, eventName, eventDesc, locationName, locationAddress);
		logger.info("Verified create event functionality");
	}

}
