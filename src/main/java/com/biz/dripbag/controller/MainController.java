package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingGooGle;
import com.biz.dripbag.model.GoogleVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/main")
@Controller
public class MainController {
	

	private static final CrwalingGooGle googleService = new CrwalingGooGle();
	
	
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home(Model model) throws IOException 
	{
		List<GoogleVO> googleList = googleService.googleTrend();
		
		for(GoogleVO one : googleList)
			System.out.print(one.getTitle() + one.getSeq() + "\n");
		
		
		model.addAttribute("GOOGLE", googleList);
		model.addAttribute("BODY","MAIN_HOME");
		return"home";
	}
		
		
	

}
