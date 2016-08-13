package com.example.chronvas.needcoffee.eventbus;

import android.location.Location;

/**
 * Created by chronvas on 3/8/2016.
 */

public class SomeSucess {

    Location location;
    String s;
    public SomeSucess(String s) {
        this.s = s;
    }

    public String getLocation() {
        return s;
    }
}
