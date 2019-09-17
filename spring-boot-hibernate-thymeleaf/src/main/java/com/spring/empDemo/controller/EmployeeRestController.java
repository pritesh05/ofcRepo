package com.spring.empDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empDemo.model.customAnnotation.DefaultApiResponses;
import com.spring.empDemo.model.entity.EmployeeEntity;
import com.spring.empDemo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employees")
@DefaultApiResponses
@Api(value = "Employee Data", description = "performing CRUD Operations for employee data")
public class EmployeeRestController {
	@Autowired
	EmployeeService service;

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@RequestMapping(method = RequestMethod.GET)
	public List<EmployeeEntity> getAllEmployees() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllEmployees method called..." + "\n");
		return service.getAllEmployees();
	}

	@ApiOperation(value = "View a employees based on id", response = EmployeeEntity.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeEntity getEmployeeById(@PathVariable long id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");
		EmployeeEntity emp = service.getEmployeeById(id);
		return emp;
	}

	@ApiOperation(value = "Add employee Record")
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
		return service.addEmployee(newemp);
	}
//	@ApiOperation(value = "Add employee Record")
//	@RequestMapping(value = "/add/emp",method = RequestMethod.POST)
//	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity newemp) {
//		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
//		return service.addEmployee(newemp);
//	}

	@ApiOperation(value = "Add list of employees Data")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<EmployeeEntity> addEmployeeList(@RequestBody List<EmployeeEntity> newempList) {
		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
		System.err.println(newempList);
		return service.addEmployeeList(newempList);
	}

	@ApiOperation(value = "Update employees Record")
	@RequestMapping(method = RequestMethod.PUT)
	public EmployeeEntity UpdateEmployee(@RequestBody EmployeeEntity upemp, @PathVariable long id) throws Exception {
		System.out.println("\n" + this.getClass().getSimpleName() + " UpdateEmployee method called..." + "\n");
		return service.UpdateEmployeeById(upemp, id);
	}

	@ApiOperation(value = "Deleting employee data based on Id")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable long id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");

		EmployeeEntity emp = service.getEmployeeById(id);
		service.deleteEmployeeById(id);
	}

	@ApiOperation(value = "Delete all employees Records")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value = "/employee/deleteall", method = RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all employees is invoked.");
		service.deleteAllEmployees();
	}
}
