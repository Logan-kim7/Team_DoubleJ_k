package com.biz.dripbag.service;


import com.biz.dripbag.model.UserVO;

public interface UserService extends GenericService<UserVO, Long>
{
	public int checkByUser(UserVO vo);
}
