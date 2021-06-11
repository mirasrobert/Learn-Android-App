package com.example.midterm_lab;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_menu extends AppCompatActivity {

    private static final String TAG = "menuActivity";

    Animation topAnim, bottomAnim;
    CardView ourteamCard, lspuCard;
    ImageView ourteamImg, lspuImg;
    TextView ourteam, lspu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        Log.i(TAG, "onCreate");


        ourteamCard = findViewById(R.id.ourTeamCard);
        lspuCard = findViewById(R.id.lspuCard);

        ourteamImg = findViewById(R.id.ourTeamImg);
        lspuImg = findViewById(R.id.lspuImg);

        ourteam = findViewById(R.id.ourteam);
        lspu = findViewById(R.id.lspu);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_bottom);

        //CALL THE ANIMATION
        startAnimation(topAnim, bottomAnim);

        ourteamCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOurTeam();
            }
        });

        lspuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLSPU();
            }
        });
    }

    public void goToOurTeam() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToLSPU() {
        Intent intent = new Intent(this, activity_lspu.class);
        startActivity(intent);
    }

    private void startAnimation(Animation topAnim, Animation bottomAnim) {
        ourteamCard.setAnimation(topAnim);
        ourteamImg.setAnimation(topAnim);
        ourteam.setAnimation(topAnim);

        lspuCard.setAnimation(bottomAnim);
        lspuImg.setAnimation(bottomAnim);
        lspu.setAnimation(bottomAnim);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    // Show Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Go to Activities by clicking into the items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.contact:
                Intent intent1 = new Intent(this, activity_contact.class);
                startActivity(intent1);
                return true;
            case R.id.youtube:
                Intent intent2 = new Intent(this, activity_ytsearch.class);
                startActivity(intent2);
                return true;
            case R.id.fb:
                Intent intent3 = new Intent(this, activity_facebook.class);
                startActivity(intent3);
                return true;
            case R.id.about:
                Toast.makeText(this, "App Version v1.5", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.location:
                Intent intent4 = new Intent(this, activity_location.class);
                startActivity(intent4);
                return true;
            case R.id.exit:
                exit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                //finishAndRemoveTask();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}