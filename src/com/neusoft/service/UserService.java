package com.neusoft.service;

import com.neusoft.po.User;

public interface UserService {

	public boolean login(User user) throws Exception;
	public boolean updateUser(User user) throws Exception;
	public User findUserinfoByUsername(User user) throws Exception;
}
