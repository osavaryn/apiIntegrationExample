package com.osavaryn;

import com.osavaryn.domain.countries.CountryDetailsResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountriesApiControllerTest {
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private static final String baseUrl = "http://localhost";
    @LocalServerPort
    private int port;


    @Test
    public void countryDetailsTest() {
        HttpEntity<String> entity = new HttpEntity<String>(null, new HttpHeaders());
        CountryDetailsResponse response = restTemplate.exchange(getBaseUrl("/v1/country/cz"), org.springframework.http.HttpMethod.GET, entity, CountryDetailsResponse.class).getBody();

        Assert.assertEquals("Czech Republic",  response.getName());
    }

    private String getBaseUrl(String uri) {
        return String.format("%s:%d%s", baseUrl, port, uri);
    }
}
