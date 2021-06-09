package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class gettingstarted extends AppCompatActivity {

    private static final String TAG = "gettingActivity";

    Animation topAnim, bottomAnim;
    TextView textView, textView2, textView3, textView4;
    ImageView startImg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gettingstarted);
        Log.i(TAG,"onCreate");

        btn = findViewById(R.id.btn);
        startImg = findViewById(R.id.imageViewHeader);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_bottom);

        //CALL THE ANIMATION
        startAnimation(topAnim, bottomAnim);

        // IF BUTTON IS CLICKED.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }

    private void startAnimation(Animation topAnim, Animation bottomAnim)
    {
        startImg.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);
        textView2.setAnimation(bottomAnim);
        textView3.setAnimation(bottomAnim);
        textView4.setAnimation(bottomAnim);
        btn.setAnimation(bottomAnim);
    }

    public void nextActivity()  {
        Intent intent = new Intent(this, activity_loading.class);
        startActivity(intent);
        finish();
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