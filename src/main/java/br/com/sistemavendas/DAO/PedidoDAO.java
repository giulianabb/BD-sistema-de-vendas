package br.com.sistemavendas.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sistemavendas.DAOCustom.PedidoDAOCustom;
import br.com.sistemavendas.model.Pedido;

@RepositoryRestResource
public interface PedidoDAO extends CrudRepository<Pedido, Long>, PedidoDAOCustom {

	public List<Pedido> findPedidoByData(Date data);
	
}
