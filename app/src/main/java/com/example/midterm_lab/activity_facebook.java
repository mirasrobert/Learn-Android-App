package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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

        //Assign variable
        CardView cardView = (CardView) findViewById(R.id.robertcard);
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
        // Use setOnLongClickListener to long press card view
            @Override
            public boolean onLongClick(View v) {
                //Initialize the popup menu
                PopupMenu popup = new PopupMenu(activity_facebook.this, v);
                popup.setOnMenuItemClickListener(activity_facebook.this::
                        setOnMenuItemClickListener);
                //Inflate the popup menu
                //Read the layout of the created xml file
                popup.inflate(R.menu.robert_popupmenu);
                popup.show();
                return false;
            }
        });

        CardView cardView1 = (CardView) findViewById(R.id.nathancard);
        cardView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popup = new PopupMenu(activity_facebook.this, v);
                popup.setOnMenuItemClickListener(activity_facebook.this::
                        setOnMenuItemClickListener);
                popup.inflate(R.menu.nathan_popupmenu);
                popup.show();
                return false;
            }
        });

        CardView cardView2 = (CardView) findViewById(R.id.jccard);
        cardView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popup = new PopupMenu(activity_facebook.this, v);
                popup.setOnMenuItemClickListener(activity_facebook.this::
                        setOnMenuItemClickListener);
                popup.inflate(R.menu.jc_popupmenu);
                popup.show();
                return false;
            }
        });

        CardView cardView3 = (CardView) findViewById(R.id.leynardcard);
        cardView3.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            PopupMenu popup = new PopupMenu(activity_facebook.this, v);
            popup.setOnMenuItemClickListener(activity_facebook.this::
                    setOnMenuItemClickListener);
            popup.inflate(R.menu.leynard_popupmenu);
            popup.show();
            return false;
        }
    });

        CardView cardView4 = (CardView) findViewById(R.id.airmancard);
        cardView4.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            PopupMenu popup = new PopupMenu(activity_facebook.this, v);
            popup.setOnMenuItemClickListener(activity_facebook.this::
                    setOnMenuItemClickListener);
            popup.inflate(R.menu.airman_popupmenu);
            popup.show();
            return false;
        }
    });

        CardView cardView5 = (CardView) findViewById(R.id.mcerrolcard);
        cardView5.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            PopupMenu popup = new PopupMenu(activity_facebook.this, v);
            popup.setOnMenuItemClickListener(activity_facebook.this::
                    setOnMenuItemClickListener);
            popup.inflate(R.menu.errol_popupmenu);
            popup.show();
            return false;
        }
    });

        CardView cardView6 = (CardView) findViewById(R.id.marvincard);
        cardView6.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            PopupMenu popup = new PopupMenu(activity_facebook.this, v);
            popup.setOnMenuItemClickListener(activity_facebook.this::
                    setOnMenuItemClickListener);
            popup.inflate(R.menu.marvin_popupmenu);
            popup.show();
            return false;
        }
    });
}
    public activity_facebook() {
        super();
    }

    public boolean setOnMenuItemClickListener(MenuItem item) {

        switch (item.getItemId()) {

            //Robert Copy and Share
            case R.id.menu_copy_robert:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                // Use ClipboardManager Class to be able to use clipboard framework
                // Creates a new text clip to put on the clipboard
                //Clipboard holds the ClipData that contains description of the data
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", "https://www.facebook.com/MirasRobert");
                clipboard.setPrimaryClip(clip);

                return true;
            case R.id.menu_share_robert:

                Intent sendIntent = new Intent();
                // Use ACTION_SEND to send data from one activity to another
                sendIntent.setAction(Intent.ACTION_SEND);
                // Send Intent text that you set or put
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/MirasRobert");
                // Set text font to plain
                sendIntent.setType("text/plain");
                //Intent.createChooser display the Android sharesheet
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            //Nathan Copy and Share
                return true;
            case R.id.menu_copy_nathan:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard1 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip1 = ClipData.newPlainText("text", "https://www.facebook.com/TheBoyWhoShatteredPreciousTime");
                clipboard1.setPrimaryClip(clip1);

                return true;
            case R.id.menu_share_nathan:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/TheBoyWhoShatteredPreciousTime");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            //JC Copy and Share
                return true;
            case R.id.menu_copy_jc:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard2 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip2 = ClipData.newPlainText("text", "https://www.facebook.com/jcnitro86");
                clipboard2.setPrimaryClip(clip2);

                return true;
            case R.id.menu_share_jc:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/jcnitro86");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                //Ley Copy and Share
                return true;
            case R.id.menu_copy_leynard:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard3 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip3 = ClipData.newPlainText("text", "https://www.facebook.com/profile.php?id=100010132547016");
                clipboard3.setPrimaryClip(clip3);

                return true;
            case R.id.menu_share_leynard:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/profile.php?id=100010132547016");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                //Airman Copy and Share
                return true;
            case R.id.menu_copy_airman:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard4 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip4 = ClipData.newPlainText("text", "https://www.facebook.com/alcatraz.pereja");
                clipboard4.setPrimaryClip(clip4);

                return true;
            case R.id.menu_share_airman:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/alcatraz.pereja");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                //Mc Errol Copy and Share
                return true;
            case R.id.menu_copy_errol:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard5 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip5 = ClipData.newPlainText("text", "https://www.facebook.com/mcerrol.juliano");
                clipboard5.setPrimaryClip(clip5);

                return true;
            case R.id.menu_share_errol:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/mcerrol.juliano");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                //Marvin Copy and Share
                return true;
            case R.id.menu_copy_marvin:
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
                ClipboardManager clipboard6 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip6 = ClipData.newPlainText("text", "https://www.facebook.com/marvin.cabutin9");
                clipboard6.setPrimaryClip(clip6);

                return true;
            case R.id.menu_share_marvin:

                sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/marvin.cabutin9");
                sendIntent.setType("text/plain");

                shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            default:
                return false;
        }

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