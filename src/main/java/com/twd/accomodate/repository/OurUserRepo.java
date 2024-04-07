package com.twd.accomodate.repository;

import com.twd.accomodate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OurUserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Users> findById(Integer id);
}
