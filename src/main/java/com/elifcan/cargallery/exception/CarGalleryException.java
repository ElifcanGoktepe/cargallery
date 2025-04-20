package com.elifcan.cargallery.exception;

import lombok.Getter;

@Getter
public class CarGalleryException extends RuntimeException {

    private ErrorType errorType;
    public CarGalleryException (ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
