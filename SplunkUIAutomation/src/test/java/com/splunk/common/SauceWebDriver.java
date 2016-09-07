package com.splunk.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Avneet Dhanoa
 */

public class SauceWebDriver {
	static final Logger logger = Logger.getLogger(SauceWebDriver.class);
	
	public static WebDriver getWebDriver() {
		String browser = PropertyManager.getProperty("browser");
		String downloadsPath = PropertyManager.getProperty("downloads1");
		DesiredCapabilities desiredCapabilities = null;
		logger.info("**************** Test execution started using Sauce Labs ****************");
		try {
			// Choose the browser, version, and platform to test
			WebDriver driver;
			if ("firefox".equalsIgnoreCase(browser)) {
			
			desiredCapabilities = DesiredCapabilities.firefox();
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.helperapps.neverAsk.saveToDisk",
					"image/jpg,text/csv,text/xml,application/xml,"
							+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/csv");
			
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", downloadsPath);
			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"application/x-msi, application/zip, application/octet-stream, application/x-compressed, application/x-tar, application/gzip , application/x-tar-gz, application/x-newton-compatible-pkg, audio/x-pn-realaudio-plugin, application/gnutar, application/x-rpm, application/x-gzip, application/vnd.debian.binary-package, application/x-apple-diskimage, application/x-gtar tar.gz tgz tar.bz2 tbz2 tbz, application/x-bzip2 bz2, application/x-gzip  gz, x-world/x-3dmf, text/plain, text/x-pascal");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/x-msi, application/zip, application/octet-stream, application/x-compressed, application/x-tar, application/gzip, application/x-tar-gz, application/x-newton-compatible-pkg, audio/x-pn-realaudio-plugin, application/gnutar, application/x-rpm, application/x-gzip, application/vnd.debian.binary-package, application/x-apple-diskimage , application/x-gtar tar.gz tgz tar.bz2 tbz2 tbz, application/x-bzip2 bz2, application/x-gzip  gz, x-world/x-3dmf, text/plain, text/x-pascal, text/x-pascal");
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.closeWhenDone", false);	
			desiredCapabilities.setCapability(FirefoxDriver.PROFILE, profile);
			
		}else if("chrome".equalsIgnoreCase(browser)){
			desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability("chromedriverVersion",PropertyManager.getProperty("chromedriverVersion"));
		}else if("ie".equalsIgnoreCase(browser)){
			desiredCapabilities = DesiredCapabilities.internetExplorer();
		}
			desiredCapabilities.setCapability("build", "WebMkt-QA-Automation");
			desiredCapabilities.setCapability("tags", System.getenv("JENKINS_BUILD_NUMBER"));
			if(System.getenv("JOB_NAME") != null){
				desiredCapabilities.setCapability("name", System.getenv("JOB_NAME") + "_" + System.getenv("JENKINS_BUILD_NUMBER"));
			}else{
				desiredCapabilities.setCapability("name", "Local Build");
			}
			desiredCapabilities.setCapability("browserName",PropertyManager.getProperty("browser"));
			desiredCapabilities.setCapability("version", PropertyManager.getProperty("browserversion"));
			desiredCapabilities.setCapability("platform", PropertyManager.getProperty("platform"));
			
			desiredCapabilities.setCapability("seleniumVersion", PropertyManager.getProperty("seleniumVersion"));
			desiredCapabilities.setCapability("tunnelIdentifier", PropertyManager.getProperty("tunnelName"));
			desiredCapabilities.setCapability("screen-resolution","1280x1024");

			

			

			/*
			 * desiredCapabilities.setBrowserName(System.getenv(
			 * "SELENIUM_BROWSER")); System.out.println(
			 * "\n System.getenv('SELENIUM_BROWSER'): " +
			 * System.getenv("SELENIUM_BROWSER"));
			 * 
			 * desiredCapabilities.setCapability("version",
			 * System.getenv("SELENIUM_VERSION")); System.out.println(
			 * "\n version: " + System.getenv("SELENIUM_VERSION"));
			 * 
			 * desiredCapabilities.setCapability("platform",
			 * System.getenv("SELENIUM_PLATFORM")); System.out.println(
			 * "\n platform: " + System.getenv("SELENIUM_PLATFORM"));
			 * 
			 * desiredCapabilities.setCapability("resolution",
			 * System.getenv("SELENIUM_RESOLUTION")); System.out.println(
			 * "\n resolution" + System.getenv("SELENIUM_RESOLUTION"));
			 * 
			 * desiredCapabilities.setCapability("tags",
			 * System.getenv("SELENIUM_TAGS")); System.out.println("\n tags: " +
			 * System.getenv("SELENIUM_TAGS"));
			 */

			// Create the connection to Sauce Labs to run the tests
			driver = new RemoteWebDriver(
					new URL("http://solutions_ui:d374fc13-60f1-4823-8e36-5dbfbde29311@ondemand.saucelabs.com:80/wd/hub"),
					desiredCapabilities);
			logger.info("\n Sauce Connection Succesful \n");
			getSauceEnvURI(driver);
			return driver;
		} catch (MalformedURLException e) {
			logger.info("\n\n Sauce Connection Failedl \n\n");
			e.printStackTrace();
		}

