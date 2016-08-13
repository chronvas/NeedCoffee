package com.example.chronvas.needcoffee.http;

import com.example.chronvas.needcoffee.http.responsemodels.photos.Example;
import com.example.chronvas.needcoffee.http.responsemodels.search.VenueSearchResponse;
import com.example.chronvas.needcoffee.http.responsemodels.venue.VenueResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by chronvas on 3/8/2016.
 */

public interface FoursquareAPIService {

    @Headers("Content-Type: application/json")
    @GET("search")
    Call<VenueSearchResponse> getSearchVenues(
            @Query("client_id") String client_id,
            @Query("client_secret")String client_secret,
            @Query("v") String version,
            @Query("ll") String lat_long,
            @Query("query") String query ,
            @Query("limit") String limit);

    @Headers("Content-Type: application/json")
    @GET("search")
    Call<VenueSearchResponse> getSearchVenuesBounded(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String version,
            @Query("query") String query,
            @Query("intent") String intent,
            @Query("sw") String sw,
            @Query("ne") String ne);

    @Headers("Content-Type: application/json")
    @GET("{venue_id}/photos")
    Call<Example> getVenuePhotos(
            @Path("venue_id") String venue_id,
            @Query("group") String group,
            @Query("client_id") String client_id,
            @Query("client_secret")String client_secret,
            @Query("v") String version,
            @Query("limit") String limit);


    @Headers("Content-Type: application/json")
    @GET("{venue_id}")
    Call<VenueResponse> getVenue(
            @Path("venue_id") String venue_id,
            @Query("client_id") String client_id,
            @Query("client_secret")String client_secret,
            @Query("v") String version );

}
