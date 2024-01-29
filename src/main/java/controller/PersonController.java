package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/practica1/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private TextoHelper textoHelper;

	@GetMapping("/hola")
	@ResponseBody
	public String HelloWolrd() {
		return "Hola mundo";
	}

	@PostMapping(path = "/generate", consumes = "application/json", produces = "application/json")
	public Boolean generatePerson(@RequestBody PersonPetition petition) {

		List<Persona> personas = textoHelper.generatePersonas(petition.getNumberOfPersons());
		personService.saveAllPersons(personas);

		if (personas.size() == petition.getNumberOfPersons()) {

			return true;

		} else {

			return false;

		}

	}

}
