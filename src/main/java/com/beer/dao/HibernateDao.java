package com.beer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class HibernateDao<T> implements IHibernateDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public T saveNew(T entity) {
	getSession().save(entity);
	return entity;
    }
    
}
