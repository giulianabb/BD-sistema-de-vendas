package br.com.sistemavendas.container;

import java.util.List;
import java.util.Map;

import br.com.sistemavendas.model.Cliente;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Solicita;

public class HistoricoPedidos {
	
	private Cliente cliente;
	private List<Solicita> solicitacoes;
	private Map<Long, List<ItemPedido>> itensPorPedido;
	
	public HistoricoPedidos() {
	}

	public HistoricoPedidos(Cliente cliente, List<Solicita> solicitacoes, Map<Long, List<ItemPedido>> itensPorPedido) {
		super();
		this.cliente = cliente;
		this.solicitacoes = solicitacoes;
		this.itensPorPedido = itensPorPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Solicita> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicita> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public Map<Long, List<ItemPedido>> getItensPorPedido() {
		return itensPorPedido;
	}

	public void setItensPorPedido(Map<Long, List<ItemPedido>> itensPorPedido) {
		this.itensPorPedido = itensPorPedido;
	}
	
}
