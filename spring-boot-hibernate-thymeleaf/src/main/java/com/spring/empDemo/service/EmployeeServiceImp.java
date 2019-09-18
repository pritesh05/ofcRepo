package com.spring.empDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.EmployeeEntity;
import com.spring.empDemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository eRepository;

	@Override
	public List<EmployeeEntity> getAllEmployees() throws ParseException {
		List<EmployeeEntity> list=eRepository.findAll();
		
		HashMap<String, Object> hmap=new HashMap<String, Object>();
		String sUId;
		for (EmployeeEntity employeeEntity : list) {
			sUId="e";
			sUId = sUId + UUID.randomUUID().toString()+employeeEntity.getId();
			employeeEntity.setId(sUId);
			System.err.println(sUId+"\n");
			sUId=null;
			hmap.put("id", employeeEntity.getDepartmentEntity().getId());
			hmap.put("name", employeeEntity.getDepartmentEntity().getDepartment());
			employeeEntity.setDepart(hmap);
			employeeEntity.getId();
			employeeEntity.getAddressEntity().setCityId(employeeEntity.getAddressEntity().getCityEntity().getCityId());
			employeeEntity.getAddressEntity().setStateId(employeeEntity.getAddressEntity().getStateEntity().getStateId());
			employeeEntity.getAddressEntity().setCountryId(employeeEntity.getAddressEntity().getCountryEntity().getCountryId());
			System.err.println(employeeEntity.getAddressEntity().getCountryEntity().getCountryId());
			
		}
		System.err.println(list);
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called !!!" + "\n");
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
//		List<EmployeeEntity> l1 = new ArrayList<EmployeeEntity>();
//		System.err.println(newemp.getDob());
		newemp = eRepository.save(newemp);
		return newemp;
	}

	public List<EmployeeEntity> addEmployeeList(List<EmployeeEntity> newempList) {
		for (EmployeeEntity employeeEntity : newempList) {
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

/*	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
		if (entity.getId() == null) {
			entity = eRepository.save(entity);

			return entity;
		} else {
			Optional<EmployeeEntity> employee = eRepository.findById(entity.getId());

			if (employee.isPresent()) {
				EmployeeEntity newEntity = employee.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());

				newEntity = eRepository.save(newEntity);
				return newEntity;
			} else {
				entity = eRepository.save(entity);

				return entity;
			}
		}
	}*/
}
