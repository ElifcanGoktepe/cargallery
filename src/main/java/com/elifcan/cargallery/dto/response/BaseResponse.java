package com.elifcan.cargallery.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BaseResponse<T> {
    String message;
    Integer code;
    T data;
}
