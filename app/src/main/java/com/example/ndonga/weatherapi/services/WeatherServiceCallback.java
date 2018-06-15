package com.example.ndonga.weatherapi.services;

import com.example.ndonga.weatherapi.models.Channel;

public interface WeatherServiceCallback {
    void serviceSuccess (Channel channel);
    void serviceFailure (Exception exception);
}
