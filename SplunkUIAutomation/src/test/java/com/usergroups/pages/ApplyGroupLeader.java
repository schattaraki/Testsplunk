package com.usergroups.pages;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.DateUtil;
import com.splunk.util.LogUtil;

/**prepareBeforeclass
 * 
 * @author schattaraki
 *
 */
public class ApplyGroupLeader extends BasePage {
	private static Log logger = LogUtil.getLog(CreateUserGroup.class);
	protected static String baseUrl=null;
	public static int index_event=0;
	public ApplyGroupLeader(WebDriver driver)
	{
		super(driver);
	
	}
//Get Home page
	public void getHomepage()
	{
		
		System.out.println("getHomepage @@@@@@@@@@@@@@@");
		if (PropertyManager.getProperty("qaEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qaurl");
		} else if(PropertyManager.getProperty("stgEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgurl");
		}else if (PropertyManager.getProperty("qaUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qausergroupsurl");
		} else if(PropertyManager.getProperty("stgUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgusergroupsurl");
		}
		System.out.println("After if getHomepage @@@@@@@@@@@@@@@");
		logger.info("\n\n" + "URL: " + baseUrl + "\n\n");
		System.out.println("getHomepage @@@@@@@@@@@@@@@");
		openUrl(driver,baseUrl);
		
	}
	public void getApplyGroupLeader(String firstName, String lastName,String emailID, String mobileNo, String country, String stateName,
			String postalCode, String issue,String username,String password) {
		
		String applyLeaderURL = "apply-leader.html";
		String baseURL = getBaseURL();
		logger.info(baseURL+applyLeaderURL);
		driver.navigate().to(baseURL+applyLeaderURL);
		clickOnElement("applyGroupLeaderButton");
		sleep(3000);
		
		//Login
		enterText("username_login",username);
		enterText("password_login",password);
		clickOnElement("submit_login");
		sleep(3000);
		
		clickOnElement("applyGroupLeaderButton");
		sleep(3000);
		/*enterText("firstName_field",firstName);
		enterText("lastName_field",lastName);
		enterText("emailId_field",emailID);*/
		enterText("mobile_field",mobileNo);
		enterText("country_field",country);
		enterText("state_field",stateName);
		enterText("postal_field",postalCode);
		enterText("message_field",issue);
		
		clickOnElement("showIntrest");
		
		clickOnElement("showIntrest1");
		sleep(30000);
//	clickOnElement("signUpButton");
		//sleep(3000);
	//	clickOnElement("userprofileName");
		
		//sleep(3000);
		//clickOnElement("logOutButton");
		logOutSplunkCom();
		
	}
	public void verifyShowInterest(String address,String username,String password)
	{
	
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement element = driver.findElement(By.xpath(PropertyManager.getProperty("findMoreGroupsInput")));
		element.sendKeys(Keys.ENTER);
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
		clickOnElement("KeepmeProceed");
		sleep(2000);
		WebElement signmeup = driver.findElement(By.xpath(PropertyManager.getProperty("Signmeup")));
		WaitForElementToBeClickable(signmeup);
		signmeup.click();
		loginSplunkCom(username,password);
		sleep(2000);
		logOutSplunkCom();
		
	//clickOnElement("findMoreGroupsInput");
		//WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
	//	waitForElementToBeVisible(selectlocation);
		//selectlocation.click();
		
	/*	sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000)*/;
		///WebElement clickOnFirstGroup = driver.findElement(By.xpath(PropertyManager.getProperty("firstGroupLink")));
		/*waitForElementToBeVisible(clickOnFirstGroup);
		clickOnFirstGroup.click();*/
	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();",clickOnFirstGroup);	
		
		
	}
	
	
	
	
}


