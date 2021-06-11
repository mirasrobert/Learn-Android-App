package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class activity_ytsearch extends AppCompatActivity {

    EditText searchInput;
    ImageView imageView;
    TextView textView;
    Animation topAnim, bottomAnim;
    TextInputLayout searchplaceholder;
    Button searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ytsearch);

        searchInput = (EditText) findViewById(R.id.searchInput);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView5);
        searchplaceholder = findViewById(R.id.searchplaceholder);
        searchbtn = findViewById(R.id.searchBtn);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_bottom);

        //CALL THE ANIMATION
        startAnimation(topAnim, bottomAnim);

    }

    private void startAnimation(Animation topAnim, Animation bottomAnim)
    {
        imageView.setAnimation(topAnim);
        textView.setAnimation(topAnim);
        searchbtn.setAnimation(bottomAnim);
        searchplaceholder.setAnimation(bottomAnim);
    }

    public void searchYt(View v)
    {
        String searchText = searchInput.getText().toString();


        String ytLink = "https://www.youtube.com/results?search_query="+searchText;

        if (!searchText.equals("")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ytLink));
            startActivity(intent);
        } else {
            Toast.makeText(this, "Search field is required", Toast.LENGTH_SHORT).show();
        }


    }
}