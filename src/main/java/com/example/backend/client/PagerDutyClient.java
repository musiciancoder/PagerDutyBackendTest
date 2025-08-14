package com.example.backend.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PagerDutyClient {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private final Logger logger = LoggerFactory.getLogger(PagerDutyClient.class);

    public PagerDutyClient(@Value("${pagerduty.api.token}") String apiToken) {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.set("Authorization", "Token token=" + apiToken);
        headers.set("Accept", "application/vnd.pagerduty+json;version=2");
        logger.info("PagerDutyClient initialized with provided API token.");
        this.fetchServices();
    }

/*    public static void prueba() {
        System.out.println("Prueba de conexión a PagerDuty API");
    }*/

    public String fetchServices() {
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.pagerduty.com/services",
                HttpMethod.GET,
                entity,
                String.class
        );
        if (response.getStatusCode() != HttpStatus.OK) {
            logger.error("Failed to fetch services: {}", response.getStatusCode());
            throw new RuntimeException("Failed to fetch services from PagerDuty API");
        }else {
            logger.info("Successfully fetched services from PagerDuty API");
            logger.info("Response: {}", response.getBody());
        }
        return response.getBody(); // Replace with DTO later
    }
}
