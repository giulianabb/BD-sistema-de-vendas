package br.com.sistemavendas.container;

public class GastoPorCliente {
	
	private String nomeCompleto;
	private Integer torre;
	private Integer apartamento;
	private Integer numPedidos;
	private Double totalGasto;
	
	public GastoPorCliente() {
	}

	public GastoPorCliente(String nomeCompleto, Integer torre, Integer apartamento, Integer numPedidos,
			Double totalGasto) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.torre = torre;
		this.apartamento = apartamento;
		this.numPedidos = numPedidos;
		this.totalGasto = totalGasto;
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

	public Integer getNumPedidos() {
		return numPedidos;
	}

	public void setNumPedidos(Integer numPedidos) {
		this.numPedidos = numPedidos;
	}

	public Double getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(Double totalGasto) {
		this.totalGasto = totalGasto;
	}

	
}
