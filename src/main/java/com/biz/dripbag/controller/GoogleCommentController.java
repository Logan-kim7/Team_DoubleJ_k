package com.biz.dripbag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.dripbag.model.GoogleCommentVO;
import com.biz.dripbag.service.GoogleCommentService;

@Controller
@RequestMapping("/gclist")
public class GoogleCommentController {

	@Autowired
	@Qualifier("gcServiceV1")
	GoogleCommentService gcService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gComentList(Model model) {

		List<GoogleCommentVO> gcList = gcService.selectAll();

		model.addAttribute("BODY", "GC_LIST");
		model.addAttribute("GC_LIST", gcList);

		return "home";
	}

	@RequestMapping(value = "/thumbsup", method = RequestMethod.GET)
	public String thumbsUp(@RequestParam("id") Long seq) {

		long sequence = Long.valueOf(seq);
		System.out.println("\n\n\n" + sequence + "\n\n\n");

		GoogleCommentVO vo = gcService.findById(sequence);

		gcService.hit(vo);

		return "redirect:/gclist/";
	}

}
