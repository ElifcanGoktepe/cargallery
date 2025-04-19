package com.elifcan.cargallery.dto.request;

public record AddCarRequestDto(
        String name,
        String brand,
        String model,
        String color,
        String image,
        String description
) {
}
