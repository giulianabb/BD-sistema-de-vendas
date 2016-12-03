package br.com.sistemavendas.type;

public enum MeioDeContato {
	telefone("Telefone"),
	whastapp("WhatsApp"),
	facebook("Facebook"),
	outros("Outros");
	
	private String meio;
	
	private MeioDeContato(String meio) {
		this.meio = meio;
	}
	
	public String getMeio() {
		return meio;
	}
	
	@Override
	public String toString() {
		return this.getMeio();
	}
}
