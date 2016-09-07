package com.splunk.common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.splunk.util.LogUtil;

/**
 * @author Avneet Dhanoa
 */

public class WebDriverManager {

	private static Log logger = LogUtil.getLog(WebDriverManager.class);
	public static WebDriver getWebDriver() {
		try {
			WebDriver driver;
			String browser = PropertyManager.getProperty("browser");
			String downloadsPath = PropertyManager.getProperty("downloads");
			logger.info("DBROWSER"+ System.getProperty("BROWSER"));
			logger.info("DTESTENV"+ System.getProperty("TESTENV"));
			logger.info("DGROUPS"+ System.getProperty("GROUPS"));
			if ("firefox".equalsIgnoreCase(browser)) {
				FirefoxProfile profile = new FirefoxProfile();
				/*profile.setPreference("browser.helperapps.neverAsk.saveToDisk",
						"image/jpg,text/csv,text/xml,application/xml,"
								+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/csv");*/
				
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.download.dir", downloadsPath);
				profile.setPreference("browser.helperApps.neverAsk.openFile",
						"application/x-msi, application/zip, application/octet-stream, application/x-compressed, application/x-tar, application/gzip , application/x-tar-gz, application/x-newton-compatible-pkg, audio/x-pn-realaudio-plugin, application/gnutar, application/x-rpm, application/x-gzip, application/vnd.debian.binary-package, application/x-apple-diskimage, application/x-gtar tar.gz tgz tar.bz2 tbz2 tbz, application/x-bzip2 bz2, application/x-gzip  gz, x-world/x-3dmf, text/plain, text/x-pascal");
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/x-msi, application/zip, application/octet-stream, application/x-compressed, application/x-tar, application/gzip, application/x-tar-gz, application/x-newton-compatible-pkg, audio/x-pn-realaudio-plugin, application/gnutar, application/x-rpm, application/x-gzip, application/vnd.debian.binary-package, application/x-apple-diskimage , application/x-gtar tar.gz tgz tar.bz2 tbz2 tbz, application/x-bzip2 bz2, application/x-gzip  gz, x-world/x-3dmf, text/plain, text/x-pascal, text/x-pascal");
				
				/*profile.setPreference("browser.helperApps.neverAsk.openFile",
						"application/x-msi, application/octet-stream");
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/x-msi, application/octet-stream");*/
				
				
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				profile.setPreference("browser.download.manager.showAlertOnComplete", false);
				profile.setPreference("browser.download.manager.closeWhenDone", false);
				
				driver = new FirefoxDriver(profile);

			} else if ("ie".equalsIgnoreCase(browser)) {
				File file = new File(PropertyManager.getProperty("IEServerPath"));
				// get the path of webdriver exe
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				driver = new InternetExplorerDriver(capabilities);

			} else if ("chrome".equalsIgnoreCase(browser)) {
				File file = new File(PropertyManager.getProperty("ChromeServerPath"));
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				driver = new ChromeDriver(options);

			} else {
				driver = new HtmlUnitDriver();
			}
			getEnvURI(driver);
			return driver;
		} catch (Exception ex) {
			System.out.println("Exception Occured in method: Inside Get Web Driver: " + ex.getMessage());
		}
		return null;

	}

	public static void getEnvURI(WebDriver driver) {
		Logger logger = Logger.getLogger(WebDriverManager.class);

		// Based Upon Environment specified In config Webdriver will get the
		// URL to run Automation Suite

		if (Boolean.valueOf(PropertyManager.getProperty("qaEnv"))) {
			logger.info("\n\n*****\n QA Env Selected" + "\n\n*****\n");
			getQAEnvURI(driver);
		} else if (Boolean.valueOf(PropertyManager.getProperty("stgEnv"))) {
			logger.info("\n\n*****\n STAGE Env Selected" + "\n\n*****\n");
			getStgEnvURI(driver);
		}else if (Boolean.valueOf(PropertyManager.getProperty("prodEnv"))) {
			logger.info("\n\n*****\n PRODUCTION Env Selected" + "\n\n*****\n");
			getProdEnvURI(driver);
		} 
		else if (Boolean.valueOf(PropertyManager.getProperty("qaUserGroupEnv"))) {
			logger.info("\n\n*****\n QA User Group Env Selected" + "\n\n*****\n");
			getUserGroupQAEnvURI(driver);
		} else if (Boolean.valueOf(PropertyManager.getProperty("stgUserGroupEnv"))) {
			logger.info("\n\n*****\n STAGE User Group Env Selected" + "\n\n*****\n");
			getUserGroupSTGEnvURI(driver);
		} else {
			driver.quit();
			System.out.println("\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n");
			logger.info("\n\nNO ENVIRONMENT SPECIFIED TO RUN \n\n");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static void getQAEnvURI(WebDriver driver) {

		driver.get(PropertyManager.getProperty("qaurl"));
	}

	public static void getUserGroupSTGEnvURI(WebDriver driver) {

		driver.get(PropertyManager.getProperty("stgusergroupsurl"));
	}

	public static void getStgEnvURI(WebDriver driver) {

		logger.info("Splunk com stg URL::"+PropertyManager.getProperty("stgurl"));
		driver.get(PropertyManager.getProperty("stgurl"));
	}
	
	public static void getProdEnvURI(WebDriver driver) {

		logger.info("Splunk com Prod URL::"+PropertyManager.getProperty("produrl"));
		driver.get(PropertyManager.getProperty("produrl"));
	}

	public static void getUserGroupQAEnvURI(WebDriver driver) {

		driver.get(PropertyManager.getProperty("qausergroupsurl"));
	}
}
