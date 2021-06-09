package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_ytsearch extends AppCompatActivity {

    EditText searchInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ytsearch);

        searchInput = (EditText) findViewById(R.id.searchInput);


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