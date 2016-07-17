package com.beer.service.dbinit;

public class DbFiller {

    public static String[] NAME = { "aaa 1", "aaa 2", "aaa 3", "aaa 4", "aaa 5" };
    public static String[] DESCRIPTION = { "description 1", "description 2", "description 3" };
    public static String[] ALCOHOL_PERCENTAGE = { "8%", "10%", "12%" };
    public static String[] BREWERY_LOCATION = { "Dublin", "Italia", "Australia", "Germany" };

    public static Data<String> name = new Data<>(NAME);
    public static Data<String> description = new Data<>(DESCRIPTION);
    public static Data<String> alcoholPercentage = new Data<>(ALCOHOL_PERCENTAGE);
    public static Data<String> breweryLocaion = new Data<>(BREWERY_LOCATION);

    public static class Data<T> {
	private T[] data;
	private int index;

	public Data(T[] data) {
	    this.data = data;
	}

	public T next() {
	    if (index == data.length)
		index = 0;

	    return data[index++];
	}
    }

    public static String getName() {
	return name.next();
    }

    public static String getDescription() {
	return description.next();
    }

    public static String getAlcoholPercentage() {
	return alcoholPercentage.next();
    }

    public static String getBreweryLocation() {
	return breweryLocaion.next();
    }

}
