package com.spring.empDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.empDemo.model.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer>{
}