package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author dpritesh
 *
 */
/**
 * @author dpritesh
 *
 */
@Entity
@Table(name = "TBL_EMPLOYEES")
public class EmployeeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "first_name")
//    @Size(min = 2, max = 30)
	@ApiModelProperty(notes = "first name of employee")
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(notes = "last name of employee")
	private String lastName;

	@Column(name = "gender")
	private String gender;
	@Column(name = "date_of_birth")
	private String dob;
	@Column(name = "hire_date")
	private String hireDate;

	@Column(name = "email", nullable = false, length = 200)
//    @Email(message = "Email should be valid")
	@ApiModelProperty(notes = "email id of employee")
	private String email;

	/**
	 * one-to-one relationship between common table with the help of @JoinTble
	 * annotation
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * @JoinTable(name = "JOIN_TBL_EMP_DEPT", joinColumns = {@JoinColumn(name =
	 *                 "em_id",referencedColumnName = "emp_id")}, inverseJoinColumns
	 *                 = {@JoinColumn(name = "dep_id",referencedColumnName =
	 *                 "dept_id",unique = true)}) private DepartmentEntity
	 *                 department;
	 */
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_DEPT", joinColumns = {
//			@JoinColumn(name = "emp_id", referencedColumnName = "emp_id") }, inverseJoinColumns = {
//					@JoinColumn(name = "dept_id", referencedColumnName = "dept_id") })
//	private Set<DepartmentEntity> department;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "JOIN_TBL_EMP_DEPT", joinColumns = {
			@JoinColumn(name = "em_id", referencedColumnName = "emp_id") }, inverseJoinColumns = {
					@JoinColumn(name = "dep_id", referencedColumnName = "dept_id") })
	private DepartmentEntity department;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_DEPT_MNGR", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "dept_mngr_id"))
//	private DepartmentManager departmentManager;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "JOIN_TBL_EMP_SALARY", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "sal_id"))
//	private SalaryEntity salaryEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}