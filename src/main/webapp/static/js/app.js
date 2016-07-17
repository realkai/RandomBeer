"use strict";

var host = 'http://localhost:9393';

var app = angular.module('myApp', []);

// service
app.factory('BeerService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				fetchAllBeers : function() {
					return $http.get(host + '/all').then(function(response) {
						return response.data;
					}, function(errResponse) {
						console.error('Error fectching beers');
					});
				},
				addNewBeer : function(tempBeer) {
					return $http.post(host + '/beer', tempBeer).then(
							function(response) {
								return response.data;
							}, 
							function(errResponse) {
								console.error('Error ');
							});
				},
				removeBeers : function(selection) {
					return $http.post(host + '/remove', selection).then(
							function(response) {
								return response.data;
							}, 
							function(errResponse) {
								console.error('Error ');
							});
				}
			};
		} ]);

app.factory('RandomService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				fetchRandomBeer : function() {
					return $http.get('http://localhost:9393/random').then(
							function(response) {
								return response.data
							}, function(errResponse) {
								console.error('Error fectching beers');
							});
				}
			};
		} ]);

// controller
app.controller('BeerController', [
		'$scope',
		'BeerService',
		function($scope, BeerService) {
			var self = this;
			self.tempBeer = {
				name : '',
				description : '',
				alcoholPercentage : '',
				breweryLocation : ''
			};
			self.beers = [];
			self.selection = [];
			self.beerIndexList=[];

			self.fetchAllBeers = function() {
				BeerService.fetchAllBeers().then(function(d) {
					self.beers = d;
				}, function(errResponse) {
					console.error('Error fetching beers');
				});
			};

			self.addNewBeer = function(tempBeer) {
				BeerService.addNewBeer(tempBeer).then(self.fetchAllBeers,
						function(errResponse) {
							console.error('error adding beer');
						});
			};

			self.remove = function(selection) {
				if (selection.length > 0) {
					BeerService.removeBeers(selection).then(self.fetchAllBeers,
							function(){
						for(var i=0;i<self.beerIndexList.length;i++){
							self.beers.splice(self.beerIndexList[i],1);
						}
					});

					self.selection = [];
					self.beerIndexList= [];
				}
			}

			self.toggleSelection = function(id, beer) {
				var idx = self.selection.indexOf(id);
				
				var beerPos = self.beers.indexOf(beer);
				var beerIdx = self.beerIndexList.indexOf(beerPos);
				
				if (idx > -1) {
					self.selection.splice(idx, 1);
					self.beerIndexList.splice(beerIdx, 1);
				} else {
					self.selection.push(id);
					self.beerIndexList.push(beerPos)
				}
			};

			self.fetchAllBeers();

		} ]);

app.controller('RandomController', [ '$scope', 'RandomService',
		function($scope, RandomService) {
			var self = this;
			self.randomBeer = null;

			self.fetchRandomBeer = function() {
				RandomService.fetchRandomBeer().then(function(data) {
					self.randomBeer = data;
				}, function(errResponse) {
					console.error('Error fetching random beer');
				});
			};

			self.fetchRandomBeer();
		} ]);