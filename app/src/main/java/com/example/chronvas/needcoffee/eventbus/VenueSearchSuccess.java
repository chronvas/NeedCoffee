package com.example.chronvas.needcoffee.eventbus;

import com.example.chronvas.needcoffee.http.responsemodels.search.VenueSearchResponse;

import retrofit2.Response;

/**
 * Created by chronvas on 3/8/2016.
 */

public class VenueSearchSuccess {

    Response<VenueSearchResponse> response;

    public VenueSearchSuccess(Response<VenueSearchResponse> response) {

        this.response = response;
    }

    public Response<VenueSearchResponse> getResponse() {

        return response;
    }
}
