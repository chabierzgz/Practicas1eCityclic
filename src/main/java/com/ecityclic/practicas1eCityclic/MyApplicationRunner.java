package com.ecityclic.practicas1eCityclic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ecityclic.practicas1eCityclic.entity.Persona;
import com.ecityclic.practicas1eCityclic.helper.TextoHelper;
import com.ecityclic.practicas1eCityclic.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class MyApplicationRunner implements ApplicationRunner {
	
	@Autowired
	TextoHelper textoHelper;
	
	@Autowired
	private PersonService personaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//		TextoHelper textoHelper = new TextoHelper();

		Scanner scan = new Scanner(System.in);

		System.out.println(
				"Introduce el número del método deseado : \n1. Método dibujar. \n2. Método getPersonas. \n3. Método pintarSoloMayoresDe");

		int opcion = scan.nextInt();

		switch (opcion) {

		case 1:

			Date fecha1 = getBirthDate1(1050, Calendar.MARCH, 24);
			Date fecha2 = getBirthDate2("24/03/1950");

			Persona persona = Persona.builder().nom("Carlos").fechaNacimiento(textoHelper.generaFecha()).ciutat("Mataró").build();
//			persona.setNom("Carlos");
//			persona.setFechaNacimiento(fecha1);
//			persona.setCiutat("Mataró");

			textoHelper.dibujar(persona, opcion);

			break;

		case 2:

			List<Persona> personas = textoHelper.getPersonas(2);
			personaService.saveAllPersons(personas);
//			
			List<Persona> personasBD = personaService.getAllPersons();
//
			for (Persona p : personasBD) {
				log.info(p);
			}

			break;

		case 3:
			List<Persona> listaPersonas = textoHelper.getPersonas(10);
//			List<Persona> lista = textoHelper.getSoloMayoresDe(listaPersonas, 40);
//			textoHelper.pintaLista(lista);

			break;

		default:
			break;
		}
		scan.close();
	}

	private Date getBirthDate2(String fechaString) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = sdf.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}

	private Date getBirthDate1(int year, int month, int day) {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

	public boolean someLibraryMethod() {
		return true;
	}
}
