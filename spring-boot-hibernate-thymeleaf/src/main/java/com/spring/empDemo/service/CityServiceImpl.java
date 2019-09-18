package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.CityEntity;
import com.spring.empDemo.repository.CityRepository;
import com.spring.empDemo.repository.StateRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	StateRepository sRepository;

	@Autowired
	CityRepository cRepository;

	public List<CityEntity> getAllCities() {
		return cRepository.findAll();
	}

	public Optional<CityEntity> getCityById(Integer cityId) throws RecordNotFoundException {
		if (!cRepository.existsById(cityId)) {
			throw new RecordNotFoundException("city with id " + cityId + " not found");
		}
		return cRepository.findById(cityId);
	}

	@Override
	public CityEntity addCity(Integer stateId, CityEntity cityEntity) throws RecordNotFoundException {
		return null;
	}



}
