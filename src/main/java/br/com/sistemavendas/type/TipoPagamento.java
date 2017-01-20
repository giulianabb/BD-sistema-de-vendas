package br.com.sistemavendas.type;

public enum TipoPagamento {
	credito("Cartão de crédito"),
	debito("Cartão de débito"),
	cheque("Cheque"),
	deposito("Depósito bancário"),
	dinheiro("Dinheiro");
	
	private String pagamento;

	private TipoPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	public String getPagamento() {
		return pagamento;
	}
	
	@Override
	public String toString() {
		return this.getPagamento();
	}
	
	
}
