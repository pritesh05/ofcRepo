package com.spring.empDemo.service;

import java.util.ArrayList;
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
	public List<EmployeeEntity> getAllEmployees() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called !!!" + "\n");
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) eRepository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + " getEmployeeById method called !!!" + "\n");
		Optional<EmployeeEntity> employee = eRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity newemp) {
		System.out.println("\n" + this.getClass().getSimpleName() + " createOrUpdateEmployee method called !!!" + "\n");
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
	public EmployeeEntity UpdateEmployeeById(EmployeeEntity updemp, long id) throws RecordNotFoundException {
		System.out.println("\n" + this.getClass().getSimpleName() + "  UpdateEmployeeById method called !!!" + "\n");
		EmployeeEntity emp = getEmployeeById(id);

		if (updemp.getFirstName() == null || updemp.getFirstName().isEmpty())
			updemp.setFirstName(emp.getFirstName());
		if (updemp.getLastName() == null || updemp.getLastName().isEmpty())
			updemp.setLastName(emp.getLastName());
		if (updemp.getEmail() == null)
			updemp.setEmail(emp.getEmail());
		updemp.setId(id);
//		System.err.println(updemp);
		return eRepository.save(updemp);
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity)
    {
        if(entity.getId()  == null)
        {
            entity = eRepository.save(entity);
             
            return entity;
        }
        else
        {
            Optional<EmployeeEntity> employee = eRepository.findById(entity.getId());
             
            if(employee.isPresent())
            {
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
