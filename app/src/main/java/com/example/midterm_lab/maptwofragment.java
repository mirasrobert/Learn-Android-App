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

public class    maptwofragment extends Fragment {

    final String TAG = "mapfragtwo";

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
            LatLng stamaria = new LatLng(14.470727, 121.423763);
            googleMap.addMarker(new MarkerOptions().position(stamaria).title("Marker in Sta. Maria Laguna"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stamaria, 15f));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "mapfragtwo : onCreateView");

        return inflater.inflate(R.layout.fragment_maptwofragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "mapfragtwo : onCreateView");

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
        Log.d(TAG, "mapfragtwo : onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "MapFragOne : onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "mapfragtwo : onResume");
    }
}