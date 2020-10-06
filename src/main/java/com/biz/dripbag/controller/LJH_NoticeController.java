package com.biz.dripbag.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;


@RequestMapping(value="/notice")
@Controller
public class LJH_NoticeController
{
	@Qualifier("NoticeServiceV1")
	@Autowired
	private NoticeService noticeService;
	
	private List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{
		
		model.addAttribute("NOTICE", noticeList);
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
	
	@Autowired
	public void test()
	{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("임의제목");
		noticeVO.setSeq(1);
		noticeVO.setDate("2020-00-00");
		
	}
}
