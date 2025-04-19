package com.elifcan.cargallery.dto.request;

public record DoRegisterRequestDto(
        String name,
        String address,
        String email,
        String phone,
        String password,
        String rePassword,
        String avatar
) {
}
