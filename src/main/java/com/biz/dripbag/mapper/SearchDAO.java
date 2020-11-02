package com.biz.dripbag.mapper;


import java.util.List;
import java.util.Map;

public interface SearchDAO 
{
	 public List<Map<String, String>> selectColumn(String table); 
	 public List<Map<String, String>> searchListMap(String[] test);
}
