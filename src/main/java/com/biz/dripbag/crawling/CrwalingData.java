package com.biz.dripbag.crawling;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.biz.dripbag.model.GoogleListVO;
import com.biz.dripbag.model.NewsListVO;
import com.biz.dripbag.service.GoogleListService;
import com.biz.dripbag.service.NewsListService;
import com.biz.dripbag.service.sub.DateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableScheduling
@Service("CrawlingData")
public class CrwalingData
{
	@Qualifier("googleServiceV1")
	private final GoogleListService googleService;
	
	@Qualifier("newsServiceV1")
	private final NewsListService newsService;
	
	@Qualifier("dateV1")
	private final DateService dateService;
	
	private final List<GoogleListVO> googleList;
	private final List<NewsListVO> newslist;
	
	public List<GoogleListVO> getGoogleList() { return googleList; }
	public List<NewsListVO> getNewsList() { return newslist; }
	
	@Scheduled(fixedDelay = 86400000)
	public List<GoogleListVO> googleTrend() 
	{
		googleList.clear();
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc;
		GoogleListVO vo;
		int index = 0;
		try 
		{
		  doc = Jsoup.connect(url).get();
		  Elements trendList = doc.select("item");
		
		  for(Element one : trendList) 
		  { 
			  vo = new GoogleListVO(); 
			  vo.setTitle(one.select("title").text());
			  vo.setImg(one.getElementsByTag("ht:picture").text());
			  vo.setDates(dateService.dateTime()[0]);
			  vo.setSeq(googleService.insert(vo));			  
			  googleList.add(vo);
			  if(index++ >= 9) break;
		  }		  
		} 
		catch (IOException e) { System.out.println("구글 트렌드 접속 실패"); }
		
		index=0;
		return googleList;
	}
	
	
	@Scheduled(fixedDelay = 86400000)
	public List<NewsListVO> news()
	{
		newslist.clear();
		String newsUrl = "/?pageIndex=0"; // 뉴스 페이지 인덱스 문자열
		String url = "https://mnews.sarangbang.com"; // 뉴스페이지 URL ( 디테일 붙이기 용도)
		
		NewsListVO vo;
		String[] detailNews;
		int index = 0;
		try 
		{
			Document doc = Jsoup.connect(url+newsUrl).get();
			Elements elNewsList = doc.select(".list_news.rank").select("li");
			detailNews = new String[elNewsList.size()];
		
			for(Element one : elNewsList)
				detailNews[index++] = url + one.select("a").attr("href");
			
			for(int i=0; i<detailNews.length; ++i)
			{
				doc = Jsoup.connect(detailNews[i]).get();
				
				vo = new NewsListVO();
				vo.setDates(dateService.dateTime()[0]);			  
				vo.setTitle(doc.select(".view_wrap > .article_head h3").text()); // Title
				vo.setImg(doc.select(".figcaption.text-center img").attr("src")); // img url
				vo.setCont(doc.select(".article_view p").text()); // content	
				vo.setSeq(newsService.insert(vo));
				newslist.add(vo);
			}			
		}
		catch (IOException e)  { System.out.println("사랑방 뉴스 접속 실패"); }
		return newslist;
	}
	

}
