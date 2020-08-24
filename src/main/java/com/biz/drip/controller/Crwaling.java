package com.biz.drip.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class Crwaling 
{
	
	public String test() throws IOException
	{
		String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
		Document doc = Jsoup.connect(url).get();
		Elements trendList = doc.select("item");
		String dd = "";
		for(Element one : trendList)
		{
			//System.out.println(one.select("title"));
			System.out.println(one.getElementsByTag("ht:news_item_title").text());
			dd = one.getElementsByTag("ht:news_item_title").text();
			break;
		}
		return dd;
	}
	
}
