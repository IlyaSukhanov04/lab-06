package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        City Same = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(Same));

        City Calg = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(Calg));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        City Calg2 = new City("Calgary", "Alberta");
        cityList.add(Calg2);
        assertEquals(2, cityList.countCities());

        cityList.delete(Calg2);

        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(Calg2));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        City vancouver = new City("Vancouver", "British Columbia");

        assertThrows(java.util.NoSuchElementException.class, () -> {
            cityList.delete(vancouver);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }
}