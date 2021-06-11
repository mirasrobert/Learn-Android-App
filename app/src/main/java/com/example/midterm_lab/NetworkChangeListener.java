package com.example.midterm_lab;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class NetworkChangeListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Common.isConnectedToInternet(context)) { //not connected
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View layout_dialog = LayoutInflater.from(context).inflate(R.layout.checkinternet_dialogbox, null);
            builder.setView(layout_dialog);

            AppCompatButton button = layout_dialog.findViewById(R.id.button);

            //show dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            dialog.setCancelable(false);

            dialog.getWindow().setGravity(Gravity.CENTER);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    onReceive(context, intent);
                }
            });
        }
    }
}
