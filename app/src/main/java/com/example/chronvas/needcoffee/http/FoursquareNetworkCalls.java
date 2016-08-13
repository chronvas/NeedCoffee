package com.example.chronvas.needcoffee.http;

import android.location.Location;
import android.util.Log;

import com.example.chronvas.needcoffee.eventbus.VenueAddressFailure;
import com.example.chronvas.needcoffee.eventbus.VenueAddressSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueBestPhotoURLSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueBoundedSearchSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueCategoriesSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueImageUrlSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueLatLngLocationSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueNameSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueRatingSuccess;
import com.example.chronvas.needcoffee.eventbus.VenueSearchSuccess;
import com.example.chronvas.needcoffee.helpers.Constants;
import com.example.chronvas.needcoffee.http.responsemodels.photos.Example;
import com.example.chronvas.needcoffee.http.responsemodels.photos.Item;
import com.example.chronvas.needcoffee.http.responsemodels.search.Venue;
import com.example.chronvas.needcoffee.http.responsemodels.search.VenueSearchResponse;
import com.example.chronvas.needcoffee.http.responsemodels.venue.BestPhoto;
import com.example.chronvas.needcoffee.http.responsemodels.venue.Category;
import com.example.chronvas.needcoffee.http.responsemodels.venue.VenueResponse;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chronvas on 3/8/2016.
 */

public class FoursquareNetworkCalls implements Network.VenueSearchCalls {

    private FoursquareAPIService foursquareAPIService;

    private List<Venue> venueList;

    public FoursquareNetworkCalls(FoursquareAPIService foursquareAPIService) {
        this.foursquareAPIService = foursquareAPIService;
    }

    @Override
    public Response<VenueSearchResponse> getNearbyWithLatLong(LatLng latLng){
        String clientId = Constants.FOURSQUARE_CLIENT_ID;
        String clientSecret = Constants.FOURSQUARE_CLIENT_SECRET;
        String query = Constants.FOURSQUARE_QUERY;
        String version = Constants.FOURSQUARE_VERSION;
        String lat_long = latLng.latitude + "," + latLng.longitude;
        String limit = "15";
        Call<VenueSearchResponse> call = foursquareAPIService.getSearchVenues(clientId, clientSecret, version, lat_long, query, limit);
        call.enqueue(new Callback<VenueSearchResponse>() {
            @Override
            public void onResponse(Call<VenueSearchResponse> call, Response<VenueSearchResponse> response) {

                if (response.code() == HttpURLConnection.HTTP_OK){

                    EventBus.getDefault().post(new VenueSearchSuccess(response));

                }
            }

            @Override
            public void onFailure(Call<VenueSearchResponse> call, Throwable t) {
                Log.e("getNearbyWithLatLong ","Failed");
                t.printStackTrace();
            }
        });

        return null;
    }

    @Override //sw ne
    public Response<VenueSearchResponse> getNearbyWithBounds(LatLngBounds latLngBounds) {
        String clientId = Constants.FOURSQUARE_CLIENT_ID;
        String clientSecret = Constants.FOURSQUARE_CLIENT_SECRET;
        String query = Constants.FOURSQUARE_QUERY;
        String version = Constants.FOURSQUARE_VERSION;
        String intent = Constants.FOURSQUARE_INTENT;
        String sw = String.valueOf(latLngBounds.southwest.latitude) + "," + String.valueOf(latLngBounds.southwest.longitude);
        String ne = String.valueOf(latLngBounds.northeast.latitude) + "," + String.valueOf(latLngBounds.northeast.longitude);
        Call<VenueSearchResponse> call = foursquareAPIService.getSearchVenuesBounded(clientId, clientSecret, version, query, intent, sw, ne);
        call.enqueue(new Callback<VenueSearchResponse>() {
            @Override
            public void onResponse(Call<VenueSearchResponse> call, Response<VenueSearchResponse> response) {

                if (response.code() == HttpURLConnection.HTTP_OK) {

                    EventBus.getDefault().post(new VenueBoundedSearchSuccess(response.body().getResponse().getVenues()));

                }
            }

            @Override
            public void onFailure(Call<VenueSearchResponse> call, Throwable t) {
                Log.e("getNearbyWithLatLong ", "Failed");
                t.printStackTrace();
            }
        });

        return null;
    }


