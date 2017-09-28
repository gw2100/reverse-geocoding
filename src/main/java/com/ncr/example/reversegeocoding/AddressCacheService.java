package com.ncr.example.reversegeocoding;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AddressCacheService {
    public static final int MAX_CACHE_ROW = 10;
    String lookup(double lat, double lng);
    /**
     *   if less then maxed capacity
     *     add one
     *   else
     *     remove least accessed;
     *     add one
     * @param address
     */
    void update(double lat, double lng,String address);
    List<TimedGeoAddress> findAll();
}
