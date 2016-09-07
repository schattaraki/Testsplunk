package com.splunk.tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.splunk.common.TestBase;
import com.splunk.pages.SplunkSemDownloadsPage;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */
public class SplunkSemDownloadsTest extends TestBase {
	SplunkSemDownloadsPage splunkSem;

	private static Log logger = LogUtil.getLog(SplunkSemDownloadsTest.class);

	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		try {
			splunkSem = new SplunkSemDownloadsPage(driver);
		} catch (Exception e) {
			logger.info("Error is:" + e);
		}
	}

	@Test(priority = 1, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" })
	public void testVerifyLandingPage(String title) {
		logger.info("Verifying Splunk Sem downloads landing page");
		
		splunkSem.getHomePage();
		Assert.assertEquals(driver.getTitle(), title,
				"Splunk Sem downloads title not matched");
		
		logger.info("Verified Splunk Sem downloads landing page");
	}

	/*@Test(priority = 2, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage", enabled = true)
	public void testVerifySplunkSemWindows64Downloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem download functionality");
		
		splunkSem.verifySplunkSemWindows64Downloads(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk Sem download functionality");
	}

	@Test(priority = 3, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64DownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Downloads Not Started Link functionality");
		
		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName , "Windows64 Bit");

		logger.info("Verified Splunk Sem  Downloads Not Started Link functionality");
	}

	@Test(priority = 5, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64DownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem downloads Get This URL");
		
		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName , "Windows64 Bit");

		logger.info("Verified Splunk Sem downloads Get This URL");
	}

	@Test(priority = 4, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows64MD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Sem MD5 downloads functionality");
		
		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, "Windows64 Bit");

		logger.info("Verified Splunk Sem MD5 downloads functionality");
	}
	
	@Test(priority = 6, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows32ZIPDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows32 download functionality");

		splunkSem.verifySplunkSemWindows32ZIPDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Windows32 download functionality");
	}

	@Test(priority = 7, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows32ZIPDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows32 Downloads Not Started Link functionality");

		splunkSem
				.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Sem  Windows32 Downloads Not Started Link functionality");
	}


	@Test(priority = 8, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows32ZIPMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows32 MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Sem Windows32 MD5 downloads functionality");
	}
	
	@Test(priority = 9, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows32ZIPDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows32 downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Windows32 Bit ZIP ");

		logger.info("Verified Splunk Sem Windows32 downloads Get This URL");
	}
	
	@Test(priority = 10, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemWindows86MSIDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows86 MSI download functionality");

		splunkSem.verifySplunkSemWindows86MSIDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Windows86 MSI download functionality");
	}

	@Test(priority = 11, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows86MSIDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows86 MSI Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Sem  Windows86 MSI Downloads Not Started Link functionality");
	}

	@Test(priority = 12, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows86MSIMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows86 MSI MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Sem Windows86 MSI MD5 downloads functionality");
	}

	@Test(priority = 13, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemWindows86MSIDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Windows86 MSI downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Windows86 MSI ");

		logger.info("Verified Splunk Sem Windows86 MSI downloads Get This URL");
	}
	
	@Test(priority = 14, dataProvider = "splunkSem", groups = { "Regression",
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
	
	@Test(priority = 18, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64tgzDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 tgz download functionality");

		splunkSem.verifySplunkSemKernelLinuxDistributions64tgzDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 tgz download functionality");
	}

	@Test(priority = 19, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64tgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 tgz Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Sem  Kernel Linux Distributions 64 tgz Downloads Not Started Link functionality");
	}

	@Test(priority = 20, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64tgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 tgz MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 tgz MD5 downloads functionality");
	}

	@Test(priority = 21, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64tgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 tgz downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Linux Distributions 64 tgz ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 tgz downloads Get This URL");
	}
	
	@Test(priority = 22, dataProvider = "splunkSem", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debDownloads(String username,
		String password, String pageTitle, String donwloadFileName) {
	logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 64.deb download functionality");
	
	splunkSem.verifySplunkSemKernelLinuxDistributionsamd64debDownloads(username, password,
			pageTitle, donwloadFileName);
	
	logger.info("Verified Splunk Sem Kernel Linux Distributions amd 64.deb download functionality");
	}
	
	@Test(priority = 23, dataProvider = "splunkSem", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debDownloadsNotStartedLink(
		String donwloadFileName) {
	logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 64.deb Downloads Not Started Link functionality");
	
	splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Sem  Kernel Linux Distributions amd 64.deb Downloads Not Started Link functionality");
	}
	
	@Test(priority = 24, dataProvider = "splunkSem", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debMD5Downloads(
		String donwloadFileName) {
	logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 64.deb MD5 downloads functionality");
	
	splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Sem Kernel Linux Distributions amd 64.deb MD5 downloads functionality");
	}
	
	@Test(priority = 25, dataProvider = "splunkSem", groups = { "Regression",
		"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd64debDownloadsGetThisURLLink(
		String donwloadFileName) {
	logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 64.deb downloads Get This URL");
	
	splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
			"amd 64.deb ");
	
	logger.info("Verified Splunk Sem Kernel Linux Distributions amd 64.deb downloads Get This URL");
	}
	
	@Test(priority = 26, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 .rpm download functionality");

		splunkSem.verifySplunkSemKernelLinuxDistributions64rpmDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 .rpm download functionality");
	}

	@Test(priority = 27, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 .rpm Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"64 .rpm ");

		logger.info("Verified Splunk Sem  Kernel Linux Distributions 64 .rpm  Downloads Not Started Link functionality");
	}

	@Test(priority = 28, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 .rpm MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, "64 .rpm ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 .rpm MD5 downloads functionality");
	}

	@Test(priority = 29, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions64rpmDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 64 .rpm downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"64 .rpm ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 64 .rpm downloads Get This URL");
	}*/
	
	@Test(priority = 30, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32tgzDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 tgz download functionality");

		splunkSem.verifySplunkSemKernelLinuxDistributions32tgzDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 tgz download functionality");
	}

	@Test(priority = 31, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32tgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 tgz Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Sem  Kernel Linux Distributions 32 tgz Downloads Not Started Link functionality");
	}

	@Test(priority = 32, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32tgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 tgz MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 tgz MD5 downloads functionality");
	}

	@Test(priority = 33, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32tgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 tgz downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Linux Distributions 32 tgz ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 tgz downloads Get This URL");
	}

	@Test(priority = 34, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd32debDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 32.deb download functionality");

		splunkSem.verifySplunkSemKernelLinuxDistributionsamd32debDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Kernel Linux Distributions amd 64.deb download functionality");
	}

	@Test(priority = 35, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd32debDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 32.deb Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"amd 32.deb ");

		logger.info("Verified Splunk Sem  Kernel Linux Distributions amd 32.deb Downloads Not Started Link functionality");
	}

	@Test(priority = 36, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd32debMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 32.deb MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, "amd 32.deb ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions amd 32.deb MD5 downloads functionality");
	}

	@Test(priority = 37, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributionsamd32debDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions amd 32.deb downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"amd 32.deb ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions amd 32.deb downloads Get This URL");
	}

	@Test(priority = 38, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",     enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32rpmDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 .rpm download functionality");

		splunkSem.verifySplunkSemKernelLinuxDistributions32rpmDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 .rpm download functionality");
	}

	@Test(priority = 39, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32rpmDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 .rpm Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"32 .rpm ");

		logger.info("Verified Splunk Sem  Kernel Linux Distributions 32 .rpm  Downloads Not Started Link functionality");
	}

	@Test(priority = 40, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32rpmMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 .rpm MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, "32 .rpm ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 .rpm MD5 downloads functionality");
	}

	@Test(priority = 41, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemKernelLinuxDistributions32rpmDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Kernel Linux Distributions 32 .rpm downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"32 .rpm ");

		logger.info("Verified Splunk Sem Kernel Linux Distributions 32 .rpm downloads Get This URL");
	}
	
