package com.elifcan.cargallery.repository;

import com.elifcan.cargallery.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    

    List<Car> findAllByModelContaining(String model);

    List<Car> findAllByBrandContaining(String brand);

}
