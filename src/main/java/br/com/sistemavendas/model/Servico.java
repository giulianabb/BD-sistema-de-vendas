package br.com.sistemavendas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sistemavendas.type.Funcao;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	@Enumerated(EnumType.STRING)
	private Funcao funcao;
	
	public Servico() {
	}

	public Servico(Long id, Pedido pedido, Funcionario funcionario, Funcao funcao) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.funcionario = funcionario;
		this.funcao = funcao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}
