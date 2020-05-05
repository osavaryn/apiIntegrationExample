package com.osavaryn.domain.countries;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CountryDetailsResponse {
    private String name;
    private CapitalData capital;
    private List<String> borders;
}
