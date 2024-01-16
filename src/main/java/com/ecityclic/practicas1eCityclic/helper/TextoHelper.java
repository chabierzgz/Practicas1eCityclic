package com.ecityclic.practicas1eCityclic.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.joda.time.LocalDate;

import com.ecityclic.practicas1eCityclic.beans.Persona;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TextoHelper {

	Scanner lector = new Scanner(System.in);

	public void dibujar(Persona persona, int repetir) {

		for (int i = 0; i < repetir; i++) {

			log.info("Datos personales :" + persona);

		}

	}

	public List<Persona> getPersonas(int numDePersonas) {

		List<Persona> personas = new ArrayList<Persona>();

		int i = 0;

		while (i < numDePersonas) {

			Persona persona = new Persona();

			persona.setNom("Nombre " + i);

			persona.setFechaNacimiento(generaFecha());

			persona.setCiutat("Ciudad " + i);

			personas.add(persona);

			i++;

		}

		return personas;

	}

	public void pintarSoloMayoresDe(int edad, int cantidadDePersonas) {

		List<Persona> personas = getPersonas(cantidadDePersonas);

		for (Persona person : personas) {

			Calendar fechaN = Calendar.getInstance();

			Calendar fechaHoy = Calendar.getInstance();

			fechaN.setTime(person.getFechaNacimiento());

			int anos = fechaHoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);

			if (anos >= edad) {

				log.info(person + "\nEdad: " + anos);

			}

		}

	}

	public Date generaFecha() {
		Calendar c = Calendar.getInstance();
		int num = (int) (Math.random() * 100);

		c.add(Calendar.YEAR, -num);
		return c.getTime();

	}

}
