package br.com.sistemavendas.type;

public enum TipoPagamento {
	dinheiro("Dinheiro"),
	deposito("Depósito bancário"),
	debito("Cartão de débito"),
	credito("Cartão de crédito"),
	cheque("Cheque");
	
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
