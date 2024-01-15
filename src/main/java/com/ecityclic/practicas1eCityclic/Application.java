/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ecityclic.practicas1eCityclic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ecityclic.practicas1eCityclic.beans.Persona;
import com.ecityclic.practicas1eCityclic.helper.TextoHelper;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Application {
	
	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
	
	private void run() {
//		int prueba = 1;
//		log.info("Método main para hacer la prueba {}", prueba);
		
/*		Date fecha1 = getBirthDate1(1050,Calendar.MARCH,24);
		Date fecha2 = getBirthDate2("24/03/1950");
		
		10
		Persona persona = new Persona();
		persona.setNom("Carlos");
		persona.setFechaNacimiento(fecha1);
		persona.setCiutat("Mataró");
		
		TextoHelper textoHelper = new TextoHelper();
		
		textoHelper.dibujar(persona, 5);
		
		List<Persona> personas = textoHelper.getPersonas(2);
		
		for (Persona p : personas) {
			log.info(p);
		}
		
		textoHelper.pintarSoloMayoresDe(40);*/
		
		TextoHelper textoHelper = new TextoHelper();
		
		textoHelper.pintarSoloMayoresDe(40);
		
		

	}
	
	

	private Date getBirthDate2(String fechaString){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = sdf.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
	private Date getBirthDate1(int year, int month,  int day) {
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
