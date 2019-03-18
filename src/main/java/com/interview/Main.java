package com.interview;

import com.interview.models.Restaurant;
import com.interview.models.User;
import com.interview.modules.RestaurantFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 18/03/19.
 */
public class Main {
    public static void main(String[] args) {
        List<Restaurant> allRestaurants = new ArrayList<Restaurant>();
        allRestaurants.add(new Restaurant(1, 2, new int[]{7, 8, 9, 10, 13, 14, 15}));
        allRestaurants.add(new Restaurant(2, 3, new int[]{7, 8, 9, 13, 14, 15}));
        Restaurant restaurant = new Restaurant(4, 4, new int[]{8, 9, 10, 13, 14, 15});
        allRestaurants.add(restaurant);
        allRestaurants.add(new Restaurant(-5, -10, new int[]{7, 8, 9, 10, 13, 14, 15}));

        User user = new User("Abhijeet", 0, 0);

        List<Restaurant> selectedRestaurant = new ArrayList<Restaurant>();
        selectedRestaurant.add(restaurant);

        RestaurantFilter restaurantFilter = new RestaurantFilter(10, allRestaurants);

        System.out.println(restaurantFilter.getRestaurants(user, selectedRestaurant, new int[] {8, 9, 10}));

    }
}
