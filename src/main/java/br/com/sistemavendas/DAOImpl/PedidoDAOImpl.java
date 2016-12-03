package br.com.sistemavendas.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemavendas.DAOCustom.PedidoDAOCustom;
import br.com.sistemavendas.model.Pedido;

public class PedidoDAOImpl implements PedidoDAOCustom  {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Pedido> findPedidosAtivos() {
		return em.createQuery("select p from Pedido p where (status_pedido = 'preparo' or status_pedido = 'para_entrega')").getResultList();
	}

}
