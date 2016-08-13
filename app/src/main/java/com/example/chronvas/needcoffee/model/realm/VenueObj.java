package com.example.chronvas.needcoffee.model.realm;

import io.realm.RealmObject;

/**
 * Created by chronvas on 5/8/2016.
 */

public class VenueObj extends RealmObject {

    public VenueObj(){}

    private String venueid;
    private String bestphotourl;
    private String name;
    private String description;
    private int rating;
    private double latitude;
    private double longtitude;

    public String getVenueid() {
        return venueid;
    }

    public void setVenueid(String venueid) {
        this.venueid = venueid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getBestphotourl() {
        return bestphotourl;
    }

    public void setBestphotourl(String bestphotourl) {
        this.bestphotourl = bestphotourl;
    }
}
