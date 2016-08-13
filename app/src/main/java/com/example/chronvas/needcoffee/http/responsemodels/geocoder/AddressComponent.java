package com.example.chronvas.needcoffee.http.responsemodels.geocoder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronvas on 4/8/2016.
 */

public class AddressComponent {
    @SerializedName("address_components")
    private List<ComponentItem> componentItems = new ArrayList<>();

    public List<ComponentItem> getComponentItems() {
        return componentItems;
    }

    public void setComponentItems(List<ComponentItem> componentItems) {
        this.componentItems = componentItems;
    }
}
