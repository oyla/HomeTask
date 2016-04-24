/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author Oyla
 */
class Address {

    private String country;
    private String city;
    private String street;
    private int bld;
    private int flat;

    public Address() {
        this("", "", "", 0, 0);
    }

    public Address(String country, String city, String street, int bld, int flat) {
        setCountry(country);
        setCity(city);
        setStreet(street);
        setBld(bld);
        setFlat(flat);
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return the bld
     */
    public int getBld() {
        return bld;
    }

    /**
     * @return the flat
     */
    public int getFlat() {
        return flat;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @param bld the bld to set
     */
    public void setBld(int bld) {
        if (bld < 0) {
            this.bld = 0;
        } else {
            this.bld = bld;
        }
    }

    /**
     * @param flat the flat to set
     */
    public void setFlat(int flat) {
        if (flat < 0) {
            this.flat = 0;
        } else {
            this.flat = flat;
        }
    }

    public String showAddress() {
        String s = "";
        if (getCountry().isEmpty() && getCity().isEmpty() && getStreet().isEmpty() && bld == 0 && flat == 0) {
            s = "Unknown address";
        } else {
            if (!getCountry().isEmpty()) {
                s += getCountry() + " ";
            }
            if (!getCity().isEmpty()) {
                s += getCity() + " ";
            }
            if (!getStreet().isEmpty()) {
                s += getStreet() + " ";
            }
            if (bld > 0) {
                s += getBld() + " ";
            }
            if (flat > 0) {
                s += getFlat();
            }
        }

        return s;
    }
}
