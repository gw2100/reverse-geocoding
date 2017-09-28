package com.ncr.example.reversegeocoding.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.ncr.example.reversegeocoding.Address;
import com.ncr.example.reversegeocoding.AddressCacheService;
import com.ncr.example.reversegeocoding.AddressNotFoundException;
import com.ncr.example.reversegeocoding.ReverseGeocodingService;


@Component
public class GoogleReverseGeocodingService implements ReverseGeocodingService {
    private static final Logger LOG = LoggerFactory.getLogger(GoogleReverseGeocodingService.class);
    @Autowired
    private AddressCacheService addressCacheService;

//    @Value("${googleUrlReverseGeocoding}")
//    String googleUrlReverseGeocoding = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";

    @Value("${apiKeyForGoogle}")
    String apiKeyForGoogle = "AIzaSyBIOSNA3sP2nqvlI8ilSf_Xk-yR8xXmkZU";

    @Override
    public String findAddressByLatLng(double latitude, double longitude) {
        String key = latitude + "," + longitude;
        String address = addressCacheService.lookup(latitude,longitude);
        if (address == null) {
             address = findFromGoogle(latitude, longitude);          
            addressCacheService.update(latitude,longitude,address);
        }
        return address;
    }
    private String findFromGoogle(double latitude, double longitude) {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKeyForGoogle).build();
        LatLng latlng = new LatLng(latitude, longitude);
        GeocodingResult[] results = null;
        try {
            results = GeocodingApi.newRequest(context).latlng(latlng).await();
        } catch (ApiException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        if (results == null || results.length == 0)
            throw new AddressNotFoundException(latlng.toString());
        LOG.info("result[0]=" + results[0].formattedAddress);       
        return results[0].formattedAddress;
    }
}
