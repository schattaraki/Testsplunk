package com.splunk.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFunctionality {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss_a");
		System.out.println(sdf.format(date));
	}

}
