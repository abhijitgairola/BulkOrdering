package com.interview.modules;

import com.interview.models.Restaurant;
import com.interview.models.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abhijeet on 18/03/19.
 */
public class RestaurantFilter {

    private int maxDistance = 10;
    private List<Restaurant> allRestaurants;

    public RestaurantFilter(int maxDistance, List<Restaurant> allRestaurants) {
        this.maxDistance = maxDistance;
        this.allRestaurants = allRestaurants;
    }

    public List<Restaurant> getRestaurants(User user, List<Restaurant> alreadySelected, int[] timings) {
        List<Restaurant> filteredList = new ArrayList<Restaurant>();
        if (alreadySelected == null)
            alreadySelected = new ArrayList<Restaurant>();
        for (Restaurant restaurant : allRestaurants) {
            if (alreadySelected.contains(restaurant))
                continue;
            alreadySelected.add(restaurant);
            if (getMinDistance(user, alreadySelected) < maxDistance
                    && isSamePlane(restaurant, alreadySelected)
                    && isTimingsSatisfied(timings, restaurant)) {
                filteredList.add(restaurant);
            }
            alreadySelected.remove(alreadySelected.size() - 1);
        }
        return filteredList;
    }

    /**
     * Private utils functions
     */
    private boolean isSamePlane(Restaurant toCheck, List<Restaurant> alreadySelected) {
        if (alreadySelected == null || alreadySelected.size() == 0)
            return true;
        Restaurant sampleSelected = alreadySelected.get(0);
        boolean latCheck = false, longCheck = false;
        if ((sampleSelected.getLatitude() > 0 && toCheck.getLatitude() > 0) || (sampleSelected.getLatitude() < 0 || toCheck.getLatitude() < 0))
            latCheck = true;
        if ((sampleSelected.getLongitude() > 0 && toCheck.getLongitude() > 0) || (sampleSelected.getLongitude() < 0 || toCheck.getLongitude() < 0))
            longCheck = true;
        return latCheck && longCheck;
    }

    private double getMinDistance(final User user, List<Restaurant> selectedRestaurants) {
        selectedRestaurants.sort(new Comparator<Restaurant>() {
            public int compare(Restaurant obj1, Restaurant obj2) {
                double distance1 = obj1.getDistance(user);
                double distance2 = obj2.getDistance(user);
                if (distance1 > distance2)
                    return -1;
                return 1;
            }
        });
        double distance = 0;
        for (int i = 1; i < selectedRestaurants.size(); i++) {
            distance += selectedRestaurants.get(i - 1).getDistance(selectedRestaurants.get(i));
        }
        distance += selectedRestaurants.get(selectedRestaurants.size() - 1).getDistance(user);
        return distance;
    }

    private boolean isTimingsSatisfied(int[] timings, Restaurant restaurant) {
        for (int i = 0; i < timings.length; i++) {
            if (!restaurant.isDeliveringInTime(timings[i]))
                return false;
        }
        return true;
    }
}
