package com.example.chronvas.needcoffee.eventbus;


import android.location.Location;

/**
 * Created by chronvas on 3/8/2016.
 */

public class FusedlocationSuccess {

    Location location;

    public FusedlocationSuccess(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

}
