package com.spring.empDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.empDemo.model.entity.CountryEntity;
import com.spring.empDemo.model.entity.StateEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long>{


}
