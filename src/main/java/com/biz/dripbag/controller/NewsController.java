package com.biz.dripbag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/news")
@Controller
public class NewsController {
    
    
    @Autowired
    CrwalingData nServ;
    
    @RequestMapping(value = "/{n_index}", method =  RequestMethod.GET)
    public String news(Model model, @PathVariable("n_index") String n_index) throws IOException {
        
        
        int ret =  Integer.valueOf(n_index);
        
        //log.debug(">>>>>>"+nServ.getterNewsList().size());
        
        System.out.println(ret);
        model.addAttribute("BODY","NEWS_HOME");
        model.addAttribute("NEWS", "NEWSMAIN");
        model.addAttribute("NEWSLIST",nServ.getNewsList());
        model.addAttribute("NEWSDATA",nServ.getNewsList().get(ret));
        

        return "home";
    }

}