package com.example.ndonga.weatherapi.services;

import android.os.AsyncTask;

import com.example.ndonga.weatherapi.Constants;
import com.example.ndonga.weatherapi.models.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {
    private static OkHttpClient client = new OkHttpClient();

    public static void findWeather(String location, Callback callback) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.WEATHER_LOCATION_QUERY_PARAMETER, location)
        .addQueryParameter(Constants.WEATHER_APP_ID_QEURY, Constants.WEATHER_APP_ID);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
//                .header("Authorization", "Bearer " + Constants.YELP_ACCESS_TOKEN)
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public List<Weather> processResults(Response response) {
        List<Weather> locationWeather = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                // The response JSON is an array of business objects within an object so we need to get that array
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray locationJSON = weatherJSON.getJSONArray("weather");

                Type collectionType = new TypeToken<List<Weather>>() {}.getType();
                Gson gson = new GsonBuilder().create();
                locationWeather = gson.fromJson(locationJSON.toString(), collectionType);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return locationWeather;
    }
}
