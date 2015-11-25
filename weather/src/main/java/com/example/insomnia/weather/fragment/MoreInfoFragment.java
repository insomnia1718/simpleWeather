package com.example.insomnia.weather.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.insomnia.weather.R;
import com.example.insomnia.weather.source.Weather;
import com.example.insomnia.weather.source.Weather.ResultsEntity.*;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MoreInfoFragment extends Fragment {
    private static MoreInfoFragment fragment;
    @Bind(R.id.cloth_level_tip)
    TextView clothLevelTip;
    @Bind(R.id.cloth_level_content)
    TextView clothLevelContent;
    @Bind(R.id.washCar_level_tip)
    TextView washCarLevelTip;
    @Bind(R.id.washCar_level_content)
    TextView washCarLevelContent;
    @Bind(R.id.travel_level_tip)
    TextView travelLevelTip;
    @Bind(R.id.travel_level_content)
    TextView travelLevelContent;
    private Weather mWeather;

    public static MoreInfoFragment getInstance() {
        if (fragment == null) fragment = new MoreInfoFragment();
        return fragment;
    }

    public static MoreInfoFragment getInstance(Weather weather){
       fragment = getInstance();
        fragment.mWeather = weather;
        return fragment;
    }

    public MoreInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.weather.LOAD.COMPLETE"))
                    Log.i("LoadBroadcastReceiver", "noticeMoreInfo");
                if (mWeather!=null)
                    loadDatas();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.weather.LOAD.COMPLETE");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, filter);
    }

    private void loadDatas() {
        loadDatas(0,clothLevelTip,clothLevelContent);
        loadDatas(1,washCarLevelTip,washCarLevelContent);
        loadDatas(2,travelLevelTip,travelLevelContent);
    }

    private void loadDatas(int postion,TextView tip,TextView content){
        IndexEntity levelEntity = mWeather.getResults().get(0).getIndex().get(postion);
        String tipData = levelEntity.getZs();
        String contentData = levelEntity.getDes();
        tip.setText(TextUtils.isEmpty(tipData)?"...":tipData);
        content.setText(TextUtils.isEmpty(contentData)?"...":contentData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_info, container, false);
        ButterKnife.bind(this, view);
        if (mWeather != null){
            loadDatas();
        }
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
