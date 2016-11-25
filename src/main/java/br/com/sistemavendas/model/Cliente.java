package br.com.sistemavendas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nomeCompleto;
	private Integer torre;
	private Integer apartamento;
	private String telefone;
	
	public Cliente() {
	}
	
	public Cliente(Long id, String nomeCompleto, Integer torre, Integer apartamento, String telefone) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.torre = torre;
		this.apartamento = apartamento;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public Integer getTorre() {
		return torre;
	}
	public void setTorre(Integer torre) {
		this.torre = torre;
	}
	public Integer getApartamento() {
		return apartamento;
	}
	public void setApartamento(Integer apartamento) {
		this.apartamento = apartamento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
