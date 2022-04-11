package com.azold.bhut_app.controllers;

import com.azold.bhut_app.domain.Car;
import com.azold.bhut_app.dto.CarRequestDto;
import com.azold.bhut_app.dto.CarResponseDto;
import com.azold.bhut_app.services.CarService;
import com.azold.bhut_app.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Value("${baseUrl}")
    private String baseUrl;

    private LogService logService;
    private RestTemplate restTemplate;

    @Autowired
    public CarController(RestTemplate restTemplate, LogService logService){
        this.logService = logService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/listCars")
    public ResponseEntity<List<CarResponseDto>> listCars(){
            return restTemplate.exchange(
                    baseUrl + "/cars",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>(){});
        }

    @PostMapping("/createCar")
    private ResponseEntity<CarResponseDto> createCar(@Valid @RequestBody CarRequestDto carRequestDto){
        Car carEntity = CarService.toEntity(carRequestDto);

        CarResponseDto response = restTemplate.postForObject(
                baseUrl + "/cars",
                carEntity,
                CarResponseDto.class);

        logService.insertNewLogByCar(carEntity);

        return ResponseEntity.ok(response);
    }
}
