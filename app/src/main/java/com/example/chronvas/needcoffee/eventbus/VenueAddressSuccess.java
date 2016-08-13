package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 6/8/2016.
 */
public class VenueAddressSuccess {

    String address;
    String venue_id;

    public VenueAddressSuccess(String venue_id, String address) {
        this.venue_id = venue_id;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getVenue_id() {
        return venue_id;
    }
}
