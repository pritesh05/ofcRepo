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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "States")
public class StateEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private int stateId;
	@Column(name = "state_name")
	private String stateName;
	@Column(name = "country_id")
	private String countryId;
	@OneToMany(mappedBy = "stateEntity",fetch = FetchType.LAZY)
	private Set<CityEntity> cityEntities=new HashSet<>();
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public Set<CityEntity> getCityEntities() {
		return cityEntities;
	}
	public void setCityEntities(Set<CityEntity> cityEntities) {
		this.cityEntities = cityEntities;
	}
	@Override
	public String toString() {
		return "StateEntity [stateId=" + stateId + ", stateName=" + stateName + ", countryId=" + countryId
				+ ", cityEntities=" + cityEntities + "]";
	}

	
}
