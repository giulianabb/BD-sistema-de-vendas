package br.com.sistemavendas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome_completo")
	private String nomeCompleto;
	@Column(name="torre")
	private Integer torre;
	@Column(name="apartamento")
	private Integer apartamento;
	@Column(name="telefone")
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
	public void setId(Long id) {
		this.id = id;
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
