package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.DepartmentEntity;
import com.spring.empDemo.model.entity.EmployeeEntity;
import com.spring.empDemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl {
	@Autowired
	DepartmentRepository dRepository;

	public List<DepartmentEntity> getAllDept() {
		List<DepartmentEntity> list=dRepository.findAll();
		for (DepartmentEntity employeeEntity : list) {
			System.err.println(employeeEntity);
//			System.err.println(employeeEntity.getDepartmentEntity().getDepartment());
		}
		return dRepository.findAll();
	}

	public DepartmentEntity getDeptById(long id) throws RecordNotFoundException {
		Optional<DepartmentEntity> optional = dRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RecordNotFoundException("No department record exist for given id");
		}
	}

}