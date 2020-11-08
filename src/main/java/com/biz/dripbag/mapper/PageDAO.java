package com.biz.dripbag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.dripbag.model.SearchVO;

public interface PageDAO  
{
	public List<SearchVO> test(@Param("table")  String table, 
							   @Param("seq")    long seq, 
							   @Param("max")    String max, 
							   @Param("flag")   String flag,
							   @Param("search") String search
							  );
	
	public List<SearchVO> testj(@Param("table")  String table, 
			   					@Param("seq")    long seq, 
			   					@Param("max")    String max, 
			   					@Param("flag")   String flag,
								@Param("search") String search
								);
	
	public int size(@Param("table") String table, @Param("search") String search);
	public int sizej(@Param("table") String table, @Param("seqj") long seqj, @Param("search") String search);
}
