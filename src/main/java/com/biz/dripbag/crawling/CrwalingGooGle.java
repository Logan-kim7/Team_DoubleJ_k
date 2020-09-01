package com.biz.dripbag.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration 
public class CrwalingGooGle
{
	//@Scheduled(cron = "0/3 * * * * *")
		public void test() throws IOException
		{
			String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
			Document doc = Jsoup.connect(url).get();
			Elements trendList = doc.select("item");
			
			String title = "";
			String approxTraffic = "";
			String googleDate = "";
			String imgPath = "";
			
			for(Element one : trendList)
			{
				title = one.select("title").text();
				approxTraffic = one.getElementsByTag("ht:approx_traffic").text();
				googleDate = one.getElementsByTag("pubDate").text();
				imgPath = one.getElementsByTag("ht:picture").text();
				
				System.out.println(title);
				System.out.println(approxTraffic);
				System.out.println(googleDate);
				System.out.println(imgPath);
				break;
			}
	
		}
}
