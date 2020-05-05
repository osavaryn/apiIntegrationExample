package com.osavaryn.controller.api.v1;

import com.osavaryn.domain.backendDto.CountryDetails;
import com.osavaryn.domain.countries.CountryDetailsResponse;
import com.osavaryn.service.RestCountriesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping(value = "/v1/country")
public class CountriesApiController {
    @Autowired
    RestCountriesApiService restCountriesApiService;

    @RequestMapping(value = "/{countryCode}", method = RequestMethod.GET)
    public CountryDetailsResponse getWeatherDetails(@PathVariable @NotNull String countryCode) {
        return restCountriesApiService.getCountryDetailsByCode(countryCode);
    }

}
