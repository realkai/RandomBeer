package com.beer.service.dbinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beer.dao.beer.IBeerDao;
import com.beer.domain.Beer;

@Service
@Transactional
public class DbInitService implements IdbInitService{
    
    @Autowired
    private IBeerDao beerDao;

    @Override
    public void init() {
	createBeer();
    }
    
    private void createBeer() {
	for (int i = 0; i < 10; i++) {
	    beerDao.saveNew(beer());
	}
    }
    
    private Beer beer() {
	Beer beer = new Beer();
	beer.setName(DbFiller.getName());
	beer.setAlcoholPercentage(DbFiller.getAlcoholPercentage());
	beer.setBreweryLocation(DbFiller.getBreweryLocation());
	beer.setDescription(DbFiller.getDescription());
	return beer;
    }

}
