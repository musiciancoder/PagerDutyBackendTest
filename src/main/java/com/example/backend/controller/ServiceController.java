package com.example.backend.controller;

import com.example.backend.dto.ServiceDto;
import com.example.backend.servicexx.PagerDutyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etl/services")
@Tag(name = "ETL - Services", description = "Fetch and list PagerDuty services")
public class ServiceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PagerDutyService pagerDutyService;

    public ServiceController(PagerDutyService pagerDutyService) {
        this.pagerDutyService = pagerDutyService;
    }



    @GetMapping("/etl/services")
    @Operation(summary = "List stored services", description = "Lists all services stored in H2 with name and description")
    public ResponseEntity<List<ServiceDto>> listStoredServices() {
        logger.info("CONTROLLER OKAY");
        List<ServiceDto> services = pagerDutyService.getOrFetchServices();
        logger.info("Returning {} services from H2 database", services.size());
        return ResponseEntity.ok(services);
    }

    @GetMapping("/ping")
    @Operation(summary = "Ping endpoint", description = "Used to verify backend connection")
    public ResponseEntity<String> ping() {
        logger.info("CONTROLLER OKAY");
        return ResponseEntity.ok("Backend is alive and reachable.");
    }
}
