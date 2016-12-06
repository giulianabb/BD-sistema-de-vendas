package br.com.sistemavendas.DAOCustom;

import java.util.List;

import br.com.sistemavendas.container.PedidosPorDia;
import br.com.sistemavendas.container.PedidosPorTorre;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Solicita;

public interface PedidoDAOCustom {

	public List<Pedido> findPedidosAtivos();
	public List<Solicita> findPedidosNaoPagos();
	public List<PedidosPorTorre> findPedidosPorTorre();
	public List<PedidosPorDia> findPedidosPorDia();
}
