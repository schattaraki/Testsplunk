/**
 * 
 */
package com.usergroups.tests;
import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.splunk.common.TestBase;
import com.splunk.util.LogUtil;
import com.usergroups.pages.CreateUserGroup;

/**
 * @author schattaraki
 *
 */
public class CreateUserGroupTest extends TestBase {

	CreateUserGroup createusergroup;
	private static Log logger = LogUtil.getLog(CreateUserGroupTest.class);

	@BeforeClass(alwaysRun=true)
	public void prepareBeforeclass() throws Exception {
		try {
			createusergroup = new CreateUserGroup(driver);

		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "homePage", groups = { "Regression", "Sanity" })
	public void tesetVerifyLandingPage(String title) {
		logger.info("Verifying Home landing page");
		createusergroup.getHomepage();
		logger.info("Verifying landing page title");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Page TItle::" +title);
		logger.info("Page TItle::" + driver.getTitle());
		
		// Assert.assertEquals(driver.getTitle(), title, "Title not matched");
		logger.info("Verified Home landing page");
	}

	@Test(priority = 3, dataProvider = "homePage", groups = { "Regression", "Sanity" }, enabled =true)
	public void testVerifyCreateGroupFuntionality(String username, String password, String groupNameText, String desc,
			String leaderText, String locationText, String tags) {
		logger.info("Verify Create group functionality");
		createusergroup.verifyCreateGroupFuntionality(username, password, groupNameText, desc, leaderText, locationText,
				tags);
		logger.info("Verified Create group functionality");
	}
	

	@Test(priority = 2, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testVerifyCreateEventFuntionality(String username, String password,
			String address,String eventName,String eventDesc,String locationName,String enterlocation,String description){
		
		logger.info("Verify create event functionality");
		createusergroup.verifyCreateEventFuntionality(username,password,
				 address,eventName,eventDesc,locationName,enterlocation,description);
		logger.info("Verified create event functionality");
		
		
	}
	@Test(priority = 4, dataProvider = "homePage", groups = { "Regression",
	"Sanity" },enabled=false)
	public void testverifyGroupSearchFunctionality(String address)
	{
		logger.info("verify group search functionality ");
		createusergroup.testverifyGroupSearchFunctionality(address);
		logger.info("verified group search functionality ");
		
	}
	
	
}
