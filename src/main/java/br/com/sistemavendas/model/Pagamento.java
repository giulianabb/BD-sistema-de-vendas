package br.com.sistemavendas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.sistemavendas.type.TipoPagamento;

@Entity
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipo;
	private Double valor;
	private Boolean efetuado;
	@Column(name="data_pagamento")
	private Date dataPagamento;
	
	public Pagamento() {
	}

	public Pagamento(Long id, TipoPagamento tipo, Double valor, Boolean efetuado, Date dataPagamento) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.efetuado = efetuado;
		this.dataPagamento = dataPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getEfetuado() {
		return efetuado;
	}

	public void setEfetuado(Boolean efetuado) {
		this.efetuado = efetuado;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
