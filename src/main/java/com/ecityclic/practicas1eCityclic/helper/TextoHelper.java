package com.ecityclic.practicas1eCityclic.helper;

import com.ecityclic.practicas1eCityclic.beans.Persona;

import jdk.internal.org.jline.utils.Log;

public class TextoHelper {
	
	public void dibujar (Persona persona) {
		
		Log.info("nombre:{} Fecha de nacimiento: {} ciudad: {}"
				,persona.getNom(),persona.getFechaNacimiento(), persona.getCiutat());
		
	}

}


