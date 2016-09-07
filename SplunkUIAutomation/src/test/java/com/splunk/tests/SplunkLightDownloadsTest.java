package com.splunk.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.pages.SplunkLightDownloadsPage;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */
public class SplunkLightDownloadsTest extends TestBase {
	SplunkLightDownloadsPage splunkLight;

	private static Log logger = LogUtil.getLog(SplunkLightDownloadsTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			splunkLight = new SplunkLightDownloadsPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying Splunk light downloads landing page");
		
		splunkLight.getHomePage();
		Assert.assertEquals(driver.getTitle(), title,
				"Splunk light downloads title not matched");
		
		logger.info("Verified Splunk light downloads landing page");
	}

	@Test(priority = 2, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightDownloadsForWindows(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk light download functionality");
		
		splunkLight.verifySplunkLightDownloadsForWindows(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk light download functionality");
	}

	@Test(priority = 3, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightForWindowsDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk light Downloads Not Started Link functionality");
		
		splunkLight.verifySplunkLightDownloadsNotStartedLink(donwloadFileName, " Windows ");

		logger.info("Verified Splunk light  Downloads Not Started Link functionality");
	}

	

	@Test(priority = 4, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightForWindowsMD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk light MD5 downloads functionality");
		
		splunkLight.verifySplunkLightMD5Downloads(donwloadFileName, " Windows");

		logger.info("Verified Splunk light MD5 downloads functionality");
	}

	@Test(priority = 5, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightForWindowsDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk light Windows downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(donwloadFileName,
				" Windows ");

		logger.info("Verified Splunk light Windows downloads Get This URL");
	}
	
	@Test(priority = 6, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightDownloadsForLinux64RPM(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64 .RPM file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux64RPM(username, password, pageTitle,
				downloadFileName);

		logger.info("Verified Splunk light Linux 64 .RPM file download functionality");
	}

	@Test(priority = 7, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkLightForLinux64RPMDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64RPM Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName, " Linux 64RPM ");

		logger.info("Verified Splunk light  Linux 64RPM Downloads Not Started Link functionality");
	}

	

	@Test(priority = 8, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64RPMMD5Downloads(String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .RPM MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName, " Linux64 .RPM ");

		logger.info("Verified Splunk light Linux64 .RPM MD5 downloads functionality");
	}
	
	@Test(priority =9, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64RPMDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .RPM  downloads Get This URL");

		splunkLight
				.verifySplunkLightDownloadsGetThisURLLink(downloadFileName , " Linux64 .RPM ");

		logger.info("Verified Splunk light Linux64 .RPM  downloads Get This URL");
	}
	
	@Test(priority = 10, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForLinux64TGZ(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64 .TGZ file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux64TGZ(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light Linux 64 .TGZ file download functionality");
	}

	@Test(priority = 11, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64TGZDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64 .TGZ Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" Linux 64 .TGZ ");

		logger.info("Verified Splunk light  Linux 64 .TGZ Downloads Not Started Link functionality");
	}

	@Test(priority = 12, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64TGZMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .RPM MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" Linux64 .TGZ ");

		logger.info("Verified Splunk light Linux64 .TGZ MD5 downloads functionality");
	}

	@Test(priority = 13, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64TGZDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .TGZ  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" Linux64 .RPM ");

		logger.info("Verified Splunk light Linux64 .TGZ  downloads Get This URL");
	}
	
	@Test(priority = 14, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForLinux64DEB(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64 .DEB file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux64DEB(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light Linux 64 .DEB file download functionality");
	}

	@Test(priority = 15, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64DEBDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 64 .DEB Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" Linux 64 .DEB ");

		logger.info("Verified Splunk light  Linux 64 .DEB Downloads Not Started Link functionality");
	}

	@Test(priority = 16, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64DEBMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .DEB MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" Linux64 .DEB ");

		logger.info("Verified Splunk light Linux64 .DEB MD5 downloads functionality");
	}

	@Test(priority = 17, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux64DEBDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux64 .DEB  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" Linux64 .DEB ");

		logger.info("Verified Splunk light Linux64 .DEB  downloads Get This URL");
	}
	
	@Test(priority = 18, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForLinux32DEB(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .DEB file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux32DEB(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light Linux 32 .DEB file download functionality");
	}

	@Test(priority = 19, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32DEBDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .DEB Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" Linux 32 .DEB ");

		logger.info("Verified Splunk light  Linux 32 .DEB Downloads Not Started Link functionality");
	}

	@Test(priority = 20, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32DEBMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .DEB MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" Linux 32 .DEB ");

		logger.info("Verified Splunk light Linux 32 .DEB MD5 downloads functionality");
	}

