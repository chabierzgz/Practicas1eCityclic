package com.ecityclic.practicas1eCityclic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperations;
import com.ecityclic.practicas1eCityclic.repository.MathematicRepository;

@Service
public class MathematicService {

	@Autowired
	private MathematicRepository mathematicRepository;

	@Transactional
	public void saveMathematicOperation(MathematicsOperations mathematicsOperations) {

		mathematicRepository.save(mathematicsOperations);

	}

	public List<MathematicsOperations> getMathematicOperation() {

		return mathematicRepository.findAll();

	}

}
