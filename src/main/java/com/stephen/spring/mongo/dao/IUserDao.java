package com.stephen.spring.mongo.dao;

import com.stephen.spring.mongo.model.User;

public interface IUserDao extends IBaseDao<User, String>{

	User findUserByName(String name);
}
