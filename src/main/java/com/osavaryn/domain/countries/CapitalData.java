package com.osavaryn.domain.countries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CapitalData {
    private String name;
    private Coordinates coordinates;
    private WeatherData weatherInCapital;
}
