package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.DepartmentEntity;
import com.spring.empDemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl {
	@Autowired
	DepartmentRepository dRepository;

	public List<DepartmentEntity> getAllDept() {
		return dRepository.findAll();
	}

	public DepartmentEntity getDeptById(long id) throws RecordNotFoundException {
		Optional<DepartmentEntity> optional = dRepository.findById((int) id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}