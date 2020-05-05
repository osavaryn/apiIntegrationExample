package com.osavaryn.service;

import com.osavaryn.domain.backendDto.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

@Validated
@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {
    @Value("${openweather.api.url:#{null}}")
    private String openWeatherApiUrl;
    @Value("${rapidapi.key:#{null}}")
    private String rapidapiKey;
    @Autowired
    RestTemplate externalRestApi;
    private static String X_RAPID_API_HOST = "community-open-weather-map.p.rapidapi.com";

    @Override
    public WeatherDetails getWeatherByCity(String city, String countryCode) {
        ResponseEntity<WeatherDetails> responseEntity = externalRestApi.exchange(
                openWeatherApiUrl + "/weather?q=" + city + "," + "countryCode&units=metric",
                HttpMethod.GET, openWeatherRestRequest(null),
                WeatherDetails.class);
        return responseEntity.getBody();
    }

    private <T> HttpEntity<T> openWeatherRestRequest(T request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", X_RAPID_API_HOST);
        headers.add("x-rapidapi-key", rapidapiKey);

        return new HttpEntity<>(request, headers);

    }
}
