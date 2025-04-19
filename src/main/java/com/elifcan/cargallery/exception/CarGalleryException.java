package com.elifcan.cargallery.exception;

public class CarGalleryException extends RuntimeException {
    private ErrorType errorType;
    public CarGalleryException (ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
