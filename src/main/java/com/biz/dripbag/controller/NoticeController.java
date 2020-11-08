package com.biz.dripbag.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.model.SearchVO;
import com.biz.dripbag.service.NoticeService;
import com.biz.dripbag.service.sub.HitService;
import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class NoticeController
{
	@Qualifier("noticeServiceV1")
	private final NoticeService noticeService;
	
	@Qualifier("CrawlingData")
	private final CrwalingData cService;
	
	@Qualifier("hitV1")
	private final HitService hService;
	
	@Qualifier("searchServiceV1")
	private final SearchService searchService;
	
	@Autowired
	@Qualifier("pageV1")
	private PageService pageService;
						
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public String home(Model model)
	{
		List<?> list = pageService.getPage();
		if(list == null)
		{
			System.out.println("페이지 검색 없음");
			list = searchService.getSearch() != null ? searchService.getSearch() : noticeService.selectAll();
		}
			
			else
				System.out.println(list.toString());

		model.addAttribute("LIST", list);
		model.addAttribute("GOOGLE", cService.getGoogleList());
		model.addAttribute("NEWS", 	cService.getNewsList());
		model.addAttribute("BODY", "NOTICE_HOME");
		model.addAttribute("CURPAGE", pageService.curPage());
		model.addAttribute("TOTALPAGE", pageService.allSize("tbl_notice"));
		return "home";
	}
		
	@RequestMapping(value="/detail/{seq}")
	public String detail(@PathVariable("seq") String seq, Model model, HttpServletRequest req)
	{
		long iseq = Long.valueOf(seq);
		noticeService.hit(iseq);
				
		model.addAttribute("BODY", "NOTICE_DETAIL");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model)
	{
		model.addAttribute("BODY", "NOTICE_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		noticeService.insert(vo);
		return "redirect:/notice/";
	}
	
	@ResponseBody
	@RequestMapping(value="/deletes", method=RequestMethod.POST)
	public String deletes(@RequestParam String delete_seq[])
	{

		noticeService.deletes(delete_seq);
		return "redirect:/notice/";
	}
	
	
	@ResponseBody
	@RequestMapping(value= {"/page", "/page/"}, method = RequestMethod.GET)
	public boolean page(Model model, @RequestParam Map<String, String> map)
	{			
		if(pageService.test("tbl_notice", map.get("seq"), map.get("max"), map.get("flag"), map.get("nextpage")) != null);		
			return true;		
	}
	
}
