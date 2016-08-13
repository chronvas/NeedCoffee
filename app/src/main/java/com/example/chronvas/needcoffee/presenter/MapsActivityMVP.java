package com.example.chronvas.needcoffee.presenter;

import com.example.chronvas.needcoffee.http.responsemodels.search.Venue;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chronvas on 3/8/2016.
 */

public interface MapsActivityMVP {

    interface Model {

        //id by LatLng
        void storeVenueId_byLatLng(LatLng venueLatLng, String venueId);

        String readVenueId_byLatLng(LatLng venueLatLng);

        //bestphoto
        void storeVenue_bestPhotoURL(String venueId, String bestPhotoURL);

        String readVenue_bestPhotoURL(String venueId);

        //Address
        void storeVenue_Address(String venueId, String address);

        String readVenue_Address(String venueId);

        //Location LatLng
        void storeVenue_LocationLatLng(String venueId, LatLng venueLatLng);

        LatLng readVenue_LocationLatLng(String venueId);

        //Rating
        void storeVenue_Rating(String venueId, float rating);

        float readVenue_Rating(String venueId);

        //Name
        void storeVenue_Name(String venueId, String name);

        String readVenue_Name(String venueId);

        //Categories
        void storeVenue_Categories(String venueid, List<String> categories);

        List<String> readVenue_Categories(String venueid);
    }

    interface View {

        void hideCurrenlLocationLayout();

        void showCurrentLocationLayout();

        GoogleMap getMap();

        void setMap(GoogleMap map);

        void showShopDetails();

        void hideShopDetails();

        void moveMapCamera(CameraUpdate cameraUpdate);

        void addVenueMarkersToMap(List<Venue> venues);

        void addShopMarker(LatLng position);

        void addMyLocationMarker(LatLng latLng);

        void setWholeAddressTextView(String wholeaddress);

        void storeHashMap(HashMap<String, String> latLngStringHashMap);

        void storeVenueId_ImageURL(String venueId, String venueImageURL);

        LatLngBounds getMapBounds();
    }

    interface Presenter  {

        void venueClicked(String venueId);

        void setView(MapsActivityMVP.View view);

        void viewCreated();

        void registerBus();

        void unregisterBus();

        String getVenueBestPhotoURL(String venueId);

        String getVenueName(String venueId);

        String getVenueIdbyLatLong(LatLng venueLatLng);

        void mapCameraIdle(LatLngBounds latLngBounds);

        LatLng getVenueLocationLatLng(String venueId);

        String getVenueAddress(String venueId);

        String getVenueCategory(String venueId);

        float getVenueRating(String venueId);
    }

}
