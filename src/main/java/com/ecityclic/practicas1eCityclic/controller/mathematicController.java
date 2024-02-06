package com.ecityclic.practicas1eCityclic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.ecityclic.practicas1eCityclic.beans.MathematicPetition;
import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.helper.MathematicOperationHelper;
import com.ecityclic.practicas1eCityclic.service.MathematicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/practica1/mathematic")
public class mathematicController {

	@Autowired
	private MathematicService mathematicService;
	@Autowired
	private MathematicOperationHelper mathematicOperationHelper;

	@PostMapping("/operation")
	@ResponseBody
	public int getResultOperationA(@RequestBody MathematicPetition mathematicPetition) {

		mathematicService.saveMathematicOperation(
				MathematicsOperationsEntity.builder().operationMath(mathematicPetition.getOperation()).build());

		return mathematicOperationHelper.bestTransOperation(mathematicPetition.getOperation());

	}

	@PostMapping("/operation/{operation}")
	@ResponseBody
	public int getResultOperationB(@PathVariable("operation") String operation) {

		mathematicService
				.saveMathematicOperation(MathematicsOperationsEntity.builder().operationMath(operation).build());

		return mathematicOperationHelper.bestTransOperation(operation);

	}

	@GetMapping("/getOperations")
	@ResponseBody
	public List<MathematicsOperationsEntity> getOperations() {

		List<MathematicsOperationsEntity> operationsList;

		return operationsList = mathematicService.getMathematicOperation();
	}

	@GetMapping("/getOperation")
	@ResponseBody
	public MathematicsOperationsEntity getOperatioForId(@RequestParam("id") int id) {

		return mathematicService.getMathematicOperationById(id);

	}

	@GetMapping("/getsuma")
	@ResponseBody
	public int getSoloSuma(@RequestParam("id") int id) {


		return mathematicOperationHelper.getSoloSuma(id);



		}
	
	/**
	 * quiero que recibas operaciones como:
	 *  localhost:8081/sumanNumeros?SUMA=1212&menos=2323&multiplica=22
	 * y que me devuelvas el resultado. Ademas, que guardes esta operacion en BD
	 * para poderlas listas luego en otro momento.
	 * 
	 * Quiero poder ver todas las operaciones que se han hecho
	 * 
	 * Quiero poder repetir una operacion.
	 * 
	 * Pra ahorrar espacio en la BVD, no se guardará el resultado de la operación
	 * Estse será siempre calculado.
	 */
	
	
//	@GetMapping("/sumaNumeros/{valores}")
//	@ResponseBody
//	public void sumaNumeros(@RequestParam Hash<String,Integer> valores) {
//		
//		
//		if(operacion.getValor().equals("SUMA")) {
//			
//		}
//		if("SUMA".equals(operacion.getValor()){
//			
//		}
//	}
		

	

}
