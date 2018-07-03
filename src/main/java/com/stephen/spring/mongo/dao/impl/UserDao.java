package com.stephen.spring.mongo.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.stephen.spring.mongo.dao.IUserDao;
import com.stephen.spring.mongo.model.User;

@Repository
public class UserDao extends BaseDao<User, String> implements IUserDao {

	public User findUserByName(String name) {
	    Query query = new Query();
	    query.addCriteria(Criteria.where("user_name").is(name));
		return getMongoTemplate().findOne(query, User.class);
	}
}
