package br.com.sistemavendas.type;

public enum Funcao {
	atendimento("Atendimento"),
	cozinha("Cozinha"),
	entrega("Entrega");
	
	private String funcao;

	private Funcao(String funcao) {
		this.funcao = funcao;
	}
}
