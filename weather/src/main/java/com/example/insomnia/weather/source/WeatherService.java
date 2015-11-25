package com.example.insomnia.weather.source;

import com.example.insomnia.weather.source.JsonParse;
import com.example.insomnia.weather.source.Weather;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by insomnia on 2015/11/6.
 */
public class WeatherService {
    private String cityName;
    private static final String KEY = "FeyhMDkbvEvUCIctW3aLYX83";
    private static final String MCODE = "A7:92:19:6B:35:1B:47:B4:B0:4E:BA:89:0B:5C:DF:1F:24:37:A8:7B;com.example.bmapdemo";
    private String output = "json";

    public WeatherService(String cityName) {
        this.cityName = cityName;
    }

    public Weather getWeather() throws JSONException {
        String response = getResponse();
        if (response != null) {
            return JsonParse.parse(response);
        }
        return null;
    }

    public String getResponse() {
        String requestUrl = buildURL();
        StringBuilder responBuilder = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
            conn.setDoInput(true);
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String data;
            while ((data = reader.readLine()) != null) {
                responBuilder.append(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return responBuilder.toString();
    }


    private String buildURL() {
        StringBuilder builder = new StringBuilder();
        String cityNameofUtf8 = null;
        try {
            cityNameofUtf8 = URLEncoder.encode(cityName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        builder.append("http://api.map.baidu.com/telematics/v3/weather?location=").append(cityNameofUtf8)
                .append("&output=")
                .append(output)
                .append("&ak=")
                .append(KEY)
                .append("&mcode=")
                .append(MCODE);
        return builder.toString();
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
