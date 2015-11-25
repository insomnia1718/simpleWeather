package com.example.insomnia.weather.main;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.insomnia.weather.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarView();
//        initSystemBar(true);
    }

    protected void setActionBarView() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowHomeEnabled(false);
            View actionView = getLayoutInflater().inflate(R.layout.base_actionbar, null);
            ActionBar.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            TextView title = (TextView) actionView.findViewById(R.id.actionbar_title);
            title.setText(this.getTitle());
            LinearLayout back = (LinearLayout) actionView.findViewById(R.id.actionbar_back);
            back.setOnClickListener(v -> finish());
            actionBar.setCustomView(actionView, params);
            if (Build.VERSION.SDK_INT >= 21) {
                actionBar.setElevation(0);
            }
        }

    }

    protected void initSystemBar(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(on);
        }
        SystemBarTintManager manager = new SystemBarTintManager(this);
        manager.setStatusBarTintEnabled(true);
        manager.setStatusBarTintColor(Color.parseColor("#FBD8D0"));

    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = this.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        SharedPreferences preferences = getSharedPreferences("setting", Activity.MODE_PRIVATE);
//        boolean isSystemBarOn = preferences.getBoolean("systemBarOn", false);
//        initSystemBar(isSystemBarOn);
    }
}
