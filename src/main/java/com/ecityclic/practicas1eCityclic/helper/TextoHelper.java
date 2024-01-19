package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ecityclic.practicas1eCityclic.entity.Persona;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class TextoHelper {
	
	public void dibujar(Persona persona, int repetir) {

		for (int i = 0; i < repetir; i++) {

			log.info("Datos personales :" + persona);

		}

	}

	public List<Persona> generatePersons(int numDePersonas) {

		List<Persona> personas = new ArrayList<Persona>();

		int i = 0;

		while (i < numDePersonas) {
			
			Persona persona = Persona.builder().nom("Nombre " + i).fechaNacimiento(generaFecha()).ciutat("ciutat"+i).build();

//			Persona persona = new Persona();
//
//			persona.setNom("Nombre " + i);
//
//			persona.setFechaNacimiento(generaFecha());
//
//			persona.setCiutat("Ciudad " + i);
//
			personas.add(persona);

			i++;

		}

		return personas;

	}
	

	public List<Persona> getSoloMayoresDe(List<Persona> personas, int edad) {
		
		List<Persona> personasFiltro = new ArrayList<Persona>();

		for (Persona person : personas) {

			Calendar fechaN = Calendar.getInstance();

			Calendar fechaHoy = Calendar.getInstance();

			fechaN.setTime(person.getFechaNacimiento());

			int anos = fechaHoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);

			if (anos >= edad) {
				personasFiltro.add(person);

			}

		}
		return personasFiltro;

	}

	public Date generaFecha() {
		Calendar c = Calendar.getInstance();
		int num = (int) (Math.random() * 100);

		c.add(Calendar.YEAR, -num);
		return c.getTime();

	}

	public void pintaLista(List<Persona> lista) {
		for (Persona persona : lista) {
			log.info(persona.toString());
		}
	}
}
