package com.facchinil.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

@Deprecated
public class DateUtils2 {
	
	private DateUtils2() {
	    throw new IllegalStateException();
	 }
	
	public static Date toUTC(Date date) {
		return date == null ? null : DateUtils.addHours(date, -2);
	}
}
