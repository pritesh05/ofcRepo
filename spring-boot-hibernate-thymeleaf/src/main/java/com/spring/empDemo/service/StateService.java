package com.spring.empDemo.service;

import java.util.List;
import java.util.Optional;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.StateEntity;

public interface StateService {

	public List<StateEntity> getAllState();

	public StateEntity addState(StateEntity stateEntity);
	
	public Optional<StateEntity> getStateById(Integer stateId) throws RecordNotFoundException;
}