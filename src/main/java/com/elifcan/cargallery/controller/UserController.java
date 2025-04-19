package com.elifcan.cargallery.controller;

import com.elifcan.cargallery.dto.request.DoLoginRequestDto;
import com.elifcan.cargallery.dto.request.DoRegisterRequestDto;
import com.elifcan.cargallery.dto.response.BaseResponse;
import com.elifcan.cargallery.entity.User;
import com.elifcan.cargallery.exception.CarGalleryException;
import com.elifcan.cargallery.exception.ErrorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;


    @PostMapping(DOREGISTER)
    public ResponseEntity<BaseResponse<Boolean>> doRegister(@RequestBody DoRegisterRequestDto dto){
        if(!dto.password().equals(dto.rePassword()));
            throw new CarGalleryException(ErrorType.PASSWORD_ERROR);
        userService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .message("Basariyla kaydedildi")
                .code(200)
                .data(true)
                .build());

    }
    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody DoLoginRequestDto dto){
        Optional<User> optionalUser = userService.findByEmailPassword(dto);
        if(optionalUser.isEmpty())
            throw new CarGalleryException(ErrorType.SIFREHATASI);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .message("Basariyla giris yapildi")
                .code(200)
                .data(jwtManager.createToken(optionalKullanici.get().getId()))
                .build());
    }

    @PostMapping(ADD_ROLE)
    public ResponseEntity<BaseResponse<Boolean>> addRole(@RequestBody AddRoleRequestDto dto){
        userRoleService.addRole(dto.roleName(), dto.userId());
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Ok")
                .data(true)
                .build());
    }

}
