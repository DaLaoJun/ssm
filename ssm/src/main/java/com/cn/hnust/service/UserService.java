package com.cn.hnust.service;

import com.cn.hnust.pojo.User;

public interface UserService {
	public User getUserByUserName(String userName); 
	
	public User doUserLogin(User user);
}
