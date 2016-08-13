
package com.example.chronvas.needcoffee.http.responsemodels.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Attributes {

    @SerializedName("groups")
    @Expose
    private List<Group____> groups = new ArrayList<Group____>();

    /**
     * @return The groups
     */
    public List<Group____> getGroups() {
        return groups;
    }

    /**
     * @param groups The groups
     */
    public void setGroups(List<Group____> groups) {
        this.groups = groups;
    }

}
