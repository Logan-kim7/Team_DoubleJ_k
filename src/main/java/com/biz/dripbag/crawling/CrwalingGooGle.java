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

import com.biz.dripbag.model.GoogleVO;

@Qualifier("googleCrawling")
@Service
@Configuration
@EnableScheduling
public class CrwalingGooGle
{
	@Scheduled(cron = "0/10 * * * * *")
	public void googleTrend() 
	{
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc;
		  
		GoogleVO googleVO; 
		List<GoogleVO> googleList = new ArrayList<GoogleVO>();
		long seq = 0;
		try 
		{
		  doc = Jsoup.connect(url).get();
		  Elements trendList = doc.select("item");
		
		  for(Element one : trendList) 
		  { 
			  googleVO = new GoogleVO();
			  googleVO.setSeq(seq); googleVO.setTitle(one.select("title").text());
			  googleVO.setApproxTraffic(one.getElementsByTag("ht:approx_traffic").text());
			  googleVO.setGoogleDate(one.getElementsByTag("pubDate").text());
			  googleVO.setImgPath(one.getElementsByTag("ht:picture").text());
			  googleList.add(googleVO); 
			  seq++; 
		  }
		  
		} 
		catch (IOException e) 
		{
			System.out.println("구글 트렌드 접속 실패 URL 확인");
			e.printStackTrace();
		} 
	}
	
	
	@Scheduled(cron = "0/10 * * * * *")
	public void news()
	{
		String[] detailNews = null;
		String[] newsData = new String[3];
		String newsUrl = "/?pageIndex=0"; // 뉴스 페이지 인덱스 문자열
		String url = "https://mnews.sarangbang.com"; // 뉴스페이지 URL ( 디테일 붙이기 용도) 
		int index = 0;
		
		try 
		{
			Document doc = Jsoup.connect(url+newsUrl).get();
			Elements newsList = doc.select(".list_news.rank").select("li");
			detailNews = new String[newsList.size()];
			
			
			for(Element one : newsList)
			{
				detailNews[index] = url + one.select("a").attr("href");
				System.out.println(detailNews[index]);
				index++;
			}
			
			newsList.clear();
			index = 0;
			for(String one : detailNews)
			{
				doc = Jsoup.connect(detailNews[index]).get();
				newsData[0] = doc.select(".view_wrap > .article_head h3").text(); // Title
				newsData[1] = doc.select(".figcaption.text-center img").attr("src"); // img url
				newsData[2] = doc.select(".article_view p").text(); // content
			
				System.out.println(newsData[0]);
				System.out.println(newsData[1]);
				System.out.println(newsData[2]);					
				index++;
			}			
		}
					
		catch (IOException e) 
		{
			System.out.println("사랑방 뉴스 접속 실패 URL 확인");
			e.printStackTrace();
		}
	}
		
}
