package com.biz.dripbag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.dripbag.model.GCommentVO;
import com.biz.dripbag.service.GCommentService;

@Controller
@RequestMapping("/gclist")
public class GCommentListController {

	@Autowired
	@Qualifier("gcServiceV1")
	GCommentService gcService;

	@RequestMapping(value = "/")
	public String gComentList(Model model) {

		List<GCommentVO> gcList = gcService.selectAll();

		model.addAttribute("BODY", "GC_LIST");
		model.addAttribute("GC_LIST", gcList);

		return "home";
	}

}
