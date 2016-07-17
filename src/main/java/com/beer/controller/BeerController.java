package com.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beer.domain.Beer;
import com.beer.service.beer.IBeerService;

@Controller
public class BeerController {

    @Autowired
    private IBeerService beerService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(Model model) {
	// Beer beer = beerService.getById(1L);
	List<Beer> beers = beerService.getAll();
	model.addAttribute("beers", beers);
	return "index";
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Beer>> getAll() {
	List<Beer> beers = beerService.getAll();
	return new ResponseEntity<List<Beer>>(beers, HttpStatus.OK);
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public ResponseEntity<Beer> getRandomBeer() {
	return new ResponseEntity<Beer>(beerService.getRandomBeer(), HttpStatus.OK);
    }

    @RequestMapping(path = "/beer", method = RequestMethod.POST)
    public ResponseEntity<Beer> saveNewBeer(@RequestBody Beer beer) {
	beerService.saveNew(beer);
	return new ResponseEntity<Beer>(beer, HttpStatus.OK);
    }

    public void removeBeer() {

    }

}
