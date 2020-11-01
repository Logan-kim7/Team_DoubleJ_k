package com.biz.dripbag.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SearchDAO 
{
	public List<Map<String, String>> selectAll(@Param("table") String table);
}
