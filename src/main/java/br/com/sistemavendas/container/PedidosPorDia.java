package br.com.sistemavendas.container;

import br.com.sistemavendas.type.DiaDaSemana;

public class PedidosPorDia {
	
	private DiaDaSemana dia;
	private Double valorTotal;
	private Integer numPedidos;
	private Double mediaPorPedido;
	
	public PedidosPorDia(DiaDaSemana dia, Double valorTotal, Integer numPedidos, Double mediaPorPedido) {
		super();
		this.dia = dia;
		this.valorTotal = valorTotal;
		this.numPedidos = numPedidos;
		this.mediaPorPedido = mediaPorPedido;
	}
	
	public PedidosPorDia() {
	}

	public DiaDaSemana getDia() {
		return dia;
	}
	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getNumPedidos() {
		return numPedidos;
	}
	public void setNumPedidos(Integer numPedidos) {
		this.numPedidos = numPedidos;
	}
	public Double getMediaPorPedido() {
		return mediaPorPedido;
	}
	public void setMediaPorPedido(Double mediaPorPedido) {
		this.mediaPorPedido = mediaPorPedido;
	}
	
}
