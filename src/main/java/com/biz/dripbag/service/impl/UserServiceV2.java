package com.biz.dripbag.service.impl;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;



@Service("userServiceV2")
public class UserServiceV2 extends UserServiceV1 
{
	@Override
	public boolean findById(int flag, UserVO vo, String id) 
	{
		if(vo != null && (vo.getEmail().indexOf(" ") != -1 || vo.getPwd().indexOf(" ") != -1))
			return false;
		
		if((id != null && id.indexOf(" ") != -1))
			return false;

		
		switch (flag) 
		{
			case 0:
				if(userDAO.findById(vo.getEmail()) == null);
					return true;
				
			case 1:
				if(userDAO.findById(id) == null)
					return true;
			
			case 2:
				if(vo != null && userDAO.findByUser(vo.getEmail(), vo.getPwd()) != null)
					return true;
		}	
		
		return false;
	}
}
