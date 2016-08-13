package com.example.chronvas.needcoffee.model;

import com.example.chronvas.needcoffee.helpers.SharedPrefHelper;
import com.example.chronvas.needcoffee.presenter.MapsActivityMVP;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by chronvas on 3/8/2016.
 */

public class MapsActivityModel implements MapsActivityMVP.Model {

    private SharedPrefHelper sharedPrefHelper;
    public MapsActivityModel(SharedPrefHelper sharedPrefHelper) {
        this.sharedPrefHelper = sharedPrefHelper;
    }


    //BestPhotoURL
    @Override
    public void storeVenue_bestPhotoURL(String venueId, String bestPhotoURL) {
        //Realm example
//        Realm realm = Realm.getDefaultInstance();
//
//        VenueObj venueObj = realm.where(VenueObj.class).contains("venueid", venueId).findFirst();
//        //if exists
//        if (venueObj != null) {
//
//            //if it does not already have the same bestPhotoURL
//            if (!venueObj.getBestphotourl().equals(bestPhotoURL)) {
//                realm.beginTransaction();
//                venueObj.setBestphotourl(bestPhotoURL);
//                realm.commitTransaction();
//            }
//        }
//
//        VenueObj venueObj2 = realm.where(VenueObj.class).contains("venueid", venueId).findFirst();
//        Log.e("BEST URL",venueObj2.getBestphotourl());
//        Log.e("BEST ID",venueObj2.getVenueid());

        sharedPrefHelper.storeVenueId_bestPhotoURL(venueId,bestPhotoURL);
    }

    @Override
    public String readVenue_bestPhotoURL(String venueId) {
        return sharedPrefHelper.readVenueId_bestPhotoURL(venueId);
    }


    //Address
    @Override
    public void storeVenue_Address(String venueId, String address) {
        sharedPrefHelper.storeVenueId_address(venueId, address);
    }

    @Override
    public String readVenue_Address(String venueId) {
        return sharedPrefHelper.readVenueId_address(venueId);
    }

    @Override
    public void storeVenue_LocationLatLng(String venueId, LatLng venueLatLng) {
        sharedPrefHelper.storeVenueId_LocationLatLng(venueId, venueLatLng);
    }

    @Override
    public LatLng readVenue_LocationLatLng(String venueId) {
        return null;
    }

    //Rating
    @Override
    public void storeVenue_Rating(String venueId, float rating) {
        sharedPrefHelper.storeVenueId_rating(venueId, rating);
    }

    @Override
    public float readVenue_Rating(String venueId) {
        return sharedPrefHelper.readVenueId_rating(venueId);
    }

    //Name
    @Override
    public void storeVenue_Name(String venueId, String name) {
        sharedPrefHelper.storeVenueId_name(venueId, name);
    }

    @Override
    public String readVenue_Name(String venueId) {
        return sharedPrefHelper.readVenueId_name(venueId);
    }

    //Categories
    @Override
    public void storeVenue_Categories(String venueid, List<String> categories) {
        sharedPrefHelper.storeVenueId_categories(venueid, categories);
    }

    @Override
    public List<String> readVenue_Categories(String venueid) {
        return sharedPrefHelper.readVenueId_categories(venueid);
    }

    //Id by lat/lng
    @Override
    public void storeVenueId_byLatLng(LatLng venueLatLng, String venueId) {
        sharedPrefHelper.storeVenueIdByLatLng(venueLatLng, venueId);

    }

    @Override
    public String readVenueId_byLatLng(LatLng venueLatLng) {
        return sharedPrefHelper.readVenueIdByLatLng(venueLatLng);
    }
}
