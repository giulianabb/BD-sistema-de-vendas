package br.com.sistemavendas.DAOCustom;

import java.util.List;

import br.com.sistemavendas.model.Pedido;

public interface PedidoDAOCustom {

	public List<Pedido> findPedidosAtivos();
	
}
