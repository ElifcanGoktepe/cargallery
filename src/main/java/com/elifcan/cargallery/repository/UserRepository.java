package com.elifcan.cargallery.repository;

import com.elifcan.cargallery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
