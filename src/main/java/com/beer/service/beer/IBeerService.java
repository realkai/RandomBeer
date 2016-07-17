package com.beer.service.beer;

import java.util.List;

import com.beer.domain.Beer;

public interface IBeerService {
    
    Beer getById(Long id);
    
    List<Beer> getAll();
    
    Beer getRandomBeer();
    
    Beer saveNew(Beer beer);
    
    void deleteById(Long id);

}
