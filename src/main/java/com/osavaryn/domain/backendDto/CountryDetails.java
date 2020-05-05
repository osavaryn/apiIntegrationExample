package com.osavaryn.domain.backendDto;

import lombok.Data;

import java.util.List;

@Data
public class CountryDetails {
    private String name;
    private String capital;
    private List<String> borders;
}
