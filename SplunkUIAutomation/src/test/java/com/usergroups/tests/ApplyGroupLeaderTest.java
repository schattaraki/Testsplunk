package com.usergroups.tests;

import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.util.LogUtil;
import com.usergroups.pages.ApplyGroupLeader;
import com.usergroups.pages.UserGroupsPage;

public class ApplyGroupLeaderTest extends TestBase {
ApplyGroupLeader applygroupleadr;

private static Log logger = LogUtil.getLog(ApplyGroupLeaderTest.class);

@BeforeClass(alwaysRun = true)
public void prepareBeforeClass() throws Exception {
	try {
		applygroupleadr = new ApplyGroupLeader(driver);
	} catch (Exception e) {
		logger.info("Error is:" + e);
	}
}
@Test(priority = 2, dataProvider = "UserGroups", groups = { "Regression","Sanity" },enabled =false)
public void testVerifyApplyGroupLeader(String title, String firstName,String lastName, String emailID, String mobileNo, String country, String stateName,String postalCode, String issue, String username, String password) {
	logger.info("Verifying Apply Group Leader Form");
	applygroupleadr.getApplyGroupLeader( firstName, lastName,  emailID,  mobileNo,  country,  stateName, postalCode,  issue, username, password);

	logger.info("Page Title::"+driver.getTitle());
//	Assert.assertEquals(driver.getTitle(), title, "Title not matched");
	logger.info("Verifying Apply Group Leader Form");
}

@Test(priority = 3, dataProvider = "homePage", groups = { "Regression","Sanity" },enabled =true)
public void testverifyShowInterest(String address,String username,String password) {
	logger.info("Verifying Apply show Interse functionality");
	applygroupleadr.verifyShowInterest(address,username,password);
	logger.info("Page Title::"+driver.getTitle());
//	Assert.assertEquals(driver.getTitle(), title, "Title not matched");
	logger.info("Verifying Apply show Interest functionality");
}

}
