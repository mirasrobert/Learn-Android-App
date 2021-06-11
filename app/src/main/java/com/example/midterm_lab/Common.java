package com.example.midterm_lab;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public abstract class Common {
    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }

    public abstract void onReceive(Context context, Intent intent);
}
