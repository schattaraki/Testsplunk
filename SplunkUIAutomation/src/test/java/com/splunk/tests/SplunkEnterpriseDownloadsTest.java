package com.splunk.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.pages.SplunkEnterpriseDownloadsPage;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */
public class SplunkEnterpriseDownloadsTest extends TestBase {
	SplunkEnterpriseDownloadsPage splunkEnterprise;

	private static Log logger = LogUtil.getLog(SplunkEnterpriseDownloadsTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			splunkEnterprise = new SplunkEnterpriseDownloadsPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying Splunk Enterprise downloads landing page");
		
		splunkEnterprise.getHomePage();
		Assert.assertEquals(driver.getTitle(), title,
				"Splunk Enterprise downloads title not matched");
		
		logger.info("Verified Splunk Enterprise downloads landing page");
	}

	@Test(priority = 2, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseWindows64Downloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise download functionality");
		
		splunkEnterprise.verifySplunkEnterpriseWindows64Downloads(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk Enterprise download functionality");
	}

	@Test(priority = 3, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows64DownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Downloads Not Started Link functionality");
		
		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName , "Windows64 Bit");

		logger.info("Verified Splunk Enterprise  Downloads Not Started Link functionality");
	}

	

	@Test(priority = 4, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows64MD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise MD5 downloads functionality");
		
		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, "Windows64 Bit");

