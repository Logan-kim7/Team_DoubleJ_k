package com.biz.dripbag.service;

import java.util.List;
import java.util.Map;

public interface SearchService 
{
	public List<Map<String, String>> search(String table, String flag, String keyword);
}
