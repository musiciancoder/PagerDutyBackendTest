package com.example.backend.servicexx;

import com.example.backend.client.PagerDutyClient;
import com.example.backend.dto.ServiceDto;
import com.example.backend.repository.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.utility.ServiceMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagerDutyService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PagerDutyClient pagerDutyClient;

    @Autowired
    private ServiceRepository serviceRepository;

    public void fetchThenPersistServices() {
        //fetch from PagerDuty
        List<ServiceDto> services = pagerDutyClient.fetchServices();
        logger.info("OK SO FAR!!!!!!!!!!");
        //save services to H2 database
        serviceRepository.saveAll(services.stream()
                .map(s-> new ServiceMapper().mapToEntity(s))
                        .peek(service -> System.out.println("Saving service: " + service.getName()))
                .collect(Collectors.toList()));
    }

    public List<ServiceDto> getOrFetchServices() {
     // Check if services are cached in H2
        List<com.example.backend.entity.Service> cached = serviceRepository.findAll();
        if (cached.isEmpty()) {
            logger.info("No cached services found. Fetching from PagerDuty...");
            // If cache is empty, fetch from PagerDuty and persist
            fetchThenPersistServices(); // fetches and persists
            cached = serviceRepository.findAll();
        } else {
            logger.info("Returning cached services from H2");
        }
        return cached.stream()
                .map(s-> new ServiceMapper().mapToDto(s))
                .collect(Collectors.toList());
    }



}
