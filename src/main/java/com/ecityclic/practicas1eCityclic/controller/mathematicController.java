package com.ecityclic.practicas1eCityclic.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecityclic.practicas1eCityclic.beans.MathematicPetition;
import com.ecityclic.practicas1eCityclic.entity.MathematicsOperationsEntity;
import com.ecityclic.practicas1eCityclic.enums.OperationsEnum;
import com.ecityclic.practicas1eCityclic.helper.MathematicOperationHelper;
import com.ecityclic.practicas1eCityclic.service.MathematicService;

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

	@GetMapping("/sumavalores")
	@ResponseBody
	public int getResultSumaNumeros(@RequestParam HashMap<OperationsEnum, Integer> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.numerosStringHash(valores)).build());

		return mathematicOperationHelper.sumaNumerosHash(valores);
	}

	@GetMapping("/sumanumeros")
	@ResponseBody
	public int getSumaNumeros(@RequestParam List<Integer> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.operacionToStringList(valores)).build());
		return mathematicOperationHelper.sumaNumerosList(valores);
	}

	@GetMapping("/obtenercalculo")
	@ResponseBody
	public Double getCalculo(@RequestParam List<String> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.calculoToString(valores)).build());

		return mathematicOperationHelper.getOperation(valores);
	}

	@GetMapping("/recuperaoperacion")
	@ResponseBody
	public Double getRecuperaOperacion(@RequestParam int id) {

		return mathematicOperationHelper.getOperation(mathematicOperationHelper.stringToList(id));
	}

	/**
	 * quiero que recibas operaciones como:
	 * localhost:8081/sumanNumeros?SUMA=1212&menos=2323&multiplica=22 y que me
	 * devuelvas el resultado. Ademas, que guardes esta operacion en BD para
	 * poderlas listas luego en otro momento.
	 * 
	 * Quiero poder ver todas las operaciones que se han hecho
	 * 
	 * Quiero poder repetir una operacion.
	 * 
	 * Pra ahorrar espacio en la BD, no se guardará el resultado de la operación
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
