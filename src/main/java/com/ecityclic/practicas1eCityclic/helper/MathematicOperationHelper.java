package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.enums.OperationsEnum;
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

	public int sumaNumeros(HashMap<OperationsEnum, Integer> valores) {

		int resultado = 0;

		for (Map.Entry<OperationsEnum, Integer> datos : valores.entrySet()) {

			if (datos.getKey().equals(OperationsEnum.SUMA)) {
				resultado = resultado + datos.getValue();
			} else if (datos.getKey().equals(OperationsEnum.RESTA)) {
				resultado = resultado - datos.getValue();
			} else if (datos.getKey().equals(OperationsEnum.MULTIPLICACION)) {
				resultado = resultado * datos.getValue();
			}else if (datos.getKey().equals(OperationsEnum.DIVISION)) {
				resultado = resultado / datos.getValue();
			}

		}

		return resultado;
	}

	public String sumaNumerosString(HashMap<OperationsEnum, Integer> valores) {

		String operacion = "";

		for (Map.Entry<OperationsEnum, Integer> datos : valores.entrySet()) {

			if ("suma".equals(datos.getKey())) {
				operacion = operacion + OperationsEnum.SUMA.getSigno();
			} else if (datos.getKey().equals(OperationsEnum.RESTA)) {
				operacion = operacion + OperationsEnum.RESTA.getSigno();
			} else if (datos.getKey().equals(OperationsEnum.MULTIPLICACION)) {
				operacion = operacion + OperationsEnum.MULTIPLICACION.getSigno();
			} else if (datos.getKey().equals(OperationsEnum.DIVISION)) {
				operacion = operacion + OperationsEnum.DIVISION.getSigno();
			} else {
				operacion = operacion + String.valueOf(datos.getValue());
			}

		}

		return operacion;

	}

}
