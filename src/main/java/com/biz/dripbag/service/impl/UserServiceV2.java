package com.biz.dripbag.service.impl;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;

@Service("userServiceV2")
public class UserServiceV2 extends UserServiceV1 
{	
	@Override
	public UserVO findById(int flag, UserVO vo, String id) 
	{
		if(vo != null && (vo.getEmail().indexOf(" ") != -1 || vo.getPwd().indexOf(" ") != -1))
			return null;
		
		if((id != null && id.indexOf(" ") != -1))
			return null;
		
		switch (flag) 
		{
			case 0:
				if(userDAO.findById(vo.getEmail()) == null) return vo = new UserVO();
				break;
				
			case 1:
				if(userDAO.findById(id) == null) return vo = new UserVO();
				break;
				
			case 2:
				vo = userDAO.findByUser(vo.getEmail(), vo.getPwd());
				if(vo != null) return vo;
				break;
		}	
		
		return null;
	}
}
