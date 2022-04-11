package com.azold.bhut_app.services;

import com.azold.bhut_app.domain.Car;
import com.azold.bhut_app.dto.CarRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    public static Car toEntity(CarRequestDto carRequestDto){
        return new Car(
                carRequestDto.getTitle(),
                carRequestDto.getBrand(),
                carRequestDto.getPrice(),
                carRequestDto.getAge()
        );
    }
}
