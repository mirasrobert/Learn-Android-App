package com.example.midterm_lab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class maponefragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Cavinti Laguna, Philippines.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng cavinti = new LatLng(14.243721, 121.509029);
            googleMap.addMarker(new MarkerOptions().position(cavinti).title("Marker in Cavinti Laguna"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cavinti, 15f));
        }
    };

    // called to do initial creation of the fragment.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "MapFragOne : onCreateView", Toast.LENGTH_SHORT).show();

        // Return or inflate the fragment to view on the activity
        return inflater.inflate(R.layout.fragment_maponefragment, container, false);
    }

    /* Check if Fragment is present
    * Called immediately after onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
    * has returned, but before any saved state has been restored in to the view.
    *
    * Creates and returns the view hierarchy associated with the fragment.
    * To ensure that your Fragment's view hierarchy has been created
    * Added in API level 13
    * Deprecated in API level 28
    */

    /*
    *
    * We face some crashes initializing view in onCreateView
    * You should inflate your layout in onCreateView but shouldn't initialize
    * other views using findViewById in onCreateView
    *
    * Because sometimes view is not properly initialized. So always use findViewById in
    * onViewCreated(when view is fully created)
    * and it also passes the view as parameter.
    * onViewCreated is a make sure that view is fully created.
     */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "MapFragOne : onViewCreated", Toast.LENGTH_SHORT).show();

        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    // makes the fragment visible to the user (based on its containing activity being started).
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "MapFragOne: onStart", Toast.LENGTH_SHORT).show();
    }

    // makes fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.
    // Activity is not visible to user and goes in background when onPause() method is executed.
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "MapFragOne : onPause", Toast.LENGTH_SHORT).show();
    }

    // makes the fragment begin interacting with the user (based on its containing activity being
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "MapFragOne : onResume", Toast.LENGTH_SHORT).show();
    }

    //  fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "MapFragOne : onStop", Toast.LENGTH_SHORT).show();
    }

    // called to do final cleanup of the fragment's state.
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "MapFragOne : onDestroy", Toast.LENGTH_SHORT).show();
    }

    // called immediately prior to the fragment no longer being associated with its activity.
    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "MapFragOne : onDetach", Toast.LENGTH_SHORT).show();
    }

    // Learn more - https://developer.android.com/reference/android/app/Fragment#Lifecycle
}