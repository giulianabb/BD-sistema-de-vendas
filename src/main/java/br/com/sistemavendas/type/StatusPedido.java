package br.com.sistemavendas.type;

public enum StatusPedido {
	preparo("Em preparo"),
	para_entrega("Saiu para entrega"),
	finalizado("Pedido finalizado");
	
	private String status;
	
	StatusPedido(final String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return this.getStatus();
	}

}
