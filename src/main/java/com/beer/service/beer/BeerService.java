package com.beer.service.beer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beer.dao.beer.IBeerDao;
import com.beer.domain.Beer;

@Service
@Transactional
public class BeerService implements IBeerService {

    @Autowired
    private IBeerDao beerDao;

    @Override
    public Beer getById(Long id) {
	Beer beer = beerDao.getById(id);
	return beer;
    }

    @Override
    public List<Beer> getAll() {
	return beerDao.getAll();
    }

    @Override
    public Beer getRandomBeer() {
	return beerDao.getRandomBeer();
    }

    @Override
    public Beer saveNew(Beer beer) {
	return beerDao.saveNew(beer);
    }

    @Override
    public void deleteById(Long id) {
	beerDao.deleteById(id);
    }
    
    
}
