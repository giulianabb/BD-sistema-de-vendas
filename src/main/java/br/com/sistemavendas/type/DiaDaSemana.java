package br.com.sistemavendas.type;

public enum DiaDaSemana {
	segunda ("Segunda-feira"),
	terca ("Terça-feira"),
	quarta ("Quarta-feira"),
	quinta ("Quinta-feira"),
	sexta ("Sexta-feira"),
	sabado ("Sábado"),
	domingo ("Domingo");
	
	private String dia;
	
	private DiaDaSemana(String dia) {
		this.dia = dia;
	}
	
	private DiaDaSemana() {
	}
}
