package com.campigoto.testJava.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.campigoto.testJava.DTO.BuscaCEPDTO;
import com.campigoto.testJava.resources.exceptions.CepNotFoundException;
import com.campigoto.testJava.services.exceptions.ResourceNotFoundException;

@Service
public class CepService {

	private String CEP_API = "https://viacep.com.br/ws/";

	public BuscaCEPDTO buscar(String cep) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = CEP_API + cep + "/json";

			ResponseEntity<BuscaCEPDTO> response = restTemplate.getForEntity(url, BuscaCEPDTO.class);
			if (response.getStatusCodeValue() >= 200 && response.getStatusCodeValue() < 299) {
				if (!response.getBody().getErro()) {
					return response.getBody();
				} else {
					
					throw new CepNotFoundException();
				}
			} else {
				
				throw new ResourceNotFoundException("Falha ao buscar cep:" + cep);
			}

		} catch (Exception e) {
			throw new ResourceNotFoundException("Falha ao buscar cep: " + cep);
		}
	}

}
