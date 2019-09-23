package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.EmployeeEntity;


public interface EmployeeService {



	public EmployeeEntity getEmployeeById(String id) throws RecordNotFoundException ;

	public EmployeeEntity addEmployee(EmployeeEntity entity) ;

	public List<EmployeeEntity> addEmployeeList(List<EmployeeEntity> newempList) ;

	public void deleteEmployeeById(String id) throws RecordNotFoundException ;

	public void deleteAllEmployees() ;

	EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, String id) throws RecordNotFoundException;

	public EmployeeEntity getEmployeeByName(String firstName) throws RecordNotFoundException;

	List<EmployeeEntity> getAllEmployees();



}