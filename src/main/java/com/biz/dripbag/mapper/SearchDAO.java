package com.biz.dripbag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SearchDAO 
{
	 public Map<String, String> selectColumn(String table);
	 public List<Map<String, String>> selectAll(@Param("table")String table, @Param("keyword")String keyword);
	 public List<Map<String, String>> selectTitle(@Param("table")String table, @Param("keyword")String keyword);
	 public List<Map<String, String>> selectContent(@Param("table")String table, @Param("keyword")String keyword);
	 public List<Map<String, String>> selectWriter(@Param("table")String table, @Param("keyword")String keyword);
}
