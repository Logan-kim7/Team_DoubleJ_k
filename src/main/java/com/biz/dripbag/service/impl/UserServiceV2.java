package com.biz.dripbag.service.impl;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;



@Service("UserServiceV2")
public class UserServiceV2 extends UserServiceV1 
{
	@Override
	public boolean findById(int flag, UserVO vo, String id) 
	{
		if(vo != null && (vo.getD_email().indexOf(" ") != -1 || vo.getD_password().indexOf(" ") != -1))
			return false;
		
		if((id != null && id.indexOf(" ") != -1))
			return false;

		
		switch (flag) 
		{
			case 0:
				if(userDAO.findById(vo.getD_email()) == null);
					return true;
				
			case 1:
				if(userDAO.findById(id) == null)
					return true;
			
			case 2:
				if(vo != null && userDAO.findByUser(vo.getD_email(), vo.getD_password()) != null)
					return true;
		}	
		
		return false;
	}
}
