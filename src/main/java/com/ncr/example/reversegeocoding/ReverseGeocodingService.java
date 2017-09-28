package com.ncr.example.reversegeocoding;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ReverseGeocodingService {
    String findAddressByLatLng(double latitude,double longitude);
}
