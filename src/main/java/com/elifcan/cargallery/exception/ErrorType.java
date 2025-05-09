package com.elifcan.cargallery.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    CAR_NOT_FOUN(4001,"Entered car is not found", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(4008, "Entered password is incorrect.", HttpStatus.BAD_REQUEST),
    USER_NOT_EXIST(4006,"User not exist.", HttpStatus.BAD_REQUEST),
    EMAIL_PASSWORD_ERROR(4004, "Username or password is incorrect.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST(4002, "Entered parameter is invalid.", HttpStatus.BAD_REQUEST),
    ALREADY_EXISTS(4005, "Category already exist.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER(5000,"Unexpected error occurs.",HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(5001,"Invalid Token",HttpStatus.INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus httpStatus; // type of request
}
