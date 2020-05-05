package com.osavaryn.domain.countries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private String description;
    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;
}
