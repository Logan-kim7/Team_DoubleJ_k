package com.biz.dripbag.model.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.dripbag.model.UserVO;

public interface UserDAO 
{
	@Select("SELECT * FROM tbl_user")
	public List<UserVO> sellectAll();
}
