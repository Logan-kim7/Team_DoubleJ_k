package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.GoogleVO;

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
		return "home";
	}
		
		
	

}
