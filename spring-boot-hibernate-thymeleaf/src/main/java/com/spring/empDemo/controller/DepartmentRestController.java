package com.spring.empDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empDemo.model.customAnnotation.DefaultApiResponses;
import com.spring.empDemo.model.entity.DepartmentEntity;
import com.spring.empDemo.model.entity.EmployeeEntity;
import com.spring.empDemo.service.DepartmentServiceImpl;
import com.spring.empDemo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/departments")
@DefaultApiResponses
@Api(value = "Department Data")
public class DepartmentRestController {
	@Autowired
	DepartmentServiceImpl dService;

	@RequestMapping(method = RequestMethod.GET)
	public List<DepartmentEntity> getAllDept() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllDepartment method called..." + "\n");
		return dService.getAllDept();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DepartmentEntity getDepartmentById(@PathVariable long id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get department details by id is invoked.");
		DepartmentEntity dept  = dService.getDeptById(id);
		return dept;
	}
	

}
