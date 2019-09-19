package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBL_EMPLOYEES")
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class EmployeeEntity implements Serializable {

	public EmployeeEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name = "emp_id")
	private String id;

	@Column(name = "first_name")
	@ApiModelProperty(notes = "first name of employee")
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(notes = "last name of employee")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dob;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "email", nullable = false, length = 200)
	@ApiModelProperty(notes = "email id of employee")
	private String email;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "bonus")
	private Double bonus;

	@Column(name = "comm")
	private Double comm;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date modifyDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_dept_id")
	private DepartmentEntity departmentEntity;

	@OneToOne
	@JoinColumn(name = "FK_address_id")
	private AddressEntity addressEntity;

	@JsonProperty(access = Access.WRITE_ONLY)
	private transient Long deptId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private transient Long addId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@JsonGetter("department")
	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	@JsonGetter("address")
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getAddId() {
		return addId;
	}

	public void setAddId(Long addId) {
		this.addId = addId;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", hireDate=" + hireDate + ", email=" + email + ", salary=" + salary + ", bonus="
				+ bonus + ", comm=" + comm + ", createdAt=" + createdAt + ", modifyDate=" + modifyDate + ", deptId="
				+ deptId + ", addId=" + addId + "]";
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