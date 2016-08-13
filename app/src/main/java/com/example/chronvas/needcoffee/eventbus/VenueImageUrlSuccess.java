package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 5/8/2016.
 */

public class VenueImageUrlSuccess {

    String venueId;
    String venueImageURL;


    public VenueImageUrlSuccess(String venueId, String venueImageURL) {
        this.venueId = venueId;
        this.venueImageURL = venueImageURL;
    }

    public String getVenueId() {
        return venueId;
    }

    public String getVenueImageURL() {
        return venueImageURL;
    }
}
