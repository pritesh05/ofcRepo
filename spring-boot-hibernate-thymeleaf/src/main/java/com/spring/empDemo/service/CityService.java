package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.CityEntity;

public interface CityService {
	public List<CityEntity> getAllCities();

	public Optional<CityEntity> getCityById(Integer cityId) throws RecordNotFoundException;

	public CityEntity addCity(Integer stateId, CityEntity cityEntity) throws RecordNotFoundException;
}
