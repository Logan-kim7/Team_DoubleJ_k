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
		//@Scheduled(cron = "0/3 * * * * *")
		@Scheduled(cron = "0/10 * * * * *")
		public List<GoogleVO> googleTrend() throws IOException
		{
			String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
			Document doc = Jsoup.connect(url).get();
			Elements trendList = doc.select("item");
		
			long seq = 1;
			GoogleVO googleVO;
			List<GoogleVO> googleList = new ArrayList<GoogleVO>();
			
			for(Element one : trendList)
			{
				googleVO = new GoogleVO();
				googleVO.setSeq(seq);  
				googleVO.setTitle(one.select("title").text());
				googleVO.setApproxTraffic(one.getElementsByTag("ht:approx_traffic").text());
				googleVO.setGoogleDate(one.getElementsByTag("pubDate").text());
				googleVO.setImgPath(one.getElementsByTag("ht:picture").text());
				googleList.add(googleVO);
				seq++;
			}
	
//			for(GoogleVO vo : googleList)
//			{
//				System.out.println(vo.getTitle());
//			}
//			
			return googleList;
		}
		
}
