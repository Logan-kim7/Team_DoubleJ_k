package com.biz.dripbag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.service.GoogleCommentService;
import com.biz.dripbag.service.NewsCommentService;

@RequestMapping(value = "/halloffame")
@Controller
public class RankingController {
	@Autowired
	@Qualifier("gcServiceV1")
	GoogleCommentService gService;

	@Autowired
	@Qualifier("NewsCommentV1")
	NewsCommentService nService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("BODY", "HALL_OF_FAME");
		model.addAttribute("GITEM", gService.selectTop());
		model.addAttribute("NITEM", nService.selectTop());

		return "home";

	}

}
