package com.campigoto.testJava.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.campigoto.testJava.entities.Frete;

public class FreteInputDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String nomeDestinatario;
	
	@Size(min = 8, max = 8, message = "Deve ter 8 caracteres")
	@NotBlank(message = "Campo requerido")
	private String cepOrigem;
	
	@Size(min = 8, max = 8, message = "Deve ter 8 caracteres")
	@NotBlank(message = "Campo requerido")
	private String cepDestino;
	
	@NotNull(message = "Campo requerido")
	private Double peso;
	
	

	public FreteInputDTO() {
	}

	public FreteInputDTO(Long id, String nomeDestinatario, String cepOrigem, String cepDestino,
			Double peso) {
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso ;
	}
	
	public FreteInputDTO(Frete entity) {
		this.id = entity.getId();
		this.nomeDestinatario = entity.getNomeDestinatario();
		this.cepOrigem = entity.getCepOrigem();
		this.cepDestino = entity.getCepDestino();
		this.peso = entity.getPeso();
		
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
