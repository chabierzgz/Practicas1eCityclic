package com.ecityclic.practicas1eCityclic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecityclic.practicas1eCityclic.beans.Persona;
import com.ecityclic.practicas1eCityclic.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personaRepository;
    
    public void saveAllPersons(List<Persona> personas) {
    	personaRepository.saveAll(personas);
    }

    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> getAllPersons() {
        return personaRepository.findAll();
    }
}