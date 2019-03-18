package com.interview.models;


import java.util.Arrays;

/**
 * Created by abhijeet on 18/03/19.
 */
public class Restaurant extends Measurable {
    private int[] timings;

    public int[] getTimings() {
        return timings;
    }

    public Restaurant(int latitude, int longitude, int[] timings) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timings = timings;
    }

    public boolean isDeliveringInTime(int time) {
        for (int i = 0; i < timings.length; i++) {
            if (timings[i] == time)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "timings=" + Arrays.toString(timings) +
                "latitude=" + latitude +
                "longitude=" + longitude +
                '}';
    }
}
