package com.usergroups.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SampleTest   {

	
	public static WebDriver driver;
	public static void main(String[] args) {
//driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
	
	driver.get("file:///C:/Users/schattaraki/Desktop/Sample.html");
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	
		//String str = "Splunk Answers,Overview,Documentation,Education & Training,Community Support,Product Security Updates,Professional Services,Support Portal,Using Splunk Software $ http://answers.splunk.com/,http://www.splunk.com/en_us/support-and-services.html,http://docs.splunk.com/,http://www.splunk.com/view/education/SP-CAAAAH9,http://community.splunk.com/,http://www.splunk.com/page/securityportal,http://www.splunk.com/en_us/partners/become-a-partner/professional-services.html,http://login.splunk.com/page/sso_redirect?type=portal,http://www.splunk.com/view/SP-CAAAG2R";
		//System.out.println("Splunk COm::"+str.split(" $ ")[0]);
	WebElement element=driver.findElement(By.xpath("//input[@type='button']"));
	element.click();
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());

	}
}