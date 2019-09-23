package com.spring.empDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.empDemo.model.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

//	Optional<EmployeeEntity> findByfirstName(String firstname);
	EmployeeEntity findByfirstName(String firstname);

	EmployeeEntity findByid(String id);

}
