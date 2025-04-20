package com.elifcan.cargallery.service;


import com.elifcan.cargallery.dto.request.AddCarRequestDto;
import com.elifcan.cargallery.dto.request.AddRoleRequestDto;
import com.elifcan.cargallery.entity.Car;
import com.elifcan.cargallery.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;


    public void addCar(AddCarRequestDto dto){
        Car car= Car.builder()
                .name(dto.name())
                .brand(dto.brand())
                .model(dto.model())
                .color(dto.color())
                .description(dto.description())
                .image(dto.image())
                .build();
        repository.save(car);
    }

    public List<Car> getAll(){
        return repository.findAll();
    }

    public List<Car> findAllByModel(String model){
        return repository.findAllByModelContaining(model);
    }

    public List<Car> findAllByBrand(String brand){
        return repository.findAllByBrandContaining(brand);
    }

    public void deleteCar(Long id){
        repository.deleteById(id);
    }

    public void setCar(AddCarRequestDto dto, Long id){
        Car car = repository.findById(id).get();
        car.setName(dto.name());
        car.setModel(dto.model());
        car.setBrand(dto.brand());
        car.setImage(dto.image());
        car.setColor(dto.color());
        car.setDescription(dto.description());
        repository.save(car);


    }








}
