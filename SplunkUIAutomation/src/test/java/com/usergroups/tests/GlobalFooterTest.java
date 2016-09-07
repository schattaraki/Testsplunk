package com.usergroups.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.util.LogUtil;
import com.usergroups.pages.GlobalFooterPage;

/**
 * @author Maheshwar Kanchetty
 */
public class GlobalFooterTest extends TestBase {
	GlobalFooterPage footerPage;

	private static Log logger = LogUtil.getLog(GlobalFooterTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			footerPage = new GlobalFooterPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "globalFooter", groups = { "Regression","Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying footer landing page");
		footerPage.getHomePage();

		logger.info("Page Title::"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
	}

	@Test(priority = 2, dataProvider = "globalFooter", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" },enabled=true)
	public void testVerifyFooterCopyRightsText(String expValues) {
		logger.info("Verifying footer copy rights text");

		footerPage.getCopyRightsText(expValues);

		logger.info("Verified footer copy rights text");
	}
	
	@Test(priority = 3, dataProvider = "globalFooter", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" },enabled=true)
	public void testVerifyFooterFollowUS(String text,String link) {
		logger.info("Verifying footer follow US text and links");

		footerPage.verifyFooterFollowUS(text,link);

		logger.info("Verified footer follow US text and links");
	}

	@Test(priority = 6, dataProvider = "globalFooter", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" },enabled=true)
	public void testVerifyFooterLinks(String linkText, String URL, String title) {
		logger.info("Verifying footer links");

		footerPage.verifyfooterLinks(linkText, URL, title);

		logger.info("Verified footer links");
	}
	
	@Test(priority = 5, dataProvider = "globalFooter", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" },enabled=true)
	public void testVerifyFooterSplunkUGLink(String pageTitle, String URL) {
		logger.info("Verifying footer Splunk User Groups link");

		footerPage.verifyFooterSplunkUGLink(pageTitle, URL);

		logger.info("Verified footer Splunk User Groups link");
	}
}
