package com.neusoft.mapper;

import com.neusoft.po.User;

public interface UserMapper {
	
	public User findUserinfoByUsername(User user) throws Exception;
	public int updateUser(User user) throws Exception;
}
