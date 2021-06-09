package com.example.midterm_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainActivity";

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String person[], birthdays[], title[];
    int images[] = {R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        recyclerView = findViewById(R.id.recyclerView);

        person = getResources().getStringArray(R.array.person);
        birthdays = getResources().getStringArray(R.array.birthdays);
        title = getResources().getStringArray(R.array.title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, person, birthdays, images, title);
        recyclerView.setAdapter(adapter);
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