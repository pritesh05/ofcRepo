package com.spring.empDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.empDemo.exception.RecordNotFoundException;
import com.spring.empDemo.model.entity.CityEntity;
import com.spring.empDemo.model.entity.StateEntity;
import com.spring.empDemo.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository sRepository;

	@Override
	public List<StateEntity>  getAllState() {
		System.out.println("\n" + this.getClass().getSimpleName() + " getAllStates method called..." + "\n");
		
//		Optional<StateEntity> stateList = sRepository.findAll();
//		System.out.println("\n -->> "+stateList);
		if (!sRepository.findAll().isEmpty()) {
			return sRepository.findAll();
		} else {
			return new ArrayList<>();
		}
//		return sRepository.findAll();
	}

	public Optional<StateEntity> getStateById(Integer stateId) throws RecordNotFoundException {
		if (!sRepository.existsById(stateId)) {
			throw new RecordNotFoundException("state with id " + stateId + " not found");
		}
		return sRepository.findById(stateId);
	}

	 public StateEntity addState(StateEntity stateEntity) {
	        return sRepository.save(stateEntity);
	    }

}
