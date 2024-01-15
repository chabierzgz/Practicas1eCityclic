package com.ecityclic.practicas1eCityclic.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

		}

		int i = 0;
		while (i < repetir) {
			log.info("Datos personales :" + persona);
			i++;
		}

	}

	public List<Persona> getPersonas(int numDePersonas) {

		List<Persona> personas = new ArrayList<Persona>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int i = 0;

		while (i < numDePersonas) {

			Persona persona = new Persona();

			System.out.println("escribe nombre");
			persona.setNom("Nombre " + i);// lector.nextLine());

			System.out.println("escribe feCHa de naCimiento (dd/MM/yyyy)");
			String feCHaNaCimiento = lector.nextLine();

			System.out.println("escribe ciudad");
			String ciudad = lector.nextLine();

			try {
				persona.setFechaNacimiento(sdf.parse(feCHaNaCimiento));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			persona.setCiutat(ciudad);

			personas.add(persona);

			i++;

		}

		return personas;

	}

	public void pintarSoloMayoresDe(int edad) {

		List<Persona> personas = new ArrayList<Persona>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int i = 0;

		while (i < 3) {

			Persona persona = new Persona();

			System.out.println("escribe nombre");
			persona.setNom("Nombre " + i);// lector.nextLine());

			System.out.println("escribe feCHa de naCimiento (dd/MM/yyyy)");
			String feCHaNaCimiento = lector.nextLine();

			System.out.println("escribe ciudad");
			String ciudad = lector.nextLine();

			try {
				persona.setFechaNacimiento(sdf.parse(feCHaNaCimiento));

			} catch (ParseException e) {
				e.printStackTrace();
			}

			persona.setCiutat(ciudad);

			personas.add(persona);

			i++;

		}

		for (Persona person : personas) {

			Calendar fechaN = Calendar.getInstance();

			Calendar fechaHoy = Calendar.getInstance();

			fechaN.setTime(person.getFechaNacimiento());

			int anos = fechaHoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);
			int mes = fechaHoy.get(Calendar.MONTH) - fechaN.get(Calendar.MONTH);
			int dia = fechaHoy.get(Calendar.DATE) - fechaN.get(Calendar.DATE);

			if (mes < 0 || (mes == 0 && dia < 0)) {

				anos--;

				if (anos >= edad) {

					log.info(person + "\nEdad: " + anos);

				}

			}

		}

	}

}
