package com.campigoto.testJava.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.campigoto.testJava.DTO.BuscaCEPDTO;
import com.campigoto.testJava.DTO.FreteDTO;
import com.campigoto.testJava.services.CepService;
import com.campigoto.testJava.services.FreteService;

@RestController
@RequestMapping(value = "/frete")
public class FreteResource {
	
	@Autowired
	private FreteService freteService;
	
	@Autowired
	private CepService cepService;
	

	@PostMapping
	public ResponseEntity<FreteDTO> insert(@Valid @RequestBody FreteDTO dto) {
		dto = freteService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping("/calcular")
	public ResponseEntity<FreteDTO> calcular(
			@RequestParam("peso") Double peso, 
			@RequestParam("cepOrigem") String cepOrigem, 
			@RequestParam("cepDestino") String cepDestino,
			@RequestParam("nomeDestinatario") String nomeDestinatario) {
		
		
		// Criar serviço para busca de cep na API
		BuscaCEPDTO origem = cepService.buscar(cepOrigem);
		BuscaCEPDTO destino = cepService.buscar(cepDestino);
		
		// Calcular frete -tem que passar os outros dados ali pra salvar na entidade tbm
		// FreteDTO frete = freteService.calcular(origem, destino, peso, nomeDestinatario);
		return ResponseEntity.ok(new FreteDTO());
	}

}
