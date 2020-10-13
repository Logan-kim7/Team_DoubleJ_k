package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceV1 implements UserService 
{
	private final List<UserVO> userList;
		
	@Override
	public void join(UserVO vo)
	{ this.userList.add(vo); }
		
	@Override
	public List<UserVO> selectAll() 
	{
		return null;
	}

	@Override
	public UserVO findById(Long id) 
	{
		return null;
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
	
	
	@Override
	public boolean checkByUser(UserVO vo, int check) 
	{
		UserVO reqVO = vo;	
		/* List<UserVO> userList = selectAll(); */
		String[] strCheck = new String[] { vo.getUserId(), vo.getUserPassword() };
			

		 if(userList.size() == 0)  
			 return false;

		switch (check) 
		{
			case -2:
				for(int i= 0; i < strCheck.length; ++i) // 공백 널값 체크
				{
					strCheck[i] = strCheck[i].trim();
					if(strCheck[i].isEmpty())
						return true;
				}
		
			case 1: // 아이디 중복 체크
				for(int i= 0; i < userList.size(); ++i)
					if(userList.get(i).getUserId().equals(reqVO.getUserId())) 
							return true;
				
			case 2: // 로그인 체크
				for(int i= 0; i < userList.size(); ++i)
					if( userList.get(i).getUserId().equals(reqVO.getUserId()) && 
					    userList.get(i).getUserPassword().equals(reqVO.getUserPassword())
					   ) 
						return true;
			}
		return false;
	}

}
