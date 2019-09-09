package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.entity.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called !!!" + "\n");
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " getEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public EmployeeEntity addEmployee(EmployeeEntity entity) {
		System.out.println("\n" + this.getClass().getSimpleName() + " createOrUpdateEmployee method called !!!" + "\n");
		entity = repository.save(entity);
		return entity;

	}

	public List<EmployeeEntity> addEmployeeList(List<EmployeeEntity> newempList) {
		for (EmployeeEntity employeeEntity : newempList) {
			employeeEntity = repository.save(employeeEntity);
		}
		return newempList;
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " deleteEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public void deleteAllEmployees() {
		repository.deleteAll();
	}

	public EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, long id) throws Exception {
		System.out.println("\n" + this.getClass().getSimpleName() + "  UpdateEmployeeById method called !!!" + "\n");
		EmployeeEntity emp = getEmployeeById(id);

		if (updemp.getFirstName() == null || updemp.getFirstName().isEmpty())
			updemp.setFirstName(emp.getFirstName());
		if (updemp.getLastName() == null || updemp.getLastName().isEmpty())
			updemp.setLastName(emp.getLastName());
		if (updemp.getEmail() == null)
			updemp.setEmail(emp.getEmail());

		updemp.setId(id);
		System.err.println(updemp);
		return repository.save(updemp);

	}

}