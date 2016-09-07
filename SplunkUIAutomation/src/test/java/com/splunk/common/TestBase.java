package com.splunk.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.splunk.util.ExcelUtil;
import com.splunk.util.LogUtil;

/**
 * @author Avneet Dhanoa
 * 
 * */


public abstract class TestBase {

	protected static WebDriver driver;
	private static Log logger = LogUtil.getLog(TestBase.class);

	@BeforeSuite(alwaysRun = true)
	public void prepareBeforeSuite() {
		logger.info("info - Invoking before Suite method ");
		if (Boolean.valueOf(PropertyManager.getProperty("isSauce"))) {
			driver = SauceWebDriver.getWebDriver();
		} else {
			driver = WebDriverManager.getWebDriver();
		}

		logger.info("info - Invoking Before Suite method");
	}

	@AfterMethod(alwaysRun = true)
	public void prepareBeforeMethod(){
	}
	
//	@AfterMethod(alwaysRun = true)
	public void prepareAfterMethod(){
	}
	
	
	// @AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result) throws IOException {
		logger.info("info - End test test case method " + result.getName());
		if (!result.isSuccess()) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat(
					"dd_MM_yyyy_hh_mm_ss");
			String destFileName = result.getInstanceName() + "_"
					+ result.getName() + "_"
					+ formater.format(calendar.getTime()) + ".png";
			String destDir = PropertyManager
					.getProperty("screenshot_directory");

			File sourceFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(sourceFile, new File(destDir + "/"
					+ destFileName));
			String screenshotPath = destDir + "/" + destFileName;
			Reporter.setEscapeHtml(false);

			Reporter.log("Failed_Test_Case <a href = " + screenshotPath
					+ "</a>");
			// Reporter.setCurrentTestResult(result);
		}
	}

	//@AfterSuite(alwaysRun = true)
	public void prepareAfterSuite() {
		logger.info("info - End of the Suite ");
		driver.close();
		driver.quit();
		logger.info("info - Driver has been closed ");
	}

	@DataProvider(name = "homePage")
	public static Object[][] DP1(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("HomePage", Tag);
		return testData;
	}

	@DataProvider(name = "footerPage")
	public static Object[][] DP2(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("FooterPage", Tag);
		return testData;
	}
	
	@DataProvider(name = "UserGroups")
	public static Object[][] DP9(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("UserGroups", Tag);
		return testData;
	}
	
	@DataProvider(name = "globalFooter")
	public static Object[][] DP3(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("GlobalFooter", Tag);
		return testData;
	}
	
	@DataProvider(name = "splunkLight")
	public static Object[][] DP4(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("SplunkLight", Tag);
		return testData;
	}
	
	@DataProvider(name = "splunkSem")
	public static Object[][] DP5(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("SplunkSem", Tag);
		return testData;
	}
	
	@DataProvider(name = "splunkEnterprise")
	public static Object[][] DP6(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("SplunkEnterprise", Tag);
		return testData;
	}
	
	@DataProvider(name = "splunkHunk")
	public static Object[][] DP7(Method M) throws Exception {
		String Tag = M.getName();
		logger.info("Tag :: " + Tag);
		Object[][] testData = dataprovidercode("SplunkHunk", Tag);
		return testData;
	}
	
	/**
	 * DataDrivenTesting Reads the data from the specified Excel
	 * 
	 * @throws DataNotFoundException
	 */
	private static Object[][] dataprovidercode(String SheetName, String Tag)
			throws Exception {
		Object[][] testData = ExcelUtil.readExcelData(
				PropertyManager.getProperty("EXCEL.FILE.PATH"), SheetName, Tag);

		return testData;
		
	}}