package com.spring.empDemo.service;

import java.util.List;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.EmployeeEntity;


public interface EmployeeService {


	public List<EmployeeEntity> getAllEmployees();

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException ;

	public EmployeeEntity addEmployee(EmployeeEntity entity) ;

	public List<EmployeeEntity> addEmployeeList(List<EmployeeEntity> newempList) ;

	public void deleteEmployeeById(Long id) throws RecordNotFoundException ;

	public void deleteAllEmployees() ;

	public EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, long id) throws Exception ;

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity employee);

}