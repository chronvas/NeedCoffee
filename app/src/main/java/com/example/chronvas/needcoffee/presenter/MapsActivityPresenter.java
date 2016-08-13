package com.example.chronvas.needcoffee.presenter;

import android.location.Location;
import android.util.Log;

import com.example.chronvas.needcoffee.eventbus.FusedlocationSuccess;
import com.example.chronvas.needcoffee.eventbus.GeoLocationSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueAddressFailure;
import com.example.chronvas.needcoffee.eventbus.VenueAddressSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueBestPhotoURLSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueBoundedSearchSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueCategoriesSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueGeolocationSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueImageUrlSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueLatLngLocationSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueNameSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueRatingSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueSearchSuccess;
import com.example.chronvas.needcoffee.helpers.LocationHelper;
import com.example.chronvas.needcoffee.http.Network;
import com.example.chronvas.needcoffee.http.responsemodels.search.Venue;
import com.example.chronvas.needcoffee.model.realm.VenueObj;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chronvas on 3/8/2016.
 */

public class MapsActivityPresenter implements MapsActivityMVP.Presenter {

    private MapsActivityMVP.View view;
    private MapsActivityMVP.Model model;
    private Network.VenueSearchCalls venueSearchCalls;
    private Network.LocationCalls locationCalls;
    private LocationHelper locationHelper;

    public MapsActivityPresenter(MapsActivityMVP.Model model,Network.VenueSearchCalls venueSearchCalls, Network.LocationCalls locationCalls, EventBus bus, LocationHelper locationHelper) {
        this.model = model;
        this.venueSearchCalls = venueSearchCalls;
        this.locationHelper = locationHelper;
        this.locationCalls = locationCalls;
     }

    @Override
    public void venueClicked(String venueId) {
        venueSearchCalls.getVenue(venueId);
    }

    @Override
    public void setView(MapsActivityMVP.View view) {
        this.view = view;
    }



    @Override
    public void viewCreated() {



    }


    @Override
    public void registerBus() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void unregisterBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public String getVenueBestPhotoURL(String venueId) {
        String bestPhotoURL = model.readVenue_bestPhotoURL(venueId);
        return bestPhotoURL;
    }

    @Override
    public String getVenueName(String venueId) {
        return model.readVenue_Name(venueId);
    }

    @Override
    public String getVenueIdbyLatLong(LatLng venueLatLng) {

        return model.readVenueId_byLatLng(venueLatLng);
    }

    @Override
    public void mapCameraIdle(LatLngBounds latLngBounds) {
        venueSearchCalls.getNearbyWithBounds(view.getMapBounds());
    }

    @Override
    public LatLng getVenueLocationLatLng(String venueid) {
        return model.readVenue_LocationLatLng(venueid);
    }

    @Override
    public String getVenueAddress(String venueId) {
        return model.readVenue_Address(venueId);
    }

    @Override
    public String getVenueCategory(String venueId) {
        List<String> x = model.readVenue_Categories(venueId);
        if (x.size() > 0) return x.get(0);
        else return "empty";
    }

    @Override
    public float getVenueRating(String venueId) {
        return model.readVenue_Rating(venueId);
    }

    @Subscribe
    public void onVenueSearchSuccess(VenueSearchSuccess venueSearchSuccess){

        List<Venue> venueList = venueSearchSuccess.getResponse().body().getResponse().getVenues();

        //hashmap to be stored
        HashMap<String, String> latLngStringHashMap = new HashMap<String, String>();

        for (Venue v : venueList){
            LatLng position = new LatLng(v.getLocation().getLat(),v.getLocation().getLng());
            String venueId = v.getId();
            latLngStringHashMap.put(position.toString(),venueId);

            //add individual markers
            view.addShopMarker(position);

            //Realm storage
            VenueObj venueObj = new VenueObj();
            venueObj.setName(v.getName());
            venueObj.setVenueid(v.getId());
            venueObj.setLatitude(v.getLocation().getLat());
            venueObj.setLongtitude(v.getLocation().getLng());


            String asdfasdas = v.getCategories().get(0).getName();
            Log.e("adasdad",asdfasdas);

        }

        //tell view to store the hashmap (needs context)
        view.storeHashMap(latLngStringHashMap);

        //for each venue, get the url of the image
        for (Venue v : venueList) {
            //venueSearchCalls.getPhotosForVenue(v.getId());
            venueSearchCalls.getVenue(v.getId());
        }


    }

