package com.ecityclic.practicas1eCityclic.helper;

import org.springframework.stereotype.Component;

@Component
public class MathematicOperationHelper {

	public int transOperation(String operation) {

		int tam = operation.length();
		String A[] = new String[100];
		// Array para almacenar operadores.
		String operaciones[] = new String[100];
		int pos = 0;
		int sum = 0;
		String aux = "";

		// inicializa primer operador.
		operaciones[0] = "+";
		int index_operacion = 1;
		for (int i = 0; i < tam; i++) {
			if (operation.charAt(i) == '+' || operation.charAt(i) == '-') {
				A[pos] = aux;
				operaciones[index_operacion] = String.valueOf(operation.charAt(i));
				pos++;
				index_operacion++;
				aux = "";
			} else {
				aux = aux + operation.charAt(i);
			}
		}
		A[pos] = aux;
		pos++;

		for (int i = 0; i < pos; i++) {
			// Determina la operación a realizar.
			if (operaciones[i].equals("+")) {
				sum = sum + Integer.parseInt(A[i]);
			} else if (operaciones[i].equals("-")) {
				sum = sum - Integer.parseInt(A[i]);
			}

		}
		
		return sum;
//		System.out.println("=  " + sum);
	}

}
