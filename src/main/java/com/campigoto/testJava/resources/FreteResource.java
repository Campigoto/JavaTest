package com.campigoto.testJava.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campigoto.testJava.DTO.FreteDTO;
import com.campigoto.testJava.DTO.FreteInputDTO;
import com.campigoto.testJava.services.FreteService;

@RestController
@RequestMapping(value = "/frete")
public class FreteResource {
	
	@Autowired
	private FreteService freteService;	

	@PostMapping("/calcular")
	public ResponseEntity<FreteDTO> calcular(@Valid @RequestBody FreteInputDTO dto) {
		FreteDTO response = freteService.calcular(dto);
		return ResponseEntity.ok(response);
	}

}
