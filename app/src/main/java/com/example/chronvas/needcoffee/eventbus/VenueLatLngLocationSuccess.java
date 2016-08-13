package com.example.chronvas.needcoffee.eventbus;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by chronvas on 6/8/2016.
 */
public class VenueLatLngLocationSuccess {

    String venueid;
    LatLng venueLatLng;

    public VenueLatLngLocationSuccess(String venue_id, LatLng venueLatLng) {
        this.venueid = venue_id;
        this.venueLatLng = venueLatLng;
    }

    public String getVenueid() {
        return venueid;
    }

    public LatLng getVenueLatLng() {
        return venueLatLng;
    }
}
