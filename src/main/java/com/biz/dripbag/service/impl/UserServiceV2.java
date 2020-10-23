package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;


@Service("UserServiceV2")
public class UserServiceV2 extends UserServiceV1 
{
	
	@Override
	public boolean checkByUser(UserVO vo, int flag) 
	{
		List<UserVO> userList = userDAO.selectAll();
		
		if(vo.getD_email().indexOf(" ") != -1 || vo.getD_password().indexOf(" ") != -1)
			return false;
		
		if(userList.size() == 0)  
			return true;
		
		switch (flag) 
		{
     	  case 1:
			for(int i=0; i<userList.size(); ++i)
				if(userList.get(i).getD_email().equals(vo.getD_email()) == false)
					return true;
		  case 2:
			for(int i=0; i<userList.size(); ++i)
				if(userList.get(i).getD_password().equals(vo.getD_password()))
					return false;
		}
		return false;
	}
	
	public boolean checkByUser(String id)
	{
		if(id.equals("Master"))
			return true;
		
		List<UserVO> userList = userDAO.selectAll();
		
		if(id.indexOf(" ") != -1)
			return false;
		
		for(int i=0; i<userList.size(); ++i)
			if(userList.get(i).getD_email().equals(id) == false)
				return true;
		
		return false;
	}
		
}
