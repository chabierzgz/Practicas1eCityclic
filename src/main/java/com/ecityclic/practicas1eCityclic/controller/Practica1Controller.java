package com.ecityclic.practicas1eCityclic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecityclic.practicas1eCityclic.beans.PersonPetition;
import com.ecityclic.practicas1eCityclic.beans.Persona;
import com.ecityclic.practicas1eCityclic.helper.TextoHelper;
import com.ecityclic.practicas1eCityclic.service.PersonService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/practica1")
@Log4j2
public class Practica1Controller {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TextoHelper textoHelper;
	
	@PostMapping(path = "/persons/generate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> generatePersons(@RequestBody PersonPetition petition) {
		try {
			List<Persona> persons = textoHelper.getPersonas(petition.getNumberOfPersons());
			personService.saveAllPersons(persons);
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping(path = "/persons/", produces = "application/json")
	public ResponseEntity<List<Persona>> getToken(){
		List<Persona> personas = personService.getAllPersons();
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping(path = "/persons/olderThan/{edad}", produces = "application/json")
	public ResponseEntity<List<Persona>> getToken(@PathVariable String edad){

		List<Persona> personas = null;
		try {
			int age = Integer.valueOf(edad);
			personas = personService.getAllPersons();
			textoHelper.pintarSoloMayoresDe(age, 10);
			
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request parameters are not correct.");
		}
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
}
