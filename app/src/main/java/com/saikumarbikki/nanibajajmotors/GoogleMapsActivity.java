package com.saikumarbikki.nanibajajmotors;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemaps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLng_Maripeda = new LatLng(17.372885, 79.882883);
        LatLng latLng_Kesamudram = new LatLng(17.695708, 79.862559);

        //ToDo Need to get marker title from string file
        needLocationMarker(latLng_Maripeda,"Nani Bajaj ShowRoom Maripeda(Banglow)");
        needLocationMarker(latLng_Kesamudram,"Uma Sai Bajaj ShowRoom(Kesamudram)");
    }

    // Add a marker in needed location and move the camera
    private void needLocationMarker(LatLng showroomLocations, String markerTitle){
        moveToCurrentLocationZoom(showroomLocations);
        Marker marker_showrooms =  mMap.addMarker(new MarkerOptions().position(showroomLocations).title(markerTitle));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(showroomLocations));
        marker_showrooms.showInfoWindow();

    }

    private void moveToCurrentLocationZoom(LatLng currentLocation)
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,10));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
}
