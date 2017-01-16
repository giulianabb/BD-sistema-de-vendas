package br.com.sistemavendas.container;

import java.util.List;

import br.com.sistemavendas.model.Cliente;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Solicita;

public class HistoricoPedidos {
	
	private Cliente cliente;
	private List<Solicita> solicitacoes;
	private List<List<ItemPedido>> itensPorPedido;
	
	public HistoricoPedidos() {
	}

	public HistoricoPedidos(Cliente cliente, List<Solicita> solicitacoes, List<List<ItemPedido>> itensPorPedido) {
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

	public List<List<ItemPedido>> getItensPorPedido() {
		return itensPorPedido;
	}

	public void setItensPorPedido(List<List<ItemPedido>> itensPorPedido) {
		this.itensPorPedido = itensPorPedido;
	}
	
}