    @Subscribe
    public void onVenueBoundedSearchSuccess(VenueBoundedSearchSuccess venueBoundedSearchSuccess) {
        for (Venue v : venueBoundedSearchSuccess.getVenues()) {
            LatLng venueLatLng = new LatLng(v.getLocation().getLat(), v.getLocation().getLng());
            model.storeVenueId_byLatLng(venueLatLng, v.getId());
        }
        view.addVenueMarkersToMap(venueBoundedSearchSuccess.getVenues());
    }

    @Subscribe
    public void onFusedlocationSuccess(FusedlocationSuccess fusedlocationSuccess){

        Location location = fusedlocationSuccess.getLocation();
        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 12);
        view.addMyLocationMarker(latLng);
        view.getMap().moveCamera(cameraUpdate);

        //only 1 location update, as per requirements
        locationHelper.disconnect();


        //we have location, do a reverse lookup for the user's address
        locationCalls.getAddress(location);

    }

    @Subscribe
    public void onGeoLocationSuccess(GeoLocationSuccess geoLocationSuccess){
        view.setWholeAddressTextView(geoLocationSuccess.getWholeAddress());
    }

    @Subscribe
    public void onVenueImageURLSuccess(VenueImageUrlSuccess venueImageUrlSuccess){

        view.storeVenueId_ImageURL(venueImageUrlSuccess.getVenueId(),venueImageUrlSuccess.getVenueImageURL());
    }

    @Subscribe
    public void onVenueBestPhotoURLSuccess(VenueBestPhotoURLSuccess venueBestPhotoURLSuccess){
        model.storeVenue_bestPhotoURL(venueBestPhotoURLSuccess.getVenueId(), venueBestPhotoURLSuccess.getBestPhotoURL());
    }

    @Subscribe
    public void onVenueRatingSuccess(VenueRatingSuccess venueRatingSuccess) {
        model.storeVenue_Rating(venueRatingSuccess.getVenueId(), venueRatingSuccess.getRating());
    }

    @Subscribe
    public void onVenueAddressSuccess(VenueAddressSuccess venueAddressSuccess) {
        model.storeVenue_Address(venueAddressSuccess.getVenue_id(), venueAddressSuccess.getAddress());
    }

    @Subscribe
    public void onVenueAddressFailure(VenueAddressFailure venueAddressFailure) {
        locationCalls.getVenueAddress(venueAddressFailure.gettVenueid(), venueAddressFailure.getLatLng());
    }

    @Subscribe
    public void onVenueGeolocationSuccess(VenueGeolocationSuccess venueGeolocationSuccess) {
        model.storeVenue_Address(venueGeolocationSuccess.getVenueid(), venueGeolocationSuccess.getWholeAddress());
    }

    @Subscribe
    public void onVenueCategoriesSuccess(VenueCategoriesSuccess venueCategoriesSuccess) {
        model.storeVenue_Categories(venueCategoriesSuccess.getVenueid(), venueCategoriesSuccess.getCategories());
    }

    @Subscribe
    public void onVenueNameSuccess(VenueNameSuccess venueNameSuccess) {
        model.storeVenue_Name(venueNameSuccess.getVenue_id(), venueNameSuccess.getName());
    }

    @Subscribe
    public void onVenueLatLngLocationSuccess(VenueLatLngLocationSuccess venueLatLngLocationSuccess) {
        model.storeVenue_LocationLatLng(venueLatLngLocationSuccess.getVenueid(), venueLatLngLocationSuccess.getVenueLatLng());
    }

//    @Override
//    public void storeCoffeeImages(VenueSearchSuccess venueSearchSuccess){
//        int venuesSize = venueSearchSuccess.getResponse().body().getResponse().getVenues().size();
//        HashMap<Integer, String> hashMap = new HashMap<>();
//        for (VenueObj v ; venueSearchSuccess.getResponse().body().getResponse().getVenues()){
//            hashMap.put(v.get)
//        }
//    }


}
