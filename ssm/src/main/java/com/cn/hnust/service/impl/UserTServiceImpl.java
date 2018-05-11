package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UserTMapper;
import com.cn.hnust.pojo.UserT;
import com.cn.hnust.service.UserTService;

@Service("userTService")
public class UserTServiceImpl implements UserTService{
	@Resource  
    private UserTMapper userDao;  
    /*@Override  
    public UserT getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }*/

	public UserT getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}  
	
}
