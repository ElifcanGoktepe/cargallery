package com.elifcan.cargallery.controller;

import com.elifcan.cargallery.config.JwtManager;
import com.elifcan.cargallery.dto.request.AddRoleRequestDto;
import com.elifcan.cargallery.dto.request.DoLoginRequestDto;
import com.elifcan.cargallery.dto.request.DoRegisterRequestDto;
import com.elifcan.cargallery.dto.response.BaseResponse;
import com.elifcan.cargallery.entity.User;
import com.elifcan.cargallery.exception.CarGalleryException;
import com.elifcan.cargallery.exception.ErrorType;
import com.elifcan.cargallery.service.UserRoleService;
import com.elifcan.cargallery.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.elifcan.cargallery.config.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;
    private final JwtManager jwtManager;
    private final UserRoleService userRoleService;

    @PostMapping(REGISTER_USER)
    public ResponseEntity<BaseResponse<Boolean>> doRegister(@RequestBody DoRegisterRequestDto dto){
        if(!dto.password().equals(dto.rePassword())) throw new CarGalleryException(ErrorType.PASSWORD_ERROR);
        userService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .message("Basariyla kaydedildi")
                .code(200)
                .data(true)
                .build());

    }
    @PostMapping(LOGIN_USER)
    public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody DoLoginRequestDto dto){
        Optional<User> optionalUser = userService.findByEmailPassword(dto);
        if(optionalUser.isEmpty())
            throw new CarGalleryException(ErrorType.EMAIL_PASSWORD_ERROR);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .message("Basariyla giris yapildi")
                .code(200)
                .data(jwtManager.createToken(optionalUser.get().getId()))
                .build());
    }

    @PostMapping(ADD_ROLE)
    public ResponseEntity<BaseResponse<Boolean>> addRole(@RequestBody AddRoleRequestDto dto){
        userRoleService.addRole(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Ok")
                .data(true)
                .build());
    }

}
