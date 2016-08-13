package com.example.chronvas.needcoffee.http.responsemodels.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Venue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("specials")
    @Expose
    private Specials specials;
    @SerializedName("hereNow")
    @Expose
    private HereNow hereNow;
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("venueChains")
    @Expose
    private List<VenueChain> venueChains = new ArrayList<VenueChain>();
    @SerializedName("hasPerk")
    @Expose
    private Boolean hasPerk;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private Boolean allowMenuUrlEdit;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     *
     * @param contact
     * The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     *
     * @param verified
     * The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     *
     * @return
     * The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     *
     * @param stats
     * The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     *
     * @return
     * The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     *
     * @param specials
     * The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     *
     * @return
     * The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     *
     * @param hereNow
     * The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    /**
     *
     * @return
     * The referralId
     */
    public String getReferralId() {
        return referralId;
    }

    /**
     *
     * @param referralId
     * The referralId
     */
    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    /**
     *
     * @return
     * The venueChains
     */
    public List<VenueChain> getVenueChains() {
        return venueChains;
    }

    /**
     *
     * @param venueChains
     * The venueChains
     */
    public void setVenueChains(List<VenueChain> venueChains) {
        this.venueChains = venueChains;
    }

    /**
     *
     * @return
     * The hasPerk
     */
    public Boolean getHasPerk() {
        return hasPerk;
    }

    /**
     *
     * @param hasPerk
     * The hasPerk
     */
    public void setHasPerk(Boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The allowMenuUrlEdit
     */
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    /**
     *
     * @param allowMenuUrlEdit
     * The allowMenuUrlEdit
     */
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

}
