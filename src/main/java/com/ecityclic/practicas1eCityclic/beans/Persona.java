package com.ecityclic.practicas1eCityclic.beans;

import java.util.Date;

public class Persona {
	
	private String nom;
	private Date fechaNacimiento;
	private String ciutat;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCiutat() {
		return ciutat;
	}
	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

}
