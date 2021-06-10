package com.example.midterm_lab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    final String TAG = "broadcast";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "BroadcastReceiver : onReceive");

        try{
            if (isOnline(context)){
                Toast.makeText(context, "Network Connected", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }

        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
    //tapos gumawa dito ng method
    public boolean isOnline(Context context){
        //log
        Log.d(TAG, "BroadcastReceiver : isOnline");

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo!= null && networkInfo.isConnected());
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

}