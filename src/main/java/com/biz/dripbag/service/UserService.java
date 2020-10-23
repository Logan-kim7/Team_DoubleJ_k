package com.biz.dripbag.service;


import com.biz.dripbag.model.UserVO;

public interface UserService extends GenericService<UserVO, Long>
{
	public boolean checkByUser(UserVO vo, int flag);
	public boolean checkByUser(String id);
}
