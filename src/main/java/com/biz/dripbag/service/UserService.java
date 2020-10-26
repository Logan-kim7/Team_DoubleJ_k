package com.biz.dripbag.service;


import com.biz.dripbag.model.UserVO;

public interface UserService extends GenericService<UserVO, Long>
{
	public boolean findById(int flag, UserVO vo, String id);
}
