package com.spring.empDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.empDemo.model.entity.UsersEntity;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    Optional<UsersEntity> findByName(String username);
    
}
