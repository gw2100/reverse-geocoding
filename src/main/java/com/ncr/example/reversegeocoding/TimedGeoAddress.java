package com.ncr.example.reversegeocoding;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TimedGeoAddress {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnoreProperties
    private long id;
    
    private double lat;
    private double lng;
    

//    @Embedded
//    private Address address;
    private String address;
    public TimedGeoAddress() {
       
    }
    public TimedGeoAddress(double lat,double lng,String address, Date lastAccessedTime) {
        this.lat=lat;
        this.lng=lng;
        this.address = address;
        this.lastAccessedTime = lastAccessedTime;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date lastAccessedTime;

    public String getAddress() {
        return address;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getLastAccessedTime() {
        return lastAccessedTime;
    }
    public void setLastAccessedTime(Date lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

}
