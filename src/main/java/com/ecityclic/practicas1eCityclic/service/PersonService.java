package com.ecityclic.practicas1eCityclic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecityclic.practicas1eCityclic.entity.Persona;
import com.ecityclic.practicas1eCityclic.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personaRepository;
    
    @Transactional
    public void saveAllPersons(List<Persona> personas) {
    	personaRepository.saveAll(personas);
    }

    @Transactional
    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> getAllPersons() {
        return personaRepository.findAll();
    }
}