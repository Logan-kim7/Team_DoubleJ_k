package com.biz.dripbag.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.biz.dripbag.model.GoogleVO;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableScheduling
public class CrwalingGooGle
{
	//	@Scheduled(cron = "0/3 * * * * *")
		private void test() throws IOException
		{
			String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
			Document doc = Jsoup.connect(url).get();
			Elements trendList = doc.select("item");
		
			GoogleVO googleVO = new GoogleVO();
			
			for(Element one : trendList)
			{
				googleVO.setTitle(one.select("title").text());
				googleVO.setApproxTraffic(one.getElementsByTag("ht:approx_traffic").text());
				googleVO.setGoogleDate(one.getElementsByTag("pubDate").text());
				googleVO.setImgPath(one.getElementsByTag("ht:picture").text());
				break;
			}
	
			System.out.println(googleVO.getTitle());
		}
		
}
