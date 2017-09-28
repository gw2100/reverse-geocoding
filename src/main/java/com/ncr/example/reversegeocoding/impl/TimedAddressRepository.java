package com.ncr.example.reversegeocoding.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ncr.example.reversegeocoding.TimedGeoAddress;

public interface TimedAddressRepository extends CrudRepository<TimedGeoAddress, Long>{
    
//     @Query("select u from AppConfig u where u.rowId = ?1 order by revision desc")
//    Address findByRowId(long id);
//     
//     @Query("select u from AppConfig u where u.isActive = true order by rowId")
//     List<AppConfig> findAllActive();
    TimedGeoAddress findByLatAndLng(double lat,double lng);
    @Modifying
    @Query("update TimedGeoAddress t set t.lastAccessedTime=?1 where t.lat=?2 and t.lng=?3")
    void updateLastAccessedTime(Date now,double lat,double lng);
    
    @Query("from TimedGeoAddress order by lastAccessedTime")
    List<TimedGeoAddress> findAllOrderByLastAccessedTime();
    
//    @Query("from TimedGeoAddress order by lastAccessedTime")
//    List<TimedGeoAddress> findAllData();
}
