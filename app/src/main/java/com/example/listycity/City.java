package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {

    /**
     * The name of the city
     */
    private String city;

    /**
     * The province where the city is located
     */
    private String province;

    /**
     * City constructor: Creates a city with the provided name and province.
     *
     * @param city     The name of the city
     * @param province The province where the city is located
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of current city
     *
     * @return The current cities name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Returns the name of current province.
     *
     * @return The current Province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city for natural ordering.
     *
     * @param o The city to compare
     * @return A negative integer, zero, or a positive integer
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Determines whether two cities are equal based on name and province. [cite: 216-220]
     *
     * @param o The object to compare
     * @return true if equals too otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof City) {
            City cityObj = (City) o;
            return java.util.Objects.equals(this.city, cityObj.city) &&
                    java.util.Objects.equals(this.province, cityObj.province);
        } else {
            return false;
        }
    }

    /**
     * Returns a hash code value for this city.
     *
     * @return Hash code based on city and province
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(city, province);
    }
}