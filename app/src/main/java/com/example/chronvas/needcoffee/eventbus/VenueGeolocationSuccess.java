package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 6/8/2016.
 */

public class VenueGeolocationSuccess {

    String wholeAddress;


    String venueid;

    public VenueGeolocationSuccess(String venueid, String wholeAddress) {
        this.venueid = venueid;
        this.wholeAddress = wholeAddress;
    }


    public String getWholeAddress() {
        return wholeAddress;
    }

    public String getVenueid() {
        return venueid;
    }
}
