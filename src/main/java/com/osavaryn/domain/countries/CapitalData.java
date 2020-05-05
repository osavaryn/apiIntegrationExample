package com.osavaryn.domain.countries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CapitalData {
    private String name;
    private Coordinates coordinates;
    private WeatherData weatherInCapital;
}
