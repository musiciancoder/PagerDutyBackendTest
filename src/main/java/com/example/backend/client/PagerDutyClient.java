package com.example.backend.client;

import com.example.backend.dto.ServiceDto;
import com.example.backend.utility.ServiceResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ServiceDto> fetchServices() {
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
        } else {
            logger.info("Successfully fetched services from PagerDuty API");
            String responseBody = response.getBody();
            logger.info("Response: {}", responseBody);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                ServiceResponseWrapper wrapper = objectMapper.readValue(responseBody, ServiceResponseWrapper.class);

                // Transform and return the list
                return wrapper.getServices().stream()
                        .map(service -> new ServiceDto(service.getId(), service.getName(), service.getDescription(), service.getCreatedAt()))
                        .peek(service -> logger.info("Service fetched: {}", service.getName()))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                logger.error("Error parsing response body: {}", e.getMessage());
                throw new RuntimeException("Failed to parse services from PagerDuty API response");
            }
        }
    }

/*    public static void prueba() {
        System.out.println("Prueba de conexión a PagerDuty API");
    }*/

    //public List<ServiceDto> fetchServices() {

    }



