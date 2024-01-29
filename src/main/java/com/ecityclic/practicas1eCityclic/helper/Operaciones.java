package com.ecityclic.practicas1eCityclic.helper;

import org.springframework.stereotype.Component;

@Component
public class Operaciones {

	public int suma(int a, int b) {

		return a + b;
	}

	public int resta(int a, int b) {

		return a - b;
	}

	public int multiplica(int a, int b) {

		return a * b;
	}

	public double potenciaExponente(double potencia, double exponente) {

		return Math.pow(potencia, exponente);

	}
}
