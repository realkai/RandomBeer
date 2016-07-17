package com.beer.dao.beer;

import java.util.List;

import com.beer.dao.IHibernateDao;
import com.beer.domain.Beer;

public interface IBeerDao extends IHibernateDao<Beer> {

    Beer getById(Long id);
    
    List<Beer> getAll();
    
    void deleteById(Long id);
    
    Beer getRandomBeer();
}
