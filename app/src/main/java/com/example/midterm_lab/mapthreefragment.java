package com.example.midterm_lab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapthreefragment extends Fragment {

    final String TAG = "mapfragthree";

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sta. Maria Laguna, Philippines.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng stamaria = new LatLng(14.469910, 121.425613);
            googleMap.addMarker(new MarkerOptions().position(stamaria).title("Marker in Sta Maria Laguna"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stamaria, 15f));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "mapfragthree : onCreateView");

        return inflater.inflate(R.layout.fragment_mapthreefragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "mapfragthree : onCreateView");

        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "mapfragthree : onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "mapfragthree : onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "mapfragthree : onStop");
    }

    // called to do final cleanup of the fragment's state.
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "mapfragthree : onDestroy");
    }

    // called immediately prior to the fragment no longer being associated with its activity.
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "mapfragthree : onDetach");
    }
}