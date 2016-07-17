"use strict";

var app = angular.module('myApp', []);

// service
app.factory('BeerService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				fetchAllBeers : function() {
					return $http.get('http://localhost:9393/all').then(
							function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error fectching beers');
							});
				},
				addNewBeer:function(tempBeer) {
					return $http.post('http://localhost:9393/beer', tempBeer).then(
						function(response){
							return response.data;
						}
					);
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
app.controller('BeerController', [ '$scope', 'BeerService',
		function($scope, BeerService) {
			var self = this;
			self.tempBeer = {name:'',description:'',alcoholPercentage:'',breweryLocation:''};
			self.beers = [];

			self.fetchAllBeers = function() {
				BeerService.fetchAllBeers().then(function(d) {
					self.beers = d;
				}, function(errResponse) {
					console.error('Error fetching beers');
				});
			};
			
			self.addNewBeer = function(tempBeer) {
				BeerService.addNewBeer(tempBeer).then(
					self.fetchAllBeers, function(errResponse) {
						console.error('error adding beer');
					}
				);
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