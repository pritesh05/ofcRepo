package com.spring.empDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.customAnnotation.DefaultApiResponses;
import com.spring.empDemo.model.entity.CityEntity;
import com.spring.empDemo.model.entity.StateEntity;
import com.spring.empDemo.service.CityService;
import com.spring.empDemo.service.CityServiceImpl;
import com.spring.empDemo.service.StateService;

import io.swagger.annotations.Api;

@RestController
@DefaultApiResponses
@Api(value = "StateCity Data")
public class StateCityRestController {
	@Autowired
	StateService sService;
	@Autowired
	CityService cService;

	@RequestMapping(value = "/getAllState", method = RequestMethod.GET)
	public List<StateEntity> getAllStates() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllStates method called..." + "\n");
		return sService.getAllState();
	}

	@RequestMapping(value = "/getState/{stateId}", method = RequestMethod.GET)
	public Optional<StateEntity> getStateById(@PathVariable(value = "stateId") Integer stateId)
			throws RecordNotFoundException {
		return sService.getStateById(stateId);
	}
	
	@RequestMapping(value = "/addState", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StateEntity addState(@RequestBody StateEntity state) {
		return sService.addState(state);
	}

	@RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
	public List<CityEntity> getAllCities() {
		return cService.getAllCities();
	}

	@RequestMapping(value = "/getCity/{cityId}", method = RequestMethod.GET)
	public Optional<CityEntity> getCityById(@PathVariable(value = "cityId") Integer cityId)
			throws RecordNotFoundException {
		return cService.getCityById(cityId);
	}

	@RequestMapping(value = "/{stateId}/city", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CityEntity addCity(@PathVariable(value = "stateId") Integer stateId, @RequestBody CityEntity city)
			throws RecordNotFoundException {
		return cService.addCity(stateId, city);
	}
}
