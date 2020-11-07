package com.biz.dripbag.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/main")
@Controller
public class MainController {
		
	private final CrwalingData crwalingData;
	
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home(Model model) throws IOException 
	{				
		model.addAttribute("GOOGLE", crwalingData.getGoogleList());
		model.addAttribute("NEWS", crwalingData.getNewsList());
		model.addAttribute("BODY","MAIN_HOME");
		model.addAttribute("DATE", datetime()[0] + datetime()[1]);
		return "home";
	}
	

	public String[] datetime() {
		
		LocalDateTime DateTime = LocalDateTime.now();
		String strDate = DateTimeFormatter.ofPattern("yyy-MM-dd").format(DateTime);
		String strTime = DateTimeFormatter.ofPattern("HH:mm").format(DateTime);
		String[] arrDate = new String[] {strDate, strTime};
		return arrDate;
			
	}
}
