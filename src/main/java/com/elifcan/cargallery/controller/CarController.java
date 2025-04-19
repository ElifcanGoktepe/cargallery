package com.elifcan.cargallery.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.elifcan.cargallery.config.RestApi.CAR;

@RestController
@RequiredArgsConstructor
@RequestMapping(CAR)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class CarController {



}
