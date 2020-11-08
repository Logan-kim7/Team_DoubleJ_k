package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.NewsCommentVO;
import com.biz.dripbag.service.NewsCommentService;
import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/news")
@Controller
public class NewsController {
    
	@Autowired
	@Qualifier("searchServiceV1")
	private SearchService searchService;
	
    @Autowired
    private CrwalingData nServ;
            
    @Autowired
    private NewsCommentService newsComentService;
    
	@Autowired
	@Qualifier("pageV1")
	private PageService pageService;
    
    private int ret;
    
    @RequestMapping(value = "/{n_index}/", method =  RequestMethod.GET)
    public String news(Model model, @PathVariable("n_index") String n_index) throws IOException {
        
        ret =  Integer.valueOf(n_index);
        long longRet = nServ.getNewsList().get(ret).getSeq();
        
		List<?> list = pageService.getPage();
		if(list == null)
			list = searchService.getSearch() != null ? searchService.getSearch() : newsComentService.findBySelect(longRet);
	
        model.addAttribute("BODY","NEWS_HOME");
        model.addAttribute("NEWS", "NEWSMAIN");
        model.addAttribute("NEWSLIST", list);
        model.addAttribute("NEWSDATA",nServ.getNewsList().get(ret));
    	model.addAttribute("CURPAGE", pageService.curPage());
		model.addAttribute("TOTALPAGE", pageService.allSize("tbl_NewsComment", longRet));

        return "home";
    }
    
    @RequestMapping(value = {"/write", "/write/"}, method =  RequestMethod.POST)
    public String write(NewsCommentVO vo)  
    {
    	searchService.clear();
    	newsComentService.insert(vo);
        return "redirect:/news/" + ret + "/";
    }
    
  
	@ResponseBody
	@RequestMapping(value= {"/{any}/page", "/{any}/page/"}, method = RequestMethod.GET)
	public boolean page(Model model, @RequestParam Map<String, String> map)
	{			

		if(pageService.testj("tbl_NewsComment", map.get("seq"), map.get("max"), map.get("flag"), map.get("nextpage")) != null);		
			return true;		
	}
    
    

}