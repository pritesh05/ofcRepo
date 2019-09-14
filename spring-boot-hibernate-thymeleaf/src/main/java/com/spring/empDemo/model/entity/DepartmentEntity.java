package com.spring.empDemo.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DEPARTMENTS")
public class DepartmentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private long id;
	@Column(name = "department")
	private String department;

	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_DEPT", joinColumns = @JoinColumn(name = "dept_id"), inverseJoinColumns = @JoinColumn(name = "emp_id"))
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

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", department=" + department + "]";
	}

}
