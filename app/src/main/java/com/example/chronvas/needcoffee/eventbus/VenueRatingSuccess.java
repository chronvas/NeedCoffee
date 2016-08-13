package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 6/8/2016.
 */

public class VenueRatingSuccess {

    float rating;

    String venueId;

    public VenueRatingSuccess(String venueId, float rating) {
        this.rating = rating;
        this.venueId = venueId;
    }

    public float getRating() {
        return rating;
    }

    public String getVenueId() {
        return venueId;
    }
}
