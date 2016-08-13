package com.example.chronvas.needcoffee.eventbus;

import com.example.chronvas.needcoffee.http.responsemodels.search.Venue;

import java.util.List;

/**
 * Created by chronvas on 7/8/2016.
 */
public class VenueBoundedSearchSuccess {
    List<Venue> venues;

    public VenueBoundedSearchSuccess(List<Venue> venues) {
        this.venues = venues;
    }

    public List<Venue> getVenues() {
        return venues;
    }
}
