
package com.example.chronvas.needcoffee.http.responsemodels.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phrase {

    @SerializedName("phrase")
    @Expose
    private String phrase;
    @SerializedName("sample")
    @Expose
    private Sample sample;
    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     * @return The phrase
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * @param phrase The phrase
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * @return The sample
     */
    public Sample getSample() {
        return sample;
    }

    /**
     * @param sample The sample
     */
    public void setSample(Sample sample) {
        this.sample = sample;
    }

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

}
