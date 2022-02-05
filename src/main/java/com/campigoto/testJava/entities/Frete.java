package com.campigoto.testJava.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_frete")
public class Frete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDestinatario;
	private String cepOrigem;
	private String cepDestino;
	private Double peso;
	private Double vlTotalFrete;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataPrevistaEntrega;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataConsulta;
	
	public Frete() {
		
	}
	
	public Frete(Long id, String nomeDestinatario, String cepOrigem, String cepDestino, Double peso,
			Double vlTotalFrete, Instant dataPrevistaEntrega, Instant dataConsulta) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso;
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
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

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frete other = (Frete) obj;
		return Objects.equals(id, other.id);
	}


	
	
}
