package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_contact extends AppCompatActivity {

    public String subject, feedback;
    
    EditText subjectTxt, feedbackTxt;
    Button sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        subjectTxt = (EditText) findViewById(R.id.subjectTxt);
        feedbackTxt = (EditText) findViewById(R.id.feedbackTxt);
        sendbtn = findViewById(R.id.sendbtn);

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
            String[] array = {"nathanielcalabia19@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL, array);
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            i.putExtra(Intent.EXTRA_TEXT, feedback);

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