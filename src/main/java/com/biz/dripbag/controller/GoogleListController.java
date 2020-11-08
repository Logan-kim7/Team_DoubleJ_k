package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.GoogleCommentVO;
import com.biz.dripbag.service.GoogleCommentService;
import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;

@RequestMapping(value = "/gtrand")
@Controller
public class GoogleListController {

	@Autowired
	@Qualifier("gcServiceV1")
	GoogleCommentService gcService;
	
	@Autowired
	@Qualifier("searchServiceV1")
	private SearchService searchService;
	
	@Autowired
	@Qualifier("pageV1")
	private PageService pageService;

	@Autowired
	CrwalingData gServ;
	
	 private int ret;

	@RequestMapping(value = "/{seq}/", method = RequestMethod.GET)
	public String home(Model model, @PathVariable("seq") String seq) throws IOException {
		
		ret = Integer.valueOf(seq);
		long longret = gServ.getGoogleList().get(ret).getSeq();
		
		List<?> gclist = pageService.getPage();
		if(gclist == null)
			gclist = searchService.getSearch() != null ? searchService.getSearch() : gcService.findBySelect(longret);
			
		System.out.println(gclist.toString());
		model.addAttribute("BODY", "GOOGLE_HOME");
		model.addAttribute("TITLE", gServ.getGoogleList().get(ret));
		model.addAttribute("GC_LIST", gclist);
		return "home";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String userGSave(Model model, @ModelAttribute GoogleCommentVO gcVO) {
		 
		gcService.insert(gcVO);
		
		return "redirect:/gtrand/" + ret + "/";
	}
	
	@RequestMapping(value = "/thumbsup", method = RequestMethod.GET)
	public String thumbsUp(@RequestParam("id") Long seq) {

		long sequence = Long.valueOf(seq);

		GoogleCommentVO vo = gcService.findById(sequence);

		gcService.hit(vo);

		return "redirect:/gtrand/" + ret + "/";
	}

}
