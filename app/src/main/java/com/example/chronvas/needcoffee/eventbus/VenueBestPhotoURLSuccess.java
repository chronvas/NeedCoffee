package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 5/8/2016.
 */

public class VenueBestPhotoURLSuccess {

    String bestPhotoURL;
    String venueId;

    public VenueBestPhotoURLSuccess(String venueId, String bestPhotoURL) {
        this.bestPhotoURL = bestPhotoURL;
        this.venueId = venueId;
    }

    public String getBestPhotoURL() {
        return bestPhotoURL;
    }

    public String getVenueId() {
        return venueId;
    }
}
