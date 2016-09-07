package com.splunk.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author Avneet Dhanoa
 * */

public class PropertyManager {
	static final Logger logger = Logger.getLogger(PropertyManager.class);

	private static Properties props = null;

	private PropertyManager() {

	}

	public static String getProperty(String key) {
		try {
			String value = System.getProperty(key);
			if (props == null) {
				props = new Properties();
				try {
					
					InputStream fis = ClassLoader.getSystemClassLoader()
							.getResourceAsStream("com/splunk/resources/automation.properties");

					props.load(fis);
					InputStream orProp = ClassLoader.getSystemClassLoader()
							.getResourceAsStream("com/splunk/resources/UserGroupsOR.properties");
					props.load(orProp);
					InputStream splunkComOR = ClassLoader.getSystemClassLoader()
							.getResourceAsStream("com/splunk/resources/SplunkComOR.properties");
					props.load(splunkComOR);
				} catch (FileNotFoundException fne) {
					fne.printStackTrace();

				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}

			if (value == null) {
				value = props.getProperty(key);

			}
			logger.info("key: " + key + " value: " + value);
			return value;
		} catch (Exception e) {
			System.out.println("Inside Property Manager Class: "
					+ e.getMessage());
		}
		return null;
	}
}
