package com.biz.dripbag.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrwalingGooGle implements Crawling
{
	@Autowired
	@Override
	public String test() throws IOException
	{
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc = Jsoup.connect(url).get();
		Elements trendList = doc.select("item");
		
		String title = "";
		String content = "";
		int cutIndex = 0;
		for(Element one : trendList)
		{
			//System.out.println(one.select("title"));
			cutIndex = one.getElementsByTag("ht:news_item_title").text().lastIndexOf(";");
			content = one.getElementsByTag("ht:news_item_title").text().substring(0, cutIndex);
			break;
		}
		return content;
	}

	@Autowired
	@Override
	public String imgTest() throws IOException 
	{
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc = Jsoup.connect(url).get();
		Elements trendList = doc.select("item");
		
		String strImg;
		
		strImg = trendList.get(1).getElementsByTag("ht:picture").text();
		System.out.println(strImg);
		return strImg;
	}
	
}
