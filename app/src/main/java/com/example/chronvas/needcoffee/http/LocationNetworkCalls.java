package com.example.chronvas.needcoffee.http;

import android.location.Location;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.chronvas.needcoffee.eventbus.GeoLocationSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueGeolocationSuccess;
import com.example.chronvas.needcoffee.http.responsemodels.geocoder.LocationItem;
import com.example.chronvas.needcoffee.http.responsemodels.geocoder.MainLocation;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chronvas on 4/8/2016.
 */

public class LocationNetworkCalls implements Network.LocationCalls {

    private LocationBackendService locationBackendService;

    public LocationNetworkCalls(LocationBackendService locationBackendService) {
        this.locationBackendService = locationBackendService;
    }

    @NonNull
    private String getStringLocation(Location currentLocation) {
        String latitude = String.valueOf(currentLocation.getLatitude());
        String longitude = String.valueOf(currentLocation.getLongitude());
        return latitude + "," + longitude;
    }

    @Override
    public void getAddress(final Location location) {

        String locationString = getStringLocation(location);
        //TODO: handle language better
        Call<JsonObject> call = locationBackendService.getAddress(locationString, "true", "el");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    MainLocation usersLocation = new Gson().fromJson(response.body(),MainLocation.class);

                    if(usersLocation.getResults() != null){

                        LocationItem item = new LocationItem(usersLocation.getResults());

                        item.findValues();

//                        Log.d("city", item.getCity() != null ? item.getCity() : "null");
//                        Log.d("country", item.getCountry() != null ? item.getCountry() : "null");
//                        Log.d("postal code", item.getPostalCode() != null ? item.getPostalCode() : "null");
//                        Log.d("state", item.getState() != null ? item.getState() : "null");
//                        Log.d("area", item.getArea() != null ? item.getArea() : "null");
//                        Log.d("address", item.getWholeAddress() != null ? item.getWholeAddress() : "null");

                        EventBus.getDefault().post(new GeoLocationSuccess(item.getWholeAddress()));

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("getAddress", "onFailure: ");
                t.printStackTrace();
            }
        });
    }


    @Override
    public void getVenueAddress(final String venueid, @NonNull LatLng location) {

        //TODO: handle language better
        Call<JsonObject> call = locationBackendService.getAddress(location.latitude + "," + location.longitude, "true", "el");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    MainLocation usersLocation = new Gson().fromJson(response.body(), MainLocation.class);

                    if (usersLocation.getResults() != null) {

                        LocationItem item = new LocationItem(usersLocation.getResults());

                        item.findValues();

//                        Log.d("city", item.getCity() != null ? item.getCity() : "null");
//                        Log.d("country", item.getCountry() != null ? item.getCountry() : "null");
//                        Log.d("postal code", item.getPostalCode() != null ? item.getPostalCode() : "null");
//                        Log.d("state", item.getState() != null ? item.getState() : "null");
//                        Log.d("area", item.getArea() != null ? item.getArea() : "null");
//                        Log.d("address", item.getWholeAddress() != null ? item.getWholeAddress() : "null");

                        EventBus.getDefault().post(new VenueGeolocationSuccess(venueid, item.getWholeAddress()));

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("getAddress", "onFailure: " );
                t.printStackTrace();
            }
        });
    }
}
