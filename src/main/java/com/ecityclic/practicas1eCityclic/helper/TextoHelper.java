package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecityclic.practicas1eCityclic.entity.Persona;
import com.ecityclic.practicas1eCityclic.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class TextoHelper {

	@Autowired
	private PersonService personService;

	public void dibujar(Persona persona, int repetir) {

		for (int i = 0; i < repetir; i++) {

			log.info("Datos personales :" + persona);

		}

	}

	public List<Persona> generatePersonas(int numDePersonas) {

		List<Persona> personas = new ArrayList<Persona>();

		int i = 0;

		while (i < numDePersonas) {

			Persona persona = Persona.builder().nom("Nombre " + i).fechaNacimiento(generaFecha()).ciutat("ciutat" + i)
					.build();

			personas.add(persona);

			i++;

		}

		return personas;

	}

//	public List<Persona> pintarSoloMayoresDe(int edad, int cantidadDePersonas) {
//
//		List<Persona> listPersonas = new ArrayList<Persona>();
//		List<Persona> personas = generatePersonas(cantidadDePersonas);
//
//		for (Persona person : personas) {
//
//			Calendar fechaN = Calendar.getInstance();
//
//			Calendar fechaHoy = Calendar.getInstance();
//
//			fechaN.setTime(person.getFechaNacimiento());
//
//			int anos = fechaHoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);
//
//			if (anos >= edad) {
//
//				listPersonas.add(person);
//
//			}
//
//		}
//		return listPersonas;
//
//	}

	public Date generaFecha() {
		Calendar c = Calendar.getInstance();
		int num = (int) (Math.random() * 100);

		c.add(Calendar.YEAR, -num);
		return c.getTime();

	}

	public List<Persona> getPeopleOlderThan(int edad) {

		List<Persona> personas = personService.getAllPersons();

		List<Persona> personasMayores = new ArrayList<Persona>();

		for (Persona person : personas) {

			Calendar fechaN = Calendar.getInstance();

			Calendar fechaHoy = Calendar.getInstance();

			fechaN.setTime(person.getFechaNacimiento());

			int anos = fechaHoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);

			if (anos >= edad) {

				personasMayores.add(person);

			}

		}

		return personasMayores;
	}
}
