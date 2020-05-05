package com.osavaryn.service;

import com.osavaryn.domain.backendDto.WeatherDetails;

public interface OpenWeatherService {
    WeatherDetails getWeatherByCity(String city, String countryCode);
}
