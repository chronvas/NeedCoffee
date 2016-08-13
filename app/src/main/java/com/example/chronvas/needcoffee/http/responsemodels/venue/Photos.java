
package com.example.chronvas.needcoffee.http.responsemodels.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photos {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups")
    @Expose
    private List<Group_> groups = new ArrayList<Group_>();

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The groups
     */
    public List<Group_> getGroups() {
        return groups;
    }

    /**
     * @param groups The groups
     */
    public void setGroups(List<Group_> groups) {
        this.groups = groups;
    }

}
