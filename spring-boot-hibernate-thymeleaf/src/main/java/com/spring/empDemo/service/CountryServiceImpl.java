package com.spring.empDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.CityEntity;
import com.spring.empDemo.model.entity.CountryEntity;
import com.spring.empDemo.model.entity.StateEntity;
import com.spring.empDemo.repository.CountryRepository;
import com.spring.empDemo.repository.StateRepository;

@Service
public class CountryServiceImpl  {

	@Autowired
	CountryRepository cRepository;

	public List<CountryEntity>  getAllCountry() {
		if (!cRepository.findAll().isEmpty()) {
			return cRepository.findAll();
		} else {
			return new ArrayList<>();
		}
	}

	public Optional<CountryEntity> getCountryById(Long countryId) throws RecordNotFoundException {
		if (!cRepository.existsById(countryId)) {
			throw new RecordNotFoundException("country with id " + countryId + " not found");
		}
		return cRepository.findById(countryId);
	}

	 public CountryEntity addState(CountryEntity countryEntity) {
	        return cRepository.save(countryEntity);
	    }

}
