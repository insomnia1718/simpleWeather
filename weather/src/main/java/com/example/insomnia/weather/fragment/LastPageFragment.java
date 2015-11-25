package com.example.insomnia.weather.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.insomnia.weather.R;
import com.example.insomnia.weather.source.Weather;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LastPageFragment extends Fragment {
    @Bind(R.id.fever_level_tip)
    TextView feverLevelTip;
    @Bind(R.id.fever_level_content)
    TextView feverLevelContent;
    @Bind(R.id.sport_level_tip)
    TextView sportLevelTip;
    @Bind(R.id.sport_level_content)
    TextView sportLevelContent;
    @Bind(R.id.ray_level_tip)
    TextView rayLevelTip;
    @Bind(R.id.ray_level_content)
    TextView rayLevelContent;
    private Weather mWeather;
    private static LastPageFragment fragment;

    public static LastPageFragment getInstance() {
        if (fragment == null) fragment = new LastPageFragment();
        return fragment;
    }

    public LastPageFragment() {
    }

    public static LastPageFragment getInstance(Weather weather){
        fragment = getInstance();
        fragment.mWeather = weather;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.weather.LOAD.COMPLETE"))
                    Log.i("LoadBroadcastReceiver", "noticeLastPage");
                if (mWeather!=null)
                    loadDatas();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.weather.LOAD.COMPLETE");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, filter);
    }

    private void loadDatas() {
        loadDatas(3, feverLevelTip, feverLevelContent);
        loadDatas(4, sportLevelTip, sportLevelContent);
        loadDatas(5, rayLevelTip, rayLevelContent);
    }

    private void loadDatas(int postion, TextView tip, TextView content) {
        Weather.ResultsEntity.IndexEntity levelEntity = mWeather.getResults().get(0).getIndex().get(postion);
        String tipData = levelEntity.getZs();
        String contentData = levelEntity.getDes();
        tip.setText(TextUtils.isEmpty(tipData)?"...":tipData);
        content.setText(TextUtils.isEmpty(contentData)?"...":contentData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_last_page, container, false);
        ButterKnife.bind(this, view);
        if (mWeather != null) loadDatas();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
