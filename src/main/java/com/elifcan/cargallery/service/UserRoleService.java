package com.elifcan.cargallery.service;

import com.elifcan.cargallery.dto.request.AddRoleRequestDto;
import com.elifcan.cargallery.entity.UserRole;
import com.elifcan.cargallery.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    public final UserRoleRepository userRoleRepository;

    public List<UserRole> findAllRole(Long userId){
        return userRoleRepository.findByUserId(userId);
    }


    public void addRole(AddRoleRequestDto dto) {
        userRoleRepository.save(UserRole.builder()
                .roleName(dto.roleName())
                .userId(dto.userId())
                .build());
    }
}
