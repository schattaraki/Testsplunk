package com.usergroups.tests;

import com.splunk.common.TestBase;
import com.splunk.util.ExcelUtil;

public class Dummy extends TestBase {

	public static void main(String[] args)
	{
		
		try {
			String data[][]=ExcelUtil.readExcelData("E:\\Splunk_WS\\SplunkUIAutomation\\DataSheet\\TestData.xls","HomePage","tesetVerifyLandingPage");
		//	System.out.println(data.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
