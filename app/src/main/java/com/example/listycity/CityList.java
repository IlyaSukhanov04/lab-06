package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city
     *         This is a candidate city to add
     * @throws IllegalArgumentException
     *         If the candidate city is already in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return
     *         Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a city exists in the list.
     *
     * @param city
     *         City to check
     * @return
     *         Check on if the city is in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list. If no city found throw an exception.
     *
     * @param city
     *         City to delete
     * @throws NoSuchElementException
     *         Exception if no city found to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new NoSuchElementException();
        }
        cities.remove(city);
    }

    /**
     * Returns the count of cities in the list
     *
     * @return
     *         The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}