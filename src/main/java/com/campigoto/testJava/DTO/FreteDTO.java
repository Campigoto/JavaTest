package com.campigoto.testJava.DTO;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.campigoto.testJava.entities.Frete;

public class FreteDTO implements Serializable {
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
	
	private Double vlTotalFrete ;
	
	@FutureOrPresent(message = "A data do prevista não pode ser no passado !")
	private Instant dataPrevistaEntrega;
	
	@PastOrPresent(message = "Data incorreta !")
	private Instant dataConsulta;

	public FreteDTO() {
	}

	public FreteDTO(Long id, String nomeDestinatario, String cepOrigem, String cepDestino,
			Double peso, Double vlTotalFrete, Instant dataPrevistaEntrega, Instant dataConsulta) {
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso ;
		this.setVlTotalFrete(vlTotalFrete);
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}
	
	public FreteDTO(Frete entity) {
		this.id = entity.getId();
		this.nomeDestinatario = entity.getNomeDestinatario();
		this.cepOrigem = entity.getCepOrigem();
		this.cepDestino = entity.getCepDestino();
		this.peso = entity.getPeso();
		this.setVlTotalFrete(entity.getVlTotalFrete());
		this.dataPrevistaEntrega = entity.getDataPrevistaEntrega();
		this.dataConsulta = entity.getDataConsulta();
		
	}

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
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

	public Instant getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Instant dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public Instant getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Instant dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	
	
}
