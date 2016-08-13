package com.example.chronvas.needcoffee.helpers;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.chronvas.needcoffee.eventbus.FusedlocationSuccess;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by chronvas on 3/8/2016.
 */

public class LocationHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleApiClient googleApiClient;

    private Location location;


    public LocationHelper(Context context) {
        googleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @SuppressWarnings({"MissingPermission"})
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        this.location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location == null) {
            LocationAvailability locationAvailability= LocationServices.FusedLocationApi.getLocationAvailability(googleApiClient);
            Log.e ("FusedLocationApi : ","Availability: " + locationAvailability.isLocationAvailable()+"");
            startLocationUpdates();
        }else {
            EventBus.getDefault().post(new FusedlocationSuccess(location));
        }


    }

    @SuppressWarnings({"MissingPermission"})
    private void startLocationUpdates() {
        // Create the location request
        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setNumUpdates(10).setInterval(100);

        // Request location updates
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

        googleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("onConnectionFailed",connectionResult.toString());

    }

    @Override
    public void onLocationChanged(Location location) {
        EventBus.getDefault().post(new FusedlocationSuccess(location));
        this.location = location;
    }

    public void connect() {
        if (!googleApiClient.isConnected()) {
            googleApiClient.connect();
        }
    }

    public void disconnect() {
        if (googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    public boolean isConnected(){
        return googleApiClient.isConnected();
    }

}
