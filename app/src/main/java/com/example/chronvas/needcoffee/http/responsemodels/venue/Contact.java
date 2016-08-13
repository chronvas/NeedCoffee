
package com.example.chronvas.needcoffee.http.responsemodels.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Contact {

    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("facebookUsername")
    @Expose
    private String facebookUsername;
    @SerializedName("facebookName")
    @Expose
    private String facebookName;

    /**
     * @return The twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter The twitter
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return The facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook The facebook
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return The facebookUsername
     */
    public String getFacebookUsername() {
        return facebookUsername;
    }

    /**
     * @param facebookUsername The facebookUsername
     */
    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    /**
     * @return The facebookName
     */
    public String getFacebookName() {
        return facebookName;
    }

    /**
     * @param facebookName The facebookName
     */
    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

}
