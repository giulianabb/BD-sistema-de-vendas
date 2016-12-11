package br.com.sistemavendas.type;

public enum StatusPedido {
	aguardo("Aguardando"),
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

	public static String qualStatus(String codigo) {
		for(StatusPedido status : StatusPedido.values()) {
			if(status.name().equals(codigo)) {
				return status.getStatus();
			}
		}
		return null;
	}
	
}
