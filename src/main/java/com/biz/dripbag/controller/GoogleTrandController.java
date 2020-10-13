package com.biz.dripbag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingGooGle;

@RequestMapping(value = "/gtrand")
@Controller
public class GoogleTrandController {

	@Autowired
	CrwalingGooGle gServ;

	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public String home(Model model, String title) throws IOException {

		model.addAttribute("TITLE", title);
		model.addAttribute("BODY", "GOOGLE_HOME");
		return "home";
	}

}
