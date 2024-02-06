package com.ecityclic.practicas1eCityclic.enums;

import lombok.Getter;

@Getter
public enum OperationsEnum {
	RESTA("-"),
	SUMA("+"),
	MULTIPLICACION("*"),
	DIVISION("/")
	;
	

	private String signo;
	
	
	OperationsEnum(String signo) {
		this.signo = signo;
	}
}
