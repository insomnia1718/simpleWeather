package com.example.insomnia.weather.main;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.CompoundButton;

import com.example.insomnia.weather.R;
import com.kyleduo.switchbutton.SwitchButton;


public class SettingsActivity extends BaseActivity {
    SwitchButton switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_setting);
        CardView cardView = (CardView) findViewById(R.id.setting_about);
        cardView.setOnClickListener(v -> startActivity(new Intent(this, AboutActivity.class)));
//        SharedPreferences preferences = getSharedPreferences("setting", Activity.MODE_PRIVATE);
//        switchButton = (SwitchButton)findViewById(R.id.systemBar_switch);
//        switchButton.setChecked(preferences.getBoolean("systemBarOn",false));
//        switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
//
//            SharedPreferences.Editor editor = preferences.edit();
//            if (isChecked) {
//                editor.putBoolean("systemBarOn", true);
//                initSystemBar(true);
//                cardView.getRootView().setFitsSystemWindows(false);
//            } else {
//                editor.putBoolean("systemBarOn", false);
//                initSystemBar(false);
//
//            }
//            editor.commit();
//        });
    }
}