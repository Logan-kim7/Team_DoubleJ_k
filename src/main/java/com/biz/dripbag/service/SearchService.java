package com.biz.dripbag.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SearchService 
{
	public List<String> selectAll(@Param("table") String table);
}
