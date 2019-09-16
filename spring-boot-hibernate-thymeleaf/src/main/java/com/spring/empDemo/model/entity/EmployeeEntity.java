package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBL_EMPLOYEES")
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class EmployeeEntity implements Serializable {

	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(Long id, String firstName, String lastName, String gender, String dob, String hireDate,
			String email, Double salary, Double bonus, Double comm) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.hireDate = hireDate;
		this.email = email;
		this.salary = salary;
		this.bonus = bonus;
		this.comm = comm;
	}

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
	@Column(name = "salary")
	private Double salary;
	@Column(name = "bonus")
	private Double bonus;
	@Column(name = "comm")
	private Double comm;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_dept_id")
	private DepartmentEntity departmentEntity;

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

	@JsonIgnore
	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	@JsonIgnore
	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", hireDate=" + hireDate + ", email=" + email + ", salary=" + salary + ", bonus="
				+ bonus + ", comm=" + comm + ", departmentEntity=" + departmentEntity + "]";
	}

}

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
 * 
 * @ManyToMany(cascade = CascadeType.ALL)
 * @JoinTable(name = "JOIN_TBL_EMP_DEPT", joinColumns = {
 * @JoinColumn(name = "emp_id", referencedColumnName = "emp_id") },
 *                  inverseJoinColumns = {
 * @JoinColumn(name = "dept_id", referencedColumnName = "dept_id") }) private
 *                  Set<DepartmentEntity> department;
 */