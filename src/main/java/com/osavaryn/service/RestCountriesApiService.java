package com.osavaryn.service;

import com.osavaryn.domain.countries.CountryDetailsResponse;

public interface RestCountriesApiService {
    CountryDetailsResponse getCountryDetailsByCode(String code);
}
