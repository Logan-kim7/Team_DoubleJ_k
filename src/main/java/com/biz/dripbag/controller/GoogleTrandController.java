package com.biz.dripbag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingGooGle;

@RequestMapping(value = "/gtrand")
@Controller
public class GoogleTrandController {

	@Autowired
	CrwalingGooGle gServ;

<<<<<<< HEAD
	@RequestMapping(value = "/{title:.+}", method = RequestMethod.GET)
	public String home(Model model, @PathVariable("title") String title) throws IOException {

		List<GoogleVO> googleList = gServ.googleTrend();

		title = googleList.get(1).getTitle().toString();
		System.out.println(title);

		model.addAttribute("TITLE", googleList);
=======
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public String home(Model model, String title) throws IOException {

		model.addAttribute("TITLE", title);
>>>>>>> d7241067a28f76d38833b5c53a151dde27539080
		model.addAttribute("BODY", "GOOGLE_HOME");
		return "home";
	}

}
