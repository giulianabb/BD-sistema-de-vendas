package br.com.sistemavendas.container;

import java.util.Date;

import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.StatusPedido;

public class PedidoComCliente {
	
	private Long id;
	private String nomeCompleto;
	private Integer torre;
	private Integer apartamento;
	private Date data;
	private DiaDaSemana diaDaSemana;
	private StatusPedido status;
	private Boolean cortesia;
	
	public PedidoComCliente() {
	}

	public PedidoComCliente(Long id, String nomeCompleto, Integer torre, Integer apartamento, Date data,
			DiaDaSemana diaDaSemana, StatusPedido status, Boolean cortesia) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.torre = torre;
		this.apartamento = apartamento;
		this.data = data;
		this.diaDaSemana = diaDaSemana;
		this.status = status;
		this.cortesia = cortesia;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Boolean getCortesia() {
		return cortesia;
	}

	public void setCortesia(Boolean cortesia) {
		this.cortesia = cortesia;
	}

}
