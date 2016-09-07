/**
 * 
 */
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
public class CreateUserGroup extends BasePage {
	private static Log logger = LogUtil.getLog(CreateUserGroup.class);
	protected static String baseUrl=null;
	public static int index_event=0;
	
	public CreateUserGroup(WebDriver driver)
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
	public void verifyCreateGroupFuntionality(String username, String password,String groupNameText,String desc,String leaderText,String locationText,String tags)
{
			boolean groupSucessFlag = false;
	try
	{
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
		sleep(2000);
		if(leaderText!="")
		{
		System.out.println("leader text  "+leaderText);
   		enterText("leader",leaderText);
		sleep(5000);
			WebElement selectLeader = driver.findElement(By.xpath(PropertyManager.getProperty("selectLeader")));
		waitForElementToBeVisible(selectLeader);
		selectLeader.click();
		}
   		enterText("location",locationText);
		sleep(5000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectlocation")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(5000);
		enterText("tags",tags);
		sleep(5000);
		
		verifyAndClick(driver.findElement(By.xpath(PropertyManager.getProperty("createGroupBtn"))));
		sleep(5000);
		
		int count=0;
		sleep(120000);
		/*while(count<=25){
			boolean progressBarDisplayed = driver.findElement(By.xpath(PropertyManager.getProperty("createGroupProgressBar"))).isDisplayed();
			logger.info("Count :" +count+ ", progress Bar Displayed :"+progressBarDisplayed);
			if(!progressBarDisplayed){
				break;
			}else{
				sleep(10000);
			}
			count++;
		}*/
		
		
			//sleep(120000);
		//sleep(5000);
		List<WebElement> allActiveUserGroups = driver.findElements(By.xpath(PropertyManager.getProperty("activeUserGroups")));
		//sleep(5000);
		for (WebElement webElement : allActiveUserGroups)
		 {
			 if( webElement.getText().equalsIgnoreCase((myGroupName)))
			 {
				groupSucessFlag=true;
				logger.info("group is created succesfully");
			 }
			 else
				{
					logger.info("group not created succesfully");
				}
		 
		 }
	}catch(Exception e)
	{
		logger.info("Error while creating new group: "
				+ e.getMessage());
		Assert.fail("Error while creating new group");
		
		
	}
	//driver.navigate().refresh();
	Assert.assertTrue(groupSucessFlag,"Group not created");
	logOutSplunkCom();
	
	
}
	
	
	public void verifyCreateEventFuntionality(String username, String password,
	String address,String eventName,String eventDesc,String locationName,String enterlocation,String description) {

		driver.navigate().to(baseUrl);
		clickOnDashboardLoginLink();
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
		sleep(2000);
		//Enter Event Name 
		String enterEventName = eventName+" "+DateUtil.getCurrentDateTime("MM_dd_yyyy_HH_mm_ss_Sz");
		logger.info("Error while creating new group: "+enterEventName);
		enterText("eventName", enterEventName);
		sleep(3000);
		new Actions(driver).sendKeys(Keys.TAB);
		sleep(2000);

		//Enter Event Description 
		enterText("eventDescription", eventDesc);
	
		//start date
		clickOnElement("eventStartdate");
		sleep(4000);
		clickOnElement("NextMonth");
		sleep(4000);
		clickOnElement("StartDate");
		sleep(4000);
		
		//End Date
		clickOnElement("eventEnddate");
		sleep(4000);
		clickOnElement("NextMonth");
		sleep(4000);
		clickOnElement("EndDate");
		sleep(4000);
		//starttime
		clickOnElement("startTime");
		sleep(4000);
        
		//Endtime
		clickOnElement("endTime");
		sleep(4000);
		clickOnElement("EndTimeEvent");
		sleep(4000);
		enterText("locationName", locationName);
		enterText("EnterLocation", enterlocation);
		clickOnElement("agendaTime");
		sleep(4000);
		enterText("briefActivityDesc", description);
		index_event++;
		
		logger.info("index event value is "+index_event);
		sleep(4000);		
		switch(index_event)
	{
		case 1:
		sleep(4000);
		//publish event
		clickOnElement("PublishEvent");
		sleep(2000);
	    String eventname = driver.findElement(By.xpath("//a[text()='"+enterEventName+"']")).getText();
        Assert.assertEquals(eventname.replace(" ", "").replace("  ", "").trim(),enterEventName.replace(" ", "").replace("  ", "").trim(),"Event name is not matched");
    	break;	
		case 2:
			//publish event
		clickOnElement("PublishEvent");
		sleep(2000);
		eventname = driver.findElement(By.xpath("//a[text()='"+enterEventName+"']")).getText();
		Assert.assertEquals(eventname.replace(" ", "").replace("  ", "").trim(),enterEventName.replace(" ", "").replace("  ", "").trim(),"Event name is not matched");
		break;
		case 3:
			//Save Draftevent
		clickOnElement("SaveDraft");
		eventname = driver.findElement(By.xpath("//a[text()='"+enterEventName+"']")).getText();
		Assert.assertEquals(eventname.replace(" ", "").replace("  ", "").trim(),enterEventName.replace(" ", "").replace("  ", "").trim(),"Event name is not matched");
		sleep(2000);
		logger.info("savedraft is completed successfully");
		break;
		case 4:
			//Cancel Event
		clickOnElement("Cancel");
		sleep(4000);
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getText());
		logger.info("startTime::"+driver.findElement(By.xpath(PropertyManager.getProperty("createEventLink"))).getAttribute("value"));
         logger.info("event is cancelled successfully");
		break;
		case 5:
	//Without entering event description Click on publish button
		clickOnElement("PublishEvent");
		sleep(4000);
		if(isAlertPresent())
		{
		Alert alert=driver.switchTo().alert();
	    logger.info(alert.getText());
	   alert.accept();
		}
	}			
		
				
		logOutSplunkCom();
		sleep(5000);
	}	
	
	public boolean isAlertPresent()
	{
	    try
	    {
	      driver.switchTo().alert();
	        return true;
	    }   
	    catch (NoAlertPresentException Ex)
	    {
	        return false;
	    }   
	}
	
	
	
	public void testverifyGroupSearchFunctionality(String address)
	{
		enterText("findMoreGroupsInput", address);
		sleep(2000);
		WebElement selectlocation = driver.findElement(By.xpath(PropertyManager.getProperty("selectSearchResultItem")));
		waitForElementToBeVisible(selectlocation);
		selectlocation.click();
		sleep(2000);
		scrollTo(driver,0, 500);
		sleep(2000);
			
	}
	
	
	
	
	
}