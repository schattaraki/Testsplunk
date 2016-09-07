package com.splunk.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.pages.FooterPage;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */
public class FooterTest extends TestBase {
	FooterPage footerPage;

	private static Log logger = LogUtil.getLog(FooterTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			footerPage = new FooterPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "footerPage", groups = { "Regression",
			"Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying footer landing page");
		footerPage.getHomePage();

		logger.info("Verifying landing page title");
		Assert.assertEquals(driver.getTitle(), title, "Title not matched");
		logger.info("Verified footer landing page");
	}

	@Test(priority = 2, dataProvider = "footerPage", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" })
	public void testVerifyFooterCopyRightsText(String expValues) {
		logger.info("Verifying footer copy rights text");

		footerPage.getCopyRightsText(expValues);

		logger.info("Verified footer copy rights text");
	}

	@Test(priority = 3, dataProvider = "footerPage", dependsOnMethods = "testVerifyLandingPage", groups = { "Regression" })
	public void testVerifyFooterLinks(String linkText, String URL, String title) {
		logger.info("Verifying footer links");

		footerPage.verifyfooterLinks(linkText, URL, title);

		logger.info("Verified footer links");
	}
}
