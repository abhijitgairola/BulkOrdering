package com.interview.models;

/**
 * Created by abhijeet on 18/03/19.
 */
public abstract class Measurable {
    int latitude, longitude;

    public double getDistance(Measurable anotherRestaurant) {
        return Math.sqrt((Math.pow(Math.abs(this.latitude - anotherRestaurant.latitude) , 2)
                + Math.pow(Math.abs(this.longitude - anotherRestaurant.longitude), 2)));
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
