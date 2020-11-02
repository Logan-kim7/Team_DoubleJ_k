package com.biz.dripbag.mapper;

import org.apache.ibatis.annotations.Param;

import com.biz.dripbag.model.UserVO;

public interface UserDAO extends GenericDAO<UserVO, Long>
{
	public UserVO findByUser(@Param("d_email")String id, @Param("d_password")String pwd);
}
