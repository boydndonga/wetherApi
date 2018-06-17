package com.example.ndonga.weatherapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.ndonga.weatherapi.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> mLocationWeather = new ArrayList<>();
    private Context mContext;

    public RestaurantListAdapter(Context context, List<Weather> locationWeather) {
        mContext = context;
        mLocationWeather = locationWeather;
    }
