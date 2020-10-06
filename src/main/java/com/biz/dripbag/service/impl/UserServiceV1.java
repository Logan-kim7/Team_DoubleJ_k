package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.UserDAO;
import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceV1 implements UserService 
{

	private final List<UserVO> userList;
	private final UserDAO userDAO;
	
	@Autowired
	public void temp()
	{
		UserVO userVO = new UserVO();
		userVO.setUserId("1");
		userVO.setUserPassword("1");
		userList.add(userVO);
	}
	
	@Override
	public boolean check(UserVO userVO) 
	{
		for(UserVO vo : userList)
		{
			if(vo.getUserId().equals(userVO.getUserId()) &&  vo.getUserPassword().equals(userVO.getUserPassword()))
				return true;
		}
		return false;
	}

	@Override
	public boolean joincheck(UserVO userVO) 
	{
		for(UserVO vo : userList)
		{
			if(vo.getUserId().equals(userVO.getUserId()))
				return false;
		}
		userList.add(userVO);
		return true;		
	}
	
	@Override
	public List<UserVO> selectAll() 
	{
		return userDAO.selectAll();
	}

	@Override
	public UserVO findById(Long id) 
	{
		return userDAO.findById(id);
	}

	@Override
	public int insert(UserVO vo) 
	{
		return 0;
	}

	@Override
	public int update(UserVO vo) 
	{
		return 0;
	}

	@Override
	public int delete(Long id) 
	{
		return 0;
	}

}
