package com.example.chronvas.needcoffee.eventbus;

import java.util.List;

/**
 * Created by chronvas on 6/8/2016.
 */

public class VenueCategoriesSuccess {

    String venueid;
    List<String> categories;

    public VenueCategoriesSuccess(String venueid, List<String> categories) {
        this.venueid = venueid;
        this.categories = categories;
    }

    public String getVenueid() {
        return venueid;
    }

    public List<String> getCategories() {
        return categories;

    }
}
