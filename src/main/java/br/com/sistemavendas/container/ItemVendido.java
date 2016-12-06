package br.com.sistemavendas.container;

public class ItemVendido {
	
	private String nome;
	private String sabor;
	private Double preco;
	private Integer quantidade;
	private Double total;
	public ItemVendido(String nome, String sabor, Double preco, Integer quantidade, Double total) {
		super();
		this.nome = nome;
		this.sabor = sabor;
		this.preco = preco;
		this.quantidade = quantidade;
		this.total = total;
	}
	
	public ItemVendido() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
	
}
