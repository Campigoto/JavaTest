package com.campigoto.testJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campigoto.testJava.DTO.BuscaCEPDTO;
import com.campigoto.testJava.DTO.FreteDTO;
import com.campigoto.testJava.entities.Frete;
import com.campigoto.testJava.repositories.FreteRepository;

@Service
public class FreteService {

	@Autowired
	private FreteRepository freteRepository;

	@Transactional
	public FreteDTO insert(FreteDTO dto) {
		Frete entity = new Frete();
		copyDtoToEntity(dto, entity);
		entity = freteRepository.save(entity);
		return new FreteDTO(entity);
	}

	// Pode criar uma classe de "Mapper"
	// pode nomear como dtoToEntity (isso é opcional, aí tu ve que nome tu acha
	// melhor)
	private void copyDtoToEntity(FreteDTO dto, Frete entity) {

		entity.setNomeDestinatario(dto.getNomeDestinatario());
		entity.setCepDestino(dto.getCepDestino());
		entity.setCepOrigem(dto.getCepOrigem());
		entity.setDataConsulta(dto.getDataConsulta());
		entity.setPeso(dto.getPeso());
		entity.setDataPrevistaEntrega(dto.getDataPrevistaEntrega());
		entity.setVlTotalFrete(dto.getVlTotalFrete());

	}
	
	public FreteDTO calcular(BuscaCEPDTO origem, BuscaCEPDTO destino, Double peso, String destinatario) {
		
		// calcula os fente ae
		Frete entity = new Frete();
		
		entity = freteRepository.save(entity);
		return new FreteDTO(entity);
	}

}
