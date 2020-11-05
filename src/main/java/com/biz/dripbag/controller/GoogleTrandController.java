package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.GoogleVO;

@RequestMapping(value = "/gtrand")
@Controller
public class GoogleTrandController {

	@Autowired
	CrwalingData gServ;

	@RequestMapping(value = "/{seq}", method = RequestMethod.GET)
	public String home(Model model, @PathVariable("seq") String seq) throws IOException {
		int intSeq = Integer.valueOf(seq);
		model.addAttribute("BODY", "GOOGLE_HOME");
		model.addAttribute("TITLE", gServ.getGoogleList().get(intSeq).getTitle());
		return "home";

	}


}
