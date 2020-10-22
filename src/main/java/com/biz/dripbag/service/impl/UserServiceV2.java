package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;


@Service("UserServiceV2")
public class UserServiceV2 extends UserServiceV1 
{
	
	@Override
	public int checkByUser(UserVO vo) 
	{
		List<UserVO> userList = userDAO.selectAll();
		UserVO reqVO = vo;	
		String[] strCheck = new String[] { vo.getD_email(), vo.getD_password() };
		
			
		for(int i=0; i <strCheck.length; ++i)
			if(strCheck[i].indexOf(" ") != -1)
				return -1;
		
		if(userList.size() == 0)  
			return 0;
		
		for(int i=0; i<userList.size(); ++i)
		{	
			if(userList.get(i).getD_email().equals(reqVO.getD_email()) == false)
				return 1;


			if( userList.get(i).getD_email().equals(reqVO.getD_email()) && userList.get(i).getD_password().equals(reqVO.getD_password()))
				return 2;
		}
		return 0;
	}
		
}
