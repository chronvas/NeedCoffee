
package com.example.chronvas.needcoffee.http.responsemodels.venue;

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
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("dislike")
    @Expose
    private Boolean dislike;
    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private Boolean allowMenuUrlEdit;
    @SerializedName("specials")
    @Expose
    private Specials specials;
    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("reasons")
    @Expose
    private Reasons reasons;
    @SerializedName("hereNow")
    @Expose
    private HereNow hereNow;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("tips")
    @Expose
    private Tips tips;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = new ArrayList<Object>();
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("listed")
    @Expose
    private Listed listed;
    @SerializedName("phrases")
    @Expose
    private List<Phrase> phrases = new ArrayList<Phrase>();
    @SerializedName("pageUpdates")
    @Expose
    private PageUpdates pageUpdates;
    @SerializedName("inbox")
    @Expose
    private Inbox inbox;
    @SerializedName("venueChains")
    @Expose
    private List<Object> venueChains = new ArrayList<Object>();
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("bestPhoto")
    @Expose
    private BestPhoto bestPhoto;

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * @param canonicalUrl The canonicalUrl
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * @return The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * @return The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * @param verified The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * @return The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @param stats The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * @param likes The likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     * @return The dislike
     */
    public Boolean getDislike() {
        return dislike;
    }

    /**
     * @param dislike The dislike
     */
    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
    }

    /**
     * @return The ok
     */
    public Boolean getOk() {
        return ok;
    }

    /**
     * @param ok The ok
     */
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    /**
     * @return The allowMenuUrlEdit
     */
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    /**
     * @param allowMenuUrlEdit The allowMenuUrlEdit
     */
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    /**
     * @return The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     * @param specials The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     * @return The photos
     */
    public Photos getPhotos() {
        return photos;
    }

    /**
     * @param photos The photos
     */
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    /**
     * @return The reasons
     */
    public Reasons getReasons() {
        return reasons;
    }

    /**
     * @param reasons The reasons
     */
    public void setReasons(Reasons reasons) {
        this.reasons = reasons;
    }

    /**
     * @return The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * @param hereNow The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    /**
     * @return The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The createdAt
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The tips
     */
    public Tips getTips() {
        return tips;
    }

    /**
     * @param tips The tips
     */
    public void setTips(Tips tips) {
        this.tips = tips;
    }

    /**
     * @return The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     * @param tags The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     * @return The shortUrl
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * @param shortUrl The shortUrl
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * @return The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * @param timeZone The timeZone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * @return The listed
     */
    public Listed getListed() {
        return listed;
    }

    /**
     * @param listed The listed
     */
    public void setListed(Listed listed) {
        this.listed = listed;
    }

    /**
     * @return The phrases
     */
    public List<Phrase> getPhrases() {
        return phrases;
    }

    /**
     * @param phrases The phrases
     */
    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    /**
     * @return The pageUpdates
     */
    public PageUpdates getPageUpdates() {
        return pageUpdates;
    }

    /**
     * @param pageUpdates The pageUpdates
     */
    public void setPageUpdates(PageUpdates pageUpdates) {
        this.pageUpdates = pageUpdates;
    }

    /**
     * @return The inbox
     */
    public Inbox getInbox() {
        return inbox;
    }

    /**
     * @param inbox The inbox
     */
    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }

    /**
     * @return The venueChains
     */
    public List<Object> getVenueChains() {
        return venueChains;
    }

    /**
     * @param venueChains The venueChains
     */
    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    /**
     * @return The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * @param attributes The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * @return The bestPhoto
     */
    public BestPhoto getBestPhoto() {
        return bestPhoto;
    }

    /**
     * @param bestPhoto The bestPhoto
     */
    public void setBestPhoto(BestPhoto bestPhoto) {
        this.bestPhoto = bestPhoto;
    }

}
