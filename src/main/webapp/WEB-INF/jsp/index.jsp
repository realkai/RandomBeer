<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="static/css/app.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Random Beer</title>
</head>
<body ng-app="myApp">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<h2 style="color: white; text-align:center;">Random Beer App</h2>

	</div>

	<div class="container">
		<div><br /><br /><br /><br /></div>
		<div class="table-responsive"
			ng-controller="RandomController as randCtrl">
			<table class="table">
				<tr>
					<th>Random Beer ID</th>
					<td>{{randCtrl.randomBeer.id}}</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>{{randCtrl.randomBeer.name}}</td>
				</tr>
				<tr>
					<th>Description</th>
					<td>{{randCtrl.randomBeer.description}}</td>
				</tr>
				<tr>
					<th>Date</th>
					<td>{{randCtrl.randomBeer.createDate}}</td>
				</tr>
				<tr>
					<th>Alcohol</th>
					<td>{{randCtrl.randomBeer.alcoholPercentage}}</td>
				</tr>
				<tr>
					<th>Brewery</th>
					<td>{{randCtrl.randomBeer.breweryLocation}}</td>
				</tr>
				<tr>
					<td><button ng-click="randCtrl.fetchRandomBeer()">Show
							Another Beer</button></td>
				</tr>
			</table>
			<br> <br>
		</div>


		<div class="table-responsive"
			ng-controller="BeerController as beerCtrl">
			<table class="table">
				<tr>
					<td>Beer Name</td>
					<td><input type="text" ng-model="beerCtrl.tempBeer.name"
						required /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text"
						ng-model="beerCtrl.tempBeer.description" required /></td>
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
							ng-click="beerCtrl.addNewBeer(beerCtrl.tempBeer)">Add
							New Beer</button></td>
				</tr>

			</table>

			<table class="table">
				<tr>
					<td><button type="submit"
							ng-click="beerCtrl.remove(beerCtrl.selection)">Remove</button></td>
				</tr>
				<tr>
					<th>#</th>
					<th>Beer ID</th>
					<th>Beer Name</th>
					<th>Description</th>
					<th>Date</th>
					<th>Alcohol</th>
					<th>Brewery</th>
				</tr>

				<tr ng-repeat="beer in beerCtrl.beers">
					<td><input type="checkbox" value="{{beer.id}}"
						ng-checked="beerCtrl.selection.indexOf(beer.id) > -1"
						ng-click="beerCtrl.toggleSelection(beer.id, beer)" /></td>
					<td>{{beer.id}}</td>
					<td>{{beer.name}}</td>
					<td>{{beer.description}}</td>
					<td>{{beer.createDate}}</td>
					<td>{{beer.alcoholPercentage}}</td>
					<td>{{beer.breweryLocation}}</td>
				</tr>
			</table>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script type="text/javascript" src="static/js/app.js"></script>
</body>
</html>