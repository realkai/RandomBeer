<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="static/css/app.css">
<title>Random Beer</title>
</head>
<body ng-app="myApp">

	<div ng-controller="RandomController as randCtrl">
		<table>
			<tr>
				<th>Random Beer ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Date</th>
				<th>Alcohol</th>
				<th>Brewery</th>
			</tr>
			<tr>
				<td>{{randCtrl.randomBeer.id}}</td>
				<td>{{randCtrl.randomBeer.name}}</td>
				<td>{{randCtrl.randomBeer.description}}</td>
				<td>{{randCtrl.randomBeer.createDate}}</td>
				<td>{{randCtrl.randomBeer.alcoholPercentage}}</td>
				<td>{{randCtrl.randomBeer.breweryLocation}}</td>
			</tr>
			<tr>
				<td><button ng-click="randCtrl.fetchRandomBeer()">Show
						Another Beer</button></td>
			</tr>
		</table>
		<br> <br>
	</div>
	<div ng-controller="BeerController as beerCtrl">
		<table>
			<tr>
				<td>Beer Name</td>
				<td><input type="text" ng-model="beerCtrl.tempBeer.name" required /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" ng-model="beerCtrl.tempBeer.description" required /></td>
			</tr>
			<tr>
				<td>Alcohol</td>
				<td><input type="text"
					ng-model="beerCtrl.tempBeer.alcoholPercentage" required /></td>
			</tr>
			<tr>
				<td>Brewery</td>
				<td><input type="text"
					ng-model="beerCtrl.tempBeer.breweryLocation" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit"
						ng-click="beerCtrl.addNewBeer(beerCtrl.tempBeer)">Add New
						Beer</button></td>
			</tr>

		</table>

		<h2>Below is the Beer list!</h2>
		<table>
			<tr>
				<td><button ng-click="beerCtrl.remove()">Remove</button></td>
			</tr>
			<tr>
				<th></th>
				<th>Beer ID</th>
				<th>Beer Name</th>
				<th>Description</th>
				<th>Date</th>
				<th>Alcohol</th>
				<th>Brewery</th>
			</tr>

			<tr ng-repeat="beer in beerCtrl.beers">
				<td><input type="checkbox" value="{{beer.id}}" /></td>
				<td>{{beer.id}}</td>
				<td>{{beer.name}}</td>
				<td>{{beer.description}}</td>
				<td>{{beer.createDate}}</td>
				<td>{{beer.alcoholPercentage}}</td>
				<td>{{beer.breweryLocation}}</td>
			</tr>
		</table>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script type="text/javascript" src="static/js/app.js"></script>
</body>
</html>