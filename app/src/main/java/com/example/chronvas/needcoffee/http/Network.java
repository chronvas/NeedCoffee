package com.example.chronvas.needcoffee.http;

import android.location.Location;
import android.support.annotation.NonNull;

import com.example.chronvas.needcoffee.http.responsemodels.photos.Example;
import com.example.chronvas.needcoffee.http.responsemodels.search.VenueSearchResponse;
import com.example.chronvas.needcoffee.http.responsemodels.venue.VenueResponse;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import retrofit2.Response;

/**
 * Created by chronvas on 3/8/2016.
 */

public interface Network {

    interface VenueSearchCalls {

        void getNearby(Location location);

        Response<VenueSearchResponse> getNearbyWithLatLong(LatLng latLng);

        //sw ne
        Response<VenueSearchResponse> getNearbyWithBounds(LatLngBounds latLngBounds);

        Response<Example> getPhotosForVenue(String venue_id);

        Response<VenueResponse> getVenue(String venue_id);

    }

    interface LocationCalls {

        void getAddress (Location location);

        void getVenueAddress(final String venueid, @NonNull LatLng location);

    }

}
