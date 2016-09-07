package com.splunk.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.pages.SplunkHunkDownloadsPage;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */
public class SplunkHunkDownloadsTest extends TestBase {
	SplunkHunkDownloadsPage splunkHunk;

	private static Log logger = LogUtil.getLog(SplunkHunkDownloadsTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			splunkHunk = new SplunkHunkDownloadsPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying Splunk Hunk downloads landing page");
		
		splunkHunk.getHomePage();
		Assert.assertEquals(driver.getTitle(), title,
				"Splunk Hunk downloads title not matched");
		
		logger.info("Verified Splunk Hunk downloads landing page");
	}

	@Test(priority = 2, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = false)
	public void testVerifySplunkHunkLinux64DownloadsTGZ(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .tgz download functionality");
		
		splunkHunk.verifySplunkHunkLinux64DownloadsTGZ(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk Hunk .tgz download functionality");
	}

	@Test(priority = 3, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = false)
	public void testVerifySplunkHunkLinux64DownloadsTGZNotStartedLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .tgz Downloads Not Started Link functionality");
		
		splunkHunk.verifySplunkHunkDownloadsNotStartedLink(donwloadFileName , chromeFileName,"Linux64 Bit");

		logger.info("Verified Splunk Hunk .tgz Downloads Not Started Link functionality");
	}

	

	@Test(priority = 4, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = false)
	public void testVerifySplunkHunkLinux64MD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .tgz MD5 downloads functionality");
		
		splunkHunk.verifySplunkHunkMD5Downloads(donwloadFileName, "Linux64 Bit");

		logger.info("Verified Splunk Hunk .tgz MD5 downloads functionality");
	}
	
	@Test(priority = 5, dataProvider = "splunkHunk", groups = {
			"Regression", "Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = false)
	public void testVerifySplunkHunkLinux64DownloadsTGZGetThisURLLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .tgz  downloads Get This URL");

		splunkHunk.verifySplunkHunkDownloadsGetThisURLLink(donwloadFileName,chromeFileName,
				"Linux64 Bit");

		logger.info("Verified Splunk  Hunk .tgz downloads Get This URL");
	}
	
	
	@Test(priority = 6, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DownloadsDEB(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .deb download functionality");

		splunkHunk.verifySplunkHunkLinux64DownloadsDEB(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Hunk .deb download functionality");
	}

	@Test(priority = 7, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DownloadsDEBNotStartedLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .deb Downloads Not Started Link functionality");

		splunkHunk.verifySplunkHunkDownloadsNotStartedLink(donwloadFileName, chromeFileName,
				"Linux64 Bit");

		logger.info("Verified Splunk Hunk .deb Downloads Not Started Link functionality");
	}

	@Test(priority = 8, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DEBMD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .deb MD5 downloads functionality");

		splunkHunk
				.verifySplunkHunkMD5Downloads(donwloadFileName, "Linux64 Bit");

		logger.info("Verified Splunk Hunk .deb MD5 downloads functionality");
	}

	@Test(priority = 9, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DEBDownloadsTGZGetThisURLLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .deb  downloads Get This URL");

		splunkHunk.verifySplunkHunkDownloadsGetThisURLLink(donwloadFileName, chromeFileName,
				"Linux64 Bit");

		logger.info("Verified Splunk  Hunk .deb downloads Get This URL");
	}
	
	@Test(priority = 10, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DownloadsRPM(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .deb download functionality");

		splunkHunk.verifySplunkHunkLinux64DownloadsRPM(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Hunk .deb download functionality");
	}

	@Test(priority = 11, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64DownloadsRPMNotStartedLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .deb Downloads Not Started Link functionality");

		splunkHunk.verifySplunkHunkDownloadsNotStartedLink(donwloadFileName, chromeFileName,
				"Linux64 Bit");

		logger.info("Verified Splunk Hunk .deb Downloads Not Started Link functionality");
	}

	@Test(priority = 12, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64RPMMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Hunk .deb MD5 downloads functionality");

		splunkHunk
				.verifySplunkHunkMD5Downloads(donwloadFileName, "Linux64 Bit");

		logger.info("Verified Splunk Hunk .deb MD5 downloads functionality");
	}

	@Test(priority = 13, dataProvider = "splunkHunk", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkHunkLinux64RPMDownloadsGetThisURLLink(
			String donwloadFileName,String chromeFileName) {
		logger.info("Verifying Splunk Hunk .deb  downloads Get This URL");

		splunkHunk.verifySplunkHunkDownloadsGetThisURLLink(donwloadFileName, chromeFileName,
				"Linux64 Bit");

		logger.info("Verified Splunk  Hunk .deb downloads Get This URL");
	}
	
	
}
