package com.ecityclic.practicas1eCityclic.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NumberPetition {
	private int numUno;
	private int numDos;

}