		return null;
	}

	public static void getSauceEnvURI(WebDriver driver) {

		// Based Upon Environment specified In config, Webdriver will get the
		// URL to run Automation Suite

		/*
		 * if (System.getenv("SELENIUM_TAGS").contains("QA")) { logger.info(
		 * "\n\n*****\n QA Env Selected" + "\n\n*****\n");
		 * WebDriverManager.getQAEnvURI(driver); } else if
		 * (System.getenv("SELENIUM_TAGS").contains("STG")) { logger.info(
		 * "\n\n*****\n STG Env Selected" + "\n\n*****\n");
		 * WebDriverManager.getStgEnvURI(driver); } else if
		 * (System.getenv("SELENIUM_TAGS").contains("UAT")) { logger.info(
		 * "\n\n*****\n UAT Env Selected" + "\n\n*****\n");
		 * WebDriverManager.getUserGroupQAEnvURI(driver); } else {
		 * driver.quit(); System.out.println(
		 * "\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n"); logger.info(
		 * "\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n"); }
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 * driver.manage().deleteAllCookies();
		 */

		// Based Upon Environment specified In config Webdriver will get the
		// URL to run Automation Suite

		if (Boolean.valueOf(PropertyManager.getProperty("qaEnv"))) {
			logger.info("\n\n*****\n QA Env Selected" + "\n\n*****\n");
			WebDriverManager.getQAEnvURI(driver);
		} else if	 (Boolean.valueOf(PropertyManager.getProperty("stgEnv"))) {
			logger.info("\n\n*****\n STAGE Env Selected" + "\n\n*****\n");
			//driver.get("http://www.staging.splunk.com/");
			WebDriverManager.getStgEnvURI(driver);
		}else if (Boolean.valueOf(PropertyManager.getProperty("prodEnv"))) {
			logger.info("\n\n*****\n PRODUCTION Env Selected" + "\n\n*****\n");
			//driver.get("http://www.staging.splunk.com/");
			WebDriverManager.getProdEnvURI(driver);
		} else if (Boolean.valueOf(PropertyManager.getProperty("qaUserGroupEnv"))) {
			logger.info("\n\n*****\n QA User Group Env Selected" + "\n\n*****\n");
			WebDriverManager.getUserGroupQAEnvURI(driver);
		} else if (Boolean.valueOf(PropertyManager.getProperty("stgUserGroupEnv"))) {
			logger.info("\n\n*****\n STAGE User Group Env Selected" + "\n\n*****\n");
			WebDriverManager.getUserGroupSTGEnvURI(driver);
		} else {
			driver.quit();
			System.out.println("\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n");
			logger.info("\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		/*if (Boolean.valueOf(PropertyManager.getProperty("isSauce"))) {
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
		}	*/

	}

}
