package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.enums.OperationsEnum;
import com.ecityclic.practicas1eCityclic.service.MathematicService;

import lombok.extern.log4j.Log4j2;

@Log4j2
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

	public int sumaNumerosHash(HashMap<OperationsEnum, Integer> valores) {

		int resultado = 0;
		int numero = 0;
		String num = "";

		for (HashMap.Entry<OperationsEnum, Integer> datos : valores.entrySet()) {
			num=String.valueOf(datos.getValue());
			numero = Integer.valueOf(num);
			if (OperationsEnum.SUMA.name().equals(datos.getKey()) && datos.getValue() != null) {
				resultado = resultado + numero;
			} else if (OperationsEnum.RESTA.name().equals(datos.getKey()) && datos.getValue() != null) {
				resultado = resultado - numero;
			} else if (OperationsEnum.MULTIPLICACION.name().equals(datos.getKey()) && datos.getValue() != null) {
				resultado = resultado * datos.getValue();
			} else if (OperationsEnum.DIVISION.name().equals(datos.getKey()) && datos.getValue() != null) {
				resultado = resultado / datos.getValue();
			}

		}

		return resultado;
	}

	public String numerosStringHash(HashMap<OperationsEnum, Integer> valores) {

		String operacion = "";

		for (HashMap.Entry<OperationsEnum, Integer> datos : valores.entrySet()) {

			if (OperationsEnum.SUMA.name().equals(datos.getKey())) {
				operacion = operacion + OperationsEnum.SUMA.getSigno();
				operacion = operacion + String.valueOf(datos.getValue());
			} else if (OperationsEnum.RESTA.name().equals(datos.getKey())) {
				operacion = operacion + OperationsEnum.RESTA.getSigno();
				operacion = operacion + String.valueOf(datos.getValue());
			} else if (OperationsEnum.MULTIPLICACION.name().equals(datos.getKey())) {
				operacion = operacion + OperationsEnum.MULTIPLICACION.getSigno();
				operacion = operacion + String.valueOf(datos.getValue());
			} else if (OperationsEnum.DIVISION.name().equals(datos.getKey())) {
				operacion = operacion + OperationsEnum.DIVISION.getSigno();
				operacion = operacion + String.valueOf(datos.getValue());
			}else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "operador no válido");
			}

		}

		return operacion;
	}

	public int sumaNumerosList(List<Integer> valores) {
		int resultado = 0;
		for (int i = 0; i < valores.size(); i++) {
			resultado += valores.get(i);
		}

		return resultado;
	}

	public String operacionListToString(List<Integer> valores) {
		String espacio = " ";

		return String.join(espacio, String.valueOf(valores));
	}

	public double getOperation(List<String> valores) {

		double resultado = 0;
		double numero = 0;
		String operador = "";

		for (String valor : valores) {
			String[] separa = valor.split("=");
			operador = separa[0];
			numero = Double.valueOf(separa[1]);
			log.info("Operador = [{}] y numero = [{}]", operador, numero);

			if (OperationsEnum.SUMA.name().equalsIgnoreCase(operador)) {
				resultado += numero;
			} else if (OperationsEnum.RESTA.name().equalsIgnoreCase(operador)) {
				resultado -= numero;
			} else if (OperationsEnum.MULTIPLICACION.name().equalsIgnoreCase(operador)) {
				resultado *= numero;
			} else if (OperationsEnum.DIVISION.name().equalsIgnoreCase(operador)) {
				resultado /= numero;
			}else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "operación no valida");
			}
		}
		log.info("Resultado= [{}] ", resultado);
		return resultado;
	}

	public String calculoToString(List<String> valores) {
		String espacio = ",";
		return String.join(espacio, valores);
	}

	public List<String> stringToList(int id) {
		MathematicsOperationsEntity mathematicsOperationsEntity = mathematicService.getMathematicOperationById(id);
		String operacion = mathematicsOperationsEntity.getOperationMath();
		List<String> addOperaciones = new ArrayList<String>();
		String[] separaOperaciones = operacion.split(",");
		for (String operaciones : separaOperaciones) {
			addOperaciones.add(operaciones);
		}
		return addOperaciones;
	}
	
	public void savefecha

}
