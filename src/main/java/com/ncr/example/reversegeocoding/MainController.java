package com.ncr.example.reversegeocoding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
class MainController {
    @Autowired
    private AddressCacheService addressCacheService;
    @Autowired
    private ReverseGeocodingService reverseGeocodingService;

	@RequestMapping(path="search", method = RequestMethod.GET)
	String getAddress(@RequestParam double latitude,@RequestParam double longitude) {
		this.validateInputr(latitude,longitude);
		return this.reverseGeocodingService.findAddressByLatLng(latitude,longitude).toString();
	}
	   @RequestMapping(method = RequestMethod.GET)
	   List<TimedGeoAddress> getAllCachedAddresses() {
	        return this.addressCacheService.findAll();
	    }

	private void validateInputr(double latitude ,double  longitude) {
	    if(latitude >90 || latitude <-90||longitude >180||longitude <-180 )
	        throw new InvalidGeoLocationException(" You input are: "+latitude+", "+longitude);
	}
}