package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DEPARTMENTS")
public class DepartmentEntity implements Serializable {
	
	public DepartmentEntity() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentEntity(long id, String department, Set<EmployeeEntity> employeeEntities) {
		super();
		this.id = id;
		this.department = department;
		this.employeeEntities = employeeEntities;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private long id;
	@Column(name = "department")
	private String department;

	@OneToMany(mappedBy = "departmentEntity")
	private Set<EmployeeEntity> employeeEntities = new HashSet<EmployeeEntity>();

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_DEPT")
//	private EmployeeEntity employeeEntities ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<EmployeeEntity> getEmployeeEntities() {
		return employeeEntities;
	}

	public void setEmployeeEntities(Set<EmployeeEntity> employeeEntities) {
		this.employeeEntities = employeeEntities;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", department=" + department + ", employeeEntities=" + employeeEntities
				+ "]";
	}

}
