package com.biz.dripbag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.NewsListVO;
import com.biz.dripbag.service.NewsListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/news")
@Controller
public class NewsController {
    
    
    @Autowired
    CrwalingData nServ;
        
    private int ret;
    
    @RequestMapping(value = {"/", "/{n_index}"}, method =  RequestMethod.GET)
    public String news(Model model, @PathVariable("n_index") String n_index) throws IOException {
        
        ret =  Integer.valueOf(n_index);
        
        model.addAttribute("BODY","NEWS_HOME");
        model.addAttribute("NEWS", "NEWSMAIN");
        model.addAttribute("NEWSLIST",nServ.getNewsList());
        model.addAttribute("NEWSDATA",nServ.getNewsList().get(ret));
        

        return "home";
    }
    
    @RequestMapping(value = {"/write", "/write/"}, method =  RequestMethod.POST)
    public String write(NewsListVO vo)  {

    	
        return "redirect:/news/" + ret;
    }
    
    

}