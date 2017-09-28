package com.ncr.example.reversegeocoding;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReverseGeocodingService {
    
//    51.5    -1.1166667
//    39.195  -94.68194
//    46.18806    -123.83
//    -36.1333333 144.75
//    33.52056    -86.8025
//    39.79   -75.23806
//    40.69361    -89.58889
//    36.34333    -88.85028
//    32.0666667  34.7666667
//    48.8833333  2.15
//    40.71417    -74.00639
//    51.45   5.4666667
//    29.42389    -98.49333
//    43.69556    -116.35306
//    40.03222    -74.95778
//    53.6772222  -6.3191667
//    45.4166667  -75.7
//    17.3833333  78.4666667
//    51.52721    0.14559
//    40.76083    -111.89028
//    53.5    -2.2166667
//    51.8630556  -8.58
//    -26.1666667 27.8666667
//    32.64   -117.08333
//    62.9    27.6833333
//    29.61944    -95.63472
//    40.71417    -74.00639

    @Autowired
    private ReverseGeocodingService reverseGeocodingService;
    @Autowired
    private AddressCacheService addressCacheService;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAndAndCount() {
        int i=0;
        reverseGeocodingService.findAddressByLatLng(51.5,  -1.1166667);
        reverseGeocodingService.findAddressByLatLng(51.5,  -1.1166667);
        assert(addressCacheService.findAll().size()==++i);

        reverseGeocodingService.findAddressByLatLng(39.195,  -94.68194);
        assert(addressCacheService.findAll().size()==++i);
        reverseGeocodingService.findAddressByLatLng(46.18806,  - -123.83);
        assert(addressCacheService.findAll().size()==++i);
        reverseGeocodingService.findAddressByLatLng( 32.64, -117.08333);
        assert(addressCacheService.findAll().size()==++i);
        reverseGeocodingService.findAddressByLatLng(33.52056,  -86.8025);
        assert(addressCacheService.findAll().size()==++i);
        reverseGeocodingService.findAddressByLatLng(32.0666667,  34.7666667);
        

     
    }

}
