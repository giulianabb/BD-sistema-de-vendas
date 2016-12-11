package br.com.sistemavendas.DAOImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemavendas.DAOCustom.ClienteDAOCustom;
import br.com.sistemavendas.container.GastoPorCliente;

public class ClienteDAOImpl implements ClienteDAOCustom {

	@PersistenceContext
    private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GastoPorCliente> findGastosPorCliente() {
		List<Object[]> results = em.createNativeQuery("SELECT c.nome_completo, c.torre, c.apartamento, count(p.id), sum(pag.valor) as total from pedido p     inner join solicita s on s.pedido_id = p.id     inner join cliente c on s.cliente_id = c.id    inner join pagamento pag on s.pagamento_id = pag.id      group by c.nome_completo, c.torre, c.apartamento  order by c.torre, c.nome_completo").getResultList();
		
		List<GastoPorCliente> clientes = new ArrayList<>();
		for(Object[] result : results) {
			GastoPorCliente cliente = new GastoPorCliente();
			cliente.setNomeCompleto((String) result[0]);
			cliente.setTorre((Integer) result[1]);
			cliente.setApartamento((Integer) result[2]);
			cliente.setNumPedidos(((BigInteger) result[3]).intValue());
			cliente.setTotalGasto(((Double) result[4]));
			
			clientes.add(cliente);
		}
		return clientes;
	}

}