	@Test(priority = 21, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32DEBDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .DEB  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" Linux 32 .DEB ");

		logger.info("Verified Splunk light Linux64 .DEB  downloads Get This URL");
	}
	
	@Test(priority = 22, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForLinux32TGZ(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .TGZ file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux32TGZ(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light Linux 32 .TGZ file download functionality");
	}

	@Test(priority = 23, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32TGZDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .TGZ Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" Linux 32 .TGZ ");

		logger.info("Verified Splunk light  Linux 32 .TGZ Downloads Not Started Link functionality");
	}

	@Test(priority = 24, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32TGZMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .TGZ MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" Linux 32 .TGZ ");

		logger.info("Verified Splunk light Linux 32 .TGZ MD5 downloads functionality");
	}

	@Test(priority = 25, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32TGZDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .TGZ  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" Linux 32 .TGZ ");

		logger.info("Verified Splunk light Linux64 .TGZ  downloads Get This URL");
	}
	
	@Test(priority = 26, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForLinux32RPM(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .RPM file download functionality");

		splunkLight.verifySplunkLightDownloadsLinux32RPM(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light Linux 32 .RPM file download functionality");
	}

	@Test(priority = 27, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32RPMDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .RPM Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" Linux 32 .RPM ");

		logger.info("Verified Splunk light  Linux 32 .RPM Downloads Not Started Link functionality");
	}

	@Test(priority = 28, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32RPMMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .RPM MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" Linux 32 .RPM ");

		logger.info("Verified Splunk light Linux 32 .RPM MD5 downloads functionality");
	}

	@Test(priority = 29, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForLinux32RPMDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light Linux 32 .RPM  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" Linux 32 .RPM ");

		logger.info("Verified Splunk light Linux32 .RPM  downloads Get This URL");
	}
	
	@Test(priority = 30, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForMACOSIntelDMG(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light MACOS Intel .DMG file download functionality");

		splunkLight.verifySplunkLightDownloadsMACOSIntelDMG(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light MACOS Intel .DMG file download functionality");
	}

	@Test(priority = 31, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSIntelDMGDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS Intel .DMG Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" MACOS Intel .DMG ");

		logger.info("Verified Splunk light  MACOS Intel .DMG Downloads Not Started Link functionality");
	}

	@Test(priority = 32, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSIntelDMGMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS Intel .DMG MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" MACOS Intel .DMG ");

		logger.info("Verified Splunk light MACOS Intel .DMG MD5 downloads functionality");
	}

	@Test(priority = 33, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSIntelDMGDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS Intel .DMG  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" MACOS Intel .DMG ");

		logger.info("Verified Splunk light MACOS Intel .DMG  downloads Get This URL");
	}
	
	@Test(priority = 34, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightDownloadsForMACOSTGZ(String username,
			String password, String pageTitle, String downloadFileName) {
		logger.info("Verifying Splunk light MACOS Intel .TGZ file download functionality");

		splunkLight.verifySplunkLightDownloadsMACOSTGZ(username, password,
				pageTitle, downloadFileName);

		logger.info("Verified Splunk light MACOS Intel .TGZ file download functionality");
	}

	@Test(priority = 35, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSTGZDownloadsNotStartedLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS .TGZ Downloads Not Started Link functionality");

		splunkLight.verifySplunkLightDownloadsNotStartedLink(downloadFileName,
				" MACOS .TGZ ");

		logger.info("Verified Splunk light  MACOS .DMG Downloads Not Started Link functionality");
	}

	@Test(priority = 36, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSTGZMD5Downloads(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS .TGZ MD5 downloads functionality");

		splunkLight.verifySplunkLightMD5Downloads(downloadFileName,
				" MACOS .TGZ ");

		logger.info("Verified Splunk light MACOS .TGZ MD5 downloads functionality");
	}

	@Test(priority = 37, dataProvider = "splunkLight", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",enabled = true)
	public void testVerifySplunkLightForMACOSTGZDownloadsGetThisURLLink(
			String downloadFileName) {
		logger.info("Verifying Splunk light MACOS .TGZ  downloads Get This URL");

		splunkLight.verifySplunkLightDownloadsGetThisURLLink(downloadFileName,
				" MACOS .TGZ ");

		logger.info("Verified Splunk light MACOS .TGZ  downloads Get This URL");
	}
}
