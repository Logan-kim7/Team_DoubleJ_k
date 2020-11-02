package com.biz.dripbag.crawling;

import java.io.IOException;
import java.util.ArrayList;
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

import com.biz.dripbag.model.GoogleRankingVO;
import com.biz.dripbag.model.NewsRankingVO;
import com.biz.dripbag.service.DateService;
import com.biz.dripbag.service.GoogleTrendeService;
import com.biz.dripbag.service.NewsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableScheduling
@Service("CrawlingData")
public class CrwalingData
{
	@Qualifier("googleServiceV1")
	private final GoogleTrendeService googleService;
	
	@Qualifier("newsServiceV1")
	private final NewsService newsService;
	
	private final DateService dateService;
	
	private final List<GoogleRankingVO> googleList;
	private final List<NewsRankingVO> newslist;
	
	public List<GoogleRankingVO> getGoogleList() { return googleList; }
	public List<NewsRankingVO> getNewsList() { return newslist; }
	
	@Scheduled(fixedDelay = 86400000)
	public List<GoogleRankingVO> googleTrend() 
	{
		googleList.clear();
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc;
		GoogleRankingVO vo;
		int index = 0;
		try 
		{
		  doc = Jsoup.connect(url).get();
		  Elements trendList = doc.select("item");
		
		  for(Element one : trendList) 
		  { 
			  vo = new GoogleRankingVO(); 
			  vo.setGt_title(one.select("title").text());
			  vo.setGt_img(one.getElementsByTag("ht:picture").text());
			  vo.setGt_date(dateService.dateTime()[0]);
//			  googleService.insert(vo);
			  googleList.add(vo);
			  if(index++ >= 9) break;
		  }
		} 
		catch (IOException e) { System.out.println("구글 트렌드 접속 실패"); }
		
		index=0;
		return googleList;
	}
	
	
	@Scheduled(fixedDelay = 86400000)
	public List<NewsRankingVO> news()
	{
		newslist.clear();
		String newsUrl = "/?pageIndex=0"; // 뉴스 페이지 인덱스 문자열
		String url = "https://mnews.sarangbang.com"; // 뉴스페이지 URL ( 디테일 붙이기 용도)
		
		NewsRankingVO vo;
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
				
				vo = new NewsRankingVO();
				vo.setN_title(doc.select(".view_wrap > .article_head h3").text()); // Title
				vo.setN_img(doc.select(".figcaption.text-center img").attr("src")); // img url
				vo.setN_content(doc.select(".article_view p").text()); // content									
				//newsService.insert(vo);
				newslist.add(vo);
			}			
		}
		catch (IOException e)  { System.out.println("사랑방 뉴스 접속 실패"); }
		return newslist;
	}
	

}
