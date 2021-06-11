package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class activity_facebook extends AppCompatActivity {

    Animation leftAnim, rightAnim;
    ImageView fbicon, robert, nathan, jc, leynard, airman, mcerrol, marvin;
    CardView robertcard, nathancard, jccard, leynardcard, airmancard, mcerrolcard, marvincard;
    TextView profiletxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_facebook);

        fbicon = findViewById(R.id.fbicon);
        robert = findViewById(R.id.robert);
        nathan = findViewById(R.id.nathan);
        jc = findViewById(R.id.jc);
        leynard = findViewById(R.id.leynard);
        airman = findViewById(R.id.airman);
        mcerrol = findViewById(R.id.mcerrol);
        marvin = findViewById(R.id.marvin);

        robertcard = findViewById(R.id.robertcard);
        nathancard = findViewById(R.id.nathancard);
        jccard = findViewById(R.id.jccard);
        leynardcard = findViewById(R.id.leynardcard);
        airmancard = findViewById(R.id.airmancard);
        mcerrolcard = findViewById(R.id.mcerrolcard);
        marvincard = findViewById(R.id.marvincard);

        profiletxt = findViewById(R.id.profiletxt);

        leftAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Start animation
        startAnimation(leftAnim, rightAnim);
    }

    private void startAnimation(Animation leftAnim, Animation rightAnim) {

        profiletxt.setAnimation(rightAnim);
        fbicon.setAnimation(rightAnim);

        robert.setAnimation(leftAnim);
        robertcard.setAnimation(leftAnim);
        jc.setAnimation(leftAnim);
        jccard.setAnimation(leftAnim);
        airman.setAnimation(leftAnim);
        airmancard.setAnimation(leftAnim);
        marvin.setAnimation(leftAnim);
        marvincard.setAnimation(leftAnim);

        nathan.setAnimation(rightAnim);
        nathancard.setAnimation(rightAnim);
        leynard.setAnimation(rightAnim);
        leynardcard.setAnimation(rightAnim);
        mcerrol.setAnimation(rightAnim);
        mcerrolcard.setAnimation(rightAnim);
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