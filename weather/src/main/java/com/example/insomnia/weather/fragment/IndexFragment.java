package com.example.insomnia.weather.fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.insomnia.weather.R;
import com.example.insomnia.weather.source.Weather;
import com.example.insomnia.weather.source.Weather.ResultsEntity;
import com.example.insomnia.weather.main.ChatActivity;
import com.example.insomnia.weather.main.SettingsActivity;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class IndexFragment extends Fragment {
    @Bind(R.id.today_week_day)
    TextView todayWeekDay;
    @Bind(R.id.current_tem)
    TextView currentTem;
    @Bind(R.id.current_weather_icon)
    ImageView currentWeatherIcon;
    @Bind(R.id.current_weather_details)
    TextView currentWeatherDetails;
    @Bind(R.id.today_high_tem)
    TextView todayHighTem;
    @Bind(R.id.today_low_tem)
    TextView todayLowTem;
    @Bind(R.id.today_pm25)
    TextView todayPm25;
    @Bind(R.id.today_pm25_text)
    TextView todayPm25Text;
    @Bind(R.id.current_wea_wind)
    TextView currentWeaWind;
    @Bind(R.id.add_bn_menu)
    FloatingActionMenu addMenu;
    @Bind(R.id.icon_add_fun)
    FloatingActionButton iconAddFun;
    @Bind(R.id.icon_add_setting)
    FloatingActionButton iconAddSetting;
    @Bind(R.id.icon_add_city)
    FloatingActionButton iconAddCity;
    private Weather mWeather;
    private static IndexFragment fragment;
    private OnDialogCallback callback;

    public static IndexFragment getInstance() {
        if (fragment == null) {
            fragment = new IndexFragment();
        }
        return fragment;
    }

    public static IndexFragment getInstance(Weather Weather) {
        fragment = getInstance();
        fragment.mWeather = Weather;
        return fragment;
    }

    public interface OnDialogCallback {
        void onCallback(String name);
    }

    public void setOnDialogCallback(OnDialogCallback callback) {
        this.callback = callback;
    }

    public IndexFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.weather.LOAD.COMPLETE"))
                    Log.i("LoadBroadcastReceiver", "noticeIndex");
                loadDatas();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.weather.LOAD.COMPLETE");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, filter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_copy, container, false);
        ButterKnife.bind(this, view);
        if (mWeather != null) {
            loadDatas();
        }
        setTypeface();
        setAddButton();
        return view;
    }


    private void setTypeface() {
        Typeface fontCag = Typeface.createFromAsset(getActivity().getAssets(), "Cagliostro_Regular.ttf");
        Typeface fontGill = Typeface.createFromAsset(getActivity().getAssets(), "Gill.ttf");
        currentTem.setTypeface(fontCag);
        todayPm25Text.setTypeface(fontGill);
    }


    private void setAddButton() {
        iconAddCity.setOnClickListener(v -> {
            addMenu.toggle(true);
            AddCityFragment addCityFragment = AddCityFragment.newInstance();
            addCityFragment.setOnClickListener(callback::onCallback);
            addCityFragment.show(getFragmentManager(), "addCityDialog");
        });
        iconAddSetting.setOnClickListener(v -> {
            addMenu.toggle(false);
            startActivity(new Intent(getActivity(),SettingsActivity.class));
        });
        iconAddFun.setOnClickListener(v -> {
            addMenu.toggle(false);
            startActivity(new Intent(getActivity(),ChatActivity.class));
        });
    }


    private void loadDatas() {
        setDayOfWeek();
        String pm25 = mWeather.getResults().get(0).getPm25();
        todayPm25.setText(TextUtils.isEmpty(pm25) ? "无数据" : pm25);
        ResultsEntity.WeatherDataEntity todayWeaData = mWeather.getResults().get(0).getWeather_data().get(0);
        String currentTemData = formatCurrentTem(todayWeaData.getDate()) + "'";
        currentTem.setText(TextUtils.isEmpty(currentTemData)?"- -":currentTemData);
        String weatherDetailsData = todayWeaData.getWeather();
        currentWeatherDetails.setText(TextUtils.isEmpty(weatherDetailsData)?"- -":weatherDetailsData);
        currentWeaWind.setText(TextUtils.isEmpty(todayWeaData.getWind())?"- -":todayWeaData.getWind());
        String todayHighTemData = formatTem(todayWeaData.getTemperature())[0] + getResources().getString(R.string.du);
        String todayLowTemData = formatTem(todayWeaData.getTemperature())[1] + getResources().getString(R.string.du);
        todayHighTem.setText(TextUtils.isEmpty(todayHighTemData)?"- -":todayHighTemData);
        todayLowTem.setText(TextUtils.isEmpty(todayLowTemData)?"- -":todayLowTemData);
        currentWeatherIcon.setImageDrawable(getResources().getDrawable(getTodayWeaIcon(todayWeaData.getWeather(), isNight())));
    }

    private boolean isNight() {
        int hour = 10;
        hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return hour >= 18 && hour <= 6;
    }

    private int getTodayWeaIcon(String weaData, boolean isNight) {
        if (weaData.contains("雨")) {
            if (weaData.contains("晴"))
                return R.mipmap.today_wea_sunny_to_rain;
            else if (weaData.contains("暴雨") || weaData.contains("雷阵雨")) {
                if (weaData.contains("大")) return R.mipmap.today_wea_w_thunder_storms;
                return R.mipmap.today_wea_thunder_storms;
            } else if (weaData.contains("小雨") || weaData.contains("阵雨"))
                return R.mipmap.today_wea_small_rain;
            else if (weaData.contains("大雨") || weaData.contains("中雨"))
                return R.mipmap.today_wea_big_rain;
            return R.mipmap.today_wea_small_rain;
        }
        if (weaData.contains("雪"))

            return R.mipmap.today_wea_big_snow;
        if (weaData.contains("冰雹"))
            return R.mipmap.today_wea_thunder_storms;
        if (weaData.contains("沙尘暴"))
            return R.mipmap.today_wea_sand_storm;
        if (weaData.contains("雾")) return R.mipmap.today_wea_fog;
        if (weaData.contains("多云")) {
            if (isNight) {
                return R.mipmap.today_night_cloud;
            }
            if (weaData.contains("晴") && weaData.contains("转"))
                return R.mipmap.today_wea_sunny_cloud;
            else return R.mipmap.today_wea_cloud;
        }
        if (weaData.contains("阴")) return R.mipmap.today_wea_cloud;
        if (weaData.contains("晴"))
            if (isNight) return R.mipmap.today_night_sunny;
        return R.mipmap.today_wea_sunny;
    }

    private String formatCurrentTem(String tem) {
        for (int i = 0; i < tem.length(); i++) {
            if (tem.charAt(i) == '：') {
                return tem.substring(i + 1, tem.length() - 2);
            }
        }
        return "";
    }

    private String[] formatTem(String tem) {
        String highTem = "";
        String lowTem = "";
        for (int i = 0; i < tem.length(); i++) {
            if (tem.charAt(i) == '~') {
                highTem = tem.substring(0, i - 1);
                lowTem = tem.substring(i + 2, tem.length() - 1);
            }
        }
        String[] data = {highTem, lowTem};
        return data;
    }

    private void setDayOfWeek() {
        int d = 1;
        Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        String[] dayArray = {"/周日", "/周一", "/周二", "/周三", "/周四", "/周五", "/周六"};
        todayWeekDay.setText(dayArray[d - 1]);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
