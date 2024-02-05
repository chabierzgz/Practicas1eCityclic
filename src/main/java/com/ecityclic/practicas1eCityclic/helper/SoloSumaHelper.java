package com.ecityclic.practicas1eCityclic.helper;

import java.util.ArrayList;
import java.util.List;

public class SoloSumaHelper {

	public int getSoloSuma(String numeros) {
		
		List<String> numero = new ArrayList<String>();
		String guardaNum="";
		int resultado = 0;
		
		for(int i=0;i<numeros.length();i++) {			
			if(numeros.isEmpty()) {
				numero.add(guardaNum);				
			}else {
				guardaNum = guardaNum + numeros.charAt(i);
			}			
		}
		
		for(int i=0;i<numero.size();i++) {
			resultado = resultado + Integer.parseInt(numero.get(i));
		}
		
		return resultado;
		
	}
}
