package com.ecityclic.practicas1eCityclic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecityclic.practicas1eCityclic.beans.MathematicPetition;
import com.ecityclic.practicas1eCityclic.entity.MathematicsOperations;
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

		mathematicService.saveMathematicOperation(MathematicsOperations.builder().operationMath(mathematicPetition.getOperation()).build());

		return mathematicOperationHelper.transOperation(mathematicPetition.getOperation());

	}

	@PostMapping("/operation/{operation}")
	@ResponseBody
	public int getResultOperationB(@PathVariable("operation") String operation) {

		mathematicService.saveMathematicOperation(MathematicsOperations.builder().operationMath(operation).build());

		return mathematicOperationHelper.transOperation(operation);

	}

	@GetMapping("/getoperations")
	@ResponseBody
	public List<MathematicsOperations> getOperations() {
		
		List<MathematicsOperations> operationsList;

		return operationsList = mathematicService.getMathematicOperation();
	}
	
	

//	@GetMapping("/getOperation/{id}")
//	@ResponseBody
//	public String getOperatioForId(@PathVariable("id") int id)) {
//		
//		mathematicService.getMathematicOperationById(id);
//		MathematicsOperations.builder().id(id).
//		
//		return mathematicService.getClass();
//	}

}
