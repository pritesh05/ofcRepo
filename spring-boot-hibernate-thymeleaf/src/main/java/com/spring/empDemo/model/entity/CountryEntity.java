package com.spring.empDemo.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_COUNTRY")
public class CountryEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Long countryId;
	@Column(name = "country_name")
	private String countryName;

	@JsonIgnore
	@OneToMany(mappedBy = "countryEntity")
	private List<StateEntity> stateEntitiesList;

	@JsonIgnore
	@OneToMany(mappedBy = "countryEntity")
	private List<AddressEntity> addressEntities;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<StateEntity> getStateEntitiesList() {
		return stateEntitiesList;
	}

	public void setStateEntitiesList(List<StateEntity> stateEntitiesList) {
		this.stateEntitiesList = stateEntitiesList;
	}

	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}

	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}

	@Override
	public String toString() {
		return "CountryEntity [countryId=" + countryId + ", countryName=" + countryName + "]";
	}

}