    @Override //venueid/photos
    public Response<Example> getPhotosForVenue(final String venue_id) {
        final String group = "venue"; //as per api documentation
        String clientId = Constants.FOURSQUARE_CLIENT_ID;
        String clientSecret = Constants.FOURSQUARE_CLIENT_SECRET;
        String version = Constants.FOURSQUARE_VERSION;
        String limit = "1";

        Call<Example> call = foursquareAPIService.getVenuePhotos(venue_id, group, clientId, clientSecret, version, limit);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code() == HttpURLConnection.HTTP_OK){
                    Log.e("response",response.body().toString());
                    List<Item> items = response.body().getResponse().getPhotos().getItems();

                    if (items.size() > 0) { //if there are any photo urls

                        for (Item i : items){
                            Log.e("IMAGE",i.getPrefix()+Constants.PHOTO_SIZE+i.getSuffix());
                            String URL = i.getPrefix()+Constants.PHOTO_SIZE+i.getSuffix();

                            EventBus.getDefault().post(new VenueImageUrlSuccess(venue_id,URL));
                        }
                    }else{

                        EventBus.getDefault().post(new VenueImageUrlSuccess(venue_id,"empty"));
                    }



                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("getPhotosForVenue ", "onFailure: " );
                t.printStackTrace();
            }
        });
        return null;
    }

    @Override //venueid - the whole venue
    public Response<VenueResponse> getVenue(final String venue_id) {
        String clientId = Constants.FOURSQUARE_CLIENT_ID;
        String clientSecret = Constants.FOURSQUARE_CLIENT_SECRET;
        String version = Constants.FOURSQUARE_VERSION;
        Call<VenueResponse> call = foursquareAPIService.getVenue(venue_id, clientId, clientSecret, version);
        call.enqueue(new Callback<VenueResponse>() {
            @Override
            public void onResponse(Call<VenueResponse> call, Response<VenueResponse> response) {
                //test id : 3fd66200f964a520efe81ee3
                //get bestphoto
                //get name
                //get venue id
                ///get venue address
                ///get venue rating
                //get venue category

                if (response.code() == HttpURLConnection.HTTP_OK) {

                    //Name
                    String name = response.body().getResponse().getVenue().getName();
                    EventBus.getDefault().post(new VenueNameSuccess(venue_id, name));

                    //Location
                    LatLng venueLatLng = new LatLng(response.body().getResponse().getVenue().getLocation().getLat(), response.body().getResponse().getVenue().getLocation().getLng());
                    EventBus.getDefault().post(new VenueLatLngLocationSuccess(venue_id, venueLatLng));

                    //Address
                    if (response.body().getResponse().getVenue().getLocation().getAddress() != null) {
                        String address = response.body().getResponse().getVenue().getLocation().getAddress();
                        EventBus.getDefault().post(new VenueAddressSuccess(venue_id, address));
                    } else {
                        //notify presenter to get from reverse geolocation
                        LatLng latLng = new LatLng(response.body().getResponse().getVenue().getLocation().getLat(), response.body().getResponse().getVenue().getLocation().getLng());
                        EventBus.getDefault().post(new VenueAddressFailure(venue_id, latLng));
                    }

                    //Categories
                    List<String> categories = new ArrayList<String>();
                    for (Category category : response.body().getResponse().getVenue().getCategories()) {
                        categories.add(category.getName());
                    }
                    EventBus.getDefault().post(new VenueCategoriesSuccess(venue_id, categories));

                    //Rating
                    float rating = response.body().getResponse().getVenue().getRating();
                    EventBus.getDefault().post(new VenueRatingSuccess(venue_id, rating));

                    //BestPhotoURL
                    BestPhoto bestPhoto = response.body().getResponse().getVenue().getBestPhoto();
                    if (bestPhoto != null) {
                        String bestPhotoURL = bestPhoto.getPrefix() + Constants.PHOTO_SIZE + bestPhoto.getSuffix();
                        EventBus.getDefault().post(new VenueBestPhotoURLSuccess(venue_id, bestPhotoURL));
                    }else {
                        EventBus.getDefault().post(new VenueBestPhotoURLSuccess(venue_id, "empty"));
                    }

                }
            }

            @Override
            public void onFailure(Call<VenueResponse> call, Throwable t) {

            }
        });
        return null;
    }


    @Override
    public void getNearby(Location location) {


//        Call<JsonObject> call = foursquareAPIService.getSearchVenues();
//        call.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                if (response.code() == HttpURLConnection.HTTP_OK){
//                    Log.e("response",response.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//
//            }
//        });
    }
}
