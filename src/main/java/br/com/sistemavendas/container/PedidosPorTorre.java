package br.com.sistemavendas.container;

public class PedidosPorTorre {
	
	private Integer torre;
	private Double valorTotal;
	private Integer numPedidos;
	private Double mediaPorPedido;
	
	public PedidosPorTorre() {
	}

	public PedidosPorTorre(Integer torre, Double valorTotal, Integer numPedidos, Double mediaPorPedido) {
		super();
		this.torre = torre;
		this.valorTotal = valorTotal;
		this.numPedidos = numPedidos;
		this.mediaPorPedido = mediaPorPedido;
	}

	public Integer getTorre() {
		return torre;
	}

	public void setTorre(Integer torre) {
		this.torre = torre;
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
