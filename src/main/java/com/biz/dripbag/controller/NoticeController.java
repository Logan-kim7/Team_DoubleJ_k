package com.biz.dripbag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.DateService;
import com.biz.dripbag.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/notice")
@Controller
<<<<<<< HEAD:src/main/java/com/biz/dripbag/controller/NoticeController.java
public class NoticeController
{
	@Qualifier("NoticeServiceV1")
	private final NoticeService noticeService;
	private final DateService dService;
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{			
=======
public class LJH_NoticeController {
	@Qualifier("NoticeServiceV1")
	private final NoticeService noticeService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
>>>>>>> master:src/main/java/com/biz/dripbag/controller/LJH_NoticeController.java
		model.addAttribute("NOTICE", noticeService.selectAll());
		model.addAttribute("BODY", "NOTICE_HOME");
		return "/LJH/notice";
	}

	@RequestMapping(value = "/detail/{notice_seq}")
	public String detail(@PathVariable("notice_seq") String seq, Model model) {
		long index = Long.valueOf(seq);
		NoticeVO vo = noticeService.findById(index);
		System.out.println(vo.getTitle() + vo.getContent());
		model.addAttribute("NOTICE_VO", noticeService.findById(index));
		model.addAttribute("BODY", "NOTICE_DETAIL");
		return "/LJH/notice";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo, String dummy) {
		model.addAttribute("BODY", "NOTICE_WRITE");
		return "/LJH/notice";
	}
<<<<<<< HEAD:src/main/java/com/biz/dripbag/controller/NoticeController.java
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		String arrDate = dService.dateTime()[0];
		vo.setDate(arrDate);
=======

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo) {
>>>>>>> master:src/main/java/com/biz/dripbag/controller/LJH_NoticeController.java
		noticeService.insert(vo);
		return "redirect:/notice";
	}

}
