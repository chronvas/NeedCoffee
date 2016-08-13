package com.example.chronvas.needcoffee.injection;

import com.example.chronvas.needcoffee.helpers.Constants;
import com.example.chronvas.needcoffee.http.FoursquareAPIService;
import com.example.chronvas.needcoffee.http.FoursquareNetworkCalls;
import com.example.chronvas.needcoffee.http.LocationBackendService;
import com.example.chronvas.needcoffee.http.LocationNetworkCalls;
import com.example.chronvas.needcoffee.http.Network;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chronvas on 3/8/2016.
 */

@Module
public class ApiModule {

    @Provides
    public OkHttpClient provideClient(){
        //interceptor possible add
        return new OkHttpClient.Builder().build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public LocationBackendService provideLocationBackendService(){
        return provideRetrofit(Constants.GOOGLE_GEOCODE_API_URL,provideClient()).create(LocationBackendService.class);
    }

    @Provides
    public FoursquareAPIService provideApiService() {
        return provideRetrofit(Constants.FOURSQUARE_API_BASE_URL, provideClient()).create(FoursquareAPIService.class);
    }

    @Provides
    public Network.LocationCalls provideLocationCalls(LocationBackendService locationBackendService){
        return new LocationNetworkCalls(locationBackendService);
    }

    @Provides
    public Network.VenueSearchCalls provideVenueSearchCalls(FoursquareAPIService foursquareAPIService) {
        return new FoursquareNetworkCalls(foursquareAPIService);
    }

}
