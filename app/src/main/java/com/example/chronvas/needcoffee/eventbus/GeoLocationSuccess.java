package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 4/8/2016.
 */

public class GeoLocationSuccess {


    String wholeAddress;

    public GeoLocationSuccess(String wholeAddress) {
        this.wholeAddress = wholeAddress;
    }

    public String getWholeAddress() {
        return wholeAddress;
    }
}
