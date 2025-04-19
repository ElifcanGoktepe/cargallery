package com.elifcan.cargallery.repository;

import com.elifcan.cargallery.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
