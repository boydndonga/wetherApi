package com.example.ndonga.weatherapi.services;

import android.os.AsyncTask;

import com.example.ndonga.weatherapi.Constants;
import com.example.ndonga.weatherapi.models.Weather;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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

    
}