		logger.info("Verified Splunk Enterprise MD5 downloads functionality");
	}
	
	@Test(priority = 5, dataProvider = "splunkEnterprise", groups = {
			"Regression", "Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkEnterpriseWindows64DownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Windows64 Bit");

		logger.info("Verified Splunk Enterprise downloads Get This URL");
	}
	
	/*@Test(priority = 6, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows32ZIPDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows32 download functionality");

		splunkEnterprise.verifySplunkEnterpriseWindows32ZIPDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Windows32 download functionality");
	}

	@Test(priority = 7, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows32ZIPDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows32 Downloads Not Started Link functionality");

		splunkEnterprise
				.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Enterprise  Windows32 Downloads Not Started Link functionality");
	}


	@Test(priority = 8, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows32ZIPMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows32 MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Enterprise Windows32 MD5 downloads functionality");
	}
	
	@Test(priority = 9, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows32ZIPDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows32 downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Enterprise Windows32 downloads Get This URL");
	}*/
	
	@Test(priority = 10, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseWindows86MSIDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows86 MSI download functionality");

		splunkEnterprise.verifySplunkEnterpriseWindows86MSIDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Windows86 MSI download functionality");
	}

	@Test(priority = 11, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows86MSIDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows86 MSI Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Enterprise  Windows86 MSI Downloads Not Started Link functionality");
	}

	@Test(priority = 12, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows86MSIMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows86 MSI MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Enterprise Windows86 MSI MD5 downloads functionality");
	}

	@Test(priority = 13, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseWindows86MSIDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Windows86 MSI downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Enterprise Windows86 MSI downloads Get This URL");
	}
	
	/*@Test(priority = 14, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64ZIPDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows64 ZIP download functionality");

		splunkSem.verifySplunkSemWindows64ZIPDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Windows64 ZIP download functionality");
	}

	@Test(priority = 15, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64ZIPDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows64 ZIP Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Windows64 ZIP ");

		logger.info("Verified Splunk Sem  Windows86 MSI Downloads Not Started Link functionality");
	}

	@Test(priority = 16, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64ZIPMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows64 ZIP MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Windows64 ZIP ");

		logger.info("Verified Splunk Sem Windows64 ZIP MD5 downloads functionality");
	}

	@Test(priority = 17, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64ZIPDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows64 ZIP downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Windows64 ZIP ");

		logger.info("Verified Splunk Sem Windows64 ZIP downloads Get This URL");
	}
*/	
	/*@Test(priority = 18, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions64tgzDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 tgz download functionality");

		splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributions64tgzDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 tgz download functionality");
	}

	@Test(priority = 19, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions64tgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 tgz Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Enterprise  Kernel Linux Distributions 64 tgz Downloads Not Started Link functionality");
	}

	@Test(priority = 20, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions64tgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 tgz MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 tgz MD5 downloads functionality");
	}

	@Test(priority = 21, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions64tgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 tgz downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 tgz downloads Get This URL");
	}
	
	@Test(priority = 22, dataProvider = "splunkEnterprise", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributionsamd64debDownloads(String username,
		String password, String pageTitle, String donwloadFileName) {
	logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 64.deb download functionality");
	
	splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributionsamd64debDownloads(username, password,
			pageTitle, donwloadFileName);
	
	logger.info("Verified Splunk Sem Kernel Linux Distributions amd 64.deb download functionality");
	}
	
	@Test(priority = 23, dataProvider = "splunkEnterprise", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debDownloadsNotStartedLink(
		String donwloadFileName) {
	logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 64.deb Downloads Not Started Link functionality");
	
	splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Enterprise  Kernel Linux Distributions amd 64.deb Downloads Not Started Link functionality");
	}
	
	@Test(priority = 24, dataProvider = "splunkEnterprise", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debMD5Downloads(
		String donwloadFileName) {
	logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 64.deb MD5 downloads functionality");
	
	splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Enterprise Kernel Linux Distributions amd 64.deb MD5 downloads functionality");
	}
	
	@Test(priority = 25, dataProvider = "splunkEnterprise", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debDownloadsGetThisURLLink(
		String donwloadFileName) {
	logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 64.deb downloads Get This URL");
	
	splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Enterprise Kernel Linux Distributions amd 64.deb downloads Get This URL");
	}
	
	@Test(priority = 26, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 .rpm download functionality");

		splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributions64rpmDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 .rpm download functionality");
	}

	@Test(priority = 27, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 .rpm Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"64 .rpm ");

		logger.info("Verified Splunk Enterprise  Kernel Linux Distributions 64 .rpm  Downloads Not Started Link functionality");
	}

	@Test(priority = 28, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 .rpm MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, "64 .rpm ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 .rpm MD5 downloads functionality");
	}

	@Test(priority = 29, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 64 .rpm downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"64 .rpm ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 64 .rpm downloads Get This URL");
	}*/
	
	@Test(priority = 30, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 tgz download functionality");

		splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributions32tgzDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 tgz download functionality");
	}

	@Test(priority = 31, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32tgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 tgz Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Enterprise  Kernel Linux Distributions 32 tgz Downloads Not Started Link functionality");
	}

	@Test(priority = 32, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32tgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 tgz MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 tgz MD5 downloads functionality");
	}

	@Test(priority = 33, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32tgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 tgz downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 tgz downloads Get This URL");
	}

	@Test(priority = 34, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributionsamd32debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 32.deb download functionality");

		splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributionsamd32debDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions amd 64.deb download functionality");
	}

	@Test(priority = 35, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributionsamd32debDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 32.deb Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"amd 32.deb ");

		logger.info("Verified Splunk Enterprise  Kernel Linux Distributions amd 32.deb Downloads Not Started Link functionality");
	}

	@Test(priority = 36, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd32debMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 32.deb MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, "amd 32.deb ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions amd 32.deb MD5 downloads functionality");
	}

	@Test(priority = 37, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributionsamd32debDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions amd 32.deb downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"amd 32.deb ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions amd 32.deb downloads Get This URL");
	}

	@Test(priority = 38, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",     enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 .rpm download functionality");

		splunkEnterprise.verifySplunkEnterpriseKernelLinuxDistributions32rpmDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 .rpm download functionality");
	}

	@Test(priority = 39, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32rpmDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 .rpm Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"32 .rpm ");

		logger.info("Verified Splunk Enterprise  Kernel Linux Distributions 32 .rpm  Downloads Not Started Link functionality");
	}

	@Test(priority = 40, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32rpmMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 .rpm MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, "32 .rpm ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 .rpm MD5 downloads functionality");
	}

	@Test(priority = 41, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseKernelLinuxDistributions32rpmDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Kernel Linux Distributions 32 .rpm downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"32 .rpm ");

		logger.info("Verified Splunk Enterprise Kernel Linux Distributions 32 .rpm downloads Get This URL");
	}
	
	
	@Test(priority = 42, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseSolaris64tarZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64tarZ download functionality");

		splunkEnterprise.verifySplunkEnterpriseSolaris64tarZDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Solaris 64 tarZ download functionality");
	}

	@Test(priority = 43, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64tarZDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 tarZ Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 tarZ ");

		logger.info("Verified Splunk Enterprise  Solaris 64 tarZ  Downloads Not Started Link functionality");
	}

	@Test(priority = 44, dataProvider = "splunkEnterprise", groups = { "Regression",
 "Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkEnterpriseSolaris64tarZMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 tarZ MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, "Solaris 64 tarZ ");

		logger.info("Verified Splunk Enterprise Solaris 64 tarZ MD5 downloads functionality");
	}

	@Test(priority = 45, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64tarZDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 tarZ downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 tarZ ");

		logger.info("Verified Splunk Enterprise Solaris 64 tarZ downloads Get This URL");
	}
	
	@Test(priority = 46, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseSolaris64pkgZDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 pkgZ download functionality");

		splunkEnterprise.verifySplunkEnterpriseSolaris64pkgZDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Solaris 64 pkgZ download functionality");
	}

	@Test(priority = 47, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64pkgZDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 pkgZ Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Enterprise  Solaris 64 pkgZ  Downloads Not Started Link functionality");
	}

	@Test(priority = 48, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64pkgZMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 pkgZ MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Enterprise Solaris 64 pkgZ MD5 downloads functionality");
	}

	@Test(priority = 49, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64pkgZDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 pkgZ downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Enterprise Solaris 64 pkgZ downloads Get This URL");
	}
	
	@Test(priority = 50, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseSolaris64p5pDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 p5p download functionality");

		splunkEnterprise.verifySplunkEnterpriseSolaris64p5pDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise Solaris 64 p5p download functionality");
	}

	@Test(priority = 51, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64p5pDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 p5p Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Enterprise  Solaris 64 p5p  Downloads Not Started Link functionality");
	}

	@Test(priority = 52, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64p5pMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 p5p MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Enterprise Solaris 64 p5p MD5 downloads functionality");
	}

	@Test(priority = 53, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseSolaris64p5pDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise Solaris 64 p5p downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Enterprise Solaris 64 p5p downloads Get This URL");
	}
	
	@Test(priority = 54, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXtgzDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX tgz download functionality");

		splunkEnterprise.verifySplunkEnterpriseOSXtgzDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Enterprise OSX tgz download functionality");
	}

	@Test(priority = 55, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXtgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX tgz Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Enterprise  OSX tgz  Downloads Not Started Link functionality");
	}

	@Test(priority = 56, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",  enabled = true)
	public void testVerifySplunkEnterpriseOSXtgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX tgz MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Enterprise OSX tgz MD5 downloads functionality");
	}

	@Test(priority = 57, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXtgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX tgz downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Enterprise OSX tgz downloads Get This URL");
	}
	
	@Test(priority = 58, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",     enabled = true)
	public void testVerifySplunkEnterpriseOSXdmgDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX dmg download functionality");

		splunkEnterprise.verifySplunkEnterpriseOSXdmgDownloads(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk Enterprise OSX dmg download functionality");
	}

	@Test(priority = 59, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXdmgDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX dmg Downloads Not Started Link functionality");

		splunkEnterprise.verifySplunkEnterpriseDownloadsNotStartedLink(donwloadFileName,
				" OSX dmg ");

		logger.info("Verified Splunk Enterprise  OSX dmg  Downloads Not Started Link functionality");
	}

	@Test(priority = 60, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXdmgMD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX dmg MD5 downloads functionality");

		splunkEnterprise.verifySplunkEnterpriseMD5Downloads(donwloadFileName, " OSX dmg ");

		logger.info("Verified Splunk Enterprise OSX dmg MD5 downloads functionality");
	}

	@Test(priority = 61, dataProvider = "splunkEnterprise", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkEnterpriseOSXdmgDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Enterprise OSX dmg downloads Get This URL");

		splunkEnterprise.verifySplunkEnterpriseDownloadsGetThisURLLink(donwloadFileName,
				" OSX dmg ");

		logger.info("Verified Splunk Enterprise OSX dmg downloads Get This URL");
	}
}
