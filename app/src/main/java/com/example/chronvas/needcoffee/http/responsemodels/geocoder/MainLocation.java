package com.example.chronvas.needcoffee.http.responsemodels.geocoder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronvas on 4/8/2016.
 */

public class MainLocation {

    @SerializedName("results")
    private List<AddressComponent> results = new ArrayList<>();

    public AddressComponent getResults() {

        if (!results.isEmpty() && results != null) {
            return results.get(0);
        } else {
            return null;
        }

    }

    public void setResults(List<AddressComponent> results) {
        this.results = results;
    }


}
