package com.example.chronvas.needcoffee.http;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chronvas on 4/8/2016.
 */

public interface LocationBackendService {

    @GET("json")
    Call<JsonObject> getAddress(
            @Query("latlng") String location,
            @Query("sensor") String var,
            @Query("language") String language);
}
