package com.spring.empDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.empDemo.model.entity.RolesEntity;

public interface RolesRepository extends JpaRepository<RolesEntity, Long>{
}