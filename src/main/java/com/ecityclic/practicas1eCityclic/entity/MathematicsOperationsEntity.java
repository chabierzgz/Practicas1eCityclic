package com.ecityclic.practicas1eCityclic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ecityclic.practicas1eCityclic.beans.MathematicPetition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MathematicsOperations {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String operationMath;

}
