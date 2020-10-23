package com.biz.dripbag.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.biz.dripbag.service.DateService;

@Component
public class DateV1 implements DateService 
{
	@Override
	public String[] dateTime() 
	{
		LocalDateTime lDateTime = LocalDateTime.now();
		String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String str_Time = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);
		String[] arrDate = new String[] {strDate, str_Time};
		return arrDate;
	}

}
