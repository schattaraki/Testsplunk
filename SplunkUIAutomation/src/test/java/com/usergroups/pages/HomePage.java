package com.usergroups.pages;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.DateUtil;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */

public class HomePage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	protected static String baseUrl=null;
	private static Log logger = LogUtil.getLog(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}


	// Get HomePage
	public void getHomePage() {
		
		if (PropertyManager.getProperty("qaEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qaurl");
		} else if(PropertyManager.getProperty("stgEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgurl");
		}else if (PropertyManager.getProperty("qaUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("qausergroupsurl");
		} else if(PropertyManager.getProperty("stgUserGroupEnv").equalsIgnoreCase(("true"))) {
			baseUrl = PropertyManager.getProperty("stgusergroupsurl");
		}
		logger.info("\n\n" + "URL: " + baseUrl + "\n\n");
		openUrl(driver,baseUrl);
	}


	/*public void verifyCreateGroupFuntionality(String username, String password) {
		loginSplunkCom(username, password);
		sleep(2000);
		logger.info("Page TItle::"+driver.getTitle());
		driver.navigate().to(baseUrl+"admin");
		logger.info("Page TItle::"+driver.getTitle());
	}*/

	public void verifyCreateGroupFuntionality(String username, String password,String groupNameText,String desc,String leaderText,String locationText,String tags) {
		boolean groupSucessFlag = false;
		try{
			//Click on dash board and navigate to login page
			clickOnDashboardLoginLink();
			
			//Login functionality
			loginSplunkCom(username, password);
			
			String currentUrl = baseUrl.split(".splunk.com")[0];
			currentUrl = currentUrl+".splunk.com/admin";
			logger.info("currentUrl ::"+currentUrl);
			sleep(2000);
			driver.navigate().to(currentUrl);
			WebElement newGroup = driver.findElement(By.xpath(PropertyManager.getProperty("createNewGroupButton")));
			WaitForElementToBeClickable(newGroup);
			newGroup.click();
			sleep(2000);
			WebElement groupName = driver.findElement(By.xpath(PropertyManager.getProperty("groupName")));
			String myGroupName = groupNameText+" "+DateUtil.getCurrentDateTime("MM_dd_yyyy_HH_mm_ss_Sz");
			groupName.sendKeys(myGroupName);
			
			enterText("description",desc);
			
			enterText("leader",leaderText);
			sleep(2000);
			
			WebElement selectLeader = driver.findElement(By.xpath(PropertyManager.getProperty("selectLeader")));
			waitForElementToBeVisible(selectLeader);
			selectLeader.click();
			
			enterText("location",locationText);
			sleep(2000);
			
			WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectlocation")));
			waitForElementToBeVisible(selectlocation);
			selectlocation.click();
			
			
			enterText("tags",tags);
			
			verifyAndClick(driver.findElement(By.xpath(PropertyManager.getProperty("createGroupBtn"))));
			sleep(5000);
			int count=0;
			while(count<=15){
				boolean progressBarDisplayed = driver.findElement(By.xpath(PropertyManager.getProperty("createGroupProgressBar"))).isDisplayed();
				logger.info("Count :" +count+ ", progress Bar Displayed :"+progressBarDisplayed);
				if(!progressBarDisplayed){
					break;
				}else{
					sleep(10000);
				}
				count++;
			}
			
			List<WebElement> allActiveUserGroups = driver.findElements(By.xpath(PropertyManager.getProperty("activeUserGroups")));
			 for (WebElement webElement : allActiveUserGroups) {
				if( webElement.getText().equalsIgnoreCase((myGroupName))){
					groupSucessFlag=true;
				}
			}
			
		}catch(Exception e){
			
			logger.info("Error while creating new group: "
					+ e.getMessage());
			Assert.fail("Error while creating new group");
		}
		driver.navigate().refresh();
		logOutSplunkCom();
		Assert.assertTrue(groupSucessFlag,"Group not created");
	}

//Join this Group functionality
	public void joinThisGroup(String username,String password,String address) {
		driver.navigate().to(baseUrl);
		loginSplunkCom(username, password);
		
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
		WebElement clickOnFirstGroup = driver.findElement(By.xpath(PropertyManager.getProperty("firstGroupLink")));
		/*waitForElementToBeVisible(clickOnFirstGroup);
		clickOnFirstGroup.click();*/
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",clickOnFirstGroup);
		
		WebElement joinGroup = driver.findElement(By.xpath(PropertyManager.getProperty("joinThisGroupLink")));
		waitForElementToBeVisible(joinGroup);
		joinGroup.click();
		
		sleep(5000);
		
//		boolean joinGroupBtn = driver.findElement(By.xpath(PropertyManager.getProperty("joinThisGroupLink"))).isEnabled();
		boolean joinGroupBtn = driver.findElement(By.xpath(PropertyManager.getProperty("joinThisGroupLink"))).isDisplayed();
		
		
		logger.info("joinGroupBtn::"+joinGroupBtn);
		
		logOutSplunkCom();
		
		Assert.assertTrue(joinGroupBtn,"Join this Group not working");
	}

	//Leave this Group functionality
	public void leaveThisGroup(String username,String password,String address) {
		driver.navigate().to(baseUrl);
		loginSplunkCom(username, password);
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
		WebElement clickOnFirstGroup = driver.findElement(By.xpath(PropertyManager.getProperty("firstGroupLink")));
		/*waitForElementToBeVisible(clickOnFirstGroup);
		clickOnFirstGroup.click();*/
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",clickOnFirstGroup);
		
		WebElement joinGroup = driver.findElement(By.xpath(PropertyManager.getProperty("leaveThisGroupLink")));
		waitForElementToBeVisible(joinGroup);
		joinGroup.click();
		
		sleep(5000);
		
		
		boolean leaveGroupBtn = driver.findElement(By.xpath(PropertyManager.getProperty("leaveThisGroupLink"))).isDisplayed();
		
		logger.info("leaveGroupBtn::"+leaveGroupBtn);
		
		logOutSplunkCom();	
		
		Assert.assertTrue(leaveGroupBtn,"Leave this Group not working");
	}

//Create event functionality
	public void verifyCreateEventFuntionality(String username, String password,
			String address,String eventName,String eventDesc,String locationName,String locationAddress) {
		driver.navigate().to(baseUrl);
		loginSplunkCom(username, password);
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
		WebElement clickOnFirstGroup = driver.findElement(By.xpath(PropertyManager.getProperty("firstGroupLink")));
		/*waitForElementToBeVisible(clickOnFirstGroup);
		clickOnFirstGroup.click();*/
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",clickOnFirstGroup);
		
		WebElement createEvent = driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink")));
		waitForElementToBeVisible(createEvent);
		createEvent.click();
		
		//Enter Event Name 
		String enterEventName = eventName+" "+DateUtil.getCurrentDateTime("MM_dd_yyyy_HH_mm_ss_Sz");
		enterText("eventName", enterEventName);
		sleep(3000);
		new Actions(driver).sendKeys(Keys.TAB);
		sleep(2000);
		//Enter Event Description 
		enterText("eventDescription", eventDesc);
		
		//Click on event start date
		clickOnElement("selectSearchResultItem");
		
		//Click on event End date
		clickOnElement("eventEndtDate");
		
		
		//Click on event Start Time
		clickOnElement("startTime");
		sleep(3000);
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getText());
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getAttribute("value"));
		
		//Click on event End Time
		clickOnElement("endTime");
		
		//Enter location name
		enterText("locationName", locationName);
		
		//Enter location name
		enterText("locationAddress", locationAddress);
		
		//Click on Publish event
		clickOnElement("publishEvent");
		
		
	}

	//Draft event functionality
	public void verifyDraftEventFuntionality(String username, String password,
			String address, String eventName, String eventDesc,
			String locationName, String locationAddress) {
		driver.navigate().to(baseUrl);
		loginSplunkCom(username, password);
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
		WebElement clickOnFirstGroup = driver.findElement(By.xpath(PropertyManager.getProperty("firstGroupLink")));
		/*waitForElementToBeVisible(clickOnFirstGroup);
		clickOnFirstGroup.click();*/
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",clickOnFirstGroup);
		
		WebElement createEvent = driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink")));
		waitForElementToBeVisible(createEvent);
		createEvent.click();
		
		//Enter Event Name 
		String enterEventName = eventName+" "+DateUtil.getCurrentDateTime("MM_dd_yyyy_HH_mm_ss_Sz");
		enterText("eventName", enterEventName);
		sleep(3000);
		new Actions(driver).sendKeys(Keys.TAB);
		sleep(2000);
		//Enter Event Description 
		enterText("eventDescription", eventDesc);
		
		//Click on event start date
		clickOnElement("selectSearchResultItem");
		
		//Click on event End date
		clickOnElement("eventEndtDate");
		
		
		//Click on event Start Time
		clickOnElement("startTime");
		sleep(3000);
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getText());
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getAttribute("value"));
		
		//Click on event End Time
		clickOnElement("endTime");
		
		//Enter location name
		enterText("locationName", locationName);
		
		//Enter location name
		enterText("locationAddress", locationAddress);
		
		//Click on Publish event
		clickOnElement("saveDraft");
	}

}
