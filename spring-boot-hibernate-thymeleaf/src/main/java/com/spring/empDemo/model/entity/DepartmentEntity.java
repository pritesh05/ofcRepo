package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "TBL_DEPARTMENTS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "id", "shortName" })
public class DepartmentEntity implements Serializable {

	public DepartmentEntity() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long id;
	@Column(name = "department_name")
	private String department;
	@Column(name = "short_name", length = 5)
	private String shortName;
	@Column(name = "code", length = 5)
	private Integer code;

	@OneToMany(mappedBy = "departmentEntity")
	private List<EmployeeEntity> employeeEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("name")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonIgnore
	public List<EmployeeEntity> getEmployeeEntities() {
		return employeeEntities;
	}

	public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
		this.employeeEntities = employeeEntities;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", department=" + department + ", shortName=" + shortName + "]";
	}

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_DEPT")
//	private EmployeeEntity employeeEntities ;

}
