package com.ecityclic.practicas1eCityclic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.repository.MathematicRepository;

@Service
public class MathematicService {

	@Autowired
	private MathematicRepository mathematicRepository;

	@Transactional
	public void saveMathematicOperation(MathematicsOperationsEntity mathematicsOperations) {

		mathematicRepository.save(mathematicsOperations);

	}

	public List<MathematicsOperationsEntity> getMathematicOperation() {

		return mathematicRepository.findAll();

	}
	
	public Optional<MathematicsOperationsEntity> getMathematicOperationById (int id) {
		
		return mathematicRepository.findById(id);
	}

}