/*	@Test(priority = 42, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemSolaris64tarZDownloads(
			String username, String password, String pageTitle,
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64tarZ download functionality");

		splunkSem.verifySplunkSemSolaris64tarZDownloads(
				username, password, pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Solaris 64 tarZ download functionality");
	}

	@Test(priority = 43, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64tarZDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 tarZ Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 tarZ ");

		logger.info("Verified Splunk Sem  Solaris 64 tarZ  Downloads Not Started Link functionality");
	}

	@Test(priority = 44, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64tarZMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 tarZ MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, "Solaris 64 tarZ ");

		logger.info("Verified Splunk Sem Solaris 64 tarZ MD5 downloads functionality");
	}

	@Test(priority = 45, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64tarZDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 tarZ downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 tarZ ");

		logger.info("Verified Splunk Sem Solaris 64 tarZ downloads Get This URL");
	}
	
	@Test(priority = 46, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemSolaris64pkgZDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 pkgZ download functionality");

		splunkSem.verifySplunkSemSolaris64pkgZDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Solaris 64 pkgZ download functionality");
	}

	@Test(priority = 47, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64pkgZDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 pkgZ Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Sem  Solaris 64 pkgZ  Downloads Not Started Link functionality");
	}

	@Test(priority = 48, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64pkgZMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 pkgZ MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Sem Solaris 64 pkgZ MD5 downloads functionality");
	}

	@Test(priority = 49, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64pkgZDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 pkgZ downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 pkgZ ");

		logger.info("Verified Splunk Sem Solaris 64 pkgZ downloads Get This URL");
	}*/
	
	@Test(priority = 50, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",    enabled = true)
	public void testVerifySplunkSemSolaris64p5pDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 p5p download functionality");

		splunkSem.verifySplunkSemSolaris64p5pDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem Solaris 64 p5p download functionality");
	}

	@Test(priority = 51, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64p5pDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 p5p Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Sem  Solaris 64 p5p  Downloads Not Started Link functionality");
	}

	@Test(priority = 52, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64p5pMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 p5p MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Sem Solaris 64 p5p MD5 downloads functionality");
	}

	@Test(priority = 53, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemSolaris64p5pDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem Solaris 64 p5p downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				"Solaris 64 p5p ");

		logger.info("Verified Splunk Sem Solaris 64 p5p downloads Get This URL");
	}
	
	/*@Test(priority = 54, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXtgzDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX tgz download functionality");

		splunkSem.verifySplunkSemOSXtgzDownloads(username, password,
				pageTitle, donwloadFileName);

		logger.info("Verified Splunk Sem OSX tgz download functionality");
	}

	@Test(priority = 55, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXtgzDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX tgz Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Sem  OSX tgz  Downloads Not Started Link functionality");
	}

	@Test(priority = 56, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXtgzMD5Downloads(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX tgz MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Sem OSX tgz MD5 downloads functionality");
	}

	@Test(priority = 57, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXtgzDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX tgz downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				" OSX tgz ");

		logger.info("Verified Splunk Sem OSX tgz downloads Get This URL");
	}
	
	@Test(priority = 58, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",     enabled = true)
	public void testVerifySplunkSemOSXdmgDownloads(String username,
			String password, String pageTitle, String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX dmg download functionality");

		splunkSem.verifySplunkSemOSXdmgDownloads(username, password, pageTitle,
				donwloadFileName);

		logger.info("Verified Splunk Sem OSX dmg download functionality");
	}

	@Test(priority = 59, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXdmgDownloadsNotStartedLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX dmg Downloads Not Started Link functionality");

		splunkSem.verifySplunkSemDownloadsNotStartedLink(donwloadFileName,
				" OSX dmg ");

		logger.info("Verified Splunk Sem  OSX dmg  Downloads Not Started Link functionality");
	}

	@Test(priority = 60, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXdmgMD5Downloads(String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX dmg MD5 downloads functionality");

		splunkSem.verifySplunkSemMD5Downloads(donwloadFileName, " OSX dmg ");

		logger.info("Verified Splunk Sem OSX dmg MD5 downloads functionality");
	}

	@Test(priority = 61, dataProvider = "splunkSem", groups = { "Regression",
			"Sanity" }, dependsOnMethods = "testVerifyLandingPage",   enabled = true)
	public void testVerifySplunkSemOSXdmgDownloadsGetThisURLLink(
			String donwloadFileName) {
		logger.info("Verifying Splunk Sem OSX dmg downloads Get This URL");

		splunkSem.verifySplunkSemDownloadsGetThisURLLink(donwloadFileName,
				" OSX dmg ");

		logger.info("Verified Splunk Sem OSX dmg downloads Get This URL");
	}*/
}
