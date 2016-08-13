package com.example.chronvas.needcoffee.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by chronvas on 4/8/2016.
 */

public class SharedPrefHelper {

    private Context context;
    public SharedPrefHelper(Context context) {
        this.context = context;
    }

    //Store venue_id and LatLong, in order to retrieve later photos based on that venue_id
    public static void storeLatLng_VenueId(Context context, HashMap<String, String> hashMap){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(hashMap);
        editor.putString(Constants.LatLng_VenueIdTAG, json);
        editor.commit();
    }

    public static HashMap<String, String> readLatLng_VenueId(Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(Constants.LatLng_VenueIdTAG, null);
        Type type = new TypeToken<HashMap<String, String>>() {}.getType();
        HashMap<String, String> hashMap = gson.fromJson(json, type);
        return hashMap;
    }

    //Image URL
    public static void storeVenueId_imageURL(String venueId, String imageURL, Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(venueId, imageURL);
        editor.commit();
    }

    public static String readVenueId_imageURL(String venueId,Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String venueURL = sharedPrefs.getString(venueId,"empty");
        return venueURL;
    }

    ////////////////////////////////////////////////////
    //BestPhotoURL
    public void storeVenueId_bestPhotoURL(String venueId, String bestPhotoURL) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(venueId+"bestphotourl", bestPhotoURL);
        editor.commit();
    }

    public String readVenueId_bestPhotoURL(String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String bestPhotoURL = sharedPrefs.getString(venueId + "bestphotourl", "empty");
        return bestPhotoURL;
    }
    //////////////////////////////////////////////////////
    //Rating
    public void storeVenueId_rating(String venueId, float rating) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putFloat(venueId + "rating", rating);
        editor.commit();
    }

    public float readVenueId_rating(String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        float rating = sharedPrefs.getFloat(venueId + "rating", 0);
        return rating;
    }

    //Address
    public void storeVenueId_address(String venueId, String address) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(venueId+"address", address);
        editor.commit();
    }

    public String readVenueId_address(String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String address = sharedPrefs.getString(venueId + "address", "empty");
        return address;
    }

    //Name
    public void storeVenueId_name(String venueId, String name) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(venueId+"name", name);
        editor.commit();
    }

    public String readVenueId_name(String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String name = sharedPrefs.getString(venueId + "name", "empty");
        return name;
    }

    //Categories
    public void storeVenueId_categories(String venueid, List<String> categories) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Set<String> categoriesSet = new HashSet<>();
        int size = categories.size();
        for (int i = 0; i < size; i++) {
            categoriesSet.add(categories.get(i));
        }
        editor.putStringSet(venueid + "categories", categoriesSet);
        editor.commit();
    }

    public List<String> readVenueId_categories(String venueid) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> categoriesSet = sharedPrefs.getStringSet(venueid + "categories", null);
        List<String> categories = new ArrayList<>();
        if (categoriesSet != null && categoriesSet.size() > 0) {
            categories.addAll(categoriesSet);
        }
        return categories;
    }

    //Location LatLng
    public void storeVenueId_LocationLatLng(String venueId, LatLng venueLatLng) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        double latitude = venueLatLng.latitude;
        double longtitude = venueLatLng.longitude;
        String latitudeStr = String.valueOf(latitude);
        String longtitudeStr = String.valueOf(longtitude);
        editor.putString(venueId + "venuelat", latitudeStr);
        editor.putString(venueId + "venuelong", longtitudeStr);
        editor.commit();
    }

    public LatLng readVenueId_LocationLatLng(String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String venueLat = sharedPrefs.getString(venueId + "venuelat", "empty");
        String venueLong = sharedPrefs.getString(venueId + "venuelong", "empty");
        LatLng latLng = new LatLng(Double.parseDouble(venueLat), Double.parseDouble(venueLong));
        return latLng;
    }

    //Storing VenueId by LatLng key
    public void storeVenueIdByLatLng(LatLng venueLatLng, String venueId) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        double latitude = venueLatLng.latitude;
        double longtitude = venueLatLng.longitude;
        String latitudeStr = String.valueOf(latitude);
        String longtitudeStr = String.valueOf(longtitude);
        editor.putString(latitudeStr + longtitudeStr, venueId);
        editor.commit();
    }

    public String readVenueIdByLatLng(LatLng venueLatLng) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        double latitude = venueLatLng.latitude;
        double longtitude = venueLatLng.longitude;
        String latitudeStr = String.valueOf(latitude);
        String longtitudeStr = String.valueOf(longtitude);
        String venueId = sharedPrefs.getString(latitudeStr + longtitudeStr, "empty");
        return venueId;
    }
}
