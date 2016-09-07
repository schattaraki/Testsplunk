/*
 * 
 */
package com.splunk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;


// TODO: Auto-generated Javadoc
/**
 * This class contains date utility functions.
 * 
 * @author Maheshwar Kanchetty
 *
 */
public class DateUtil {
	
	/** The log. */
	private static Log log = LogUtil.getLog(DateUtil.class);
	
	
	/**
	 * Gets the current date time.
	 *
	 * @param format the format
	 * @return the current date time
	 */
	public static String getCurrentDateTime(String format){
		log.info("Get current date for given format "+format);
		DateFormat dateFormat = new SimpleDateFormat(format);
		//get current date time with Date()
	    Date date = new Date();
	    return dateFormat.format(date);	    
	}
	
	
	
}