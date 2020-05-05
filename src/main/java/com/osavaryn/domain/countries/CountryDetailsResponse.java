package com.osavaryn.domain.countries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetailsResponse {
    private String name;
    private CapitalData capital;
    private List<String> borders;
}
