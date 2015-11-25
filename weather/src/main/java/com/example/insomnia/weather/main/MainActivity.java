package com.example.insomnia.weather.main;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.insomnia.weather.fragment.AddCityFragment;
import com.example.insomnia.weather.source.DotImageView;
import com.example.insomnia.weather.fragment.IndexFragment;
import com.example.insomnia.weather.fragment.LastPageFragment;
import com.example.insomnia.weather.fragment.MoreInfoFragment;
import com.example.insomnia.weather.R;
import com.example.insomnia.weather.source.Weather;
import com.example.insomnia.weather.source.Weather.ResultsEntity.WeatherDataEntity;
import com.example.insomnia.weather.source.WeatherService;

import org.w3c.dom.Text;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;


public class MainActivity extends BaseActivity {
    TextView actionBarCityName;
    ViewPager todayWeatherView;
    IndexFragment indexFragment;
    MoreInfoFragment moreInfoFragment;
    LastPageFragment lastPageFragment;
    DotImageView dot1;
    DotImageView dot2;
    DotImageView dot3;
    ProgressBar progressBar;
    WeatherPagerAdapter mWeaPageAdapter;
    @Bind(R.id.tomorrow_small_icon)
    ImageView tomorrowSmallIcon;
    @Bind(R.id.tomorrow_high_tem)
    TextView tomorrowHighTem;
    @Bind(R.id.day_after_tomorrow_small_icon)
    ImageView dayAfterTomorrowSmallIcon;
    @Bind(R.id.day_after_tomorrow_high_tem)
    TextView dayAfterTomorrowHighTem;
    @Bind(R.id.day_after_tomorrow_low_tem)
    TextView dayAfterTomorrowLowTem;
    @Bind(R.id.day_after_after_tomorrow_small_icon)
    ImageView dayAfterAfterTomorrowSmallIcon;
    @Bind(R.id.day_after_after_tomorrow_high_tem)
    TextView dayAfterAfterTomorrowHighTem;
    @Bind(R.id.day_after_after_tomorrow_low_tem)
    TextView dayAfterAfterTomorrowLowTem;
    @Bind(R.id.tomorrow_low_tem)
    TextView tomorrowLowTem;
    private LocationManager locationManager;
    private MyHandler handler;
    private String cityName;
    private MyLocationListener locationListener;
    private PtrFrameLayout ptrlayout;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        handler = new MyHandler();
        preferences = getSharedPreferences("Data", Activity.MODE_PRIVATE);
        String lastCityName = preferences.getString("lastCityName", "");
        if (!TextUtils.isEmpty(lastCityName))
            cityName = lastCityName;
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        setWeaActionBarView();
        initViews();
        locationListener = new MyLocationListener();
        setLocation();
        FragmentManager manager = getFragmentManager();
        mWeaPageAdapter = new WeatherPagerAdapter(manager);
        todayWeatherView.setOffscreenPageLimit(3);
        todayWeatherView.setAdapter(mWeaPageAdapter);
        todayWeatherView.setOnPageChangeListener(new MyonPageChangeListener());

