package br.com.sistemavendas.container;

import br.com.sistemavendas.model.Funcionario;

public class ItemPedidoPorDia {
	private String nome;
	private Integer quantidade;
	private Double total;
	private Funcionario funcionario;
	
	public ItemPedidoPorDia() {
	}
	
	public ItemPedidoPorDia(String nome, Integer quantidade, Double total, Funcionario funcionario) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.total = total;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	

}
