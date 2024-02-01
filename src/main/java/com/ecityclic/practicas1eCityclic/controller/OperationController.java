package com.ecityclic.practicas1eCityclic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecityclic.practicas1eCityclic.beans.NumberPetition;
import com.ecityclic.practicas1eCityclic.beans.PersonPetition;
import com.ecityclic.practicas1eCityclic.helper.OperacionesHelper;


@RestController
@RequestMapping("/practica1/operaciones")
public class OperationController {
	
	@Autowired
	private OperacionesHelper operacionesHelper;
	
//	@Autowired
//	private NumberPetition numberPetition;
	
	@GetMapping("/suma/{num1}/{num2}")
	public int getSuma(@PathVariable("num1")int num1, @PathVariable("num2") int num2) {
		return operacionesHelper.suma(num1, num2);
	}
	
	@GetMapping("/resta")
	public int getResta(@RequestBody NumberPetition numberPetition) {
		
		return operacionesHelper.resta(numberPetition.getNumUno(), numberPetition.getNumDos());
		
	}	
	
	@GetMapping("/multiplica")
	public int getMultiplica(@RequestBody NumberPetition numberPetition) {
		
		return operacionesHelper.multiplica(numberPetition.getNumUno(), numberPetition.getNumDos());
		
	}
	
	@GetMapping("/exponente/{num1}/{num2}")
	public double getExponente(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
		
		return operacionesHelper.potenciaExponente(num1, num2);
		
	}

}
