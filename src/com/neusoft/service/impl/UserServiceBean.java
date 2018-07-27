package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.UserMapper;
import com.neusoft.po.User;
import com.neusoft.service.UserService;

@Service
public class UserServiceBean implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public boolean login(User user) throws Exception {
		boolean isok=false;
		User u=mapper.findUserinfoByUsername(user);
		if(u==null||u.getUserpassword()==null||u.getUserpassword()==""||user.getUserpassword()==null||user.getUserpassword()==""){
			isok=false;
		}else if(u.getUserpassword().equals(user.getUserpassword())){
			isok=true;
		}
		return isok;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		boolean isok=false;
		int result=mapper.updateUser(user);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public User findUserinfoByUsername(User user) throws Exception {
		return mapper.findUserinfoByUsername(user);
	}

}
