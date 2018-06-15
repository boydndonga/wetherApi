package com.example.ndonga.weatherapi.services;

import android.os.AsyncTask;

public class WeatherService {
    private WeatherServiceCallback callback;
    private String location;

    public class YahooWeatherService (WeatherServiceCallback callback){
        this.callback = callback;
    }

    public void refrehService (String location){
        new AsyncTask<>()
    }
}
