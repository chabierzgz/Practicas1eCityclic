package com.ecityclic.practicas1eCityclic.helper;

import com.ecityclic.practicas1eCityclic.beans.Persona;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TextoHelper {
	
	public void dibujar (Persona persona, int repetir) {
		
		int i = 0;
		
		while( i< repetir) {
			
			log.info("Datos personales :"+persona);
			
			i++;
			
		}
		
		
	}

}


