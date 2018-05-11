package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UserMapper;

import com.cn.hnust.pojo.User;

import com.cn.hnust.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource  
    private UserMapper userDao;  

	@Override
	public User getUserByUserName(String userName) {
		
		return userDao.selectByPrimaryKey(userName);
	}

	@Override
	public User doUserLogin(User user) {
		
		return userDao.selectByPrimaryKey(user.getUsername());
	}  
	
}
