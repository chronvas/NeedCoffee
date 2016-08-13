
package com.example.chronvas.needcoffee.http.responsemodels.photos;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("photos")
    @Expose
    private Photos photos;

    /**
     * 
     * @return
     *     The photos
     */
    public Photos getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

}
