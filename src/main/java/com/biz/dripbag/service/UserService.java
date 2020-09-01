package com.biz.dripbag.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.dripbag.model.UserVO;

public interface UserService 
{
	@Select("SELECT * FROM tbl_user")
	public List<UserVO> sellectAll();
}
