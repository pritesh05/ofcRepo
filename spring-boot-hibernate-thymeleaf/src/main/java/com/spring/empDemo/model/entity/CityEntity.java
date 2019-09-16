package com.spring.empDemo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cities")
public class CityEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id", length = 3, nullable = false)
	private int cityId;
	@Column(name = "city_name", length = 30)
	private String cityName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_state_id")
	private StateEntity stateEntity;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@JsonIgnore
	public StateEntity getStateEntity() {
		return stateEntity;
	}
	@JsonIgnore
	public void setStateEntity(StateEntity stateEntity) {
		this.stateEntity = stateEntity;
	}

	@Override
	public String toString() {
		return "CityEntity [cityId=" + cityId + ", cityName=" + cityName + ", stateEntity=" + stateEntity + "]";
	}

	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "JOIN_TBL_State_City", joinColumns = {
	 * 
	 * @JoinColumn(name = "city_id", referencedColumnName = "city_id") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "state_id", referencedColumnName = "state_id") }) private
	 * Set<StateEntity> stateEntities;
	 */

}
