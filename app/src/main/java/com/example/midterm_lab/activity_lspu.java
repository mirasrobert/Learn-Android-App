package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Objects;

public class activity_lspu extends AppCompatActivity {

    private static final String TAG = "lspuActivity";

    Animation topAnim, bottomAnim;
    CardView visionCard, missionCard;
    TextView vision, visionText, mission, missionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lspu);
        Log.i(TAG,"onCreate");

        vision = findViewById(R.id.vision);
        visionText = findViewById(R.id.visionText);

        mission = findViewById(R.id.mission);
        missionText = findViewById(R.id.missionText);

        visionCard = findViewById(R.id.visionCard);
        missionCard = findViewById(R.id.missionCard);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Start animation
        startAnimation(topAnim, bottomAnim);

    }

    private void startAnimation(Animation topAnim, Animation bottomAnim) {

        vision.setAnimation(topAnim);
        visionText.setAnimation(topAnim);
        visionCard.setAnimation(topAnim);

        mission.setAnimation(bottomAnim);
        missionText.setAnimation(bottomAnim);
        missionCard.setAnimation(bottomAnim);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart");
    }
}