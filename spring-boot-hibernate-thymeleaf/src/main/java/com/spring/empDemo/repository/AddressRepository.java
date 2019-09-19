package com.spring.empDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.empDemo.model.entity.AddressEntity;
import com.spring.empDemo.model.entity.UsersEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{


}
