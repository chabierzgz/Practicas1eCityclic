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

	@PostMapping(path ="/operation" , produces="application/json", consumes="application/json")
	@ResponseBody
	public int getResultOperationA(@RequestBody MathematicPetition mathematicPetition) {

		mathematicService.saveMathematicOperation(
				MathematicsOperationsEntity.builder().operationMath(mathematicPetition.getOperation()).build());

		return mathematicOperationHelper.bestTransOperation(mathematicPetition.getOperation());

	}

	@PostMapping(path="/operations/{operation}")
	@ResponseBody
	public Integer getResultOperationB(@PathVariable String operation) {

		mathematicService
				.saveMathematicOperation(MathematicsOperationsEntity.builder().operationMath(operation).build());

		return mathematicOperationHelper.bestTransOperation(operation);

	}

	@GetMapping(path="/getOperations", produces="application/json")
	@ResponseBody
	public List<MathematicsOperationsEntity> getOperations() {

		return mathematicService.getMathematicOperation();
	}

	@GetMapping(path="/getOperation", produces="application/json")
	@ResponseBody
	public MathematicsOperationsEntity getOperatioForId(@RequestParam("id") int id) {

		return mathematicService.getMathematicOperationById(id);

	}

	@GetMapping(path="/getsuma", produces="application/json")
	@ResponseBody
	public int getSoloSuma(@RequestParam("id") int id) {

		return mathematicOperationHelper.getSoloSuma(id);

	}

	@GetMapping(path="/sumavalores", produces="application/json")
	@ResponseBody
	public int getResultSumaNumeros(@RequestParam HashMap<OperationsEnum, Integer> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.numerosStringHash(valores)).build());

		return mathematicOperationHelper.sumaNumerosHash(valores);
	}

	@GetMapping(path="/sumanumeros", produces="application/json")
	@ResponseBody
	public int getSumaNumeros(@RequestParam List<Integer> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.operacionListToString(valores)).build());
		return mathematicOperationHelper.sumaNumerosList(valores);
	}

	@GetMapping(path="/obtenercalculo", produces="application/json")
	@ResponseBody
	public Double getCalculo(@RequestParam List<String> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.calculoToString(valores)).build());

		return mathematicOperationHelper.getOperation(valores);
	}
	
	@GetMapping(path="/obtenercalculos/{valores}", produces="application/json")
	@ResponseBody
	public Double getCalculoPath(@PathVariable("valores") List<String> valores) {

		mathematicService.saveMathematicOperation(MathematicsOperationsEntity.builder()
				.operationMath(mathematicOperationHelper.calculoToString(valores)).build());

		return mathematicOperationHelper.getOperation(valores);
	}

	@GetMapping(path="/recuperaoperacion", produces="application/json")
	@ResponseBody
	public Double getRecuperaOperacion(@RequestParam int id) {

		return mathematicOperationHelper.getOperation(mathematicOperationHelper.stringToList(id));
	}
	
	@GetMapping(path="/mostraroperaciones", produces="application/json")
	@ResponseBody
	public List<MathematicsOperationsEntity> getMethodName() {
		return mathematicService.getMathematicOperation();
	}
	
	
	

}
