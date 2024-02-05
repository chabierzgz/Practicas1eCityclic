package com.ecityclic.practicas1eCityclic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecityclic.practicas1eCityclic.entity.SoloSumaEntity;
import com.ecityclic.practicas1eCityclic.helper.SoloSumaHelper;
import com.ecityclic.practicas1eCityclic.service.SoloSumaService;

@RestController
@RequestMapping("/suma")
public class SoloSumaController {

	@Autowired
	private SoloSumaService soloSumaService;

	@Autowired
	private SoloSumaHelper soloSumaHelper;

	@PostMapping("/resultado/{numeros}")
	@ResponseBody
	public int getResultadoSuma(@PathVariable("numeros") String numeros) {

		soloSumaService.saveSuma(SoloSumaEntity.builder().soloSuma(numeros).build());

		return soloSumaHelper.getSoloSuma(numeros);
	}

}
