package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.service.MathematicService;

@Component
public class MathematicOperationHelper {

	@Autowired
	MathematicService mathematicService;

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

	public int getSoloSuma(int id) {

		MathematicsOperationsEntity mathematicsOperationsEntity = mathematicService.getMathematicOperationById(id);

		String operacion = mathematicsOperationsEntity.getOperationMath();
		List<String> numero = new ArrayList<String>();
		String guardaNum = "";
		int resultado = 0;

		for (int i = 0; i < operacion.length(); i++) {
			if (operacion.charAt(i) == '+') {
				numero.add(guardaNum);
			} else if (operacion.charAt(i) == '-') {
				i = operacion.length();
				throw new ResponseStatusException(HttpStatus.FOUND, "La operación seleccionada no es una suma");
			} else {
				guardaNum = guardaNum + operacion.charAt(i);
			}
		}

		for (int i = 0; i < numero.size(); i++) {
			resultado = resultado + Integer.parseInt(numero.get(i));
		}

		return resultado;

	}

}
