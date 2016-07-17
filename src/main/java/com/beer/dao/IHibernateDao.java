package com.beer.dao;


public interface IHibernateDao<T> {
    
    T saveNew(T entity);
    
    void update(T entity);
    
}
