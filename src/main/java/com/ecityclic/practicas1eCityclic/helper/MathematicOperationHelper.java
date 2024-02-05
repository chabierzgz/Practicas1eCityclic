package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MathematicOperationHelper {

//	public int transOperation(String operation) {
//
//		int tam = operation.length();
//		String A[] = new String[100];
//		// Array para almacenar operadores.;
//		String operaciones[] = new String[100];
//		int posicion = 0;
//		int sum = 0;
//		String aux = "";
//
//		// inicializa primer operador.
//
//		operaciones[0] = "+";
//		int index_operacion = 1;
//		for (int i = 0; i < tam; i++) {
//			if (operation.charAt(i) == '+' || operation.charAt(i) == '-') {
//				A[posicion] = aux;
//				operaciones[index_operacion] = String.valueOf(operation.charAt(i));
//				posicion++;
//				index_operacion++;
//				aux = "";
//			} else {
//				aux = aux + operation.charAt(i);
//			}
//		}
//		A[posicion] = aux;
//		posicion++;
//
//		for (int i = 0; i < posicion; i++) {
//			// Determina la operación a realizar.
//			if (operaciones[i].equals("+")) {
//				sum = sum + Integer.parseInt(A[i]);
//			} else if (operaciones[i].equals("-")) {
//				sum = sum - Integer.parseInt(A[i]);
//			}
//
//		}
//
//		return sum;
//		System.out.println("=  " + sum);
//	}

	public int bestTransOperation(String operation) {

		List<String> numeros = new ArrayList<String>();
		List<String> TipoOperacion = new ArrayList<String>();

		int resultado = 0;
		String aux = "";

		// inicializa primer operador.

		TipoOperacion.add("+");
		for (int i = 0; i < operation.length(); i++) {
			if (operation.charAt(i) == '+' || operation.charAt(i) == '-') {
				numeros.add(aux);
				TipoOperacion.add(String.valueOf(operation.charAt(i)));
				aux = "";
			} else {
				aux = aux + operation.charAt(i);
			}
		}
		numeros.add(aux);

		for (int i = 0; i < numeros.size(); i++) {
			// Determina la operación a realizar.
			if (TipoOperacion.get(i).equals("+")) {
				resultado = resultado + Integer.parseInt(numeros.get(i));
			} else if (TipoOperacion.get(i).equals("-")) {
				resultado = resultado - Integer.parseInt(numeros.get(i));
			}

		}

		return resultado;

	}

}
