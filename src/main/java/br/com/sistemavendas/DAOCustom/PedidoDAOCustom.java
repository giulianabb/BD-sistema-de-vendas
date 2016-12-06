package br.com.sistemavendas.DAOCustom;

import java.util.List;

import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Solicita;

public interface PedidoDAOCustom {

	public List<Pedido> findPedidosAtivos();
	public List<Solicita> findPedidosNaoPagos();
	public List<Pedido> findPedidosPorTorre();
	public List<Pedido> findPedidosPorDia();
}
