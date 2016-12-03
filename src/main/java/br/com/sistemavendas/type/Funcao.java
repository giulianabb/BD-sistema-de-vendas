package br.com.sistemavendas.type;

public enum Funcao {
	atendimento("Atendimento"),
	cozinha("Cozinha"),
	entrega("Entrega");
	
	private String funcao;

	private Funcao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	@Override
	public String toString() {
		return this.getFuncao();
	}
}
