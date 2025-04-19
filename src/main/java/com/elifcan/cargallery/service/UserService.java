package com.elifcan.cargallery.service;

import com.elifcan.cargallery.dto.request.DoLoginRequestDto;
import com.elifcan.cargallery.dto.request.DoRegisterRequestDto;
import com.elifcan.cargallery.entity.User;
import com.elifcan.cargallery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    public void doRegister(DoRegisterRequestDto dto){
        userRepository.save(User.builder()
                        .name(dto.name())
                        .email(dto.email())
                        .password(dto.password())

                .build());
    }

    public Optional<User> findByEmailPassword(DoLoginRequestDto dto){
        return userRepository.findOptionalByEmailAndPassword(dto.email(),dto.password());
    }

    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }
}
