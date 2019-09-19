package com.spring.empDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.AddressEntity;
import com.spring.empDemo.model.entity.DepartmentEntity;
import com.spring.empDemo.model.entity.EmployeeEntity;
import com.spring.empDemo.repository.AddressRepository;
import com.spring.empDemo.repository.DepartmentRepository;
import com.spring.empDemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository eRepository;
	@Autowired
	DepartmentRepository dRepository;
	@Autowired
	AddressRepository aRepository;

	@Override
	public List<EmployeeEntity> getAllEmployees()  {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called !!!" + "\n");
		List<EmployeeEntity> listEmp=eRepository.findAll();
		String sUId;
		for (EmployeeEntity employeeEntity : listEmp) {
			sUId="e";
			sUId = sUId + UUID.randomUUID().toString()+employeeEntity.getId();
			employeeEntity.setId(sUId);
			sUId=null;
			employeeEntity.getId();
			employeeEntity.getAddressEntity().setCityId(employeeEntity.getAddressEntity().getCityEntity().getCityId());
			employeeEntity.getAddressEntity().setStateId(employeeEntity.getAddressEntity().getStateEntity().getStateId());
			employeeEntity.getAddressEntity().setCountryId(employeeEntity.getAddressEntity().getCountryEntity().getCountryId());
		}
//		System.err.println(list);
		return eRepository.findAll();
	}


	@Override
	public EmployeeEntity getEmployeeById(String id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " getEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = eRepository.findById(id);

		if (employee.isPresent()) {
//			String deptName = employee.get().getDepartmentEntity().getShortName();
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity newemp) {
		Optional<DepartmentEntity> opDept = dRepository.findById(newemp.getDeptId());
		Optional<AddressEntity> opAddr = aRepository.findById(newemp.getAddId());
//		System.err.println(opDept.get().getId()+" ---- "+newemp.getDeptId());
		newemp.setDepartmentEntity(opDept.get());
		newemp.setAddressEntity(opAddr.get());
		newemp = eRepository.save(newemp);
		return newemp;
	}

	public List<EmployeeEntity> addEmployeeList(List<EmployeeEntity> newempList) {
		for (EmployeeEntity employeeEntity : newempList) {
			Optional<DepartmentEntity> opDept = dRepository.findById(employeeEntity.getDeptId());
			Optional<AddressEntity> opAddr = aRepository.findById(employeeEntity.getAddId());
			employeeEntity.setDepartmentEntity(opDept.get());
			employeeEntity.setAddressEntity(opAddr.get());
			employeeEntity = eRepository.save(employeeEntity);
		}
		return newempList;
	}

	@Override
	public void deleteEmployeeById(String id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " deleteEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = eRepository.findById(id);

		if (employee.isPresent()) {
			eRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public void deleteAllEmployees() {
		eRepository.deleteAll();
	}

	@Override
	public EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, String id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + "  UpdateEmployeeById method called !!!" + "\n");
		EmployeeEntity emp = getEmployeeById(id);

		if (emp.getFirstName() == null || emp.getFirstName().isEmpty())
			updemp.setFirstName(emp.getFirstName());
		if (emp.getLastName() == null || emp.getLastName().isEmpty())
			updemp.setLastName(emp.getLastName());
		if (emp.getEmail() == null)
			updemp.setEmail(emp.getEmail());
		updemp.setId(id);
//		System.err.println(updemp);
		return eRepository.save(updemp);
	}

 
}
