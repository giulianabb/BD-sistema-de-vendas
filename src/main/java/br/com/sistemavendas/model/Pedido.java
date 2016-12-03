package br.com.sistemavendas.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.MeioDeContato;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="data_pedido")
	private Date data;
	
	@Enumerated(EnumType.STRING)
	@Column(name="dia_semana")
	private DiaDaSemana diaDaSemana;
	
	@Column(name="status_pedido")
	private String status;
	private Boolean cortesia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="meio_de_contato")
	private MeioDeContato meioDeContato;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens;
	
	
	public Pedido() {
	}

	public Pedido(Long id, Date data, DiaDaSemana diaDaSemana, String status, Boolean cortesia,
			MeioDeContato meioDeContato, Set<ItemPedido> itens) {
		super();
		this.id = id;
		this.data = data;
		this.diaDaSemana = diaDaSemana;
		this.status = status;
		this.cortesia = cortesia;
		this.meioDeContato = meioDeContato;
		this.itens = itens;
	}

	public Long getId() {
		return id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getCortesia() {
		return cortesia;
	}

	public void setCortesia(Boolean cortesia) {
		this.cortesia = cortesia;
	}

	public MeioDeContato getMeioDeContato() {
		return meioDeContato;
	}

	public void setMeioDeContato(MeioDeContato meioDeContato) {
		this.meioDeContato = meioDeContato;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

}
