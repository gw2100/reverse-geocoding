package com.ncr.example.reversegeocoding;

public class InvalidGeoLocationException extends RuntimeException {
    private static String msg="User input error: Latitude must be between -90 and 90, Longitude must be between -180 and 180";
    public InvalidGeoLocationException() {
        super(msg);
    }
    public InvalidGeoLocationException(String message) {
        super(msg+message);
    }

}
