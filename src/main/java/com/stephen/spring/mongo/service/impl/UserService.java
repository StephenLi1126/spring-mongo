package com.stephen.spring.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.spring.mongo.dao.IUserDao;
import com.stephen.spring.mongo.model.User;
import com.stephen.spring.mongo.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	public User findUserByName(String name) {
		return this.userDao.findUserByName(name);
	}

	@Override
	public int count() {
		return (int) this.userDao.count();
	}

}
