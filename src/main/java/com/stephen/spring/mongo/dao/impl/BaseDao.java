package com.stephen.spring.mongo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.stephen.spring.mongo.dao.IBaseDao;

public class BaseDao<T, ID extends Serializable> implements IBaseDao<T,  ID > {

    MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext;
    MongoEntityInformation<T, ID> entityInformation;
    MongoRepository<T, ID> mongoRepository;

    @Autowired
    protected MongoOperations mongoTemplate;
    protected Class<T> entityClass;
    
    public MongoOperations getMongoTemplate() {
		return mongoTemplate;
	}
    
	@Autowired
    public void setMongoTemplate(MongoOperations mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		setEntityClass(getEntityClass());
	}
    
	@SuppressWarnings("unchecked")
	public void setEntityClass(Class<T> entityClass) {
		MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext = this.mongoTemplate
				.getConverter().getMappingContext();
		MongoPersistentEntity<?> entity = mappingContext.getPersistentEntity(entityClass);
		MongoEntityInformation<T, ID> entityInformation = new MappingMongoEntityInformation<T, ID>((MongoPersistentEntity<T>) entity);
		this.entityInformation = entityInformation;
		this.mongoRepository = new SimpleMongoRepository<T, ID>(entityInformation, mongoTemplate);
	}
    
    @SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
    	ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();
		this.entityClass = (Class<T>)pt.getActualTypeArguments()[0];
		return this.entityClass;
    }
    
	@Override
	public List<T> findAll() {
		return this.mongoRepository.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return this.mongoRepository.findAll(arg0);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> arg0) {
		return this.mongoRepository.findAll(arg0);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> arg0, Sort arg1) {
		return this.mongoRepository.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> S insert(S arg0) {
		return this.mongoRepository.insert(arg0);
	}

	@Override
	public <S extends T> List<S> insert(Iterable<S> arg0) {
		return this.mongoRepository.insert(arg0);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> arg0) {
		return this.mongoRepository.save(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return this.mongoRepository.findAll(arg0);
	}

	@Override
	public long count() {
		return this.mongoRepository.count();
	}

	@Override
	public void delete(ID arg0) {
		this.mongoRepository.delete(arg0);		
	}

	@Override
	public void delete(T arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(ID arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findOne(ID arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends T> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
