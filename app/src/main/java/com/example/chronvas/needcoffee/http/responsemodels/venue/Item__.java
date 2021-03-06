
package com.example.chronvas.needcoffee.http.responsemodels.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item__ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("likes")
    @Expose
    private Likes_ likes;
    @SerializedName("logView")
    @Expose
    private Boolean logView;
    @SerializedName("agreeCount")
    @Expose
    private Integer agreeCount;
    @SerializedName("disagreeCount")
    @Expose
    private Integer disagreeCount;
    @SerializedName("todo")
    @Expose
    private Todo todo;
    @SerializedName("user")
    @Expose
    private User_ user;

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
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
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
     * @return The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return The likes
     */
    public Likes_ getLikes() {
        return likes;
    }

    /**
     * @param likes The likes
     */
    public void setLikes(Likes_ likes) {
        this.likes = likes;
    }

    /**
     * @return The logView
     */
    public Boolean getLogView() {
        return logView;
    }

    /**
     * @param logView The logView
     */
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    /**
     * @return The agreeCount
     */
    public Integer getAgreeCount() {
        return agreeCount;
    }

    /**
     * @param agreeCount The agreeCount
     */
    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    /**
     * @return The disagreeCount
     */
    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    /**
     * @param disagreeCount The disagreeCount
     */
    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    /**
     * @return The todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * @param todo The todo
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * @return The user
     */
    public User_ getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User_ user) {
        this.user = user;
    }

}
