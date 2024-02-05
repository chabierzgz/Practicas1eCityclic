package com.ecityclic.practicas1eCityclic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecityclic.practicas1eCityclic.entity.SoloSumaEntity;
import com.ecityclic.practicas1eCityclic.repository.SoloSumaRepository;

@Service
public class SoloSumaService {
	
	@Autowired
	private SoloSumaRepository soloSumaRepository;
	
	@Transactional
	public void saveSuma (SoloSumaEntity soloSumaEntity) {
		
		soloSumaRepository.save(soloSumaEntity);
	}

}
