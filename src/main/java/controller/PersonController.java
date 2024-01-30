package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecityclic.practicas1eCityclic.beans.PersonPetition;
import com.ecityclic.practicas1eCityclic.entity.Persona;
import com.ecityclic.practicas1eCityclic.helper.TextoHelper;
import com.ecityclic.practicas1eCityclic.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/practica1/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private TextoHelper textoHelper;

	@GetMapping
	@ResponseBody
	public String HelloWorld() {
		return "Hola mundo";
	}

	@PostMapping(path = "/generate", consumes = "application/json")
	public void generatePersonas(@RequestBody PersonPetition petition) {

		List<Persona> personas = textoHelper.generatePersonas(petition.getNumberOfPersons());
		personService.saveAllPersons(personas);


	}
	
	
	@GetMapping("/all")
	@ResponseBody
	public List<Persona> mostrarPersonas(){
		
		List<Persona> personas = personService.getAllPersons();
		
		return personas;
		
		
	}
	

}
