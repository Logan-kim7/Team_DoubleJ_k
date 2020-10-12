package com.biz.dripbag.service;


import com.biz.dripbag.model.UserVO;

public interface UserService extends GenericService<UserVO, Long>
{
	public void join(UserVO vo);
	public boolean checkByUser(UserVO vo, int check);
}
