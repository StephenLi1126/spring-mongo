package com.stephen.spring.mongo.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBaseDao<T, ID extends Serializable> extends MongoRepository<T, ID> {

}
