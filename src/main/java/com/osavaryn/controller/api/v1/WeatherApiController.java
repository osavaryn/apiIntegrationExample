package com.osavaryn.controller.api.v1;

import com.osavaryn.domain.backendDto.WeatherDetails;
import com.osavaryn.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping(value = "/v1/weather")
public class WeatherApiController {
    @Autowired
    OpenWeatherService openWeatherService;


    @RequestMapping(value = "/{city}/{country}", method = RequestMethod.GET)
    public WeatherDetails getWeatherDetails(@PathVariable @NotNull String city, @PathVariable @NotNull String country) {
        return openWeatherService.getWeatherByCity(city, country);
    }



}
