package com.osavaryn.domain.backendDto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherDetails {
    private Coords coord;
    private List<Weather> weather;
    private MainData main;
    private WindData wind;
}
