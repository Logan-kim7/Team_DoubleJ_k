package com.biz.dripbag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.biz.dripbag.model.SearchVO;

public interface SearchDAO 
{
	 public Map<String, String> selectColumn(String table);
	 public List<Map<String, String>> selectAll(@Param("table")String table,     @Param("keyword")String keyword);
	 public List<Map<String, String>> selectTitle(@Param("table")String table,   @Param("keyword")String keyword);
	 public List<Map<String, String>> selectContent(@Param("table")String table, @Param("keyword")String keyword);
	 public List<Map<String, String>> selectWriter(@Param("table")String table,  @Param("keyword")String keyword);
	 
	 public List<SearchVO> all(@Param("table")String table,     @Param("keyword")String keyword,  @Param("seqj")String seq);
	 public List<SearchVO> title(@Param("table")String table,   @Param("keyword")String keyword,  @Param("seqj")String seq);
	 public List<SearchVO> content(@Param("table")String table, @Param("keyword")String keyword,  @Param("seqj")String seq);
	 public List<SearchVO> writer(@Param("table")String table,  @Param("keyword")String keyword,  @Param("seqj")String seq);
	 public List<SearchVO> pageSearch(String table);
}
