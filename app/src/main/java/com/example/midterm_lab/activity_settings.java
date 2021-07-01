package com.example.midterm_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class activity_settings extends AppCompatActivity {

    private View parentView;
    private SwitchMaterial themeSwitch;
    private TextView settings_title, appearance_title, dark_theme_title;

    private UserSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = (UserSettings) getApplication();
        initWidgets();

        loadSharedPreferences();

        initSwitchListener();

    }

    private void initSwitchListener() {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    settings.setCustomTheme(UserSettings.DARK_THEME);
                }
                else {

                    settings.setCustomTheme(UserSettings.LIGHT_THEME);
                }

                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME, settings.getCustomTheme());
                editor.commit();
                // Update the UI
                applyTheme();

            }
        });
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
        applyTheme();

    }

    private void initWidgets() {
        settings_title = findViewById(R.id.settings_title);
        appearance_title = findViewById(R.id.appearance_title);
        dark_theme_title = findViewById(R.id.dark_theme_title);
        themeSwitch = findViewById(R.id.themeSwitch);
        parentView = findViewById(R.id.parentView);
    }

    private void applyTheme() {

        if(settings.getCustomTheme().equals(UserSettings.DARK_THEME)) {

            settings_title.setTextColor(this.getResources().getColor(R.color.white));
            appearance_title.setTextColor(this.getResources().getColor(R.color.white));
            dark_theme_title.setTextColor(this.getResources().getColor(R.color.white));
            parentView.setBackgroundColor(this.getResources().getColor(R.color.black));
            themeSwitch.setChecked(true);

        } else {

            settings_title.setTextColor(this.getResources().getColor(R.color.black));
            appearance_title.setTextColor(this.getResources().getColor(R.color.black));
            dark_theme_title.setTextColor(this.getResources().getColor(R.color.black));
            parentView.setBackgroundColor(this.getResources().getColor(R.color.white));
            themeSwitch.setChecked(false);

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            startActivity(new Intent(this, activity_menu.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}