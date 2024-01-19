package com.ecityclic.practicas1eCityclic.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private Date fechaNacimiento;
	private String ciutat;
	
	@Override
	public String toString() {
		String objeto = "\n";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		objeto += "nombre: "+nom+"\n";
		objeto += "fecha Nacimiento: "+sdf.format(fechaNacimiento)+"\n";
		objeto += "ciudad: "+ciutat+"\n";
		
		
		String mejor = String.format("\nNombre: %s\nNacimiento: %s\nCiudad: %s", nom, sdf.format(fechaNacimiento), ciutat);
		return mejor;
	}

}
