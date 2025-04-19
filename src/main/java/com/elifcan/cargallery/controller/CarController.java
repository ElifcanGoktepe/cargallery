package com.elifcan.cargallery.controller;

import com.elifcan.cargallery.config.JwtManager;
import com.elifcan.cargallery.dto.request.AddCarRequestDto;
import com.elifcan.cargallery.dto.response.BaseResponse;
import com.elifcan.cargallery.entity.Car;
import com.elifcan.cargallery.exception.CarGalleryException;
import com.elifcan.cargallery.exception.ErrorType;
import com.elifcan.cargallery.service.CarService;
import com.elifcan.cargallery.config.RestApi*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.elifcan.cargallery.config.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CAR)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class CarController {

    private final CarService carService;
    private final JwtManager jwtManager;

    @PostMapping(ADD_CAR)
    private ResponseEntity<BaseResponse<Boolean>> addCar(@RequestBody AddCarRequestDto dto){
        carService.addCar(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("User registered successfully")
                .data(true)
                .build());
    }

    @PutMapping(UPDATE_CAR + "/{carId}")
    private ResponseEntity<BaseResponse<Boolean>> updateCar(@RequestBody AddCarRequestDto dto, Long carId){
        Optional<Car> optionalCar = carService.findAllById(carId);
        if(optionalCar.isEmpty()) throw new CarGalleryException(ErrorType.CAR_NOT_FOUN);
        carService.setCar(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Car updated successfully.")
                .data(true)
                .build());

    }


    @GetMapping(LIST_CAR)
    private ResponseEntity<BaseResponse<List<Car>>> getAllProduct(){
        return ResponseEntity.ok(BaseResponse.<List<Car>>builder()
                .code(200)
                .message("Cars listed below.")
                .data(carService.getAllCars())
                .build());

    }

    @DeleteMapping(DELETE_PRODUCT + "/{productId}")
    public ResponseEntity<BaseResponse<Boolean>> deleteCarById(@PathVariable Long carId){
        carService.deleteCar(carId);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Product deleted successfully.")
                .data(true)
                .build());
    }

    @GetMapping("/{carBrand}")
    public ResponseEntity<BaseResponse<List<Car>>> findCarByBrand(@PathVariable String carBrand) {
        List<Car> cars = carService.findAllByBrand(carBrand);

        if (cars.isEmpty()) {
            return ResponseEntity.ok(BaseResponse.<List<Car>>builder()
                    .code(204)
                    .message("No cars found for the specified brand.")
                    .data(cars)
                    .build());
        } else {
            return ResponseEntity.ok(BaseResponse.<List<Car>>builder()
                    .code(200)
                    .message("Cars are listed successfully.")
                    .data(cars)
                    .build());
        }
    }
    @GetMapping("/{carModel}")
    public ResponseEntity<BaseResponse<List<Car>>> findCarByModel(@PathVariable String carModel) {
        List<Car> cars = carService.findAllByModel(carModel);

        if (cars.isEmpty()) {
            return ResponseEntity.ok(BaseResponse.<List<Car>>builder()
                    .code(204)
                    .message("No cars found for the specified brand.")
                    .data(cars)
                    .build());
        } else {
            return ResponseEntity.ok(BaseResponse.<List<Car>>builder()
                    .code(200)
                    .message("Cars are listed successfully.")
                    .data(cars)
                    .build());
        }
    }


}
