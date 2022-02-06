package com.campigoto.testJava.services;

import java.time.Instant;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campigoto.testJava.DTO.BuscaCEPDTO;
import com.campigoto.testJava.DTO.FreteDTO;
import com.campigoto.testJava.DTO.FreteInputDTO;
import com.campigoto.testJava.entities.Frete;
import com.campigoto.testJava.repositories.FreteRepository;

@Service
public class FreteService {

	@Autowired
	private FreteRepository freteRepository;

	@Autowired
	private CepService cepService;

	
	private Frete copyDtoToEntity(FreteInputDTO dto) {
		Frete entity = new Frete();
		entity.setNomeDestinatario(dto.getNomeDestinatario());
		entity.setCepDestino(dto.getCepDestino());
		entity.setCepOrigem(dto.getCepOrigem());
		entity.setPeso(dto.getPeso());
		return entity;
	}

	public FreteDTO calcular(FreteInputDTO dto) {

		BuscaCEPDTO origem = cepService.buscar(dto.getCepOrigem());
		BuscaCEPDTO destino = cepService.buscar(dto.getCepDestino());

		 Double vlFrete = 0.0;
		Instant dataConsulta =  Instant.now();
		Instant dataPrevisaoEntrega = dataConsulta;
		
		if (origem.getDdd().equals(destino.getDdd())) {
			vlFrete = dto.getPeso() / 2;
			dataPrevisaoEntrega = dataPrevisaoEntrega.plus(Period.ofDays(1));
			
		} else if (origem.getUf().equals(destino.getUf())) {
			vlFrete = dto.getPeso() * .25;
			dataPrevisaoEntrega =  dataPrevisaoEntrega.plus(Period.ofDays(3));
		} else {
			vlFrete = dto.getPeso();
			dataPrevisaoEntrega =  dataPrevisaoEntrega.plus(Period.ofDays(10));
		}

		

		Frete entity = copyDtoToEntity(dto);
		entity.setDataConsulta(dataConsulta);
		entity.setDataPrevistaEntrega(dataPrevisaoEntrega);
		entity.setVlTotalFrete(vlFrete);
		entity = freteRepository.save(entity);
		return new FreteDTO(entity);
	}

}
