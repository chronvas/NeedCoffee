package com.example.chronvas.needcoffee.eventbus;

/**
 * Created by chronvas on 6/8/2016.
 */
public class VenueNameSuccess {

    String venue_id;
    String name;

    public VenueNameSuccess(String venue_id, String name) {
        this.venue_id = venue_id;
        this.name = name;
    }

    public String getVenue_id() {
        return venue_id;
    }

    public String getName() {
        return name;
    }
}
