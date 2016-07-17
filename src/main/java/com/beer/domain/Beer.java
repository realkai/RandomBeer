package com.beer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class Beer extends AbstractEntity {

    private static final long serialVersionUID = -7525319626730337083L;

    @Size(max = 100)
    private String name;

    @Type(type = "text")
    private String description;

    @Column(name = "alcohol_percentage", length = 10)
    private String alcoholPercentage;

    @Column(name = "brewery_location")
    private String breweryLocation;

    @Override
    public String toString() {
	return "Beer [name=" + name + ", description=" + description + ", alcoholPercentage=" + alcoholPercentage
		+ ", breweryLocation=" + breweryLocation + "]";
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getAlcoholPercentage() {
	return alcoholPercentage;
    }

    public void setAlcoholPercentage(String alcoholPercentage) {
	this.alcoholPercentage = alcoholPercentage;
    }

    public String getBreweryLocation() {
	return breweryLocation;
    }

    public void setBreweryLocation(String breweryLocation) {
	this.breweryLocation = breweryLocation;
    }

}