        ptrlayout = (PtrFrameLayout) findViewById(R.id.rotate_header_list_view_frame);
        ptrlayout.disableWhenHorizontalMove(true);
        ptrlayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                progressBar.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(cityName)) {
                    setLocation();
                } else {
                    new mAsyncTask().execute(cityName);
                }
            }
        });
    }

    private class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (msg.arg1 == 0) {

                } else if (msg.arg1 == 1) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                    }
                    Location currentLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    Log.i("loop", "notice");
                    if (currentLocation != null) {
                        Log.i("location", String.valueOf(currentLocation.getLatitude()));
                        Log.i("location", String.valueOf(currentLocation.getLongitude()));
                        String locationData = String.valueOf(currentLocation.getLongitude()) + "," + String.valueOf(currentLocation.getLatitude());
                        Log.i("location", locationData);
                        new mAsyncTask().execute(locationData);
                    }
                }
            }
        }
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 300000, 1000, locationListener);
        }

    }

    private void setLocation() {
        Message msg = handler.obtainMessage(0);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            msg.arg1 = 1;
            handler.sendMessage(msg);
        } else
            if (!TextUtils.isEmpty(cityName)){
                new mAsyncTask().execute(cityName);
            }
    }

    private void showUnLocationDialog() {
        new AlertDialog.Builder(MainActivity.this).setTitle("无法定位...").setMessage("请开启定位服务，并允许获取您的位置。")
                .setPositiveButton("前往设置", (dialog, which) ->
                {
                    Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(i);
                }).setNegativeButton("取消", (dialog, which) -> {
            ptrlayout.refreshComplete();
            progressBar.setVisibility(View.GONE);
            dialog.dismiss();
        }).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
        }
        locationManager.removeUpdates(locationListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private class MyonPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    clearActiveDot();
                    dot1.active();
                    break;
                case 1:
                    clearActiveDot();
                    dot2.active();
                    break;
                case 2:
                    clearActiveDot();
                    dot3.active();
                    break;
            }
        }

        private void clearActiveDot() {
            dot1.unActive();
            dot2.unActive();
            dot3.unActive();
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private class WeatherPagerAdapter extends FragmentPagerAdapter {
        public WeatherPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    IndexFragment fragment = IndexFragment.getInstance();
                    fragment.setOnDialogCallback(name -> {
                        new mAsyncTask().execute(name);
                        if (!TextUtils.isEmpty(name)) {
                            cityName = name;
                            actionBarCityName.setText(cityName);
                        }
                    });
                    return IndexFragment.getInstance();
                case 1:
                    return MoreInfoFragment.getInstance();
                case 2:
                    return LastPageFragment.getInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    private class mAsyncTask extends AsyncTask<String, Integer, Weather> {

        @Override
        protected Weather doInBackground(String... strings) {
            Weather mWeather = null;
            try {
                WeatherService service = new WeatherService(strings[0]);
                mWeather = service.getWeather();
//                Log.i("weather", service.getResponse());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mWeather;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
            ptrlayout.refreshComplete();
            progressBar.setVisibility(View.GONE);
            if (weather != null) {
                indexFragment = IndexFragment.getInstance(weather);
                moreInfoFragment = MoreInfoFragment.getInstance(weather);
                lastPageFragment = LastPageFragment.getInstance(weather);
                loadDatas(weather);
                LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(MainActivity.this);
                Intent i = new Intent("com.weather.LOAD.COMPLETE");
                broadcastManager.sendBroadcast(i);
                return;
            }
            Snackbar.make(todayWeatherView.getRootView(), "获取天气信息失败", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void loadDatas(Weather weather) {
        cityName = weather.getResults().get(0).getCurrentCity();
        if (cityName != null && !"".equals(cityName)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lastCityName", cityName);
            editor.apply();
        }
        actionBarCityName.setText(weather.getResults().get(0).getCurrentCity());
        loadDatas(1, tomorrowLowTem, tomorrowHighTem, tomorrowSmallIcon, weather);
        loadDatas(2, dayAfterTomorrowLowTem, dayAfterTomorrowHighTem, dayAfterTomorrowSmallIcon, weather);
        loadDatas(3, dayAfterAfterTomorrowLowTem, dayAfterAfterTomorrowHighTem, dayAfterAfterTomorrowSmallIcon, weather);
    }

    private void loadDatas(int day, TextView lowTem, TextView highTem, ImageView future_wea_icon, Weather weather) {
        WeatherDataEntity entity = weather.getResults().get(0).getWeather_data().get(day);
        String highTemData = formateTem(entity.getTemperature())[0] + getResources().getString(R.string.du);
        String lowTemData = formateTem(entity.getTemperature())[1] + getResources().getString(R.string.du);
        String weaData = entity.getWeather();
        future_wea_icon.setImageResource(getFutureWeaIcon(weaData));
        highTem.setText(highTemData);
        lowTem.setText(lowTemData);
    }

    private int getFutureWeaIcon(String weaData) {
        if (weaData.contains("雨")) {
            if (weaData.contains("晴"))
                return R.mipmap.future_wea_sun_to_rain;
            else if (weaData.contains("暴雨") || weaData.contains("大雨")) {
                if (weaData.contains("暴雨")) return R.mipmap.future_wea_great_rain;
                return R.mipmap.future_wea_big_rain;
            } else if (weaData.contains("小雨"))
                return R.mipmap.future_wea_small_rain;
            else if (weaData.contains("阵雨")) {
                if (weaData.contains("雷阵雨")) return R.mipmap.future_wea_thunder_rain;
                return R.mipmap.future_wea_sun_to_rain;
            } else if (weaData.contains("中雨"))
                return R.mipmap.future_wea_mid_rain;
            return R.mipmap.future_wea_small_rain;
        }
        if (weaData.contains("雪")) {
            if (weaData.contains("小雪")) return R.mipmap.future_wea_small_snow;
            if (weaData.contains("中雪") || weaData.contains("大雪"))
                return R.mipmap.future_wea_big_snow;
            return R.mipmap.future_wea_small_snow;
        }
        if (weaData.contains("冰雹"))
            return R.mipmap.future_wea_iceball;
        if (weaData.contains("沙尘暴"))
            return R.mipmap.future_wea_sand;
        if (weaData.contains("雾")) {
            if (weaData.contains("雾霾")) return R.mipmap.future_wea_mai;
            return R.mipmap.future_wea_fog;
        }
        if (weaData.contains("多云")) {
            if (weaData.contains("晴") && weaData.contains("转"))
                return R.mipmap.future_wea_sunny_cloud;
            return R.mipmap.future_wea_cloud;
        }
        if (weaData.contains("阴")) return R.mipmap.future_wea_cloud;
        if (weaData.contains("晴"))
            return R.mipmap.future_wea_sunny;
        return R.mipmap.future_wea_sunny;
    }

    private String[] formateTem(String tem) {
        String highTem = null;
        String lowTem = null;
        for (int i = 0; i < tem.length(); i++) {
            if (tem.charAt(i) == '~') {
                highTem = tem.substring(0, i - 1);
                lowTem = tem.substring(i + 2, tem.length() - 1);
            }
        }
        String[] data = new String[2];
        data[0] = highTem;
        data[1] = lowTem;
        return data;
    }

    private void initViews() {
        todayWeatherView = (ViewPager) findViewById(R.id.today_weather_fragment);
        dot1 = (DotImageView) findViewById(R.id.dot1);
        dot2 = (DotImageView) findViewById(R.id.dot2);
        dot3 = (DotImageView) findViewById(R.id.dot3);
        progressBar = (ProgressBar) findViewById(R.id.loading_progressbar);
        dot1.active();
    }

    private void setWeaActionBarView() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            View actionView = getLayoutInflater().inflate(R.layout.main_actionbar, null);
            actionBar.setCustomView(actionView);
            actionBarCityName = (TextView) actionView.findViewById(R.id.city_name);
            if (Build.VERSION.SDK_INT >= 21) {
                actionBar.setElevation(0);
            }
        }

    }


}
