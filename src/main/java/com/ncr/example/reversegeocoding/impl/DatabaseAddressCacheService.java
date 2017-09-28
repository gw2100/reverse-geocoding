package com.ncr.example.reversegeocoding.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.example.reversegeocoding.Address;
import com.ncr.example.reversegeocoding.AddressCacheService;
import com.ncr.example.reversegeocoding.TimedGeoAddress;

@Transactional
@Component
public class DatabaseAddressCacheService implements AddressCacheService {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseAddressCacheService.class);
    @Autowired
    private TimedAddressRepository timedAddressRepository;

    @Override
    public String lookup(double lat, double lng) {
        TimedGeoAddress timedAddress = timedAddressRepository.findByLatAndLng( lat, lng);
        if (timedAddress == null || timedAddress.getAddress() == null)
            return null;
        else {
            timedAddressRepository.updateLastAccessedTime(new Date(), lat,lng);
            return timedAddress.getAddress();
        }
    }
    @Override
   
    public void update(double lat,double lng, String address) {
        if (timedAddressRepository.count() == MAX_CACHE_ROW) {
            TimedGeoAddress toBeRemoved = timedAddressRepository.findAllOrderByLastAccessedTime().get(0);
            timedAddressRepository.delete(toBeRemoved);
        }
        TimedGeoAddress timedAddress = new TimedGeoAddress(lat,lng,address, new Date());
        timedAddressRepository.save(timedAddress);
    }

    @Override
    public List<TimedGeoAddress> findAll() {
        return timedAddressRepository.findAllOrderByLastAccessedTime();
    }

}
