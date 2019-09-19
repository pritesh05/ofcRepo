package com.spring.empDemo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SALARY")
public class SalaryEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sal_id")
	private Long id;
	@Column(name = "salary")
	private Double salary;
	@Column(name = "bonus")
	private Double bonus;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "SalaryEntity [id=" + id + ", salary=" + salary + ", bonus=" + bonus + "]";
	}
	
	
}
