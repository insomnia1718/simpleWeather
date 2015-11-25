package com.example.insomnia.weather.source;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by insomnia on 2015/11/6.
 */
public class JsonParse {
    public static Weather parse(String json) throws JSONException {
        JSONObject object = new JSONObject(json);
        int error = object.getInt("error");
        if (error != 0){
            return null;
        }
        Weather weather = new Weather();
        weather.setError(0);
        weather.setDate(object.getString("date"));
        JSONArray results = object.getJSONArray("results");
        JSONObject result = results.getJSONObject(0);
        List<Weather.ResultsEntity> resultsEntities = new ArrayList<>();
        Weather.ResultsEntity resultsEntity = new Weather.ResultsEntity();
        resultsEntity.setCurrentCity(result.getString("currentCity"));
        resultsEntity.setPm25(result.getString("pm25"));

        JSONArray index = result.getJSONArray("index");
        List<Weather.ResultsEntity.IndexEntity> indexEntities = new ArrayList<>();
        for (int i = 0;i< index.length();i++){
            Weather.ResultsEntity.IndexEntity indexEntity = new Weather.ResultsEntity.IndexEntity();
            JSONObject index_spe = index.getJSONObject(i);
            indexEntity.setTitle(index_spe.getString("title"));
            indexEntity.setDes(index_spe.getString("des"));
            indexEntity.setTipt(index_spe.getString("tipt"));
            indexEntity.setZs(index_spe.getString("zs"));
            indexEntities.add(indexEntity);
        }
        resultsEntity.setIndex(indexEntities);

        JSONArray weatherData = result.getJSONArray("weather_data");
        List<Weather.ResultsEntity.WeatherDataEntity> weatherDataEntities = new ArrayList<>();
        for (int i = 0;i<weatherData.length();i++){
            JSONObject weatherData_spe = weatherData.getJSONObject(i);
            Weather.ResultsEntity.WeatherDataEntity weatherDataEntity = new Weather.ResultsEntity.WeatherDataEntity();
            weatherDataEntity.setDate(weatherData_spe.getString("date"));
            weatherDataEntity.setTemperature(weatherData_spe.getString("temperature"));
            weatherDataEntity.setWeather(weatherData_spe.getString("weather"));
            weatherDataEntity.setWind(weatherData_spe.getString("wind"));
            weatherDataEntities.add(weatherDataEntity);
        }
        resultsEntity.setWeather_data(weatherDataEntities);

        resultsEntities.add(resultsEntity);
        weather.setResults(resultsEntities);
        return weather;
    }
}
