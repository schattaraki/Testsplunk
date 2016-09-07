package com.usergroups.pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.splunk.common.BasePage;
import com.splunk.common.PropertyManager;
import com.splunk.util.LogUtil;

/**
 * @author Maheshwar Kanchetty
 */

public class GlobalFooterPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 2;
	protected static int footer_followus = 1;
	private static Log logger = LogUtil.getLog(GlobalFooterPage.class);

	public GlobalFooterPage(WebDriver driver) {
		super(driver);
	}


	// Get copy rights text from Footer
	public void getCopyRightsText(String expValue) {
		scrollTo(driver,0, 5000);
		sleep(5000);
		WebElement copyRightsLoc = driver.findElement(By.xpath(PropertyManager.getProperty("copyRights")
				+ copyright_index + "]"));

		copyright_index++;
		
		//Verifying Copy Rights text
		Assert.assertEquals(getText(copyRightsLoc), expValue,
				"Copy Rights text not matched.");
	}

	// Get HomePage
	public void getHomePage() {
		String baseUrl=null;
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
		sleep(5000);
	}

	// Verify footer links
	public void verifyfooterLinks(String linkText, String title, String URL) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		System.out.println("Footer Links::"+PropertyManager.getProperty("footerLinks")+ footer_index +"]/a");
		WebElement footerLink = driver.findElement(By.xpath(PropertyManager.getProperty("footerLinks")+ footer_index +"]/a"));
		String footerLinkText = getText(footerLink);

		footerLink.click();
		sleep(3000);

		footer_index++;
		
		String cTitle=driver.getTitle();
		String cURL=driver.getCurrentUrl();
		
		driver.navigate().back();
		//Verified Footer link text
		Assert.assertEquals(footerLinkText, linkText,
				"Footer linktext not matched.");
		
		//Verified target page URL
		Assert.assertTrue(cURL.contains(URL),
				"URL not matched");
		
		//Verified target page Title
		Assert.assertEquals(cTitle, title, "Title not matched");

	}

	//Verify FollowUS text and links
	public void verifyFooterFollowUS(String expText, String expValues) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		if(footer_followus==1){
			WebElement followUSTxt = driver.findElement(By.xpath(PropertyManager.getProperty("followUSText")));
			Assert.assertEquals(followUSTxt.getText(), expText," Follow US: text not matched.");
		}
		WebElement footerLink = driver.findElement(By.xpath(PropertyManager.getProperty("followUSLinks")+ footer_followus + "]/a"));
		footer_followus++;
		Assert.assertEquals(footerLink.getAttribute("href"), expValues," Follow US links not matched.");
	}

	//Verify Splunk User Groups Link
	public void verifyFooterSplunkUGLink( String pageTitle,
			String URL) {
		scrollTo(driver,0, 5000);
		sleep(3000);
		WebElement splunkUGLink = driver.findElement(By.xpath(PropertyManager.getProperty("splunkUGLink")));
		WaitForElementToBeClickable(splunkUGLink);
		splunkUGLink.click();
		sleep(5000);
		String title=driver.getTitle();
		String cURL=driver.getCurrentUrl();
//		driver.navigate().back();
		Assert.assertEquals(title, pageTitle," Splunk User Groups link target page title not matched.");
		Assert.assertTrue(cURL.contains(URL)," Splunk User Groups link target page URL not matched.");
	}

}
