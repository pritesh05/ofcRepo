package com.spring.empDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		String dob,hireDate;
		for (EmployeeEntity employeeEntity : list) {
			dob=employeeEntity.getDob();
			hireDate=employeeEntity.getHireDate();
//			date=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
//			employeeEntity.setDob(new SimpleDateFormat("dd/MM/yyyy").format(date));
//			date=new SimpleDateFormat("dd/MM/yyyy").parse(hireDate);
//			employeeEntity.setHireDate(new SimpleDateFormat("dd/MM/yyyy").format(date));
			
//			dateFormat(dob,"dd/MM/yyyy");
//			System.err.println(employeeEntity.getDepartmentEntity().getDepartment());
//			System.err.println(dob+" -- "+hireDate);
		}
		System.err.println(list);
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called !!!" + "\n");
		return eRepository.findAll();
	}

	/*private String dateFormat(String dob, String string) {
		  
	    Date date;  		
	    System.err.println(dob+" ---- "+string);
		return string;
		
	}*/

	@Override
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " getEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = eRepository.findById(id);

		if (employee.isPresent()) {
			String deptName = employee.get().getDepartmentEntity().getShortName();
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity newemp) {
		List<EmployeeEntity> l1 = new ArrayList<EmployeeEntity>();
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
	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
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
	public EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, Long id) throws RecordNotFoundException {
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

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
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
	}
}
