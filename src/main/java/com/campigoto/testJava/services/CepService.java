package com.campigoto.testJava.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.campigoto.testJava.DTO.BuscaCEPDTO;

@Service
public class CepService {

	private String CEP_API = "https://viacep.com.br/ws/";

	public BuscaCEPDTO buscar(String cep) {

		RestTemplate restTemplate = new RestTemplate();
		String url = CEP_API + cep + "/json";

		return restTemplate.getForObject(url, BuscaCEPDTO.class);
	}
}
