package br.com.sistemavendas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.MeioDeContato;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date data;
	@Enumerated(EnumType.STRING)
	private DiaDaSemana diaDaSemana;
	private String status;
	private Boolean cortesia;
	@Enumerated(EnumType.STRING)
	private MeioDeContato meioDeContato;

	public Pedido() {
	}

	public Pedido(Long id, Date data, DiaDaSemana diaDaSemana, String status, Boolean cortesia,
			MeioDeContato meioDeContato) {
		super();
		this.id = id;
		this.data = data;
		this.diaDaSemana = diaDaSemana;
		this.status = status;
		this.cortesia = cortesia;
		this.meioDeContato = meioDeContato;
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

}
