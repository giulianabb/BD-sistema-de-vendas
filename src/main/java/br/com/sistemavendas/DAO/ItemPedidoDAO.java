package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.model.ItemPedido;

public interface ItemPedidoDAO extends CrudRepository<ItemPedido, Long>{

}
