package com.ncr.example.reversegeocoding;


import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Address {

    protected String streetAddress;
    protected String city;
    protected String state;
    protected String postalCode;
    protected String country;

    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public static Address parse(String addressStr) {
        //input should be in this format: 277 Bedford Ave, Brooklyn, NY 11211, USA
        String[] strS = addressStr.split(",");
        if (strS.length != 4)
            throw new RuntimeException("address format error: " + addressStr);
        Address a = new Address();
        a.streetAddress = strS[0].trim();
        a.city = strS[1].trim();
        String[] stateZip = strS[2].trim().split(" ");
        System.out.println("stateZip.length="+stateZip.length);
        if (stateZip.length != 2)
            throw new RuntimeException("address format error: " +  strS[2]);
        a.state = stateZip[0].trim();
        a.postalCode = stateZip[1].trim();
        a.country = strS[3].trim();
        return a;
    }
    public String toString() {
        return streetAddress+", "+city+", "+state+" "+postalCode;
    }

}
