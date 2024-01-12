package com.ecityclic.practicas1eCityclic.helper;

public class Operaciones {
	
	public int suma(int a, int b) {
		int resultat;
		
		resultat= a+b;
		return resultat;
	}

	public int resta(int a, int b) {
		int resultat;
		
		resultat= a-b;
		return resultat;
	}
	
	public int multiplica(int a, int b) {
		int resultat;
		
		resultat= a*b;
		return resultat;
	}
	
	public double potenciaExponente (double potencia, double exponente) {
		
		double resultado;
		
		resultado = Math.pow(potencia, exponente);
		
		return resultado;
		
	}
}
