package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class activity_facebook extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_facebook);
    }

    public void link1(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/MirasRobert"));
        startActivity(intent);
    }

    public void link2(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TheBoyWhoShatteredPreciousTime"));
        startActivity(intent);
    }

    public void link3(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/jcnitro86"));
        startActivity(intent);
    }

    public void link4(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100010132547016"));
        startActivity(intent);
    }

    public void link5(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/alcatraz.pereja"));
        startActivity(intent);
    }

    public void link6(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mcerrol.juliano"));
        startActivity(intent);
    }

    public void link7(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/marvin.cabutin9"));
        startActivity(intent);
    }
}