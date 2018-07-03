package com.stephen.spring.mongo.service;

import com.stephen.spring.mongo.model.User;

public interface IUserService {

	User findUserByName(String name);
	int count();
}
