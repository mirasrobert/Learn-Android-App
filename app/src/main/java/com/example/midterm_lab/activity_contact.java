package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class activity_contact extends AppCompatActivity {

    public String subject, feedback;

    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView textView;
    TextInputLayout subjectplaceholder, feedbackplaceholder;
    EditText subjectTxt, feedbackTxt;
    Button sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_contact);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView5);
        subjectplaceholder = findViewById(R.id.subjectplaceholder);
        feedbackplaceholder = findViewById(R.id.feedbackplaceholder);
        subjectTxt = (EditText) findViewById(R.id.subjectTxt);
        feedbackTxt = (EditText) findViewById(R.id.feedbackTxt);
        sendbtn = findViewById(R.id.sendbtn);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.getstarted_bottom);

        //CALL THE ANIMATION
        startAnimation(topAnim, bottomAnim);
    }

    private void startAnimation(Animation topAnim, Animation bottomAnim)
    {
        imageView.setAnimation(topAnim);
        textView.setAnimation(topAnim);
        sendbtn.setAnimation(bottomAnim);
        feedbackTxt.setAnimation(bottomAnim);
        subjectTxt.setAnimation(bottomAnim);
        subjectplaceholder.setAnimation(bottomAnim);
        feedbackplaceholder.setAnimation(bottomAnim);
    }

    public void createEmail (View v)
    {
        subject = subjectTxt.getText().toString();
        feedback = feedbackTxt.getText().toString();
        if (validation(subject, feedback)) {
            Toast.makeText(this, "All Fields Are Required", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Composing E-mail...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String[] array = {"airmanpereja34@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL, array);
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            subject = subjectTxt.getText().toString();

            //Check if user has some application that can handle email
            if (i.resolveActivity(getPackageManager()) != null )
            {
                startActivity(i);
            }
        }
    }

    public boolean validation (String subject, String feedback) {
        if (subject.equals("") || feedback.equals("")) {
            return true;
        }
        return false;
    }


}