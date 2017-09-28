package com.ncr.example.reversegeocoding;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String msg) {
        super("Address not found for geolocation: " + msg);
    }
}
