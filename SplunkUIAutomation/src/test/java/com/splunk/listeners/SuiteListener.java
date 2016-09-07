/*
 * 
 */
package com.splunk.listeners;

import java.io.File;

import org.apache.commons.logging.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.DateUtil;
import com.splunk.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving suite events. The class that is
 * interested in processing a suite event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addSuiteListener<code> method. When
 * the suite event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Maheshwar Kanchetty
 */

public class SuiteListener implements ISuiteListener, ITestListener {

	/** The log. */
	static Log log = LogUtil.getLog(SuiteListener.class);

	/** The is initialize. */
	static boolean isInitialize = false;
	// private String currentDirectoryPath = System.getProperty("user.dir");
	private String imagesFolderPath = PropertyManager
			.getProperty("screenshot_directory");

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
	 */
	public void onStart(ISuite arg0) {
		log.info("Suite name: " + arg0.getName() + " started.");
		try {
			// Delete all the images of screenshot folder
			deleteAllImages();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
	 */
	public void onFinish(ISuite arg0) {
		log.info("Suite Name :" + arg0.getName() + " - End");
		log.info("********Results*******");

	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test :" + result.getName() + " has been passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test :" + result.getName() + " has been failed");
		String methodName = result.getName().toString().trim();
		methodName = methodName
				+ DateUtil.getCurrentDateTime("MM_dd_yyyy_HH_mm_ss_Sz");
		try {
			BasePage.takeScreenShot(methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAllImages() {

		try {
			File folder = new File(imagesFolderPath);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length > 0) {
				for (File file : listOfFiles) {
					file.delete();
				}
			}
			File folder1 = new File(imagesFolderPath);
			File[] listOfFiles1 = folder1.listFiles();

			if (listOfFiles1.length == 0) {
				log.info("Screenshot folder: All the Images have been deleted");
			} else {
				log.info("Screenshot folder: All the Images are not deleted");
			}
		} catch (Exception e) {
			log.info("Error while deleting screen shots " + e.getStackTrace());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName().toString().trim();
		log.info("Test :" + methodName + " has been skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		log.info("***************** Test :" + context.getName()
				+ " execution has been started *****************");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("***************** Test :" + context.getName()
				+ " execution has been ended *****************");
	}
}