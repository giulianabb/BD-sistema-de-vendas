package br.com.sistemavendas.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.DAOCustom.ItemPedidoDAOCustom;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Pedido;

public interface ItemPedidoDAO extends CrudRepository<ItemPedido, Long>, ItemPedidoDAOCustom{

	public List<ItemPedido> findByPedido(Pedido pedido);
	public List<ItemPedido> findByPedidoId(Long pedidoId);
	public List<ItemPedido> findByPedidoIdIn(List<Long> pedidosId);
	
}
