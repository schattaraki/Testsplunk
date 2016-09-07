package com.splunk.pages;

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

public class FooterPage extends BasePage {

	protected static int copyright_index = 1;
	protected static int footer_index = 1;
	private static Log logger = LogUtil.getLog(FooterPage.class);

	public FooterPage(WebDriver driver) {
		super(driver);
	}

	// xPath for Footer links
	public static String footerLinksxPath = "//div[@class='copyright-links']/ul/li[";
	// xPath for Copy Rights in Footer
	public static String copyRights = "(//div[@class='copyright-links']/span)[";

	// Get copy rights text from Footer
	public void getCopyRightsText(String expValue) {
		scrollTo(driver,0, 5000);
		sleep(2000);
		/*WebElement copyRightsLoc = driver.findElement(By.xpath(copyRights
				+ copyright_index + "]"));*/
		By locator= By.xpath(copyRights+copyright_index + "]");
		WebElement copyRightsLoc = findElement(driver,locator,5);

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
	}

	// Verify footer links
	public void verifyfooterLinks(String linkText, String title, String expURL) {
		scrollTo(driver,0, 5000);
		sleep(2000);
		/*WebElement footerLink = driver.findElement(By.xpath(footerLinksxPath
				+ footer_index + "]/a"));*/
		
		By locator= By.xpath(footerLinksxPath+ footer_index + "]/a");
		WebElement footerLink = findElement(driver,locator,5);
		String footerLinkText = getText(footerLink);

		footerLink.click();
		sleep(5000);

		footer_index++;
		
		//Verified Footer link text
		Assert.assertEquals(footerLinkText, linkText,
				"Footer linktext not matched.");
		
		//Verified target page URL
		Assert.assertTrue(driver.getCurrentUrl().contains(expURL),
				"URL not matched");
		
		//Verified target page Title
		Assert.assertEquals(driver.getTitle(), title, "Title not matched");

		driver.navigate().back();

	}

}
