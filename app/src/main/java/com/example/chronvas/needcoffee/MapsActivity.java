package com.example.chronvas.needcoffee;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chronvas.needcoffee.helpers.LocationHelper;
import com.example.chronvas.needcoffee.helpers.SharedPrefHelper;
import com.example.chronvas.needcoffee.http.responsemodels.search.Venue;
import com.example.chronvas.needcoffee.presenter.MapsActivityMVP;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, MapsActivityMVP.View {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int LOCATION_PERMISSIONS = 1;
    public LatLng mylocation;

    @Inject
    MapsActivityMVP.Presenter presenter;

    @Inject
    LocationHelper locationHelper;

    @BindView(R.id.users_address_textvies)
    TextView usersAddressTextVies;

    @BindView(R.id.current_location_layout)
    RelativeLayout currentLocationLayout;

    HashMap<String, Marker> venueMarkers = new HashMap<>();
    private GoogleMap map;
    private MapView mapView;
    private View view;
    private Marker marker;
    private MultiplePermissionsListener allPermissionsListener;

    @Override
    public void hideCurrenlLocationLayout() {
        currentLocationLayout.setVisibility(View.GONE);
    }

    @Override
    public void showCurrentLocationLayout() {
        currentLocationLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public GoogleMap getMap() {
        return map;
    }

    @Override
    public void setMap(GoogleMap map) {
        this.map = map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        NeedCoffeeApp application = (NeedCoffeeApp) getApplication();
        application.getComponent().inject(this);
        ButterKnife.bind(this);
        ;
        ActionBar actionBar = this.getSupportActionBar();

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);


//        Dexter.checkPermissions(new MultiplePermissionsListener() {
//            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
//            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
//        }, android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION,android.Manifest.permission.INTERNET, android.Manifest.permission.ACCESS_NETWORK_STATE);


        presenter.viewCreated();
        presenter.setView(this);
        presenter.registerBus();
        if (checkPlayServices()) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

                    Snackbar.make(mapView, R.string.rationale_location, Snackbar.LENGTH_INDEFINITE)
                            .setAction(android.R.string.ok, new View.OnClickListener() {
                                @Override
                                @TargetApi(Build.VERSION_CODES.M)
                                public void onClick(View v) {
                                    ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSIONS);
                                }
                            }).show();
                } else {
                    ActivityCompat.requestPermissions(
                            this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSIONS
                    );
                }
            } else {


                locationHelper.connect();
            }
        }

    }


    @Override
    public void showShopDetails() {

    }

    @Override
    public void hideShopDetails() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
        presenter.setView(this);
        presenter.registerBus();
    }

    @SuppressWarnings("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMyLocationEnabled(false);
        CustomInfoWindowAdapter customInfoWindowAdapter = new CustomInfoWindowAdapter();
        map.setInfoWindowAdapter(customInfoWindowAdapter);
        map.setOnInfoWindowClickListener(customInfoWindowAdapter);
        map.setOnMarkerClickListener(customInfoWindowAdapter);
        map.setOnInfoWindowCloseListener(customInfoWindowAdapter);
        map.setOnCameraIdleListener(customInfoWindowAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregisterBus();
    }

    @Override
    public void moveMapCamera(CameraUpdate cameraUpdate) {
        map.moveCamera(cameraUpdate);
    }


    public MarkerOptions produceMarkerForVenue(Venue venue) {
        return new MarkerOptions()
                .position(new LatLng(venue.getLocation().getLat(), venue.getLocation().getLng()))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.venue_pin));
    }

    @Override
    public void addVenueMarkersToMap(List<Venue> venues) {
        if (map != null) {
            LatLngBounds bounds = map.getProjection().getVisibleRegion().latLngBounds;

            //Loop through all the items that are available to be placed on the map
            for (Venue v : venues) {
                String venueKeyLatLng = String.valueOf(v.getLocation().getLat()) + String.valueOf(v.getLocation().getLng());
                if (bounds.contains(new LatLng(v.getLocation().getLat(), v.getLocation().getLng()))) {
                    //If the item isn't already being displayed
                    if (!venueMarkers.containsKey(venueKeyLatLng)) {
                        //Add the Marker to the Map and keep track of it with the HashMap
                        venueMarkers.put(venueKeyLatLng, map.addMarker(produceMarkerForVenue(v)));
                    }
                } //If the marker is off screen (Unlikely, since the search bounds request)
                else {
                    //If the course was previously on screen
                    if (venueMarkers.containsKey(venueKeyLatLng)) {
                        //1. Remove the Marker from the GoogleMap
                        venueMarkers.get(venueKeyLatLng).remove();
                        //2. Remove the reference to the Marker from the HashMap
                        venueMarkers.remove(venueKeyLatLng);
                    }
                }
            }
        }
    }

    @Override //Deprecated
    public void addShopMarker(LatLng position) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.venue_pin));
        map.addMarker(markerOptions);


        this.getMap().addMarker(new MarkerOptions().position(position).icon(BitmapDescriptorFactory.fromResource(R.drawable.venue_pin)));

    }

    @Override
    public void addMyLocationMarker(LatLng latLng) {
        this.mylocation = latLng;
        map.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.my_location)));

    }

    @Override
    public void setWholeAddressTextView(String wholeaddress) {
        usersAddressTextVies.setText(wholeaddress);
    }

    @Override
    public void storeHashMap(HashMap<String, String> latLngStringHashMap) {
        SharedPrefHelper.storeLatLng_VenueId(this, latLngStringHashMap);
    }

    @Override
    public void storeVenueId_ImageURL(String venueId, String venueImageURL) {
        SharedPrefHelper.storeVenueId_imageURL(venueId, venueImageURL, this);
    }

    @Override
    public LatLngBounds getMapBounds() {
        return map.getProjection().getVisibleRegion().latLngBounds;
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                //FirebaseCrash.log("A user doesn't have play services");

                finish();
            }
            return false;
        }
        return true;
    }


    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnInfoWindowCloseListener, GoogleMap.OnCameraIdleListener {

        private final View window;
        private final View contents;

        CustomInfoWindowAdapter() {
            window = getLayoutInflater().inflate(R.layout.infoconst, null);
            contents = getLayoutInflater().inflate(R.layout.custom_info_window, null);

        }

        @Override
        public View getInfoWindow(Marker marker) {
            LatLng markerPosition = marker.getPosition();
            if (markerPosition.longitude != mylocation.longitude && markerPosition.latitude != mylocation.latitude) {
                renderInfoWindow(marker, window);
                return window;
            } else {
                return null;
            }
        }

        @Override
        public View getInfoContents(Marker marker) {

            renderInfoContents(marker, contents);
            return contents;
        }


        private void renderInfoWindow(Marker marker, View view) {
            //set the icon
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.venue_pin_selected));

            TextView venueNameTextView = (TextView) view.findViewById(R.id.venue_name);
            TextView venueAddressTextView = (TextView) view.findViewById(R.id.venue_location);
            ImageView shopImageView = (ImageView) view.findViewById(R.id.venue_bestphoto);
            TextView venueRatingTextView = (TextView) view.findViewById(R.id.venue_rating_circle);
            TextView venueCategoryTextView = (TextView) view.findViewById(R.id.venue_category);
            venueRatingTextView.setVisibility(View.VISIBLE);
            shopImageView.setVisibility(View.VISIBLE);

            String venueId = presenter.getVenueIdbyLatLong(marker.getPosition());
            presenter.venueClicked(venueId); //TODO: handle double calls to this

            String venueName = presenter.getVenueName(venueId);
            if (!venueName.equals("empty")) {
                venueNameTextView.setText(venueName);
            }

            String venueAddress = presenter.getVenueAddress(venueId);
            if (!venueAddress.equals("empty")) {
                venueAddressTextView.setText(venueAddress);
            }

            String venueCategory = presenter.getVenueCategory(venueId);
            if (!venueCategory.equals("empty")) {
                venueCategoryTextView.setText(venueCategory);
            }

            float ratng = presenter.getVenueRating(venueId);
            if (ratng > 0) {
                venueRatingTextView.setText(String.valueOf(ratng));
            } else {
                venueRatingTextView.setVisibility(View.GONE);
            }



            String venueBestPhotoURL = presenter.getVenueBestPhotoURL(venueId);
            MarkerCallback markerCallback = new MarkerCallback(marker);
            if (!venueBestPhotoURL.equals("empty") && !venueBestPhotoURL.isEmpty()) {
                Picasso.with(getApplicationContext())
                        .load(venueBestPhotoURL).noFade()
                        .placeholder(R.drawable.venue_pin)
                        .into(shopImageView, markerCallback);
            } else {
                shopImageView.setVisibility(View.GONE);
            }

        }

        private void renderInfoContents(Marker marker, View view) {

        }

        @Override
        public boolean onMarkerClick(Marker marker) {
            System.out.println("s");

            return false;
        }

        @Override
        public void onInfoWindowClick(Marker marker) {
            System.out.println("f");
        }

        @Override
        public void onInfoWindowClose(Marker marker) {
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.venue_pin));

        }

        @Override
        public void onCameraIdle() {
            //TODO: decide to hide / show "current location" layout if user's location marker is visible
            presenter.mapCameraIdle(map.getProjection().getVisibleRegion().latLngBounds);


        }


    }

    public class MarkerCallback implements Callback {
        Marker marker = null;

        MarkerCallback(Marker marker) {
            this.marker = marker;
        }

        @Override
        public void onError() {
            Log.e(getClass().getSimpleName(), "Error loading thumbnail!");
        }

        @Override
        public void onSuccess() {
            if (marker != null && marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
                //TODO: animation
                marker.showInfoWindow();
            }
        }
    }


}
