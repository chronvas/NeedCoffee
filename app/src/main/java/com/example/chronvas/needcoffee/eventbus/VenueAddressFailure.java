package com.example.chronvas.needcoffee.eventbus;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by chronvas on 6/8/2016.
 */
public class VenueAddressFailure {

    String venueid;
    LatLng latLng;


    public VenueAddressFailure(String venueid, LatLng latLng) {
        this.venueid = venueid;
        this.latLng = latLng;
    }

    public String gettVenueid() {
        return venueid;
    }

    public LatLng getLatLng() {
        return latLng;
    }

}
