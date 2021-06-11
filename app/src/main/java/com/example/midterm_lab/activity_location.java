package com.example.midterm_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_location extends AppCompatActivity {

    final String TAG = "LocationActivity";
    // Dito na yung Broadcastlistener then sa baba yung override

    NetworkChangeListener networkChangeListener = new NetworkChangeListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_location);
    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
        Log.d(TAG, "LocationActivity : onStart");
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
        Log.d(TAG, "LocationActivity : onStop");
        ;

    }

    private void replaceFragmentForGoogleMap(Fragment fragment) {
        // Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the frame layout with GOOGLE MAP FRAGMENT
        fragmentTransaction.replace(R.id.frameLayoutId, fragment);
        fragmentTransaction.commit();

    }

    // Show the MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.location_menu, menu);
        return true;
    }

    // DO SOMETHING WHEN BUTTON IN MENU IS CLICKED.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            // SHOW THE LOCATIONS OF EACH PERSON
            case R.id.robert:
                replaceFragmentForGoogleMap(new maponefragment());
                return true;

            case R.id.jc:
                replaceFragmentForGoogleMap(new maptwofragment());
                return true;

            case R.id.airman:
                replaceFragmentForGoogleMap(new mapthreefragment());
                return true;

            case R.id.nathan:
                replaceFragmentForGoogleMap(new mapfourfragment());
                return true;

            case R.id.marvin:
                replaceFragmentForGoogleMap(new mapfivefragment());
                return true;

            case R.id.leynard:
                replaceFragmentForGoogleMap(new mapsixfragment());
                return true;

            case R.id.errol:
                replaceFragmentForGoogleMap(new mapsevenfragment());
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"LocationActivity : onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"LocationActivity : onPaused");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"LocationActivity : onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"LocationActivity : onRestart");

    }

}