package com.ecityclic.practicas1eCityclic.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Persona {

	private String nom;
	private Date fechaNacimiento;
	private String ciutat;

	@Override
	public String toString() {
		String objeto = "\n";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		objeto += "nombre: " + nom + "\n";
		objeto += "fecha Nacimiento: " + sdf.format(fechaNacimiento) + "\n";
		objeto += "ciudad: " + ciutat + "\n";

		String mejor = String.format("\nNombre: %s\nNacimiento: %s\nCiudad: %s", nom, sdf.format(fechaNacimiento),
				ciutat);
		return mejor;
	}
}
