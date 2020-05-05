package com.osavaryn.domain.countries;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherData {
    private String description;
    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;
}
