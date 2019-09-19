package com.spring.empDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.empDemo.model.entity.CityEntity;
import com.spring.empDemo.model.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{




}