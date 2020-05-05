package com.osavaryn.service;

import com.osavaryn.domain.backendDto.CountryDetails;
import com.osavaryn.domain.backendDto.WeatherDetails;
import com.osavaryn.domain.countries.CapitalData;
import com.osavaryn.domain.countries.Coordinates;
import com.osavaryn.domain.countries.CountryDetailsResponse;
import com.osavaryn.domain.countries.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestCountriesApiServiceImpl implements RestCountriesApiService {
    @Value("${restcountries.api.url:#{null}}")
    private String restCountriesApiUrl;
    @Autowired
    RestTemplate externalRestApi;
    @Autowired
    OpenWeatherService openWeatherService;

    @Override
    public CountryDetailsResponse getCountryDetailsByCode(String code) {
        ResponseEntity<CountryDetails> counryResponse = externalRestApi.exchange(
                restCountriesApiUrl + "/v2/alpha/" + code,
                HttpMethod.GET,
                null,
                CountryDetails.class);

        WeatherDetails weatherDetails = openWeatherService.getWeatherByCity(counryResponse.getBody().getCapital(), code);
        return mapToCountryDetailsResponse(counryResponse.getBody(), weatherDetails);
    }

    private CountryDetailsResponse mapToCountryDetailsResponse(CountryDetails countryDetails, WeatherDetails weatherDetails) {
        return CountryDetailsResponse.builder()
                .name(countryDetails.getName())
                .borders(countryDetails.getBorders())
                .capital(CapitalData.builder()
                        .name(countryDetails.getCapital())
                        .coordinates(Coordinates.builder()
                                .latitude(weatherDetails.getCoord().getLat())
                                .longitude(weatherDetails.getCoord().getLon())
                                .build())
                        .weatherInCapital(WeatherData.builder()
                                .description(weatherDetails.getWeather().get(0).getDescription())
                                .humidity(weatherDetails.getMain().getHumidity())
                                .pressure(weatherDetails.getMain().getPressure())
                                .temperature(weatherDetails.getMain().getTemp())
                                .windSpeed(weatherDetails.getWind().getSpeed())
                                .build())
                        .build()
                )
                .build();
    }
}
