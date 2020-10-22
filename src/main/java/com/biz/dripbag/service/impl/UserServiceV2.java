package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;


@Service("UserServiceV2")
public class UserServiceV2 extends UserServiceV1 
{
	
	@Override
	public int checkByUser(UserVO vo, int check) 
	{
		UserVO reqVO = vo;	
		List<UserVO> userList = userDAO.selectAll();
		String[] strCheck = new String[] { vo.getD_email(), vo.getD_password() };
			
		if(userList.size() == 0)  
			return 1;
			
		for(int i= 0; i < strCheck.length; ++i) // 공백체크
		{
			if(strCheck[i].indexOf(" ") != -1)
				return -1;
		}
		
		switch (check) 
		{
			case 1: // 아이디 중복 체크
				for(int i= 0; i < userList.size(); ++i)
					if(userList.get(i).getD_email().equals(reqVO.getD_email())) 
							return 1;
				
			case 2: // 로그인 체크
				for(int i= 0; i < userList.size(); ++i)
					if( userList.get(i).getD_email().equals(reqVO.getD_email()) && 
					    userList.get(i).getD_password().equals(reqVO.getD_password())
					   ) 
						return 2;
			}
		return 0;
	}
}
