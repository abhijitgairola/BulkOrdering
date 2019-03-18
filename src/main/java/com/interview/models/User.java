package com.interview.models;

/**
 * Created by abhijeet on 18/03/19.
 */
public class User extends Measurable {
    private String name;

    public User(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }
}
